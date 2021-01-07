package com.example.domain.shiori;



import lombok.Data;

@Data
public class Destination {
	/** 目的地ID */
	private Integer id;
	/** しおりID */
	private Integer shioriId;
	/** 目的地名 */
	private String destination;

}