package com.shaw.service_vod.controller;

import com.shaw.online.model.vod.Video;
import com.shaw.service_util.normal.Result;
import com.shaw.service_vod.service.VideoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "课程小结（课时）")
@RestController
@RequestMapping(value="/admin/vod/video")
@CrossOrigin
public class VideoController {

	@Autowired
	private VideoService videoService;

	@ApiOperation(value = "获取")
	@GetMapping("get/{id}")
	public Result get(@PathVariable Long id) {
		Video video = videoService.getById(id);
		return Result.ok(video);
	}

	@ApiOperation(value = "新增")
	@PostMapping("save")
	public Result save(@RequestBody Video video) {
		videoService.save(video);
		return Result.ok(null);
	}

	@ApiOperation(value = "修改")
	@PutMapping("update")
	public Result updateById(@RequestBody Video video) {
		videoService.updateById(video);
		return Result.ok(null);
	}

	@ApiOperation(value = "删除")
	@DeleteMapping("remove/{id}")
	public Result remove(@PathVariable Long id) {
		videoService.removeById(id);
		return Result.ok(null);
	}
}
