package com.city.weather.model;

import java.io.Serializable;

public class CityTempDetails implements Serializable {
	private static final long serialVersionUID = 19084937837L;

	private String temp_min;
	private String temp_max;
	private String humidity;

	public String getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(String temp_min) {
		this.temp_min = temp_min;
	}

	public String getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(String temp_max) {
		this.temp_max = temp_max;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
}