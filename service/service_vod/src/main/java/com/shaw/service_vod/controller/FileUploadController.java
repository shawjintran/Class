package com.shaw.service_vod.controller;

import com.shaw.service_util.normal.Result;

import com.shaw.service_vod.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/admin/vod/file")
@CrossOrigin
public class FileUploadController {
	@Autowired
	FileService fileService;

	@PostMapping("/upload")
	public Result upload( @RequestParam("file")MultipartFile file) throws IOException {
		String url = fileService.upload(file);
		if(!ObjectUtils.isEmpty(url))
			return Result.ok(url);
		else
			return Result.fail(url);
	}
}
