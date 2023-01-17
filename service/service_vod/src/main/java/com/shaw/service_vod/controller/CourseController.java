package com.shaw.service_vod.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shaw.online.model.vod.Course;
import com.shaw.online.vo.vod.CourseFormVo;
import com.shaw.online.vo.vod.CourseQueryVo;
import com.shaw.service_util.normal.Result;
import com.shaw.service_vod.service.CourseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/admin/vod/course/")
@CrossOrigin
public class CourseController {
	@Autowired
	private CourseService courseService;

	@ApiOperation(value = "获取分页列表")
	@GetMapping("{page}/{limit}")
	public Result index(
			@ApiParam(name = "page", value = "当前页码", required = true)
			@PathVariable Long page,
			@ApiParam(name = "limit", value = "每页记录数", required = true)
			@PathVariable Long limit,
			@ApiParam(name = "courseVo", value = "查询对象", required = false)
					CourseQueryVo courseQueryVo) {
		Page<Course> pageParam = new Page<>(page, limit);
		Map<String,Object> map = courseService.findPage(pageParam, courseQueryVo);
		return Result.ok(map);
	}
	@ApiOperation(value = "新增")
	@PostMapping("save")
	public Result save(@RequestBody CourseFormVo courseFormVo) {
		Long courseId = courseService.saveCourseInfo(courseFormVo);
		return Result.ok(courseId);
	}
	@ApiOperation(value = "获取")
	@GetMapping("get/{id}")
	public Result get(@PathVariable Long id) {
		CourseFormVo course = courseService.getCourseFormVoById(id);
		return Result.ok(course);
	}

	@ApiOperation(value = "修改")
	@PutMapping("update")
	public Result updateById(@RequestBody CourseFormVo courseFormVo) {
		courseService.updateCourseById(courseFormVo);
		return Result.ok(courseFormVo.getId());
	}
}
