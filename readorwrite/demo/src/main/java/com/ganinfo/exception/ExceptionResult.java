package com.ganinfo.exception;

import com.ganinfo.common.view.ResultCode;
import com.ganinfo.common.view.ResultMessage;



/**
 * @ClassName: ExceptionResult 
 * @Description: 异常统一返回处理
 * @author laocunzhang
 * @date 2017年11月23日 上午9:56:49 
 * @version V1.0
 */
public class ExceptionResult extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/** Result status */
	private Integer code;
	/** Result message */
	private String message;
	
//	private String error;
	public ExceptionResult() {
		this(ResultCode.SERVER_ERROR.getCode(), ResultMessage.SERVER_ERROR.getMessage());
	}
	public ExceptionResult(Integer code, String message) {
		this.code = code;
		this.message = message;
		
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
//	/**
//	 * @return the error
//	 */
//	public String getError() {
//		return error;
//	}
//	/**
//	 * @param error the error to set
//	 */
//	public void setError(String error) {
//		this.error = error;
//	}
	
	

}
