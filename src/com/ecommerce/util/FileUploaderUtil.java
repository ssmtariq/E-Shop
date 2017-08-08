package com.ecommerce.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.struts.upload.FormFile;

public class FileUploaderUtil {
	public static String uploadImage(String filePath, FormFile file, Integer id) throws FileNotFoundException, IOException{
		/************File Upload Start*************/
		File folder = new File(filePath);
		if (!folder.exists()) {
			folder.mkdir();
		}
		String fileName = file.getFileName();
		if (!("").equals(fileName)) {
			System.out.println("Server path:" + filePath);
			File newFile = new File(filePath, (id+fileName));
			if (!newFile.exists()) {
				FileOutputStream fos = new FileOutputStream(newFile);
				fos.write(file.getFileData());
				fos.flush();
				fos.close();
			}
			//request.setAttribute("uploadedFilePath", newFile.getAbsoluteFile());
			//request.setAttribute("uploadedFileName", newFile.getName());
		}
		/************File Upload End*************/
		return (file.getFileName());
	}
}
