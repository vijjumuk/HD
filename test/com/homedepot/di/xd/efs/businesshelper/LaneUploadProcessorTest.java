package com.homedepot.di.xd.efs.businesshelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.to.InputFileTO;
import com.homedepot.di.xd.efs.to.ResponseTO;
import com.homedepot.di.xd.efs.upload.FileParser;
import com.homedepot.di.xd.efs.upload.FileParserFactory;
import com.homedepot.di.xd.efs.upload.FileType;

/**
 * The class <code>LaneUploadProcessorTest</code> contains tests for the class
 * {@link <code>LaneUploadProcessor</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 2/20/15 6:40 PM
 *
 * @author 583541
 *
 * @version $Revision$
 */
public class LaneUploadProcessorTest {


	//Test case when there is no header fields in the uploaded csv.
	@Test

	public void validateHeaderFieldsForLane() throws IOException, Exception
	{

		LaneUploadProcessor lanepro = new LaneUploadProcessor();

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

		int val=lanepro.validateHeader(uploadedHeader);
		Assert.assertEquals(1,val);


	}

	//Test case when  valid header fields are present in the uploaded csv
	@Test

	public void validateHeaderFieldsForLaneForvalidheaders() throws IOException, Exception
	{
		LaneUploadProcessor lanepro = new LaneUploadProcessor();
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

		Assert.assertEquals(0,lanepro.validateHeader(uploadedHeader));
	}


	//Test case when invalid header fields are present in the uploaded csv
	@Test

	public void validateHeaderFieldsForLaneForInvalidheaders() throws IOException, Exception 
	{
		LaneUploadProcessor lanepro = new LaneUploadProcessor();
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

		Assert.assertEquals(-1,lanepro.validateHeader(uploadedHeader));
	}


	//Test case when  invalid origin is present in the csv

	@Test
	public void validateOrigin() throws IOException, Exception
	{
		LaneUploadProcessor lanepro = new LaneUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/LaneUpload_InvalidOrigin.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		lanepro.processValidHeaderDataForLane(fileObj, responseTo);

		Assert.assertEquals(UploadConstants.INVALID_ORIGIN,responseTo.getErrorMsg());

	}

	//Test case when origin field is empty in the csv


	@Test
	public void validateEmptyOrigin() throws IOException, Exception
	{
		LaneUploadProcessor lanepro = new LaneUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/LaneUpload_EmptyOrigin.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		lanepro.processValidHeaderDataForLane(fileObj, responseTo);

		Assert.assertEquals(UploadConstants.INVALID_ORIGIN,responseTo.getErrorMsg());

	}

	@Test
	public void validateDC() throws IOException, Exception
	{
		LaneUploadProcessor lanepro = new LaneUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/LaneUpload_InvalidDC.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		lanepro.processValidHeaderDataForLane(fileObj, responseTo);

		Assert.assertEquals(UploadConstants.INVALID_DESTINATION,responseTo.getErrorMsg());

	}

	@Test
	public void validateDCempty() throws IOException, Exception
	{
		LaneUploadProcessor lanepro = new LaneUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/LaneUpload_EmptyDC.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		lanepro.processValidHeaderDataForLane(fileObj, responseTo);

		Assert.assertEquals(UploadConstants.INVALID_DESTINATION,responseTo.getErrorMsg());

	}

/*	@Test
	public void validateLane() throws IOException, Exception
	{
		LaneUploadProcessor lanepro = new LaneUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/LaneUpload_InvalidLaneName.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				"lane", "sxv8609");

		ResponseTO responseTo = new ResponseTO();
		lanepro.processValidHeaderDataForLane(fileObj, responseTo);

		Assert.assertEquals(UploadConstants.INVALID_LANE_NAME,responseTo.getErrorMsg());

	}*/


	@Test
	public void validatevendorNumber() throws IOException, Exception
	{
		LaneUploadProcessor lanepro = new LaneUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/LaneUpload_Invalid_vendor.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		lanepro.processValidHeaderDataForLane(fileObj, responseTo);

		Assert.assertEquals(UploadConstants.INVALID_VNDR,responseTo.getErrorMsg());

	}



	@Test
	public void VendorEffectivebegindate() throws IOException, Exception
	{
		LaneUploadProcessor lanepro = new LaneUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/LaneUpload_InvalidVendoreffBeginDate.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		lanepro.processValidHeaderDataForLane(fileObj, responseTo);

		Assert.assertEquals(UploadConstants.INVALID_VENDOR_EFF_BGN_DT,responseTo.getErrorMsg());


	}

	@Test
	public void VendorEffectiveenddate() throws IOException, Exception
	{
		LaneUploadProcessor lanepro = new LaneUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/LaneUpload_InvalidVendoreffEndDate.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		lanepro.processValidHeaderDataForLane(fileObj, responseTo);

		Assert.assertEquals(UploadConstants.INVALID_VENDOR_EFF_END_DT,responseTo.getErrorMsg());

	}

	@Test
	public void loadGroupEffectiveBeginDate() throws IOException, Exception
	{
		LaneUploadProcessor lanepro = new LaneUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/LaneUpload_InvalidLoadGroupeffBeginDate.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		lanepro.processValidHeaderDataForLane(fileObj, responseTo);

		Assert.assertEquals(UploadConstants.INVALID_LOAD_GRP_EFF_BGN_DT,responseTo.getErrorMsg());

	}

	@Test
	public void loadGroupEffectiveEndDate() throws IOException, Exception
	{
		LaneUploadProcessor lanepro = new LaneUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/LaneUpload_InvalidLoadGroupeffEndDate.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		lanepro.processValidHeaderDataForLane(fileObj, responseTo);

		Assert.assertEquals(UploadConstants.INVALID_LOAD_GRP_EFF_END_DT,responseTo.getErrorMsg());

	}

	@Test
	public void testvendorDCLocation() throws Exception 
	{
		LaneUploadProcessor lanepro = new LaneUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/LaneUpload_InvalidVendorDC.csv"));

		FileType fileType = FileType.getFileTypeFor(FileType.LANE.getFileType());
		FileParser parser = FileParserFactory.getFileParserFor(fileType);

		InputFileTO  fileObj  = new InputFileTO(parser.parse(uploadedInputStream),
				null, null);

		ResponseTO responseTo = new ResponseTO();
		lanepro.processValidHeaderDataForLane(fileObj, responseTo);
		Assert.assertEquals(UploadConstants.INVALID_DESTINATION +UploadConstants.INVALID_VNDR,responseTo.getErrorMsg());



	}
}


