package com.shaw.service_vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.shaw.online.model.vod.Course;
import com.shaw.service_vod.service.CourseService;
import com.shaw.service_vod.mapper.CourseMapper;
import org.springframework.stereotype.Service;

/**
* @author sky
* @description 针对表【course(课程)】的数据库操作Service实现
* @createDate 2023-01-16 22:21:55
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{

}




