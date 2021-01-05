package com.example.common.weather;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * API呼び出し情報のクラス.
 * @author yuri.okada
 *
 */
@Component
public class WeatherApiClient {
	
	private RestTemplate restTemplate=new RestTemplate();
	
	/**
	 * 天気予報を取得する.
	 * @param city 都市名
	 * @return　天気予報情報
	 */
	public WeatherEntity getWeather(String destination) {
		final String API_KEY="804e576d9cfd447db84a22b1e69f906d";
		return restTemplate.getForObject("https://api.openweathermap.org/data/2.5/forecast?q="+destination+",jp&APPID="+API_KEY+"&lang=ja&units=metric&cnt=20",WeatherEntity.class);
	}


}
