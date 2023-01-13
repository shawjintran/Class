package com.shaw.service_vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shaw.online.model.vod.Teacher;
import com.shaw.online.vo.vod.TeacherQueryVo;
import com.shaw.service_vod.service.TeacherService;
import com.shaw.service_vod.mapper.TeacherMapper;

import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

/**
* @author sky
* @description 针对表【teacher(讲师)】的数据库操作Service实现
* @createDate 2023-01-12 18:32:02
*/
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
    implements TeacherService{

	@Override
	public Page<Teacher> DividePage(Long page, Long limit, TeacherQueryVo teacherQueryVo) {
		//创建page对象，传递当前页和每页记录数
		com.baomidou.mybatisplus.extension.plugins.pagination.Page<Teacher> pageParam = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>(page, limit);
		//获取条件值 前端只根据此方法进行添加
		String name = teacherQueryVo.getName();//讲师名称
		Integer level = teacherQueryVo.getLevel();//讲师级别

		String joinDateBegin = teacherQueryVo.getJoinDateBegin();//开始时间
		String joinDateEnd = teacherQueryVo.getJoinDateEnd();//结束时间
		//封装条件
		QueryWrapper<Teacher> wrapper = new QueryWrapper<>();
		if(!ObjectUtils.isEmpty(name)) {
			wrapper.like("name",name);
		}
		if(!ObjectUtils.isEmpty(level)) {
			wrapper.eq("level",level);
		}
		if(!ObjectUtils.isEmpty(joinDateBegin)) {
			wrapper.ge("join_date",joinDateBegin);
		}
		if(!ObjectUtils.isEmpty(joinDateEnd)) {
			wrapper.le("join_date",joinDateEnd);
		}
		return this.page(pageParam, wrapper);
	}
}




