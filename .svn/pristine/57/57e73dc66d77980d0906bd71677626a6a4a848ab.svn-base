/**
 * 
 */
package com.homedepot.di.xd.efs.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.csvreader.CsvReader;
import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.InputFileTO;

/**
 * @author 588893
 *
 */
public class EFSValidationUtilTest {

	@Test
	public void testGetMinRecordCount() throws EFSException, IOException {
		
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_Template.csv"));
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		int recCount = ValidationUtil.getRecordCount(reader);
		
		assertEquals(UploadConstants.MIN_ROW_COUNT, recCount);
	}
	
	
	@Test
	public void testGetMaxRecordCount() throws FileNotFoundException, UnsupportedEncodingException, EFSException {
		
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_Max_Records.csv"));
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		
		int recCount = ValidationUtil.getRecordCount(reader);
		
		assertEquals(UploadConstants.MAX_ROW_COUNT, recCount);
	}
	
	
	@Test
	public void testIsEmpty(){
		
		String uploadType = "ESA";
		assertNotNull(ValidationUtil.isEmpty(uploadType));
		
	}

	/*@Test
	public void testIsRowEmpty() throws Exception{
		
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_Valid.csv"));
		
		InputFileTO fileInput = new InputFileTO(uploadedInputStream, null, null);
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(fileInput.getInputStream(), "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		String[] row = reader.getValues();
		
		assertFalse(ValidationUtil.isRowEmpty(row));
		
	}
	
	
	@Test
	public void testIsRowEmptyForNoRows() throws Exception{
		
		InputStream uploadedInputStream = new FileInputStream(new File(
				"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_Template.csv"));
		
		InputFileTO fileInput = new InputFileTO(uploadedInputStream, null, null);
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(fileInput.getInputStream(), "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		String[] row = reader.getValues();
		
		assertTrue(ValidationUtil.isRowEmpty(row));
		
	}
	*/
	
	
}
