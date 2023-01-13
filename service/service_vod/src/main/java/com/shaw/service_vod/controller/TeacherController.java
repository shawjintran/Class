package com.shaw.service_vod.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shaw.online.model.vod.Teacher;
import com.shaw.online.vo.vod.TeacherQueryVo;
import com.shaw.service_util.exception.onlineException;
import com.shaw.service_util.result.Result;
import com.shaw.service_vod.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "讲师操作")
@RequestMapping("/admin/vod/teacher")
public class TeacherController {
	@Autowired
	private TeacherService teacherService;

	@GetMapping("/all")
	public Result findAll(){
		return Result.ok(teacherService.list());
	}
	@ApiOperation(value = "获取分页列表")
	@PostMapping("select/{page}/{limit}")
	public Result index(
			@ApiParam(name = "page", value = "当前页码", required = true)
			@PathVariable Long page,
			@ApiParam(name = "limit", value = "每页记录数", required = true)
			@PathVariable Long limit,
			@ApiParam(name = "teacherVo", value = "查询对象", required = false)
			@RequestBody(required = false) TeacherQueryVo teacherQueryVo) {
		//调用方法得到分页查询结果
		Page<Teacher> pageModel=teacherService.DividePage(page,limit,teacherQueryVo);
		return Result.ok(pageModel);
	}
	@PostMapping("/add")
	public Result add(Teacher teacher){
		boolean save = teacherService.save(teacher);
		if (save)
			return Result.ok(null);
		else
			return Result.fail(null);
	}
	@PostMapping("/update")
	public Result update(Teacher teacher){
		boolean is = teacherService.updateById(teacher);
		if(is)
			return Result.ok(null);
		else
			return Result.fail(null);
	}
	@DeleteMapping("/delete/{id}")
	public Result delete(@PathVariable Long id){
		boolean is = teacherService.removeById(id);
		if(is)
			return Result.ok(null);
		else
			return Result.fail(null);
	}
	@DeleteMapping("/delete")
	public Result deleteAll(@RequestBody List<Long> ids){
		boolean is = teacherService.removeByIds(ids);
		if(is)
			return Result.ok(null);
		else
			return Result.fail(null);

	}
}
