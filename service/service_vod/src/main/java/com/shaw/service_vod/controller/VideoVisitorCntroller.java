package com.shaw.service_vod.controller;

import com.shaw.service_util.normal.Result;
import com.shaw.service_vod.service.VideoVisitorService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/admin/vod/videoVisitor")
public class VideoVisitorCntroller {
	@Autowired
	VideoVisitorService videoVisitorService;
	@ApiOperation("显示统计数据")
	@GetMapping("findCount/{courseId}/{startDate}/{endDate}")
	public Result showChart(
			@ApiParam("开始时间") @PathVariable Long courseId,
			@ApiParam("开始时间") @PathVariable String startDate,
			@ApiParam("结束时间") @PathVariable String endDate){

		Map<String, Object> map = videoVisitorService.findCount(courseId, startDate, endDate);
		return Result.ok(map);
	}

}
