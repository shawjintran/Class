package com.shaw.service_vod.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.shaw.online.model.vod.Subject;
import com.shaw.online.vo.vod.SubjectEeVo;
import com.shaw.service_vod.mapper.SubjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class SubjectListener extends AnalysisEventListener<SubjectEeVo> {

	@Autowired
	SubjectMapper subjectMapper;
	@Override
	public void invoke(SubjectEeVo data, AnalysisContext context) {
		Subject subject = new Subject();
		BeanUtils.copyProperties(data,subject);
		int insert = subjectMapper.insert(subject);
		System.out.println(insert);
	}

	@Override
	public void doAfterAllAnalysed(AnalysisContext context) {

	}
}
