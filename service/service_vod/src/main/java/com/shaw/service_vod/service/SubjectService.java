package com.shaw.service_vod.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.shaw.online.model.vod.Subject;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
* @author sky
* @description 针对表【subject(课程科目)】的数据库操作Service
* @createDate 2023-01-16 19:04:11
*/
public interface SubjectService extends IService<Subject> {
public List<Subject>selectList(Long id);
void exportData(HttpServletResponse hsr) throws IOException;

	void importDictData(MultipartFile file);
}
