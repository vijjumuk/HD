package com.homedepot.di.xd.efs.businesshelper;

import static org.junit.Assert.*;

import org.junit.Test;


public class FileUploadFactoryTest {

	@Test
	public void test() {
		
		String fileType = "LOCATION";
		IUploadProcessor uploadfile = FileUploadFactory
				.getUploadObj(fileType);
		
		assertNotNull(uploadfile);
	}

	@Test
	public void LaneTest() {
		
		String fileType = "LANE";
		IUploadProcessor uploadfile = (IUploadProcessor) FileUploadFactory
				.getUploadObj(fileType);
		
		assertNotNull(uploadfile);
	}

}
