package com.shaw.service_vod.controller;

import com.shaw.online.model.vod.Subject;
import com.shaw.service_util.normal.Result;
import com.shaw.service_vod.service.SubjectService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin/vod/subject")
@CrossOrigin
public class SubjectController {

	@Autowired
	 SubjectService subjectService;

	@GetMapping("/getChildSubject/{id}")
	public Result getChildSubject(@PathVariable Long id){
		List<Subject> list = subjectService.selectList(id);
		return Result.ok(list);
	}
	@ApiOperation(value="导出")
	@GetMapping(value = "/exportData")
	public void exportData(HttpServletResponse response) throws IOException {
		subjectService.exportData(response);
	}
	@ApiOperation(value = "导入")
	@PostMapping("/importData")
	public Result importData(MultipartFile file) {
		subjectService.importDictData(file);
		return Result.ok(null);
	}
}
