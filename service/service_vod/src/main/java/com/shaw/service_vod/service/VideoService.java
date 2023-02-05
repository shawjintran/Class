package com.shaw.service_vod.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.shaw.online.model.vod.Video;

/**
* @author sky
* @description 针对表【video(课程视频)】的数据库操作Service
* @createDate 2023-01-16 22:21:55
*/
public interface VideoService extends IService<Video> {

	void removeVideoByCourseId(Long id);

	void removeVideoById(Long id);

	void removeVideoByChapterId(Long chapter_id,Long course_id);
}
