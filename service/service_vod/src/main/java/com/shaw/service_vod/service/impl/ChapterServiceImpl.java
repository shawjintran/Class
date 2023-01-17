package com.shaw.service_vod.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.shaw.online.model.vod.Chapter;
import com.shaw.online.model.vod.Video;
import com.shaw.online.vo.vod.ChapterVo;
import com.shaw.online.vo.vod.VideoVo;
import com.shaw.service_util.normal.Result;
import com.shaw.service_vod.service.ChapterService;
import com.shaw.service_vod.mapper.ChapterMapper;
import com.shaw.service_vod.service.VideoService;
import io.swagger.annotations.Api;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author sky
* @description 针对表【chapter(课程)】的数据库操作Service实现
* @createDate 2023-01-16 22:21:55
*/
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter>
    implements ChapterService{
	@Autowired
	VideoService videoService;
	@Override
	public List<ChapterVo> getNestedTreeList(Long courseId) {
		ArrayList<ChapterVo> chapterVos = new ArrayList<>();
		QueryWrapper<Chapter> wrapper = new QueryWrapper<>();
		List<Chapter> chapters = baseMapper.selectList(wrapper.eq("course_id", courseId));

		chapters.stream().forEach(chapter -> {
			ChapterVo chapterVo = new ChapterVo();
			BeanUtils.copyProperties(chapter,chapterVo);

			QueryWrapper<Video> wrapper1 = new QueryWrapper<>();
			wrapper1.eq("chapter_id",chapter.getId());
			List<Video> list = videoService.list(wrapper1);
			ArrayList<VideoVo> videoVos = new ArrayList<>();

			list.stream().forEach(video -> {
				VideoVo videoVo = new VideoVo();
				BeanUtils.copyProperties(video,videoVo);
				videoVos.add(videoVo);
			});
			chapterVo.setChildren(videoVos);
			chapterVos.add(chapterVo);
		});
		return chapterVos;
	}
}




