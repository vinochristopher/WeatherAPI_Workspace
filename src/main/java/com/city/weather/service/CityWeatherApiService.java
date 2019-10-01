package com.city.weather.service;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.city.weather.model.CityWeatherDetails;
import com.city.weather.model.CityWeatherJSONResponse;
import com.city.weather.model.CityWeatherList;
import com.city.weather.model.CityWeatherResponse;
import com.city.weather.util.CityWeatherApiUtil;

@Service
public class CityWeatherApiService {

	Logger logger = LoggerFactory.getLogger(CityWeatherApiService.class);
	@Value("${weatherapi.url}")
	private String apiURL;
	@Value("${weatherapi.key}")
	private String weatherApiKey;

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();

	}

	@Autowired
	private RestTemplate restTemplate;

	public CityWeatherJSONResponse getWeatherDetails(String postalCode) {
		logger.info("Entered getWeatherDetails method...");
		String weatherAPIURL = apiURL + "?zip=" + postalCode + ",us&appid=" + weatherApiKey;
		return restTemplate.getForObject(weatherAPIURL, CityWeatherJSONResponse.class);
	}

	public CityWeatherResponse processUserRequest(String postalCode) {
		logger.info("Entered processUserRequest method...");
		CityWeatherJSONResponse weatherResponseJSON = getWeatherDetails(postalCode);
		List<CityWeatherDetails> cityWeatherDetails = new ArrayList<>();
		List<CityWeatherList> weatherLists = weatherResponseJSON.getList();

		for (CityWeatherList list : weatherLists) {
			if (list.getDt_txt().contains(CityWeatherApiUtil.dateFormatter())) {
				CityWeatherDetails cityWeatherList = new CityWeatherDetails();
				cityWeatherList.setDateTime(list.getDt_txt());
				cityWeatherList.setMinTemp(CityWeatherApiUtil.parsingJSONData(list.getMain().getTemp_min()));
				cityWeatherList.setMaxTemp(CityWeatherApiUtil.parsingJSONData(list.getMain().getTemp_max()));
				cityWeatherList.setHumidity(list.getMain().getHumidity());
				cityWeatherList.setWeatherDescription(list.getWeather().get(0).getDescription());
				cityWeatherDetails.add(cityWeatherList);
			}
		}

		CityWeatherResponse cityHourlyWeatherServiceResponse = new CityWeatherResponse();
		cityHourlyWeatherServiceResponse.setZipCode(postalCode);
		cityHourlyWeatherServiceResponse.setCity(weatherResponseJSON.getCity().getName());
		cityHourlyWeatherServiceResponse.setDetailsWeatherList(cityWeatherDetails);
		return cityHourlyWeatherServiceResponse;
	}
}
