package com.homedepot.di.xd.efs.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

import com.csvreader.CsvReader;
import com.homedepot.di.xd.efs.to.InputFileTO;
import com.sun.jersey.core.header.FormDataContentDisposition;

public class UploadResourceTest {/*

	@Test(expected = IllegalArgumentException.class)
	public void testUploadFile() throws Exception {
	
		UploadResource resource = new UploadResource();
		
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_Valid.csv"));
		
		InputFileTO fileInput = new InputFileTO(uploadedInputStream, null, null);
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(fileInput.getInputStream(), "UTF-8")));
		reader.skipRecord();
		
		FormDataContentDisposition fileDetail = new FormDataContentDisposition("Name");
		String userId = "MXG8621";
		resource.uploadFile(uploadedInputStream,fileDetail,userId);
	}*/
	
	@Test(expected = IllegalArgumentException.class)
	public void testLaneUploadFile() throws Exception {
	
		UploadResource resource = new UploadResource();
		
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/Lane_Upload_Valid.csv"));
		
		
		FormDataContentDisposition fileDetail = new FormDataContentDisposition("Lane");
		String userId = "SXV8609";
		String fileType = "2";
		resource.uploadFile(uploadedInputStream,fileDetail,userId, fileType);
	}

}
