package com.ganinfo.common.view;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @ClassName: ApiResult 
 * @Description: api 统一返回参数
 * @author laocunzhang
 * @date 2017年11月22日 下午10:07:31 
 * @version V1.0
 */
public class ApiResult {
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	/** Result status */
	private Integer code;
	/** Result message */
	private String message;
	/** Result data */
	private Object data;
	/** Total item size */
	private Integer total;
	

	/**
	 * @param code
	 * @param message
	 * @param data
	 * @param total
	 */
	public ApiResult() {
		this(ResultCode.DEF_ERROR.getCode(), ResultMessage.DEF_ERROR.getMessage(), null, null);
	}
	public ApiResult(Integer code, String message) {
		this.code = code;
		this.message = message;		
	}
	public ApiResult(Integer code, String message, Object data,Integer total) {
		this.code = code;
		this.message = message;
		this.data = data;
		this.total=total;
		
	}
	public ApiResult(ResultCode code, ResultMessage message, Object data,Integer total) {
		this(code.getCode(), message.getMessage(), data,total);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(ResultCode code) {
		this.code = code.getCode();
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(ResultMessage message) {
		this.message = message.getMessage();
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public void setSuccess() {
		this.setCode(ResultCode.SUCCESS);
		this.setMessage(ResultMessage.DEF_SUCCESS.getMessage());
	}
	
	
	public String toJSON() {
		return GSON.toJson(this);
	}
}
