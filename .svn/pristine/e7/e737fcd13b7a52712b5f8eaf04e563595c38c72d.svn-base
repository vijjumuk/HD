/**
 * 
 */
package com.homedepot.di.xd.efs.businesshelper;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import org.junit.Test;

import com.csvreader.CsvReader;
import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.InputFileTO;
import com.homedepot.di.xd.efs.to.ResponseTO;
import com.homedepot.di.xd.efs.upload.FileParser;
import com.homedepot.di.xd.efs.upload.FileParserException;
import com.homedepot.di.xd.efs.upload.FileParserFactory;
import com.homedepot.di.xd.efs.upload.FileType;
import com.homedepot.di.xd.efs.upload.FormatException;

/**
 * @author 588893
 *
 */
public class UploadManagerTest {/*

	@Test(expected = EFSException.class)
	public void testProcessUploadedFile() throws Exception{
		
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_Template.csv"));
		
		String fileName = "EFS_Location_Template.csv";
		String userId = "mxg8621";
		
		UploadManager uploadManager = new UploadManager();
		InputFileTO fileInput = new InputFileTO(uploadedInputStream, fileName, userId);
		ResponseTO responseTO = new ResponseTO();
		
		uploadManager.processUploadedFile(fileInput, responseTO);
	}
	
	@Test
	public void testGetUploadFileType() throws IOException{
		
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_Valid.csv"));
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		String[] uploadedHeader = reader.getValues(); 
		String fileType = UploadManager.identifyFileType(uploadedHeader);
		assertEquals(UploadConstants.EFS_LOCATION,fileType);
		
	}
	
	@Test
	public void testValidateHeaders() throws EFSException, IOException{
		
		UploadManager uploadManager = new UploadManager();
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_Template_No_Header.csv"));
		String fileName = "EFS_Location_Template.csv";
		String userId = "mxg8621";
		InputFileTO fileInput = new InputFileTO(uploadedInputStream, fileName, userId);
		ResponseTO responseTO = new ResponseTO();
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(fileInput.getInputStream(), "UTF-8")));
		//reader.skipRecord();
		boolean isHeaderValid = uploadManager.validateHeaders(reader, fileInput,responseTO);
		assertFalse(isHeaderValid);
		
	}
	
	@Test
	public void testValidateHeaderFields() throws IOException{
		
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_Template.csv"));
		
		InputFileTO fileInput = new InputFileTO(uploadedInputStream, null, null);
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(fileInput.getInputStream(), "UTF-8")));
		reader.skipRecord();
		String[] uploadedHeader = reader.getValues();
		int isHeaderValid = UploadManager.validateHeaderFields(uploadedHeader,
				UploadConstants.getLocationHeader());
		assertEquals(0, isHeaderValid);
	}
	*/
	@Test
	public void testProcessUploadedFileForLane() throws Exception{
		
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/Lane_Upload_Template.csv"));
		
		
		UploadManager uploadManager = new UploadManager();
		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null); 
		ResponseTO responseTO = new ResponseTO();
		
		uploadManager.processUploadedFile(fileObj, responseTO);
	}
	
	@Test
	public void testGetUploadFileTypeForLane() throws Exception{
		
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/Lane_Upload_Valid.csv"));
		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null); 
		Map<Integer, Object[]> fileContents = null;

		//Read the file content
		fileContents = fileObj.getFileContents();
		String[] uploadedHeader = (String[])fileContents.get(0);
		String fileTyp = UploadManager.identifyFileType(uploadedHeader);
		assertEquals(UploadConstants.LANE_UPLOAD,fileTyp);
		
	}
	
		
		
		
	
	
	@Test
	public void testValidateHeaderFieldsForLane() throws Exception{
		
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/Lane_Upload_Template.csv"));
		
		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null); 
		Map<Integer, Object[]> fileContents = null;

		//Read the file content
		fileContents = fileObj.getFileContents();
		String[] uploadedHeader = (String[])fileContents.get(0);
		int isHeaderValid = UploadManager.validateHeaderFields(uploadedHeader,
				UploadConstants.getShippingLaneHeader());
		assertEquals(-1, isHeaderValid);
	}
}
