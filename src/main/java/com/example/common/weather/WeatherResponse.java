package com.example.common.weather;


import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * WeatherControllerが返却するレスポンス値を保持するクラス.
 * @author yuri.okada
 *
 */
@Getter
@AllArgsConstructor
public class WeatherResponse {
	
	/**天気予報リスト*/
	private Object list;

}
