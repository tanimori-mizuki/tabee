package com.example.domain.memory;

import lombok.Data;

/**
 * 思い出画像ドメイン.
 * 
 * @author masashi.nose
 *
 */
@Data
public class MemoryImage {

	/** ID */
	private Integer id;
	/** 思い出ID */
	private Integer memoryId;
	/** 画像パス */
	private String imagePath;

}