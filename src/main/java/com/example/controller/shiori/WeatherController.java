package com.example.controller.shiori;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.weather.WeatherApiClient;
import com.example.common.weather.WeatherEntity;
import com.example.common.weather.WeatherResponse;


/**
 * 天気予報を取得するコントロ―ラ.
 * @author yuri.okada
 *
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
	private WeatherApiClient weatherApiClient;
	
	/**
	 * 天気予報を取得する.
	 * @param city 都市名
	 * @return　5日分の天気予報情報
	 */
	@GetMapping("")
	public WeatherResponse getWeather(String destination) {
		System.out.println(destination);
		WeatherEntity weatherEntity= weatherApiClient.getWeather(destination);
		return new WeatherResponse(weatherEntity.getList());
	}
	
	

}
