package com.td3a.ddd.core.application;


import lombok.Data;

/**
 * 列表请求，page参数
 */

@Data
public class PageRequest {
	private int pageNumber;
	private int pageSize;
}
