package com.homedepot.di.xd.efs.to;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

/**
 * The class <code>LaneTOTest</code> contains tests for the class {@link
 * <code>LaneTO</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 2/20/15 4:08 PM
 *
 * @author 583541
 *
 * @version $Revision$
 */
public class LaneTOTest {


	@Test
	public void testGetAndSetForlaneId()
	{
		LaneTO lto = new LaneTO();
		int laneId=1;
		lto.setLaneId(laneId);
		assertEquals(laneId,lto.getLaneId());

	}

	@Test
	public void testGetAndSetcreatedUserId()
	{
		LaneTO lto = new LaneTO();
		String  userid="SXP8562";
		lto.setCreatedUserId(userid);
		assertEquals(userid,lto.getCreatedUserId());

	}


	@Test
	public void testGetAndSetcreatedTs()
	{
		LaneTO lto = new LaneTO();
		Date newdate = new Date(System.currentTimeMillis());
		lto.setCreatedTs(new Date(System.currentTimeMillis()));
		assertEquals(newdate,lto.getCreatedTs());

	}


	@Test
	public void testGetAndSetlastUptdUserId()
	{
		LaneTO lto = new LaneTO();
		String  userid="SXP8562";
		lto.setLastUptdUserId(userid);
		assertEquals(userid,lto.getLastUptdUserId());

	}

	@Test
	public void testGetAndSetlastUptdTs()
	{
		LaneTO lto = new LaneTO();
		Date newdate = new Date(System.currentTimeMillis());
		lto.setLastUptdTs(newdate);
		assertEquals(newdate,lto.getLastUptdTs());

	}


	@Test
	public void testGetAndSetFordestinationLocId()
	{
		LaneTO lto = new LaneTO();
		int destinationLocId=201;
		lto.setDestinationLocId(destinationLocId);
		assertEquals(destinationLocId,lto.getDestinationLocId());

	}

	@Test
	public void testGetAndSetFororiginLocId()
	{
		LaneTO lto = new LaneTO();
		int originLocId=101;
		lto.setOriginLocId(originLocId);
		assertEquals(originLocId,lto.getOriginLocId());

	}

	@Test
	public void testGetAndSetshppingLaneName()
	{
		LaneTO lto = new LaneTO();
		String  shppingLaneName="BREAUX BRIDGE - 5520";
		lto.setShppingLaneName(shppingLaneName);
		assertEquals(shppingLaneName,lto.getShppingLaneName());

	}

	@Test
	public void testGetAndSetactiveFlag()
	{
		LaneTO lto = new LaneTO();
		Boolean  activeFlag=true;
		lto.setActiveFlag(activeFlag);
		assertTrue(lto.isActiveFlag());

	}

	@Test
	public void testGetAndSetoriginId()
	{
		LaneTO lto = new LaneTO();
		String  originId="454512LA001";
		lto.setOriginId(originId);
		assertEquals(originId,lto.getOriginId());

	}

	@Test
	public void testGetAndSetdestinationId()
	{
		LaneTO lto = new LaneTO();
		String  destinationId="5520";
		lto.setDestinationId(destinationId);
		assertEquals(destinationId,lto.getDestinationId());

	}
  
	@Test
	public void testGetAndSeterrorString()
	{
		LaneTO lto = new LaneTO();
		String  errorString="Record already exists";
		lto.setErrorString(errorString);
		assertEquals(errorString,lto.getErrorString());

	}

	@Test
	public void testGetAndSetLaneLoadGroupTO()
	{
		LaneTO lto1 = new LaneTO();
		LaneLoadGroupTO lto = new LaneLoadGroupTO();
		int laneLoadGrpId=1;
		lto.setLandLoadGroupId(laneLoadGrpId);
		int laneId=123;
		lto.setLaneId(laneId);
		String  createdUserId="SXP8562";
		lto.setCreatedUserId(createdUserId);
		lto.setCreatedTs(new Date(System.currentTimeMillis()));
		String  userid="SXP8562";
		lto.setLastUptdUserId(userid);
		Date newdate2 = new Date(System.currentTimeMillis());
		lto.setLastUptdTs(newdate2);
		Date effectiveBeginDate = new Date(System.currentTimeMillis());
		lto.setEffectiveBeginDate(effectiveBeginDate);
		Date effectiveEndDate = new Date(System.currentTimeMillis());
		lto.setEffectiveEndDate(effectiveEndDate);
		String  laneLoadGroupName="SXP8562";
		lto.setLaneLoadGroupName(laneLoadGroupName);
		lto1.setLaneLoadGroupTo(lto);
		assertNotNull(lto1);

	}


}

