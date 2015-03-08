package com.homedepot.di.xd.efs.businesshelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.homedepot.di.xd.efs.to.InputFileTO;
import com.homedepot.di.xd.efs.to.ResponseTO;
import com.homedepot.di.xd.efs.upload.FileParser;
import com.homedepot.di.xd.efs.upload.FileParserFactory;
import com.homedepot.di.xd.efs.upload.FileType;


/**
 * The class <code>ScheduleUploadProcessorTest</code> contains tests for the
 * class {@link <code>ScheduleUploadProcessor</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 3/6/15 4:56 PM
 *
 * @author 565581
 *
 * @version $Revision$
 */
public class ScheduleUploadProcessorTest {

	
	/**
	 * Test case when there is no header fields in the uploaded csv.
	 * @throws IOException
	 * @throws Exception
	 */
	@Test
	public void validateHeaderFieldsForSchedule() throws IOException, Exception
	{

		ScheduleUploadProcessor schedulePro = new ScheduleUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Schedule_NoHeader.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null); 
		Map<Integer, Object[]> fileContents = null;

		//Read the file content
		fileContents = fileObj.getFileContents();
		String[] uploadedHeader = (String[])fileContents.get(0);

		int val=schedulePro.validateHeader(uploadedHeader);
		Assert.assertEquals(1,val);

	}
	
	/**
	 * Test case when  valid header fields are present in the uploaded csv
	 * @throws IOException
	 * @throws Exception
	 */
	@Test
	public void validateHeaderFieldsForScheduleForvalidheaders() throws IOException, Exception
	{

		ScheduleUploadProcessor schedulePro = new ScheduleUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Schedule_ValidHeader.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null); 
		Map<Integer, Object[]> fileContents = null;

		//Read the file content
		fileContents = fileObj.getFileContents();
		String[] uploadedHeader = (String[])fileContents.get(0);

		int val=schedulePro.validateHeader(uploadedHeader);
		Assert.assertEquals(0,val);

	}
	
	
	/**
	 * Test case when  invalid header fields are present in the uploaded csv
	 * @throws IOException
	 * @throws Exception
	 */
	@Test
	public void validateHeaderFieldsForScheduleForInvalidheaders() throws IOException, Exception
	{

		ScheduleUploadProcessor schedulePro = new ScheduleUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Schedule_InvalidHeader.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null); 
		Map<Integer, Object[]> fileContents = null;

		//Read the file content
		fileContents = fileObj.getFileContents();
		String[] uploadedHeader = (String[])fileContents.get(0);

		int val=schedulePro.validateHeader(uploadedHeader);
		Assert.assertEquals(-1,val);

	}
	
	/**
	 * Test case when  invalid origin is present in the csv
	 * @throws IOException
	 * @throws Exception
	 */

	@Test
	public void validateOrigin() throws IOException, Exception
	{
		ScheduleUploadProcessor schedulePro = new ScheduleUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Schedule_InvalidOrigin.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		schedulePro.processValidHeaderDataForSchedule(fileObj, responseTo);
		
		Assert.assertNotNull(responseTo);
		//Assert.Assert.assertEquals(UploadConstants.INVALID_ORIGIN,responseTo.getErrorMsg());

	}
	
	/**
	 * Test case when origin field is empty in the csv
	 * @throws IOException
	 * @throws Exception
	 */
	@Test
	public void validateEmptyOrigin() throws IOException, Exception
	{
		ScheduleUploadProcessor schedulePro = new ScheduleUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/LaneUpload_EmptyOrigin.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.SCHEDULE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		schedulePro.processValidHeaderDataForSchedule(fileObj, responseTo);

		Assert.assertNotNull(responseTo);
		//Assert.assertEquals(UploadConstants.INVALID_ORIGIN,responseTo.getErrorMsg());
	}
	
	//validateDC
	//validateScheduleTypeCd
	//validateScheduleGrpCd
	//validateEffectiveBeginDate
	//validateEffectiveEndDate
	
	
	
	
	
	
	
	
}
