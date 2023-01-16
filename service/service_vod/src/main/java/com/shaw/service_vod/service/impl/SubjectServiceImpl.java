package com.shaw.service_vod.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.shaw.online.model.vod.Subject;
import com.shaw.online.vo.vod.SubjectEeVo;
import com.shaw.service_util.exception.onlineException;
import com.shaw.service_vod.service.SubjectService;
import com.shaw.service_vod.mapper.SubjectMapper;
import com.shaw.service_vod.utils.SubjectListener;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
* @author sky
* @description 针对表【subject(课程科目)】的数据库操作Service实现
* @createDate 2023-01-16 19:04:11
*/
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject>
    implements SubjectService{

	@Autowired
	private SubjectListener subjectListener;
	//查询下一层课程分类
	@Override
	public List<Subject> selectList(Long id) {
		QueryWrapper<Subject> wrapper = new QueryWrapper<>();
		wrapper.eq("parent_id",id);
		List<Subject> subjectList = this.baseMapper.selectList(wrapper);
		//向list集合每个Subject对象中设置hasChildren
		for (Subject subject:subjectList) {
			Long subjectId = subject.getId();
			boolean isChild = this.isChildren(subjectId);
			subject.setHasChildren(isChild);
		}
		return subjectList;
	}

	@Override
	public void exportData(HttpServletResponse hsr) throws IOException {
		hsr.setContentType("application/vnd.ms-excel");
		hsr.setCharacterEncoding("utf-8");
		String fileName = URLEncoder.encode("课程分类", "UTF-8");
		hsr.setHeader("Content-Disposition", "attachment;filename="+ fileName + ".xlsx");
		List<Subject> subjectList = baseMapper.selectList(null);
		List<SubjectEeVo> subjectVoList = new ArrayList<>(subjectList.size());
		for(Subject subject : subjectList) {
			SubjectEeVo dictVo = new SubjectEeVo();
			BeanUtils.copyProperties(subject,dictVo);
			subjectVoList.add(dictVo);
		}
		EasyExcel.write(hsr.getOutputStream(), SubjectEeVo.class)
				.sheet("课程分类")
				.doWrite(subjectVoList);
	}

	@Override
	public void importDictData(MultipartFile file) {
		try {
			EasyExcel.read(file.getInputStream(),
					SubjectEeVo.class,subjectListener)
					.sheet()
					.doRead();
		} catch (IOException e) {
			throw new onlineException(20001,"导入失败");
		}
	}


	//判断id下面是否有子节点
	private boolean isChildren(Long id) {
		QueryWrapper<Subject> wrapper = new QueryWrapper<>();
		wrapper.eq("parent_id",id);
		Integer count = this.baseMapper.selectCount(wrapper);
		return count>0;
	}
}




