package com.shaw.service_vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shaw.online.model.vod.VideoVisitor;
import com.shaw.online.vo.vod.VideoVisitorCountVo;
import com.shaw.service_vod.service.VideoVisitorService;
import com.shaw.service_vod.mapper.VideoVisitorMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
* @author sky
* @description 针对表【video_visitor(视频来访者记录表)】的数据库操作Service实现
* @createDate 2023-02-05 15:38:39
*/
@Service
public class VideoVisitorServiceImpl extends ServiceImpl<VideoVisitorMapper, VideoVisitor>
    implements VideoVisitorService{

	@Override
	public Map<String, Object> findCount(Long courseId, String startDate, String endDate) {
		List<VideoVisitorCountVo> count = baseMapper.findCount(courseId, startDate, endDate);
		ArrayList<VideoVisitor> list = new ArrayList<>();
		HashMap<String, Object> map = new HashMap<>();
		//一个代表日期,一个代表日期对应的数量
		List<Integer> countList = count.stream()
				.map(VideoVisitorCountVo::getUserCount)
				.collect(Collectors.toList());
		List<String> dateList = count.stream()
				.map(VideoVisitorCountVo::getJoinTime)
				.collect(Collectors.toList());
		map.put("xData",dateList);
		map.put("yData",countList);
		return map;

	}
}




