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
 * @date 2017-5-16
 */
public enum ResultMessage {
	DEF_SUCCESS("请求成功！"),
	DEF_ERROR("请求失败！"),
	NO_DATA("没有匹配数据！"),
	NO_URL("访问地址不存在！"),
	METHOD_NOT_ALLOWED("请求方式不被支持！"),
	PARAM_ERROR("参数异常！"),
	SERVER_ERROR("服务器异常！");

	private String message;

	private ResultMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
