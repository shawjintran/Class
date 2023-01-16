package com.shaw.service_vod.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.shaw.online.model.vod.Chapter;
import com.shaw.service_vod.service.ChapterService;
import com.shaw.service_vod.mapper.ChapterMapper;
import org.springframework.stereotype.Service;

/**
* @author sky
* @description 针对表【chapter(课程)】的数据库操作Service实现
* @createDate 2023-01-16 22:21:55
*/
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter>
    implements ChapterService{

}




