package com.shaw.service_util.result;


import lombok.Data;
import lombok.experimental.Accessors;
import org.apache.poi.ss.formula.functions.T;

import javax.validation.constraints.AssertTrue;

@Data
@Accessors(chain = true)
public class Result<T> {
	//状态码
	private Integer code;
	//返回状态信息
	private String message;
	//返回数据
	private T data;

	public Result() {};

	//成功方法
	public static<T> Result<T> ok(T data){
		Result<T> result = new Result<>();
		result.setCode(20000)
				.setMessage("Success");
		if (data==null)
			return result;
		return result.setData(data);
	}
	//失败方法
	public static<T> Result<T> fail(T data){
		Result<T> result = new Result<>();
		result.setCode(20001)
				.setMessage("Flop");
		if (data==null)
			return result;
		return result.setData(data);
	}
}
