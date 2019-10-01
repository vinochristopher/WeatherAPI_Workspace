package com.city.weather.model;

import java.io.Serializable;

public class CityWeatherDescription implements Serializable {
	private static final long serialVersionUID = 19084937837L;

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}