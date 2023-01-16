package com.shaw.service_vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.shaw.online.model.vod.Video;
import com.shaw.service_vod.service.VideoService;
import com.shaw.service_vod.mapper.VideoMapper;
import org.springframework.stereotype.Service;

/**
* @author sky
* @description 针对表【video(课程视频)】的数据库操作Service实现
* @createDate 2023-01-16 22:21:55
*/
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video>
    implements VideoService{

}




