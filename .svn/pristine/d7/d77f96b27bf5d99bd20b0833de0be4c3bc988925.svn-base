/**
 * 
 */
package com.homedepot.di.xd.efs.to;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.junit.Test;

import com.homedepot.di.xd.efs.upload.FileParser;
import com.homedepot.di.xd.efs.upload.FileParserFactory;
import com.homedepot.di.xd.efs.upload.FileType;


/**
 * @author 588893
 *
 */
public class InputFileTOTest {

	/*@Test
	public void testSetAndGetInputStream() throws FileNotFoundException {
		
		InputFileTO fileTO = new InputFileTO(null, null, null);
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_Template.csv"));
		fileTO.setInputStream(uploadedInputStream);
		uploadedInputStream = 	fileTO.getInputStream();
		assertNotNull(uploadedInputStream);
		
	}*/
	
	@Test
	public void testSetAndGetFileName(){
		
		InputFileTO fileTO = new InputFileTO(null, null, null);
		String fileName = "EFS";
		fileTO.setFileName(fileName);
		assertEquals(fileName, fileTO.getFileName());
	}
	
	@Test
	public void testSetAndGetUserId(){
		
		InputFileTO fileTO = new InputFileTO(null, null, null);
		String userId = "mxg8621";
		fileTO.setUserId(userId);
		assertEquals(userId, fileTO.getUserId());
	}
	
	
	@Test
	public void testSetAndGetFileType(){
		
		InputFileTO fileTO = new InputFileTO(null, null, null);
		String fileType = "EFS";
		fileTO.setFileType(fileType);
		assertEquals(fileType, fileTO.getFileType());
	}

	@Test
	public void testSetAndGetFileTypeCode(){
		
		InputFileTO fileTO = new InputFileTO(null, null, null);
		short fileTypeCode = 4;
		fileTO.setFileTypeCode(fileTypeCode);
		assertEquals(fileTypeCode, fileTO.getFileTypeCode());
	}
	
	/*@Test
	public void testInputFileTO() throws FileNotFoundException{
		
		InputFileTO fileTO = null;
		
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_Template.csv"));
		String fileName = "EFS_Location_Template.csv";
		String userId = "mxg8621";
		
		fileTO = new InputFileTO(uploadedInputStream,
				fileName, userId);
		
		assertNotNull(fileTO);
	}
*/

	
	@Test
	public void testLaneSetAndGetFileName(){
		
		InputFileTO fileTO = new InputFileTO(null, null, null);
		String fileName = "LaneUpload";
		fileTO.setFileName(fileName);
		assertEquals(fileName, fileTO.getFileName());
	}
	
	@Test
	public void testLaneSetAndGetUserId(){
		
		InputFileTO fileTO = new InputFileTO(null, null, null);
		String userId = "sxv8609";
		fileTO.setUserId(userId);
		assertEquals(userId, fileTO.getUserId());
	}
	
	
	@Test
	public void testLaneSetAndGetFileType(){
		
		InputFileTO fileTO = new InputFileTO(null, null, null);
		String fileType = "Lane";
		fileTO.setFileType(fileType);
		assertEquals(fileType, fileTO.getFileType());
	}

	@Test
	public void testLaneSetAndGetFileTypeCode(){
		
		InputFileTO fileTO = new InputFileTO(null, null, null);
		short fileTypeCode = 2;
		fileTO.setFileTypeCode(fileTypeCode);
		assertEquals(fileTypeCode, fileTO.getFileTypeCode());
	}
	
	@Test
	public void testLaneInputFileTO() throws Exception{
		
		InputFileTO fileObj = null;
		
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/Lane_Upload_Template.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		 fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);
		
		assertNotNull(fileObj);
	}
	
	

}
