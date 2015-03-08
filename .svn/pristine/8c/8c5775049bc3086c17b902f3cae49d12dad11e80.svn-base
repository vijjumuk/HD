package com.homedepot.di.xd.efs.businesshelper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import com.csvreader.CsvReader;
import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.InputFileTO;
import com.homedepot.di.xd.efs.to.LocationTO;
import com.homedepot.di.xd.efs.to.ResponseTO;
import com.homedepot.homer.util.HomerUnitTestCase;

public class LocationUploadProcessorTest extends HomerUnitTestCase {

	String userId = "nab04";
	@Test
	public void inValidLocationNumber() throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();
		LocationTO locationTO = new LocationTO();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_InvalidLocation.csv"));
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		locationProcessor.validateLocationDetail(row, errString, locationTO);
		Assert.assertEquals("Invalid Location Number,", errString.toString());
	}
	
	
	@Test
	public void inValidLocationDCNumber() throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();
		LocationTO locationTO = new LocationTO();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_InvalidLocationDC.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		locationProcessor.validateLocationDetail(row, errString, locationTO);
		Assert.assertEquals("Invalid Location Number,", errString.toString());
	}
	
	@Test
	public void inValidLocationDescription() throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();

		LocationTO locationTO = new LocationTO();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_inValidLocName.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		locationProcessor.validateLocationDetail(row, errString, locationTO);
		Assert.assertEquals("Invalid Location Name,", errString.toString());
	}
	
	
	@Test
	public void inValidLocationAddressLine1() throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();

		LocationTO locationTO = new LocationTO();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_InvalidAddressLine1.csv"));
		
		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		locationProcessor.validateAddressLines(row, errString, locationTO);
		Assert.assertEquals(" Invalid Address Line 1,", errString.toString());
	}
	
	@Test
	public void inValidLocationAddressLine2() throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();
		LocationTO locationTO = new LocationTO();
		StringBuilder errString = new StringBuilder();
		String[] row;
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_InvalidAddressLine2.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		locationProcessor.validateAddressLines(row, errString, locationTO);
		
		Assert.assertEquals(" Invalid Address Line 2,", errString.toString());
	}
	
	@Test
	public void inValidLocationAddressLine3() throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();

		LocationTO locationTO = new LocationTO();
		StringBuilder errString = new StringBuilder();
		String[] row;
		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_InvalidAddressLine3.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		locationProcessor.validateAddressLines(row, errString, locationTO);
		
		Assert.assertEquals(" Invalid Address Line 3,", errString.toString());
	}
	
	@Test
	public void inValidLocationAddressLine4() throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();
		LocationTO locationTO = new LocationTO();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_InvalidAddressLine4.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		locationProcessor.validateAddressLines(row, errString, locationTO);
		Assert.assertEquals(" Invalid Address Line 4,", errString.toString());
	}
	
	@Test
	public void inValidLocationAddressLine5() throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();
		LocationTO locationTO = new LocationTO();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_InvalidAddressLine5.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		locationProcessor.validateAddressLines(row, errString, locationTO);
		Assert.assertEquals(" Invalid Address Line 5,", errString.toString());
	}
	
	@Test
	public void inValidCityName() throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();
		LocationTO locationTO = new LocationTO();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_InvalidCityName.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));

		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		locationProcessor.validateCityDetails(row, errString, locationTO);
		Assert.assertEquals(" Invalid City Name,", errString.toString());
	}
	
	@Test
	public void inValidStateCode() throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();
		LocationTO locationTO = new LocationTO();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_InvalidStateCode.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		locationProcessor.validateCityDetails(row, errString, locationTO);
		
		Assert.assertEquals(" Invalid State code,", errString.toString());
	}
	
	@Test
	public void inValidPostalCode()throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();

		LocationTO locationTO = new LocationTO();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_InvalidPostalCode.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		locationProcessor.validateCityDetails(row, errString, locationTO);
		
		Assert.assertEquals(" Invalid Postal code,", errString.toString());
	}
	
	@Test
	public void inValidLatitude()throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();

		LocationTO locationTO = new LocationTO();
		StringBuilder errString = new StringBuilder();
		String[] row;		
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_InvalidLatitude.csv"));

		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		locationProcessor.validateCityDetails(row, errString, locationTO);
		Assert.assertEquals(" Invalid latitude Value,",errString.toString());
	}
	
	@Test
	public void inValidLongitude()throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();
		LocationTO locationTO = new LocationTO();
		StringBuilder errString = new StringBuilder();
		String[] row;
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_InvalidLongitude.csv"));


		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		locationProcessor.validateCityDetails(row, errString, locationTO);
		Assert.assertEquals(" Invalid Longitude Value,",errString.toString());
	}
	
	@Test
	public void inValidCountryCode()throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();
		LocationTO locationTO = new LocationTO();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_InvalidCountryCode.csv"));


		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		locationProcessor.validateCityDetails(row, errString, locationTO);
		Assert.assertEquals(" Invalid Country code,", errString.toString());
	}
	
	@Test
	public void inValidLocTypeCd()throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();
		LocationTO locationTO = new LocationTO();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_InvalidLocTypCd.csv"));


		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		locationProcessor.validateLocationDetail(row, errString, locationTO);
		Assert.assertEquals(" Invalid Location type code,", errString.toString());
	}
	
	/*@Test
	public void inValidLocTypeCdValue()throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();
		LocationTO locationTO = new LocationTO();
		StringBuilder errString = new StringBuilder();
		String[] row;	
		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_InvalidLocTypCdValue.csv"));


		CsvReader reader = new CsvReader(new BufferedReader(
				new InputStreamReader(uploadedInputStream, "UTF-8")));
		reader.skipRecord();
		reader.skipRecord();
		row = reader.getValues();
		
		locationProcessor.validateLocationDetail(row, errString, locationTO);
		Assert.assertEquals(" Invalid Location type code,", errString.toString());
	}*/
	
	/*@Test
	public void inValidActiveFlg()throws Exception {
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();

		InputStream uploadedInputStream = new FileInputStream(
				new File(
						"./test/com/homedepot/di/xd/efs/testdata/EFS_Location_InvalidActiveFlg.csv"));

		InputFileTO fileObj = new InputFileTO(uploadedInputStream, null, userId);
		ResponseTO responseTo = new ResponseTO();
		locationProcessor.processDataForLocation(fileObj, responseTo);
		Assert.assertEquals("No of Records Processed is 0 and No of Records errored out is 1", responseTo.getReturnMessage());
	}*/
	
	@Test
	public void getInsertAndUpdateLocationDetailsTest() throws EFSException{
		
		LocationUploadProcessor locationProcessor = new LocationUploadProcessor();
		LocationTO locTo = null;
		Map<String, Integer> locationAndXrefDetailsMap = new HashMap<String, Integer>();
		List<LocationTO> locationToList = new ArrayList<LocationTO>();
	    locTo= new LocationTO();
		locTo.setLocationId(1);
		locTo.setLocationTypeCd("13");
		locTo.setSourceLocationNbr("5047");
		locationToList.add(locTo);
		locationAndXrefDetailsMap.put("13-5047", 1);
		
		locTo = new LocationTO();
		locTo.setLocationId(2);
		locTo.setLocationTypeCd("13");
		locTo.setSourceLocationNbr("5023");
		locationToList.add(locTo);
		List<LocationTO> updateLocationList = locationProcessor.getInsertAndUpdateLocationDetails(locationAndXrefDetailsMap,locationToList);
	}

}
