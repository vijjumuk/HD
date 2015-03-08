package com.homedepot.di.xd.efs.to;

import java.io.Serializable;

public class ScheduleOrderDayTO extends TimestampTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int scheduleId;
	private short orderDayOfWeekCode;
	
	private short tenderDayOfWeekCode;
	private short tenderRelativeWeekNumber;
	private short vendorTransportationTimeHours;
	private short shipmentBeginDayOfWeekCode;
	private short shipmentBeginRelativeWeekNumber;
	private short shipmentEndDayOfWeekCode;
	private short shipmentEndRelativeWeekNumber;
	
	private String originLocationShipmentBeginTime;
	private String originLocationShipmentEndTime;
	private String expectedCarrierDepartTime;
	
	private short expectedShipmentTransitTimeHours;
	private short arrivalBeginDayOfWeekCode;
	private short arrivalBeginRelativeWeekNumber;
	private short arrivalEndDayOfWeekCode;
	private short arrivalEndRelativeWeekNumber;

	private String expectedCarrierArrivalBeginTime;
	private String expectedCarrierArrivalEndTime;
	
	private short dcBeginShipmentWorkDayOfWeekCode;
	private short dcBeginShipmentWorkRelativeWeekNumber;
	private short dcEndShipmentWorkDayOfWeekCode;
	private short dcEndShipmentWorkRelativeWeekNumber;
	
	private short dcBeginWorkShiftSequenceNumber;
	private short dcEndWorkShiftSequenceNumber;
	private short dcShipmentWorkShiftCount;
	private short dcShipmentWorkHours;
	public int getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}
	public short getOrderDayOfWeekCode() {
		return orderDayOfWeekCode;
	}
	public void setOrderDayOfWeekCode(short orderDayOfWeekCode) {
		this.orderDayOfWeekCode = orderDayOfWeekCode;
	}
	public short getTenderDayOfWeekCode() {
		return tenderDayOfWeekCode;
	}
	public void setTenderDayOfWeekCode(short tenderDayOfWeekCode) {
		this.tenderDayOfWeekCode = tenderDayOfWeekCode;
	}
	public short getTenderRelativeWeekNumber() {
		return tenderRelativeWeekNumber;
	}
	public void setTenderRelativeWeekNumber(short tenderRelativeWeekNumber) {
		this.tenderRelativeWeekNumber = tenderRelativeWeekNumber;
	}
	public short getVendorTransportationTimeHours() {
		return vendorTransportationTimeHours;
	}
	public void setVendorTransportationTimeHours(short vendorTransportationTimeHours) {
		this.vendorTransportationTimeHours = vendorTransportationTimeHours;
	}
	public short getShipmentBeginDayOfWeekCode() {
		return shipmentBeginDayOfWeekCode;
	}
	public void setShipmentBeginDayOfWeekCode(short shipmentBeginDayOfWeekCode) {
		this.shipmentBeginDayOfWeekCode = shipmentBeginDayOfWeekCode;
	}
	public short getShipmentBeginRelativeWeekNumber() {
		return shipmentBeginRelativeWeekNumber;
	}
	public void setShipmentBeginRelativeWeekNumber(
			short shipmentBeginRelativeWeekNumber) {
		this.shipmentBeginRelativeWeekNumber = shipmentBeginRelativeWeekNumber;
	}
	public short getShipmentEndDayOfWeekCode() {
		return shipmentEndDayOfWeekCode;
	}
	public void setShipmentEndDayOfWeekCode(short shipmentEndDayOfWeekCode) {
		this.shipmentEndDayOfWeekCode = shipmentEndDayOfWeekCode;
	}
	public short getShipmentEndRelativeWeekNumber() {
		return shipmentEndRelativeWeekNumber;
	}
	public void setShipmentEndRelativeWeekNumber(short shipmentEndRelativeWeekNumber) {
		this.shipmentEndRelativeWeekNumber = shipmentEndRelativeWeekNumber;
	}
	public String getOriginLocationShipmentBeginTime() {
		return originLocationShipmentBeginTime;
	}
	public void setOriginLocationShipmentBeginTime(
			String originLocationShipmentBeginTime) {
		this.originLocationShipmentBeginTime = originLocationShipmentBeginTime;
	}
	public String getOriginLocationShipmentEndTime() {
		return originLocationShipmentEndTime;
	}
	public void setOriginLocationShipmentEndTime(
			String originLocationShipmentEndTime) {
		this.originLocationShipmentEndTime = originLocationShipmentEndTime;
	}
	public String getExpectedCarrierDepartTime() {
		return expectedCarrierDepartTime;
	}
	public void setExpectedCarrierDepartTime(String expectedCarrierDepartTime) {
		this.expectedCarrierDepartTime = expectedCarrierDepartTime;
	}
	public short getExpectedShipmentTransitTimeHours() {
		return expectedShipmentTransitTimeHours;
	}
	public void setExpectedShipmentTransitTimeHours(
			short expectedShipmentTransitTimeHours) {
		this.expectedShipmentTransitTimeHours = expectedShipmentTransitTimeHours;
	}
	public short getArrivalBeginDayOfWeekCode() {
		return arrivalBeginDayOfWeekCode;
	}
	public void setArrivalBeginDayOfWeekCode(short arrivalBeginDayOfWeekCode) {
		this.arrivalBeginDayOfWeekCode = arrivalBeginDayOfWeekCode;
	}
	public short getArrivalBeginRelativeWeekNumber() {
		return arrivalBeginRelativeWeekNumber;
	}
	public void setArrivalBeginRelativeWeekNumber(
			short arrivalBeginRelativeWeekNumber) {
		this.arrivalBeginRelativeWeekNumber = arrivalBeginRelativeWeekNumber;
	}
	public short getArrivalEndDayOfWeekCode() {
		return arrivalEndDayOfWeekCode;
	}
	public void setArrivalEndDayOfWeekCode(short arrivalEndDayOfWeekCode) {
		this.arrivalEndDayOfWeekCode = arrivalEndDayOfWeekCode;
	}
	public short getArrivalEndRelativeWeekNumber() {
		return arrivalEndRelativeWeekNumber;
	}
	public void setArrivalEndRelativeWeekNumber(short arrivalEndRelativeWeekNumber) {
		this.arrivalEndRelativeWeekNumber = arrivalEndRelativeWeekNumber;
	}
	public String getExpectedCarrierArrivalBeginTime() {
		return expectedCarrierArrivalBeginTime;
	}
	public void setExpectedCarrierArrivalBeginTime(
			String expectedCarrierArrivalBeginTime) {
		this.expectedCarrierArrivalBeginTime = expectedCarrierArrivalBeginTime;
	}
	public String getExpectedCarrierArrivalEndTime() {
		return expectedCarrierArrivalEndTime;
	}
	public void setExpectedCarrierArrivalEndTime(
			String expectedCarrierArrivalEndTime) {
		this.expectedCarrierArrivalEndTime = expectedCarrierArrivalEndTime;
	}
	public short getDcBeginShipmentWorkDayOfWeekCode() {
		return dcBeginShipmentWorkDayOfWeekCode;
	}
	public void setDcBeginShipmentWorkDayOfWeekCode(
			short dcBeginShipmentWorkDayOfWeekCode) {
		this.dcBeginShipmentWorkDayOfWeekCode = dcBeginShipmentWorkDayOfWeekCode;
	}
	public short getDcBeginShipmentWorkRelativeWeekNumber() {
		return dcBeginShipmentWorkRelativeWeekNumber;
	}
	public void setDcBeginShipmentWorkRelativeWeekNumber(
			short dcBeginShipmentWorkRelativeWeekNumber) {
		this.dcBeginShipmentWorkRelativeWeekNumber = dcBeginShipmentWorkRelativeWeekNumber;
	}
	public short getDcEndShipmentWorkDayOfWeekCode() {
		return dcEndShipmentWorkDayOfWeekCode;
	}
	public void setDcEndShipmentWorkDayOfWeekCode(
			short dcEndShipmentWorkDayOfWeekCode) {
		this.dcEndShipmentWorkDayOfWeekCode = dcEndShipmentWorkDayOfWeekCode;
	}
	public short getDcEndShipmentWorkRelativeWeekNumber() {
		return dcEndShipmentWorkRelativeWeekNumber;
	}
	public void setDcEndShipmentWorkRelativeWeekNumber(
			short dcEndShipmentWorkRelativeWeekNumber) {
		this.dcEndShipmentWorkRelativeWeekNumber = dcEndShipmentWorkRelativeWeekNumber;
	}
	public short getDcBeginWorkShiftSequenceNumber() {
		return dcBeginWorkShiftSequenceNumber;
	}
	public void setDcBeginWorkShiftSequenceNumber(
			short dcBeginWorkShiftSequenceNumber) {
		this.dcBeginWorkShiftSequenceNumber = dcBeginWorkShiftSequenceNumber;
	}
	public short getDcEndWorkShiftSequenceNumber() {
		return dcEndWorkShiftSequenceNumber;
	}
	public void setDcEndWorkShiftSequenceNumber(short dcEndWorkShiftSequenceNumber) {
		this.dcEndWorkShiftSequenceNumber = dcEndWorkShiftSequenceNumber;
	}
	public short getDcShipmentWorkShiftCount() {
		return dcShipmentWorkShiftCount;
	}
	public void setDcShipmentWorkShiftCount(short dcShipmentWorkShiftCount) {
		this.dcShipmentWorkShiftCount = dcShipmentWorkShiftCount;
	}
	public short getDcShipmentWorkHours() {
		return dcShipmentWorkHours;
	}
	public void setDcShipmentWorkHours(short dcShipmentWorkHours) {
		this.dcShipmentWorkHours = dcShipmentWorkHours;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + arrivalBeginDayOfWeekCode;
		result = prime * result + arrivalBeginRelativeWeekNumber;
		result = prime * result + arrivalEndDayOfWeekCode;
		result = prime * result + arrivalEndRelativeWeekNumber;
		result = prime * result + dcBeginShipmentWorkDayOfWeekCode;
		result = prime * result + dcBeginShipmentWorkRelativeWeekNumber;
		result = prime * result + dcBeginWorkShiftSequenceNumber;
		result = prime * result + dcEndShipmentWorkDayOfWeekCode;
		result = prime * result + dcEndShipmentWorkRelativeWeekNumber;
		result = prime * result + dcEndWorkShiftSequenceNumber;
		result = prime * result + dcShipmentWorkHours;
		result = prime * result + dcShipmentWorkShiftCount;
		result = prime
				* result
				+ ((expectedCarrierArrivalBeginTime == null) ? 0
						: expectedCarrierArrivalBeginTime.hashCode());
		result = prime
				* result
				+ ((expectedCarrierArrivalEndTime == null) ? 0
						: expectedCarrierArrivalEndTime.hashCode());
		result = prime
				* result
				+ ((expectedCarrierDepartTime == null) ? 0
						: expectedCarrierDepartTime.hashCode());
		result = prime * result + expectedShipmentTransitTimeHours;
		result = prime * result + orderDayOfWeekCode;
		result = prime
				* result
				+ ((originLocationShipmentBeginTime == null) ? 0
						: originLocationShipmentBeginTime.hashCode());
		result = prime
				* result
				+ ((originLocationShipmentEndTime == null) ? 0
						: originLocationShipmentEndTime.hashCode());
		result = prime * result + scheduleId;
		result = prime * result + shipmentBeginDayOfWeekCode;
		result = prime * result + shipmentBeginRelativeWeekNumber;
		result = prime * result + shipmentEndDayOfWeekCode;
		result = prime * result + shipmentEndRelativeWeekNumber;
		result = prime * result + tenderDayOfWeekCode;
		result = prime * result + tenderRelativeWeekNumber;
		result = prime * result + vendorTransportationTimeHours;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScheduleOrderDayTO other = (ScheduleOrderDayTO) obj;
		if (arrivalBeginDayOfWeekCode != other.arrivalBeginDayOfWeekCode)
			return false;
		if (arrivalBeginRelativeWeekNumber != other.arrivalBeginRelativeWeekNumber)
			return false;
		if (arrivalEndDayOfWeekCode != other.arrivalEndDayOfWeekCode)
			return false;
		if (arrivalEndRelativeWeekNumber != other.arrivalEndRelativeWeekNumber)
			return false;
		if (dcBeginShipmentWorkDayOfWeekCode != other.dcBeginShipmentWorkDayOfWeekCode)
			return false;
		if (dcBeginShipmentWorkRelativeWeekNumber != other.dcBeginShipmentWorkRelativeWeekNumber)
			return false;
		if (dcBeginWorkShiftSequenceNumber != other.dcBeginWorkShiftSequenceNumber)
			return false;
		if (dcEndShipmentWorkDayOfWeekCode != other.dcEndShipmentWorkDayOfWeekCode)
			return false;
		if (dcEndShipmentWorkRelativeWeekNumber != other.dcEndShipmentWorkRelativeWeekNumber)
			return false;
		if (dcEndWorkShiftSequenceNumber != other.dcEndWorkShiftSequenceNumber)
			return false;
		if (dcShipmentWorkHours != other.dcShipmentWorkHours)
			return false;
		if (dcShipmentWorkShiftCount != other.dcShipmentWorkShiftCount)
			return false;
		if (expectedCarrierArrivalBeginTime == null) {
			if (other.expectedCarrierArrivalBeginTime != null)
				return false;
		} else if (!expectedCarrierArrivalBeginTime
				.equals(other.expectedCarrierArrivalBeginTime))
			return false;
		if (expectedCarrierArrivalEndTime == null) {
			if (other.expectedCarrierArrivalEndTime != null)
				return false;
		} else if (!expectedCarrierArrivalEndTime
				.equals(other.expectedCarrierArrivalEndTime))
			return false;
		if (expectedCarrierDepartTime == null) {
			if (other.expectedCarrierDepartTime != null)
				return false;
		} else if (!expectedCarrierDepartTime
				.equals(other.expectedCarrierDepartTime))
			return false;
		if (expectedShipmentTransitTimeHours != other.expectedShipmentTransitTimeHours)
			return false;
		if (orderDayOfWeekCode != other.orderDayOfWeekCode)
			return false;
		if (originLocationShipmentBeginTime == null) {
			if (other.originLocationShipmentBeginTime != null)
				return false;
		} else if (!originLocationShipmentBeginTime
				.equals(other.originLocationShipmentBeginTime))
			return false;
		if (originLocationShipmentEndTime == null) {
			if (other.originLocationShipmentEndTime != null)
				return false;
		} else if (!originLocationShipmentEndTime
				.equals(other.originLocationShipmentEndTime))
			return false;
		if (scheduleId != other.scheduleId)
			return false;
		if (shipmentBeginDayOfWeekCode != other.shipmentBeginDayOfWeekCode)
			return false;
		if (shipmentBeginRelativeWeekNumber != other.shipmentBeginRelativeWeekNumber)
			return false;
		if (shipmentEndDayOfWeekCode != other.shipmentEndDayOfWeekCode)
			return false;
		if (shipmentEndRelativeWeekNumber != other.shipmentEndRelativeWeekNumber)
			return false;
		if (tenderDayOfWeekCode != other.tenderDayOfWeekCode)
			return false;
		if (tenderRelativeWeekNumber != other.tenderRelativeWeekNumber)
			return false;
		if (vendorTransportationTimeHours != other.vendorTransportationTimeHours)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ScheduleOrderDayTO [scheduleId=" + scheduleId
				+ ", orderDayOfWeekCode=" + orderDayOfWeekCode
				+ ", tenderDayOfWeekCode=" + tenderDayOfWeekCode
				+ ", tenderRelativeWeekNumber=" + tenderRelativeWeekNumber
				+ ", vendorTransportationTimeHours="
				+ vendorTransportationTimeHours
				+ ", shipmentBeginDayOfWeekCode=" + shipmentBeginDayOfWeekCode
				+ ", shipmentBeginRelativeWeekNumber="
				+ shipmentBeginRelativeWeekNumber
				+ ", shipmentEndDayOfWeekCode=" + shipmentEndDayOfWeekCode
				+ ", shipmentEndRelativeWeekNumber="
				+ shipmentEndRelativeWeekNumber
				+ ", originLocationShipmentBeginTime="
				+ originLocationShipmentBeginTime
				+ ", originLocationShipmentEndTime="
				+ originLocationShipmentEndTime
				+ ", expectedCarrierDepartTime=" + expectedCarrierDepartTime
				+ ", expectedShipmentTransitTimeHours="
				+ expectedShipmentTransitTimeHours
				+ ", arrivalBeginDayOfWeekCode=" + arrivalBeginDayOfWeekCode
				+ ", arrivalBeginRelativeWeekNumber="
				+ arrivalBeginRelativeWeekNumber + ", arrivalEndDayOfWeekCode="
				+ arrivalEndDayOfWeekCode + ", arrivalEndRelativeWeekNumber="
				+ arrivalEndRelativeWeekNumber
				+ ", expectedCarrierArrivalBeginTime="
				+ expectedCarrierArrivalBeginTime
				+ ", expectedCarrierArrivalEndTime="
				+ expectedCarrierArrivalEndTime
				+ ", dcBeginShipmentWorkDayOfWeekCode="
				+ dcBeginShipmentWorkDayOfWeekCode
				+ ", dcBeginShipmentWorkRelativeWeekNumber="
				+ dcBeginShipmentWorkRelativeWeekNumber
				+ ", dcEndShipmentWorkDayOfWeekCode="
				+ dcEndShipmentWorkDayOfWeekCode
				+ ", dcEndShipmentWorkRelativeWeekNumber="
				+ dcEndShipmentWorkRelativeWeekNumber
				+ ", dcBeginWorkShiftSequenceNumber="
				+ dcBeginWorkShiftSequenceNumber
				+ ", dcEndWorkShiftSequenceNumber="
				+ dcEndWorkShiftSequenceNumber + ", dcShipmentWorkShiftCount="
				+ dcShipmentWorkShiftCount + ", dcShipmentWorkHours="
				+ dcShipmentWorkHours + "]";
	}
	
	
	
}
