package com.shaw.service_vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.shaw.online.model.vod.Video;
import com.shaw.service_vod.service.FileService;
import com.shaw.service_vod.service.VideoService;
import com.shaw.service_vod.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
* @author sky
* @description 针对表【video(课程视频)】的数据库操作Service实现
* @createDate 2023-01-16 22:21:55
*/
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video>
    implements VideoService{
	@Autowired
	FileService fileService;
	@Override
	public void removeVideoByCourseId(Long id) {
		QueryWrapper<Video> wrapper = new QueryWrapper<>();
		wrapper.eq("course_id",id);
		List<Video> videos = baseMapper.selectList(wrapper);
		videos.stream().forEach((video)->{
			if (ObjectUtils.isEmpty(video.getId()))
				return;
			this.removeVideoById(video.getId());
		});
		baseMapper.delete(wrapper);
	}

	@Override
	public void removeVideoById(Long id) {
		Video video = baseMapper.selectById(id);
		if(ObjectUtils.isEmpty(video.getVideoSourceId()))
			return;
		fileService.removeVideo(video.getVideoSourceId());
		baseMapper.deleteById(id);
	}
	public void removeVideoByChapterId(Long chapter_id,Long course_id){
		QueryWrapper<Video> wrapper = new QueryWrapper<>();
		wrapper.eq("chapter_id",chapter_id);
		wrapper.eq("course_id",course_id);
		List<Video> videos = baseMapper.selectList(wrapper);
		videos.stream().forEach((video)->{
			if (ObjectUtils.isEmpty(video.getId()))
				return;
			this.removeVideoById(video.getId());
		});
		baseMapper.delete(wrapper);
	}
}




