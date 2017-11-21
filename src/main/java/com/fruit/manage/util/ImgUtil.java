package com.fruit.manage.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.jfinal.upload.UploadFile;

/**
 * @author Administrator
 *
 */
public class ImgUtil {

	private static Logger log = Logger.getLogger(ImgUtil.class);

	// 上传图片
	public static String upImg(UploadFile uploadFiles, HttpServletRequest request) {
		String imagePath = "";
		File src = null;
		try {
			src = uploadFiles.getFile();
			imagePath = uploadpic(src, request);
		} catch (Exception e) {
			log.error("图片保存失败，稍后请重试！"+e.getMessage(),e);
		} finally {
			if (src != null) {
				src.delete();
			}
		}
		return imagePath;
	}

	public static String uploadpic(File file, HttpServletRequest request) {
		String filename = file.getName();
		String delfilename = filename;
		if (StringUtils.isBlank(filename)) {
			return null;
		}
		//生成文件名
		filename = "img_" + UUID.randomUUID().toString().replace("-", "") + filename.substring(filename.lastIndexOf("."));
		/**
		 * 新保存的位置
		 */
		String path = request.getSession().getServletContext().getRealPath("/");
		String newPath = "/media/upload/";// 自定义目录 用于存放图片
		/**
		 * 没有则新建目录
		 */
		File floder = new File(path + newPath);
		if (!floder.exists()) {
			floder.mkdirs();
		}
		/**
		 * 保存新文件
		 */
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			File savePath = new File(path + newPath + filename);
			if (!savePath.isDirectory())
				savePath.createNewFile();
			System.err.println(savePath.getAbsolutePath());
			fis = new FileInputStream(file);
			fos = new FileOutputStream(savePath);
			byte[] bt = new byte[300];
			while (fis.read(bt, 0, 300) != -1) {
				fos.write(bt, 0, 300);
			}
		} catch (Exception e) {
			log.error("文件上传失败", e);
		} finally {
			try {
				if (null != fis)
					fis.close();
				if (null != fos)
					fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/**
		 * 删除原图片，JFinal默认上传文件路径为 /upload（自动创建）
		 */
		File delFile = new File(path + "/upload/" + delfilename);
		if (delFile.exists()) {
			delFile.delete();
		}
		return "http://" + request.getServerName() + ":" + request.getServerPort() + newPath + filename;
	}
}
