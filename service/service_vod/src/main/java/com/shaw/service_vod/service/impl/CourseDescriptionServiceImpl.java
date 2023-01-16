package com.shaw.service_vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.shaw.online.model.vod.CourseDescription;
import com.shaw.service_vod.service.CourseDescriptionService;
import com.shaw.service_vod.mapper.CourseDescriptionMapper;
import org.springframework.stereotype.Service;

/**
* @author sky
* @description 针对表【course_description(课程简介)】的数据库操作Service实现
* @createDate 2023-01-16 22:21:55
*/
@Service
public class CourseDescriptionServiceImpl extends ServiceImpl<CourseDescriptionMapper, CourseDescription>
    implements CourseDescriptionService{

}




