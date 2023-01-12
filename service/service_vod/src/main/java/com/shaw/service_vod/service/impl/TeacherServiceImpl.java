package com.shaw.service_vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shaw.online.model.vod.Teacher;
import com.shaw.service_vod.service.TeacherService;
import com.shaw.service_vod.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

/**
* @author sky
* @description 针对表【teacher(讲师)】的数据库操作Service实现
* @createDate 2023-01-12 18:32:02
*/
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService{

}




