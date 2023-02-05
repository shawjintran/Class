package com.shaw.service_vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.shaw.online.model.vod.Course;
import com.shaw.online.model.vod.CourseDescription;
import com.shaw.online.model.vod.Subject;
import com.shaw.online.model.vod.Teacher;
import com.shaw.online.vo.vod.CourseFormVo;
import com.shaw.online.vo.vod.CoursePublishVo;
import com.shaw.online.vo.vod.CourseQueryVo;
import com.shaw.service_vod.service.*;
import com.shaw.service_vod.mapper.CourseMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author sky
* @description 针对表【course(课程)】的数据库操作Service实现
* @createDate 2023-01-16 22:21:55
*/
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course>
    implements CourseService{
	@Autowired
	TeacherService teacherService;
	@Autowired
	SubjectService subjectService;
	@Autowired
	CourseDescriptionService descriptionService;
	@Autowired
	VideoService videoService;
	@Autowired
	ChapterService chapterService;
	@Override
	public Map<String, Object> findPage(Page<Course> pageParam, CourseQueryVo courseQueryVo) {
		QueryWrapper<Course> wrapper = new QueryWrapper<>();
		if(!ObjectUtils.isEmpty(courseQueryVo.getSubjectId()))
			wrapper.eq("subject_id",courseQueryVo.getSubjectId());
		if(!ObjectUtils.isEmpty(courseQueryVo.getSubjectParentId()))
			wrapper.eq("subject_parent_id",courseQueryVo.getSubjectParentId());
		if(!ObjectUtils.isEmpty(courseQueryVo.getTeacherId()))
			wrapper.eq("teacher_id",courseQueryVo.getTeacherId());
		if(!ObjectUtils.isEmpty(courseQueryVo.getTitle()))
			wrapper.like("title",courseQueryVo.getTitle());
		//调用方法查询
		Page<Course> pages = baseMapper.selectPage(pageParam, wrapper);

		long totalCount = pages.getTotal();//总记录数
		long totalPage = pages.getPages();//总页数
		long currentPage = pages.getCurrent();//当前页
		long size = pages.getSize();//每页记录数
		//每页数据集合
		List<Course> records = pages.getRecords();
		//遍历封装讲师和分类名称
		records.stream().forEach(item -> {
			item=this.getTeacherOrSubjectName(item);
		});
		//封装返回数据
		Map<String,Object> map = new HashMap<>();
		map.put("totalCount",totalCount);
		map.put("totalPage",totalPage);
		map.put("records",records);
		return map;
	}

	@Override
	public Long saveCourseInfo(CourseFormVo courseFormVo) {
		if(ObjectUtils.isEmpty(courseFormVo))
			return null;
		Course course = new Course();
		BeanUtils.copyProperties(courseFormVo,course);
		baseMapper.insert(course);
		//保存课程详情信息
		CourseDescription courseDescription = new CourseDescription();
		courseDescription.setDescription(courseFormVo.getDescription());
		courseDescription.setCourseId(course.getId());
		descriptionService.save(courseDescription);
		return course.getId();
	}

	@Override
	public CourseFormVo getCourseFormVoById(Long id) {
		//从course表中取数据
		Course course = baseMapper.selectById(id);
		if(course == null){
			return null;
		}
		//从course_description表中取数据
		CourseDescription courseDescription = descriptionService.getById(id);
		//创建courseInfoForm对象
		CourseFormVo courseFormVo = new CourseFormVo();
		BeanUtils.copyProperties(course, courseFormVo);
		if(courseDescription != null){
			courseFormVo.setDescription(courseDescription.getDescription());
		}
		return courseFormVo;
	}

	//根据id修改课程信息
	@Override
	public void updateCourseById(CourseFormVo courseFormVo) {
		//修改课程基本信息
		Course course = new Course();
		BeanUtils.copyProperties(courseFormVo, course);
		baseMapper.updateById(course);
		//修改课程详情信息
		CourseDescription courseDescription = descriptionService.getById(course.getId());
		if (courseDescription==null)
		{
			courseDescription=new CourseDescription();
			courseDescription.setCourseId(course.getId());
			courseDescription.setDescription(courseFormVo.getDescription());
			descriptionService.save(courseDescription);
			return;
		}
		courseDescription.setDescription(courseFormVo.getDescription());
		// courseDescription.setId(course.getId());
		descriptionService.updateById(courseDescription);
	}

	@Override
	public boolean publishCourseById(Long id) {
		Course course = new Course();
		course.setId(id);
		course.setPublishTime(new Date());
		course.setStatus(1);
		return this.updateById(course);
	}

	@Override
	public CoursePublishVo getCoursePublishVo(Long id) {
		return baseMapper.selectCoursePublishVoById(id);
	}

	@Override
	public void removeCourseId(Long id) {
		//根据课程id删除小节
		videoService.removeVideoByCourseId(id);
		//根据课程id删除章节
		chapterService.removeChapterByCourseId(id);
		//根据课程id删除描述
		descriptionService.removeById(id);
		//根据课程id删除课程
		baseMapper.deleteById(id);
	}

	//获取讲师和分类名称
	private Course getTeacherOrSubjectName(Course course) {
		//查询讲师名称
		Teacher teacher = teacherService.getById(course.getTeacherId());
		if(teacher != null) {
			course.getParam().put("teacherName",teacher.getName());
		}
		//查询分类名称
		Subject subjectOne = subjectService.getById(course.getSubjectParentId());
		if(subjectOne != null) {
			course.getParam().put("subjectParentTitle",subjectOne.getTitle());
		}
		Subject subjectTwo = subjectService.getById(course.getSubjectId());
		if(subjectTwo != null) {
			course.getParam().put("subjectTitle",subjectTwo.getTitle());
		}
		return course;
	}

}




