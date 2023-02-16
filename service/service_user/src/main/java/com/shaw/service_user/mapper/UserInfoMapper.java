package com.shaw.service_user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shaw.online.model.user.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
* @author sky
* @description 针对表【user_info(用户表)】的数据库操作Mapper
* @createDate 2023-02-16 22:39:19
* @Entity com.shaw.service_user.entity.UserInfo
*/
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}




