package com.shaw.service_vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shaw.online.model.vod.VideoVisitor;

import java.util.Map;

/**
* @author sky
* @description 针对表【video_visitor(视频来访者记录表)】的数据库操作Service
* @createDate 2023-02-05 15:38:39
*/
public interface VideoVisitorService extends IService<VideoVisitor> {

	Map<String, Object> findCount(Long courseId, String startDate, String endDate);
}
