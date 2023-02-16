package com.shaw.service_user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shaw.online.model.user.UserInfo;
import com.shaw.service_user.service.UserInfoService;
import com.shaw.service_user.mapper.UserInfoMapper;
import org.springframework.stereotype.Service;

/**
* @author sky
* @description 针对表【user_info(用户表)】的数据库操作Service实现
* @createDate 2023-02-16 22:39:19
*/
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
    implements UserInfoService{

}




