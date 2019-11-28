/*
 * Delta CONFIDENTIAL
 *
 * (C) Copyright Delta Electronics, Inc. 2015 All Rights Reserved
 *
 * NOTICE:  All information contained herein is, and remains the
 * property of Delta Electronics. The intellectual and technical
 * concepts contained herein are proprietary to Delta Electronics
 * and are protected by trade secret, patent law or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Delta Electronics.
 */
package com.ganinfo.common.view;

/**
 * @ClassName: ResultCode 
 * @Description: 返回标志
 * @author laocunzhang
 * @date 2017年11月22日 下午10:08:16 
 * @version V1.0
 */
public enum ResultCode {
	
	/**
	 * 成功
	 */
	SUCCESS(0), 
	
	/**
	 * 请求失败
	 */
	DEF_ERROR(-1),
	
	/**
	 * 无数据
	 */
	NO_DATA(10),
	
	/**
	 * url不存在
	 */
	NO_URL(404),
	
	METHOD_NOT_ALLOWED(405),
	/**
	 * 服务器异常
	 */
	SERVER_ERROR(500);
	
	private Integer code;

	private ResultCode(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
}
