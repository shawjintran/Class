package com.shaw.service_vod.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shaw.online.model.vod.Course;
import com.shaw.online.vo.vod.CourseFormVo;
import com.shaw.online.vo.vod.CoursePublishVo;
import com.shaw.online.vo.vod.CourseQueryVo;

import java.util.Map;

/**
* @author sky
* @description 针对表【course(课程)】的数据库操作Service
* @createDate 2023-01-16 22:21:55
*/
public interface CourseService extends IService<Course> {

	Map<String, Object> findPage(Page<Course> pageParam, CourseQueryVo courseQueryVo);

	Long saveCourseInfo(CourseFormVo courseFormVo);

	CourseFormVo getCourseFormVoById(Long id);

	//根据id修改课程信息
	void updateCourseById(CourseFormVo courseFormVo);

	boolean publishCourseById(Long id);

	CoursePublishVo getCoursePublishVo(Long id);

	void removeCourseId(Long id);
}
