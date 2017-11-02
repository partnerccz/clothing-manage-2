package com.fruit.manage.controller;

import java.util.ArrayList;
import java.util.List;

import com.fruit.manage.base.BaseController;
import com.fruit.manage.util.ImgUtil;
import com.jfinal.ext.route.ControllerBind;
import com.jfinal.upload.UploadFile;

@ControllerBind(controllerKey="/manage/common",viewPath="/")
public class CommonController extends BaseController {
	
	/**
	 * 上传图片公共方法，该方法需改进：用户在连续上传文件时，对之前的文件不做ftp上传，仅对最后一个上传到ftp上
	 */
	public void upload(){
		List<UploadFile> fileList = null;
		try{
			fileList = getFiles("file");
		}catch(Exception e) {
			renderNull();
			return;
		}
		if(fileList.size() == 1){
			String picUrl=ImgUtil.upImg(fileList.get(0), getRequest());
			renderText(picUrl);
			return;
		}
		List<String> uploadText = new ArrayList<String>();
		for(UploadFile f:fileList){
			String upImg = ImgUtil.upImg(f, getRequest());
			uploadText.add(upImg);
		}
		renderJson(uploadText);
	}
	
}



