package com.hibernate.spring.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v2")
public class FileUploadController {
	
	@RequestMapping( value = "/fileUpload", method = RequestMethod.POST) 
	public void fileUpload (@RequestParam("file") MultipartFile files) {
		System.out.println(files.getOriginalFilename());
	}
}
