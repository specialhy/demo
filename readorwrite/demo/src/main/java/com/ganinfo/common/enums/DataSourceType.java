package com.ganinfo.common.enums;
/**
 * @package:com.ganinfo.common.enums
 * @className:DataSourceType
 * @description:枚举区分读写库
 * @author laocunzhang
 * @date 2018-01-28 13:48
 **/
public enum DataSourceType {
	read("read", "从库"), write("write", "主库");
	
	DataSourceType(String type, String name) {
		this.type = type;
		this.name = name;
	}
	
	
	private String type;
	private String name;
	

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}



}
