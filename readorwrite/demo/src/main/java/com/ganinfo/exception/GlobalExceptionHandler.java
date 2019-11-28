/**
 * 
 */
package com.ganinfo.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ganinfo.common.view.ApiResult;
import com.ganinfo.common.view.ResultCode;
import com.ganinfo.common.view.ResultMessage;

/**
 * @ClassName: GlobalExceptionHandler 
 * @Description: 在执行@RequestMapping时，进入逻辑处理阶段前。譬如传的参数类型错误
 * @author laocunzhang
 * @date 2018年1月25日 下午3:12:16 
 * @version V1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	 /**
     * 在controller里面内容执行之前，校验一些参数不匹配啊，Get post方法不对啊之类的
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<Object>(new ApiResult(ResultCode.METHOD_NOT_ALLOWED.getCode(),ResultMessage.METHOD_NOT_ALLOWED.getMessage()), status);

    }

}
