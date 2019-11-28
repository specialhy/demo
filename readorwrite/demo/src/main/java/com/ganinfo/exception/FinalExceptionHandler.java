/**
 * 
 */
package com.ganinfo.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganinfo.common.view.ApiResult;
import com.ganinfo.common.view.ResultCode;
import com.ganinfo.common.view.ResultMessage;

/**
 * @ClassName: FinalExceptionHandler
 * @Description: 在进入Controller之前，譬如请求一个不存在的地址，404错误。
 * @author laocunzhang
 * @date 2018年1月25日 下午3:03:11
 * @version V1.0
 */
@RestController
public class FinalExceptionHandler implements ErrorController {

	@Override
	public String getErrorPath() {
		return "/error";
	}

	@RequestMapping(value = "/error")
	@ResponseBody
	public ApiResult error(HttpServletResponse resp, HttpServletRequest req) {
		// 错误处理逻辑
		return new ApiResult(ResultCode.NO_URL.getCode(),ResultMessage.NO_URL.getMessage());
	}

}
