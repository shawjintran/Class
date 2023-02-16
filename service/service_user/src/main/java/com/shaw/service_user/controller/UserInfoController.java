package com.shaw.service_user.controller;

import com.shaw.online.model.user.UserInfo;
import com.shaw.service_user.service.UserInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/user/userInfo")
public class UserInfoController {
	@Autowired
	private UserInfoService userService;

	@ApiOperation(value = "获取")
	@GetMapping("inner/getById/{id}")
	public UserInfo getById(@PathVariable Long id) {
		return userService.getById(id);
	}
}
