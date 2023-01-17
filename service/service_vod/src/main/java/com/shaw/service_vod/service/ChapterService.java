package com.shaw.service_vod.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.shaw.online.model.vod.Chapter;
import com.shaw.online.vo.vod.ChapterVo;

import java.util.List;

/**
* @author sky
* @description 针对表【chapter(课程)】的数据库操作Service
* @createDate 2023-01-16 22:21:55
*/
public interface ChapterService extends IService<Chapter> {

	List<ChapterVo> getNestedTreeList(Long courseId);
}
