package com.shaw.service_user_client;


import com.shaw.online.model.user.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-user")
public interface UserInfoFeignClient {
	@GetMapping("/admin/user/userInfo/inner/getById/{id}")
	UserInfo getById(@PathVariable Long id);
}
