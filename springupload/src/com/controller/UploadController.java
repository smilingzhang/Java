package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
public class UploadController {

	public UploadController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping("/upload1")
	public void upload1(@RequestParam("title") String title, @RequestParam("upload") MultipartFile file,HttpServletRequest request) {
		System.out.println(title);
		String rootPath=request.getServletContext().getRealPath("/");
		if(!file.isEmpty()){
			try {
				InputStream is=file.getInputStream();
				FileOutputStream fos=new FileOutputStream(
						rootPath+"/"+"upload/"
						+file.getOriginalFilename());
				int a;
				byte []cache=new byte[is.available()];
				while((a=is.read())!=-1) {
					fos.write(a);
				}
			
				is.close();
				fos.flush();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}


	@RequestMapping("/upload2")
	public void upload2(@RequestParam("title") String title, @RequestParam("upload") MultipartFile file,HttpServletRequest request) {
		System.out.println(title);
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		 resolver.setDefaultEncoding("utf-8");
		String rootPath=request.getServletContext().getRealPath("/");
		try {
			FileCopyUtils.copy(file.getBytes(), 
					new File(rootPath+"/upload",file.getOriginalFilename()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	@RequestMapping("/upload3")
	public void upload3(@RequestParam("title") String title, @RequestParam("upload") MultipartFile []file,HttpServletRequest request) {
		System.out.println(title);
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		 resolver.setDefaultEncoding("utf-8");
		String rootPath=request.getServletContext().getRealPath("/");
		try {
			for(MultipartFile temp:file) {
				FileCopyUtils.copy(temp.getBytes(), 
						new File(rootPath+"/upload",temp.getOriginalFilename()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	}
