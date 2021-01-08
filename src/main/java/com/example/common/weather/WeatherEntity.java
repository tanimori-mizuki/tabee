package com.example.common.weather;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * 天気情報を受け取るエンティティ
 * @author yuri.okada
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherEntity {

	@JsonProperty("list")
	/**天気予報リスト*/
	private Object list;
	
}
