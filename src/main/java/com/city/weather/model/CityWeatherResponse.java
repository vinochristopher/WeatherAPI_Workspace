package com.city.weather.model;

import java.io.Serializable;
import java.util.List;

public class CityWeatherResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String city;
	private String postalCode;
	List<CityWeatherDetails> detailsWeatherList;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return postalCode;
	}

	public void setZipCode(String zipCode) {
		this.postalCode = zipCode;
	}

	public List<CityWeatherDetails> getDetailsWeatherList() {
		return detailsWeatherList;
	}

	public void setDetailsWeatherList(List<CityWeatherDetails> detailsWeatherList) {
		this.detailsWeatherList = detailsWeatherList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((detailsWeatherList == null) ? 0 : detailsWeatherList.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CityWeatherResponse other = (CityWeatherResponse) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (detailsWeatherList == null) {
			if (other.detailsWeatherList != null)
				return false;
		} else if (!detailsWeatherList.equals(other.detailsWeatherList))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		return true;
	}

}
