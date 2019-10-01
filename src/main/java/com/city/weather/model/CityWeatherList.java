package com.city.weather.model;

import java.io.Serializable;
import java.util.List;

public class CityWeatherList implements Serializable, Comparable<CityWeatherList> {
	private static final long serialVersionUID = 19084937837L;

	private CityTempDetails main;
	private List<CityWeatherDescription> weather;
	private String dt_txt;

	public CityTempDetails getMain() {
		return main;
	}

	public void setMain(CityTempDetails main) {
		this.main = main;
	}

	public List<CityWeatherDescription> getWeather() {
		return weather;
	}

	public void setWeather(List<CityWeatherDescription> weather) {
		this.weather = weather;
	}

	public String getDt_txt() {
		return dt_txt;
	}

	public void setDt_txt(String dt_txt) {
		this.dt_txt = dt_txt;
	}

	public int compareTo(CityWeatherList o) {

		return this.dt_txt.compareTo(o.dt_txt);

	}
}