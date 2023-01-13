package com.shaw.service_vod.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shaw.online.model.vod.Teacher;
import com.shaw.online.vo.vod.TeacherQueryVo;

/**
* @author sky
* @description 针对表【teacher(讲师)】的数据库操作Service
* @createDate 2023-01-12 18:32:02
*/
public interface TeacherService extends IService<Teacher> {
	public Page<Teacher> DividePage(Long page, Long limit, TeacherQueryVo teacherQueryVo);

}
