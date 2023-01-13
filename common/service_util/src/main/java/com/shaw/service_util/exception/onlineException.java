package com.shaw.service_util.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class onlineException extends RuntimeException{
	private Integer code;
	private String Mes;
}
