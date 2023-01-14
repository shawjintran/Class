package com.shaw.service_vod.controller;

import com.shaw.online.model.vod.Teacher;
import com.shaw.service_util.result.Result;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;

@RestController
@RequestMapping("/admin/vod/user")
@CrossOrigin
@Api(tags = "User about")
public class UserController {
	@PostMapping("/login")
	public Result login(){
		HashMap<String, String> map = new HashMap<>();
		map.put("token","admin-token");
		return Result.ok(map).setCode(20000);
	}
	@GetMapping("/info")
	public Result info(){
		// {"code":20000,
		// "data":{"roles":["admin"],
		// "introduction":"I am a super administrator",
		// "avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif",
		// "name":"Super Admin"}}
		HashMap<String, String> map = new HashMap<>();
		map.put("roles", Arrays.asList("admin").toString());
		map.put("introduction","I am a super administrator");
		map.put("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
		map.put("name","Super Admin");
		return Result.ok(map).setCode(20000);
	}
}
