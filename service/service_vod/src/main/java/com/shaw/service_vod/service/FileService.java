package com.shaw.service_vod.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public interface FileService {
	public String upload(MultipartFile file) throws IOException;

	void removeVideo(String videoSource);

	String uploadVideo(MultipartFile file, String originalFilename) throws IOException;

}
