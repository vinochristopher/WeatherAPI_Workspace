package com.city.weather.model;

import java.io.Serializable;

public class CityName implements Serializable {

	private static final long serialVersionUID = 19084937837L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}