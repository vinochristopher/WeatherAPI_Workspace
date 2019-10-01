package com.city.weather.controller;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.city.weather.model.CityWeatherResponse;
import com.city.weather.service.CityWeatherApiService;

@CrossOrigin
@RestController
@RequestMapping("/weatherapi")
public class CityWeatherApiController {

	Logger logger = LoggerFactory.getLogger(CityWeatherApiController.class);
	@Autowired
	private CityWeatherApiService getCityWeatherService;

	@GetMapping(value = "/{postalCode}")
	public CityWeatherResponse getCityWeatherDetails(@PathVariable String postalCode) throws IOException {
		logger.info("Entered into getCityWeatherDetails...");
		CityWeatherResponse cityWeather = getCityWeatherService.processUserRequest(postalCode);
		return cityWeather;
	}
}