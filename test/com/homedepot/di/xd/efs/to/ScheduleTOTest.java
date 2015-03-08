package com.homedepot.di.xd.efs.to;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import org.junit.Test;


public class ScheduleTOTest extends TestCase {

	/**
	 * Construct new test instance
	 *
	 * @param name the test name
	 */
	public ScheduleTOTest(String name) {
		super(name);
	}
	
	/**
	 * Test method for getter and setter of originNumber
	 * 
	 */
	@Test
	public void testGetAndSetForOriginNumber()
	{
		ScheduleTO schedule = new ScheduleTO();
		String originId = "471003IL001";
		schedule.setOriginNumber(originId);
		assertEquals(originId,schedule.getOriginNumber());
	}
	
	/**
	 * Test method for getter and setter of destinationNumber
	 * 
	 */
	@Test
	public void testGetAndSetForDestinationNumber()
	{
		ScheduleTO schedule = new ScheduleTO();
		int destNmbt = 5520;
		schedule.setDestinationNumber(destNmbt);
		assertEquals(destNmbt,schedule.getDestinationNumber());
	}
	
	/**
	 * Test method for getter and setter of scheduleTypeCode
	 * 
	 */
	@Test
	public void testGetAndSetForScheduleTypeCode()
	{
		ScheduleTO schedule = new ScheduleTO();
		short typeCd = 1;
		schedule.setScheduleTypeCode(typeCd);
		assertEquals(typeCd,schedule.getScheduleTypeCode());
	}
	
	/**
	 * Test method for getter and setter of scheduleGroupCode
	 * 
	 */
	@Test
	public void testGetAndSetForScheduleGroupCode()
	{
		ScheduleTO schedule = new ScheduleTO();
		short grpCd = 1;
		schedule.setScheduleGroupCode(grpCd);
		assertEquals(grpCd,schedule.getScheduleGroupCode());
	}
	
	/**
	 * Test method for getter and setter of scheduleName
	 * 
	 */
	@Test
	public void testGetAndSetForScheduleName()
	{
		ScheduleTO schedule = new ScheduleTO();
		String scheduleName = "3M HOUSTON CORE";
		schedule.setScheduleName(scheduleName);
		assertEquals(scheduleName,schedule.getScheduleName());
	}
	
	/**
	 * Test method for getter and setter of scheduleId
	 * 
	 */
	@Test
	public void testGetAndSetForScheduleId()
	{
		ScheduleTO schedule = new ScheduleTO();
		int scheduleId = 101;
		schedule.setScheduleId(scheduleId);
		assertEquals(scheduleId,schedule.getScheduleId());
	}
	
	/**
	 * Test method for getter and setter of effectiveBeginDate
	 * 
	 */
	@Test
	public void testGetAndSetForEffectiveBeginDate()
	{
		ScheduleTO schedule = new ScheduleTO();
		Date effBgnDt = new Date(System.currentTimeMillis());
		schedule.setEffectiveBeginDate(effBgnDt);
		assertEquals(effBgnDt,schedule.getEffectiveBeginDate());
	}

	/**
	 * Test method for getter and setter of effectiveEndDate
	 * 
	 */
	@Test
	public void testGetAndSetForEffectiveEndDate()
	{
		ScheduleTO schedule = new ScheduleTO();
		Date effEndDt = new Date(System.currentTimeMillis());
		schedule.setEffectiveEndDate(effEndDt);
		assertEquals(effEndDt,schedule.getEffectiveEndDate());
	}
	
	/**
	 * Test method for getter and setter of errorString
	 * 
	 */
	@Test
	public void testGetAndSetForErrorString()
	{
		ScheduleTO schedule = new ScheduleTO();
		String errorString = "Failed to Process";
		schedule.setErrorString(errorString);
		assertEquals(errorString,schedule.getErrorString());
	}
	
	/**
	 * Test method for getter and setter of scheduleOrderDayTO
	 * 
	 */	@Test
	public void testGetAndSetForScheduleOrderDayTO()
	{
		Map<Short, ScheduleOrderDayTO> orderDayMap = new HashMap<Short, ScheduleOrderDayTO>();
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short key = 1;
		
		orderDayMap.put(key, orderDayTO);
		assertNotNull(orderDayMap);
	}
	
}

