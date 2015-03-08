package com.homedepot.di.xd.efs.to;

import java.sql.Timestamp;

import org.junit.Assert;
import org.junit.Test;

import com.homedepot.di.xd.efs.to.LocationTO;

public class LocationTOTest {

	LocationTO locTO = null;
	
	@Test
	public void setAndGetLocationId(){
		locTO = new LocationTO();
		locTO.setLocationId(1);
		Assert.assertEquals(1, locTO.getLocationId());
	}
	
	@Test
	public void setAndGetCreateUserId(){
		locTO = new LocationTO();
		locTO.setCreateUserId("PXA8573");
		Assert.assertEquals("PXA8573", locTO.getCreateUserId());
	}

	@Test
	public void setAndGetCreateTimeStamp(){
		locTO = new LocationTO();
		Timestamp timestamp = Timestamp.valueOf("2015-02-18 10:10:10.0");
		locTO.setCreateTimeStamp(timestamp);
		Assert.assertEquals(timestamp,locTO.getCreateTimestamp());
		
	}
	
	@Test
	public void setAndGetUpdatedUserId(){
		locTO = new LocationTO();
		locTO.setLastUpdatedUserId("PXA8573");
		Assert.assertEquals("PXA8573", locTO.getLastUpdatedUserId());
	}
	
	@Test
	public void setAndGetUpdatedTimestamp(){
		locTO = new LocationTO();
		Timestamp timestamp = Timestamp.valueOf("2015-02-18 10:10:10.0");
		locTO.setLastUpdatedTimestamp(timestamp);
		Assert.assertEquals(timestamp,locTO.getLastUpdatedTimestamp());
	}
	
	@Test
	public void setAndGetAddressLine1(){
		locTO = new LocationTO();
		locTO.setAddressLine1("1224 SALTMINE HIGHWAY");
		Assert.assertEquals("1224 SALTMINE HIGHWAY", locTO.getAddressLine1());
	}
	
	@Test
	public void setAndGetAddressLine2(){
		locTO = new LocationTO();
		locTO.setAddressLine2("1224 SALTMINE HIGHWAY");
		Assert.assertEquals("1224 SALTMINE HIGHWAY", locTO.getAddressLine2());
	}@Test
	public void setAndGetAddressLine3(){
		locTO = new LocationTO();
		locTO.setAddressLine3("1224 SALTMINE HIGHWAY");
		Assert.assertEquals("1224 SALTMINE HIGHWAY", locTO.getAddressLine3());
	}@Test
	public void setAndGetAddressLine4(){
		locTO = new LocationTO();
		locTO.setAddressLine4("1224 SALTMINE HIGHWAY");
		Assert.assertEquals("1224 SALTMINE HIGHWAY", locTO.getAddressLine4());
	}@Test
	public void setAndGetAddressLine5(){
		locTO = new LocationTO();
		locTO.setAddressLine5("1224 SALTMINE HIGHWAY");
		Assert.assertEquals("1224 SALTMINE HIGHWAY", locTO.getAddressLine5());
	}
	
	@Test
	public void setAndGetCityName(){
		locTO = new LocationTO();
		locTO.setCityName("FREEDOM");
		Assert.assertEquals("FREEDOM", locTO.getCityName());
	}
	
	@Test
	public void setAndGetStateCode(){
		locTO = new LocationTO();
		locTO.setStateCode("OK");
		Assert.assertEquals("OK", locTO.getStateCode());
	}
	
	@Test
	public void setAndGetPostalCode(){
		locTO = new LocationTO();
		locTO.setPostalCode("73842");
		Assert.assertEquals("73842", locTO.getPostalCode());
	}
	
	@Test
	public void setAndGetCountryCode() {
		locTO = new LocationTO();
		locTO.setCountryCode("US");
		Assert.assertEquals("US", locTO.getCountryCode());
	}
	
	@Test
	public void setAndGetLatitude(){
		locTO = new LocationTO();
		locTO.setLatitude("36.8074");
		Assert.assertEquals("36.8074", locTO.getLatitude());
	}
	
	@Test
	public void setAndGetLongitude(){
		locTO = new LocationTO();
		locTO.setLongitude("91.9477");
		Assert.assertEquals("91.9477", locTO.getLongitude());
	}
	
	@Test
	public void setAndGetLocationTypeCode(){
		locTO = new LocationTO();
		locTO.setLocationTypeCd("2");
		Assert.assertEquals("2", locTO.getLocationTypeCd());
	}
	
	@Test
	public void setAndGetLocationName(){
		locTO = new LocationTO();
		locTO.setLocationName("CARGILL SALT - FREEDOM");
		Assert.assertEquals("CARGILL SALT - FREEDOM", locTO.getLocationName());
	}
	
	@Test
	public void setAndGetActiveFlg(){
		locTO  = new LocationTO();
		locTO.setActiveFlg("Y");
		Assert.assertEquals("Y", locTO.getActiveFlg());
	}

	@Test
	public void setAndGetSourceLocationNumber(){
		locTO = new LocationTO();
		locTO.setSourceLocationNbr("5047");
		Assert.assertEquals("5047", locTO.getSourceLocationNbr());
	}

	
	@Test
	public void testSetAndGetErrorString(){
		locTO = new LocationTO();
		String errorString = "Invalid";
		locTO.setErrorString(errorString);
		Assert.assertEquals(errorString, locTO.getErrorString());
	}
	
	
	@Test
	public void testSetAndGetRowNumber(){
		locTO = new LocationTO();
		int rowNumber = 1;
		locTO.setRowNumber(rowNumber);
		Assert.assertEquals(rowNumber, locTO.getRowNumber());
	}
	
}
