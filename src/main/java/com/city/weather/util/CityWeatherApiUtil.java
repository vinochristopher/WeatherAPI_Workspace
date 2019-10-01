package com.city.weather.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CityWeatherApiUtil {

	public static String parsingJSONData(String value) {

		float ConvertToCelsius = Float.parseFloat(value) - 273.15F;
		double fahrenheitValue = (9 * ConvertToCelsius / 5) + 32;
		return String.valueOf(Math.round(fahrenheitValue * 100.0) / 100.0);
	}

	public static String dateFormatter() {

		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate currentDate = LocalDate.now();
		LocalDate nextDay = currentDate.withDayOfMonth(currentDate.getDayOfMonth() + 1);
		return customFormatter.format(nextDay);

	}
}