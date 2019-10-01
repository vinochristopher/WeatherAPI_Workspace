package com.city.weather.model;

import java.io.Serializable;
import java.util.List;

public class CityWeatherJSONResponse implements Serializable {
	private static final long serialVersionUID = 19084937837L;

	private CityName cityName;
	private List<CityWeatherList> list;

	public CityName getCity() {
		return cityName;
	}

	public void setCity(CityName city) {
		this.cityName = city;
	}

	public List<CityWeatherList> getList() {
		return list;
	}

	public void setList(List<CityWeatherList> list) {
		this.list = list;
	}
}