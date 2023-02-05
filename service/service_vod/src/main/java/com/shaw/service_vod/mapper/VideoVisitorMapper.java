package com.shaw.service_vod.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.shaw.online.model.vod.VideoVisitor;
import com.shaw.online.vo.vod.VideoVisitorCountVo;

import java.util.List;

/**
* @author sky
* @description 针对表【video_visitor(视频来访者记录表)】的数据库操作Mapper
* @createDate 2023-02-05 15:38:39
* @Entity com.shaw.service_vod.entity.VideoVisitor
*/
public interface VideoVisitorMapper extends BaseMapper<VideoVisitor> {
	////显示统计数据
	List<VideoVisitorCountVo> findCount(Long courseId, String startDate, String endDate);
}




