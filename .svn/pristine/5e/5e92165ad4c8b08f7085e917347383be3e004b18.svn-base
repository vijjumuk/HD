/**

 * 
 */
package com.homedepot.di.xd.efs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.to.InputFileTO;
import com.homedepot.di.xd.efs.upload.FileParser;
import com.homedepot.di.xd.efs.upload.FileParserFactory;
import com.homedepot.di.xd.efs.upload.FileType;

/**
 * @author 588893
 *
 */
public class UploadValidationUtilTest {
	@Test
	public void testvalidOriginForLane()
	{
		
		String origin="688509TX002";
		Assert.assertTrue(UploadValidationUtil.isOriginValid(origin));
	}
	
	@Test
	public void testinvalidvalidOriginForLane()
	{
		
		String origin="688509TX002as3456";
		Assert.assertFalse(UploadValidationUtil.isOriginValid(origin));
	}
	
	@Test
	public void testValidDC()
	{
	String dc="5520";
	Assert.assertTrue(UploadValidationUtil.isDestinationValid(dc));
	}
	
	@Test
	public void testinvalidDC()
	{
		
		String dc="s3456";
		Assert.assertFalse(UploadValidationUtil.isDestinationValid(dc));
	}
	
	@Test
	public void testinvalidDClength()
	{
		
		String dc="45689";
		Assert.assertFalse(UploadValidationUtil.isDestinationValid(dc));
	}
	
	@Test
	public void testValidVendor()
	{
		String vndr="386225";
		Assert.assertTrue(UploadValidationUtil.isVendorValid(vndr));
	}
	
	@Test
	public void testInValidVendor()
	{
		String vndr="386225se";
		Assert.assertFalse(UploadValidationUtil.isVendorValid(vndr));
	}
	
	@Test
	public void testvalidflag()
	{
		String flag="Y";
		Assert.assertTrue(UploadValidationUtil.isFlagValid(flag));
	}
	
	@Test
	public void testInvalidflag()
	{
		String flag="";
		Assert.assertFalse(UploadValidationUtil.isFlagValid(flag));
	}
	
	@Test
	public void testvalidHeaders() throws  Exception
	{
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/LaneUpload_validheader.csv"));
		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null); 
		Map<Integer, Object[]> fileContents = null;

		//Read the file content
		fileContents = fileObj.getFileContents();
		String[] uploadedHeader = (String[])fileContents.get(0);
		Assert.assertEquals(0,UploadValidationUtil.validateHeaderFields(uploadedHeader, UploadConstants.getShippingLaneHeader()));
	}
	
	@Test
	public void testinvalidHeaders() throws  Exception
	{
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/LaneUpload_invalidheader.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null); 
		Map<Integer, Object[]> fileContents = null;

		//Read the file content
		fileContents = fileObj.getFileContents();
		String[] uploadedHeader = (String[])fileContents.get(0);
		Assert.assertEquals(-1,UploadValidationUtil.validateHeaderFields(uploadedHeader, UploadConstants.getShippingLaneHeader()));
	}
	
	@Test
	public void testnoHeaders() throws  Exception
	{
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/Lane_Upload_NoHeader.csv"));
		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null); 
		Map<Integer, Object[]> fileContents = null;

		//Read the file content
		fileContents = fileObj.getFileContents();
		String[] uploadedHeader = (String[])fileContents.get(0);
		Assert.assertEquals(1,UploadValidationUtil.validateHeaderFields(uploadedHeader, UploadConstants.getShippingLaneHeader()));
	}
	
}
