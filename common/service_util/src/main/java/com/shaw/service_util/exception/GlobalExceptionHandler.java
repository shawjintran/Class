package com.shaw.service_util.exception;

import com.shaw.service_util.result.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
//AOP
public class GlobalExceptionHandler {
	//
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Result error( Exception e){
		e.printStackTrace();
		return Result.fail(null).setMessage("global exception");
	}
	@ExceptionHandler(onlineException.class)
	@ResponseBody
	public Result error2( Exception e){
		e.printStackTrace();
		return Result.fail(null).setMessage("online exception");
	}
}
