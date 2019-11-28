package com.ganinfo.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ganinfo.common.view.ApiResult;
import com.ganinfo.common.view.ResultCode;
import com.ganinfo.common.view.ResultMessage;


/**
 * @ClassName: GlobalDefaultExceptionHandler
 * @Description: 在controller里执行逻辑代码时出的异常
 * @author laocunzhang
 * @date 2017年11月23日 上午9:45:16
 * @version V1.0
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	private Logger logger = Logger.getLogger(GlobalDefaultExceptionHandler.class);
	/**
	 * @Title: defaultErrorHandler 
	 * @Description: 统一处理某一类异常，从而能够减少代码重复率和复杂度
	 * @param req 
	 * @param e 
	 * @return ApiResult 
	 * @throws
	 */
//	@ExceptionHandler(value = ExceptionResult.class)//指定具体要处理的异常
	@ExceptionHandler//处理所有异常
	@ResponseBody
	public ApiResult defaultErrorHandler(HttpServletRequest req,Exception  ex) {
		// 打印异常信息：
		ex.printStackTrace();
		logger.error("捕获全局异常=="+ex);
		return new ApiResult(ResultCode.SERVER_ERROR.getCode(),ResultMessage.SERVER_ERROR.getMessage(),ex.toString(),null);

	} 

	/**
	 * 捕获类内所有的异常
	 * 
	 * @param ex
	 * @return
	 */
//	@ExceptionHandler(value = Exception.class)
//	public ModelAndView exceptionHandelByThymeleaf(Exception ex, HttpServletRequest req) {
//		ModelAndView mav = new ModelAndView();
//		mav.setViewName("error");
//		mav.addObject("exception", ex.getMessage());
//		mav.addObject("url", req.getRequestURL());
//		return mav;
//	}

}
