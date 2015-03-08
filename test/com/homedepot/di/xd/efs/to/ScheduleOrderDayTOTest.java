package com.homedepot.di.xd.efs.to;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * The class <code>ScheduleOrderDayTOTest</code> contains tests for the class
 * {@link <code>ScheduleOrderDayTO</code>}
 *
 * @pattern JUnit Test Case
 *
 * @generatedBy CodePro at 3/6/15 1:22 PM
 *
 * @author 565581
 *
 * @version $Revision$
 */
public class ScheduleOrderDayTOTest extends TestCase {

	/**
	 * Construct new test instance
	 *
	 * @param name the test name
	 */
	public ScheduleOrderDayTOTest(String name) {
		super(name);
	}
	
	/**
	 * Test method for getter and setter of scheduleId
	 * 
	 */
	@Test
	public void testGetAndSetForScheduleId()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		int scheduleId = 112;
		orderDayTO.setScheduleId(scheduleId);
		assertEquals(scheduleId,orderDayTO.getScheduleId());
	}
	
	/**
	 * Test method for getter and setter of orderDayOfWeekCode
	 * 
	 */
	@Test
	public void testGetAndSetForOrderDayOfWeekCode()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short orderDayOfWeekCode = 1;
		orderDayTO.setOrderDayOfWeekCode(orderDayOfWeekCode);
		assertEquals(orderDayOfWeekCode,orderDayTO.getOrderDayOfWeekCode());
	}
	
	/**
	 * Test method for getter and setter of tenderDayOfWeekCode
	 * 
	 */
	@Test
	public void testGetAndSetForTenderDayOfWeekCode()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short tenderDayOfWeekCode = 2;
		orderDayTO.setTenderDayOfWeekCode(tenderDayOfWeekCode);
		assertEquals(tenderDayOfWeekCode,orderDayTO.getTenderDayOfWeekCode());
	}
	
	/**
	 * Test method for getter and setter of tenderRelativeWeekNumber
	 * 
	 */
	@Test
	public void testGetAndSetForTenderRelativeWeekNumber()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short tenderRelativeWeekNumber = 3;
		orderDayTO.setTenderRelativeWeekNumber(tenderRelativeWeekNumber);
		assertEquals(tenderRelativeWeekNumber,orderDayTO.getTenderRelativeWeekNumber());
	}

	/**
	 * Test method for getter and setter of vendorTransportationTimeHours
	 * 
	 */
	@Test
	public void testGetAndSetForVendorTransportationTimeHours()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short vendorTransportationTimeHours = 4;
		orderDayTO.setVendorTransportationTimeHours(vendorTransportationTimeHours);
		assertEquals(vendorTransportationTimeHours,orderDayTO.getVendorTransportationTimeHours());
	}
	
	/**
	 * Test method for getter and setter of shipmentBeginDayOfWeekCode
	 * 
	 */
	@Test
	public void testGetAndSetForShipmentBeginDayOfWeekCode()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short shipmentBeginDayOfWkCd = 5;
		orderDayTO.setShipmentBeginDayOfWeekCode(shipmentBeginDayOfWkCd);
		assertEquals(shipmentBeginDayOfWkCd,orderDayTO.getShipmentBeginDayOfWeekCode());
	}
	
	/**
	 * Test method for getter and setter of shipmentBeginRelativeWeekNumber
	 * 
	 */
	@Test
	public void testGetAndSetForShipmentBeginRelativeWeekNumber()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short shipmentBeginRelativeWkNmbr = 5;
		orderDayTO.setShipmentBeginRelativeWeekNumber(shipmentBeginRelativeWkNmbr);
		assertEquals(shipmentBeginRelativeWkNmbr,orderDayTO.getShipmentBeginRelativeWeekNumber());
	}
	
	/**
	 * Test method for getter and setter of shipmentEndDayOfWeekCode
	 * 
	 */
	@Test
	public void testGetAndSetForShipmentEndDayOfWeekCode()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short shipmentEndDayOfWkCd = 5;
		orderDayTO.setShipmentEndDayOfWeekCode(shipmentEndDayOfWkCd);
		assertEquals(shipmentEndDayOfWkCd,orderDayTO.getShipmentEndDayOfWeekCode());
	}
	
	/**
	 * Test method for getter and setter of shipmentEndRelativeWeekNumber
	 * 
	 */
	@Test
	public void testGetAndSetForShipmentEndRelativeWeekNumber()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short shipmentEndRelativeWkNmbr = 5;
		orderDayTO.setShipmentEndRelativeWeekNumber(shipmentEndRelativeWkNmbr);
		assertEquals(shipmentEndRelativeWkNmbr,orderDayTO.getShipmentEndRelativeWeekNumber());
	}
	
	/**
	 * Test method for getter and setter of originLocationShipmentBeginTime
	 * 
	 */
	@Test
	public void testGetAndSetForOriginLocationShipmentBeginTime()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		String originLocShpmntBgnTime = "12.00";
		orderDayTO.setOriginLocationShipmentBeginTime(originLocShpmntBgnTime);
		assertEquals(originLocShpmntBgnTime,orderDayTO.getOriginLocationShipmentBeginTime());
	}
	
	/**
	 * Test method for getter and setter of originLocationShipmentEndTime
	 * 
	 */
	@Test
	public void testGetAndSetForOriginLocationShipmentEndTime()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		String originLocShpmntEndTime = "13.00";
		orderDayTO.setOriginLocationShipmentEndTime(originLocShpmntEndTime);
		assertEquals(originLocShpmntEndTime,orderDayTO.getOriginLocationShipmentEndTime());
	}
	
	/**
	 * Test method for getter and setter of expectedCarrierDepartTime
	 * 
	 */
	@Test
	public void testGetAndSetForExpectedCarrierDepartTime()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		String expectedCarrierDprtTime = "6.00";
		orderDayTO.setExpectedCarrierDepartTime(expectedCarrierDprtTime);
		assertEquals(expectedCarrierDprtTime,orderDayTO.getExpectedCarrierDepartTime());
	}
	
	/**
	 * Test method for getter and setter of expectedShipmentTransitTimeHours
	 * 
	 */
	@Test
	public void testGetAndSetForExpectedShipmentTransitTimeHours()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short expectedShipmentTransitHrs = 6;
		orderDayTO.setExpectedShipmentTransitTimeHours(expectedShipmentTransitHrs);
		assertEquals(expectedShipmentTransitHrs,orderDayTO.getExpectedShipmentTransitTimeHours());
	}
	
	/**
	 * Test method for getter and setter of arrivalBeginDayOfWeekCode
	 * 
	 */
	@Test
	public void testGetAndSetForArrivalBeginDayOfWeekCode()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short arrivalBeginDayOfWkCd = 7;
		orderDayTO.setArrivalBeginDayOfWeekCode(arrivalBeginDayOfWkCd);
		assertEquals(arrivalBeginDayOfWkCd,orderDayTO.getArrivalBeginDayOfWeekCode());
	}
	
	/**
	 * Test method for getter and setter of arrivalBeginRelativeWeekNumber
	 * 
	 */
	@Test
	public void testGetAndSetForArrivalBeginRelativeWeekNumber()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short arrivalBgnRelativeWkNmbr = 7;
		orderDayTO.setArrivalBeginRelativeWeekNumber(arrivalBgnRelativeWkNmbr);
		assertEquals(arrivalBgnRelativeWkNmbr,orderDayTO.getArrivalBeginRelativeWeekNumber());
	}
	
	/**
	 * Test method for getter and setter of arrivalEndDayOfWeekCode
	 * 
	 */
	@Test
	public void testGetAndSetForArrivalEndDayOfWeekCode()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short arrivalEndDayOfWkCd = 6;
		orderDayTO.setArrivalEndDayOfWeekCode(arrivalEndDayOfWkCd);
		assertEquals(arrivalEndDayOfWkCd,orderDayTO.getArrivalEndDayOfWeekCode());
	}
	
	/**
	 * Test method for getter and setter of arrivalEndRelativeWeekNumber
	 * 
	 */
	@Test
	public void testGetAndSetForArrivalEndRelativeWeekNumber()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short arrivalEndDayOfWkCd = 6;
		orderDayTO.setArrivalEndDayOfWeekCode(arrivalEndDayOfWkCd);
		assertEquals(arrivalEndDayOfWkCd,orderDayTO.getArrivalEndDayOfWeekCode());
	}
	
	/**
	 * Test method for getter and setter of expectedCarrierArrivalBeginTime
	 * 
	 */
	@Test
	public void testGetAndSetForExpectedCarrierArrivalBeginTime()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		String expectedCarrierArrivalBgnTime = "6.00";
		orderDayTO.setExpectedCarrierArrivalBeginTime(expectedCarrierArrivalBgnTime);
		assertEquals(expectedCarrierArrivalBgnTime,orderDayTO.getExpectedCarrierArrivalBeginTime());
	}
	
	/**
	 * Test method for getter and setter of expectedCarrierArrivalEndTime
	 * 
	 */
	@Test
	public void testGetAndSetForExpectedCarrierArrivalEndTime()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		String expectedCarrierArrivalEndTime = "16.00";
		orderDayTO.setExpectedCarrierArrivalEndTime(expectedCarrierArrivalEndTime);
		assertEquals(expectedCarrierArrivalEndTime,orderDayTO.getExpectedCarrierArrivalEndTime());
	}
	
	/**
	 * Test method for getter and setter of dcBeginShipmentWorkDayOfWeekCode
	 * 
	 */
	@Test
	public void testGetAndSetForDcBeginShipmentWorkDayOfWeekCode()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short dcBgnShipmentWrkDyOfWkCd = 8;
		orderDayTO.setDcBeginShipmentWorkDayOfWeekCode(dcBgnShipmentWrkDyOfWkCd);
		assertEquals(dcBgnShipmentWrkDyOfWkCd,orderDayTO.getDcBeginShipmentWorkDayOfWeekCode());
	}
	
	/**
	 * Test method for getter and setter of dcBeginShipmentWorkRelativeWeekNumber
	 * 
	 */
	@Test
	public void testGetAndSetForDcBeginShipmentWorkRelativeWeekNumber()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short dcBgnShipmentWrkRelativeWkNmbr = 5;
		orderDayTO.setDcBeginShipmentWorkRelativeWeekNumber(dcBgnShipmentWrkRelativeWkNmbr);
		assertEquals(dcBgnShipmentWrkRelativeWkNmbr,orderDayTO.getDcBeginShipmentWorkRelativeWeekNumber());
	}
	
	/**
	 * Test method for getter and setter of dcEndShipmentWorkDayOfWeekCode
	 * 
	 */
	@Test
	public void testGetAndSetForDcEndShipmentWorkDayOfWeekCode()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short dcEndShipmentWrkDyOfWkCd = 7;
		orderDayTO.setDcEndShipmentWorkDayOfWeekCode(dcEndShipmentWrkDyOfWkCd);
		assertEquals(dcEndShipmentWrkDyOfWkCd,orderDayTO.getDcEndShipmentWorkDayOfWeekCode());
	}
	
	/**
	 * Test method for getter and setter of dcEndShipmentWorkRelativeWeekNumber
	 * 
	 */
	@Test
	public void testGetAndSetForDcEndShipmentWorkRelativeWeekNumber()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short dcEndShipmentWrkRelativeWkNmbr = 8;
		orderDayTO.setDcEndShipmentWorkRelativeWeekNumber(dcEndShipmentWrkRelativeWkNmbr);
		assertEquals(dcEndShipmentWrkRelativeWkNmbr,orderDayTO.getDcEndShipmentWorkRelativeWeekNumber());
	}
	
	/**
	 * Test method for getter and setter of dcBeginWorkShiftSequenceNumber
	 * 
	 */
	@Test
	public void testGetAndSetForDcBeginWorkShiftSequenceNumber()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short dcBgnWrkShiftSeqNmbr = 9;
		orderDayTO.setDcBeginWorkShiftSequenceNumber(dcBgnWrkShiftSeqNmbr);
		assertEquals(dcBgnWrkShiftSeqNmbr,orderDayTO.getDcBeginWorkShiftSequenceNumber());
	}
	
	/**
	 * Test method for getter and setter of dcEndWorkShiftSequenceNumber
	 * 
	 */
	@Test
	public void testGetAndSetForDcEndWorkShiftSequenceNumber()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short dcEndWrkShiftSeqNmbr =10;
		orderDayTO.setDcEndWorkShiftSequenceNumber(dcEndWrkShiftSeqNmbr);
		assertEquals(dcEndWrkShiftSeqNmbr,orderDayTO.getDcEndWorkShiftSequenceNumber());
	}
	
	/**
	 * Test method for getter and setter of dcShipmentWorkShiftCount
	 * 
	 */
	@Test
	public void testGetAndSetForDcShipmentWorkShiftCount()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short dcShipmentWrkShftCount = 11;
		orderDayTO.setDcShipmentWorkShiftCount(dcShipmentWrkShftCount);
		assertEquals(dcShipmentWrkShftCount,orderDayTO.getDcShipmentWorkShiftCount());
	}
	
	/**
	 * Test method for getter and setter of dcShipmentWorkHours
	 * 
	 */
	@Test
	public void testGetAndSetForDcShipmentWorkHours()
	{
		ScheduleOrderDayTO orderDayTO = new ScheduleOrderDayTO();
		short dcShipmentWrkHrs = 12;
		orderDayTO.setDcShipmentWorkHours(dcShipmentWrkHrs);
		assertEquals(dcShipmentWrkHrs,orderDayTO.getDcShipmentWorkHours());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
