package com.homedepot.di.xd.efs.to;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

/**
 * The class <code>LaneLoadGroupTOTest</code> contains tests for the class
 * {@link <code>LaneLoadGroupTO</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 2/20/15 4:07 PM
 *
 * @author 583541
 *
 * @version $Revision$
 */
public class LaneLoadGroupTOTest {


	@Test
	public void testGetAndSetForlaneLoadGrpId()
	{
		LaneLoadGroupTO lto = new LaneLoadGroupTO();
		int laneLoadGrpId=1;
		lto.setLandLoadGroupId(laneLoadGrpId);
		assertEquals(laneLoadGrpId,lto.getLandLoadGroupId());

	}
	@Test
	public void testGetAndSetForlaneId()
	{
		LaneLoadGroupTO lto = new LaneLoadGroupTO();
		int laneId=123;
		lto.setLaneId(laneId);
		assertEquals(laneId,lto.getLaneId());

	}

	@Test
	public void testGetAndSetcreatedUserId()
	{
		LaneLoadGroupTO lto = new LaneLoadGroupTO();
		String  createdUserId="SXP8562";
		lto.setCreatedUserId(createdUserId);
		assertEquals(createdUserId,lto.getCreatedUserId());

	}


	@Test
	public void testGetAndSetcreatedTs()
	{
		LaneLoadGroupTO lto = new LaneLoadGroupTO();
		Date newdate = new Date(System.currentTimeMillis());
		lto.setCreatedTs(new Date(System.currentTimeMillis()));
		assertEquals(newdate,lto.getCreatedTs());

	}


	@Test
	public void testGetAndSetlastUptdUserId()
	{
		LaneLoadGroupTO lto = new LaneLoadGroupTO();
		String  userid="SXP8562";
		lto.setLastUptdUserId(userid);
		assertEquals(userid,lto.getLastUptdUserId());

	}

	@Test
	public void testGetAndSetlastUptdTs()
	{
		LaneLoadGroupTO lto = new LaneLoadGroupTO();
		Date newdate = new Date(System.currentTimeMillis());
		lto.setLastUptdTs(newdate);
		assertEquals(newdate,lto.getLastUptdTs());

	}

	@Test
	public void testGetAndSeteffectiveBeginDate()
	{
		LaneLoadGroupTO lto = new LaneLoadGroupTO();
		Date effectiveBeginDate = new Date(System.currentTimeMillis());
		lto.setEffectiveBeginDate(effectiveBeginDate);
		assertEquals(effectiveBeginDate,lto.getEffectiveBeginDate());

	}

	@Test
	public void testGetAndSeteffectiveEndDate()
	{
		LaneLoadGroupTO lto = new LaneLoadGroupTO();
		Date effectiveEndDate = new Date(System.currentTimeMillis());
		lto.setEffectiveEndDate(effectiveEndDate);
		assertEquals(effectiveEndDate,lto.getEffectiveEndDate());

	}

	@Test
	public void testGetAndSetlaneLoadGroupName()
	{
		LaneLoadGroupTO lto = new LaneLoadGroupTO();
		String  laneLoadGroupName="SXP8562";
		lto.setLaneLoadGroupName(laneLoadGroupName);
		assertEquals(laneLoadGroupName,lto.getLaneLoadGroupName());

	}

}

