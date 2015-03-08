package com.homedepot.di.xd.efs.dao;

import java.sql.Date;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.LaneLoadGroupTO;
import com.homedepot.di.xd.efs.to.LaneLoadGroupVendorTO;
import com.homedepot.di.xd.efs.to.LaneTO;
import com.homedepot.homer.util.HomerUnitTestCase;
import com.homedepot.ta.aa.dao.exceptions.QueryException;

public class LaneUploadDAOTest extends HomerUnitTestCase {
	
	static int laneId =100;
	static int laneGroupId=1;
	static int laneGrpVndrId=500;
	
	@Before
	public void setUp()

	throws Exception {

	// add additional set up code here

	}




	@After

	public void tearDown()

	throws Exception {

	// Add additional tear down code here

	}


	

	@Test
	public void getLaneId() throws EFSException {
		int origin = 101;
		int destination = 201;
		Assert.assertEquals(LaneUploadDAO.getLaneId(origin, destination), 1);

	}

	@Test
	public void getLaneGroupId() throws EFSException {
		int laneId = 1;
		String groupName = "DEFAULT";
		Assert.assertEquals(LaneUploadDAO.getLaneGroupId(laneId, groupName),
				123);
	}

	@Test
	public void getLaneLoadGroupVendorId() throws EFSException {
		int laneGroupId = 123;
		String vendorNumber = "383625";
		Assert.assertEquals(
				LaneUploadDAO.getLaneLoadGroupVendorId(laneGroupId, vendorNumber), 800);
	}

	@Test
	public void validateMvendorNumbersforLane() throws QueryException {
		List<String> vndrList = new ArrayList<String>();
		vndrList.add("383625");
		vndrList.add("10017");
		Assert.assertNotNull(LaneUploadDAO.validateMvendorNumbers(vndrList));

	}

	@Test
	public void getLaneValidEFSLocationIds() {
		List<String> sourceLocationId = new ArrayList<String>();
		sourceLocationId.add("5520");
		sourceLocationId.add("688509TX002");
		sourceLocationId.add("454512OK001");
		sourceLocationId.add("471003IL001");
		Map<String, Integer> locationMap = new HashMap<String, Integer>();

		LaneUploadDAO.getValidEFSLocationIds(sourceLocationId, locationMap);
		Assert.assertTrue(locationMap.size() > 1);

	}

	@Test
	public void insertRecordsShpLane_1() throws EFSException {
		LaneTO lt = new LaneTO();
		laneId++;
		lt.setLaneId(laneId);
		lt.setOriginLocId(105);
		lt.setDestinationLocId(205);
		lt.setCreatedUserId("SXP8562");
		lt.setLastUptdUserId("SXP8562");
		lt.setActiveFlag(true);
		lt.setShppingLaneName("BREAUX BRIDGE - 5520");
		
		da.table("SCHN_SHPG_LANE").where("SCHN_SHPG_LANE_ID = "+laneId);
		da.assert_count(0);
		Assert.assertTrue(LaneUploadDAO.createLane(lt));

		da.table("SCHN_SHPG_LANE").where("SCHN_SHPG_LANE_ID = "+laneId);
		da.assert_count(1);

	}

	@Test
	public void insertRecordsShpgLaneLoadGrp() throws EFSException {

		LaneLoadGroupTO laneLoadGroupTo = new LaneLoadGroupTO();
		laneGroupId++;
		laneLoadGroupTo.setLandLoadGroupId(laneGroupId);
		laneLoadGroupTo.setCreatedUserId("SXP8562");
		laneLoadGroupTo.setLastUptdUserId("SXP8562");
		laneLoadGroupTo.setLaneId(1);
		laneLoadGroupTo.setEffectiveBeginDate(new Date(System
				.currentTimeMillis()));
		laneLoadGroupTo
				.setEffectiveEndDate(new Date(System.currentTimeMillis()));
		laneLoadGroupTo.setLaneLoadGroupName("DEFAULT");

		da.table("SCHN_SHPG_LANE_LOAD_GRP").where("SCHN_SHPG_LANE_LOAD_GRP_ID = "+laneGroupId);
		da.assert_count(0);
		Assert.assertTrue(LaneUploadDAO.createLaneLoadGroup(laneLoadGroupTo));

		da.table("SCHN_SHPG_LANE_LOAD_GRP").where("SCHN_SHPG_LANE_LOAD_GRP_ID = "+laneGroupId);
		da.assert_count(1);

	}

	@Test
	public void testinsertRecordsShpgLaneLoadGrpVndr() throws EFSException {

		LaneLoadGroupVendorTO laneLoadGroupVendorTO = new LaneLoadGroupVendorTO();
		laneGrpVndrId++;
		laneLoadGroupVendorTO.setLaneLoadGrpVndrId(laneGrpVndrId);
		laneLoadGroupVendorTO.setCreatedUserId("SXP8562");
		laneLoadGroupVendorTO.setLastUptdUserId("SXP8562");
		laneLoadGroupVendorTO.setMvndrNbr("383625");
		laneLoadGroupVendorTO.setDepartmentNbr((short) 26);
		laneLoadGroupVendorTO.setLaneLoadGrpId(123);
		laneLoadGroupVendorTO.setEffectiveBeginDate(new Date(System
				.currentTimeMillis()));
		laneLoadGroupVendorTO.setEffectiveEndDate(new Date(System
				.currentTimeMillis()));
		laneLoadGroupVendorTO.setMerchendiseBaseCode((short) 1);
		laneLoadGroupVendorTO.setPrimaryLocation("Y");
		da.table("SCHN_SHLANE_LGRP_VNDR").where(
				"SCHN_SHLANE_LGRP_VNDR_ID = "+laneGrpVndrId);
		da.assert_count(0);
		Assert.assertTrue(LaneUploadDAO
				.createLaneLoadGroupVendor(laneLoadGroupVendorTO));

		da.table("SCHN_SHLANE_LGRP_VNDR").where(
				"SCHN_SHLANE_LGRP_VNDR_ID = "+laneGrpVndrId);
		da.assert_count(1);

	}

	
}
