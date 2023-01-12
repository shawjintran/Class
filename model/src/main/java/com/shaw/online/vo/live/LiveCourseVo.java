package com.shaw.online.vo.live;


import com.shaw.online.model.live.LiveCourse;
import com.shaw.online.model.vod.Teacher;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LiveCourseVo extends LiveCourse {

	@ApiModelProperty(value = "主播老师")
	private Teacher teacher;

	private Integer liveStatus;

	@ApiModelProperty(value = "直播开始时间")
	private String startTimeString;

	@ApiModelProperty(value = "直播结束时间")
	private String endTimeString;

}

