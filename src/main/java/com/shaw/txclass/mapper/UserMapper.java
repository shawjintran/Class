package com.shaw.txclass.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shaw.txclass.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
