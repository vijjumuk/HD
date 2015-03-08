package com.homedepot.di.xd.efs.to;

import java.io.Serializable;
import java.sql.Date;
import java.util.Map;

public class ScheduleTO extends TimestampTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private String originNumber;
	private int destinationNumber;
	private short scheduleTypeCode;
	private short scheduleGroupCode;
	
	private String scheduleName;
	
	private int scheduleId;
	private Date effectiveBeginDate;
	private Date effectiveEndDate;
	
	private String errorString;
	
	private Map<Short, ScheduleOrderDayTO> scheduleOrderDayTO;

	public String getOriginNumber() {
		return originNumber;
	}

	public void setOriginNumber(String originNumber) {
		this.originNumber = originNumber;
	}

	public int getDestinationNumber() {
		return destinationNumber;
	}

	public void setDestinationNumber(int destinationNumber) {
		this.destinationNumber = destinationNumber;
	}

	public short getScheduleTypeCode() {
		return scheduleTypeCode;
	}

	public void setScheduleTypeCode(short scheduleTypeCode) {
		this.scheduleTypeCode = scheduleTypeCode;
	}

	public short getScheduleGroupCode() {
		return scheduleGroupCode;
	}

	public void setScheduleGroupCode(short scheduleGroupCode) {
		this.scheduleGroupCode = scheduleGroupCode;
	}

	public String getScheduleName() {
		return scheduleName;
	}

	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}

	public int getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Date getEffectiveBeginDate() {
		return effectiveBeginDate;
	}

	public void setEffectiveBeginDate(Date effectiveBeginDate) {
		this.effectiveBeginDate = effectiveBeginDate;
	}

	public Date getEffectiveEndDate() {
		return effectiveEndDate;
	}

	public void setEffectiveEndDate(Date effectiveEndDate) {
		this.effectiveEndDate = effectiveEndDate;
	}

	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}

	public Map<Short, ScheduleOrderDayTO> getScheduleOrderDayTO() {
		return scheduleOrderDayTO;
	}

	public void setScheduleOrderDayTO(
			Map<Short, ScheduleOrderDayTO> scheduleOrderDayTO) {
		this.scheduleOrderDayTO = scheduleOrderDayTO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + destinationNumber;
		result = prime
				* result
				+ ((effectiveBeginDate == null) ? 0 : effectiveBeginDate
						.hashCode());
		result = prime
				* result
				+ ((effectiveEndDate == null) ? 0 : effectiveEndDate.hashCode());
		result = prime * result
				+ ((errorString == null) ? 0 : errorString.hashCode());
		result = prime * result
				+ ((originNumber == null) ? 0 : originNumber.hashCode());
		result = prime * result + scheduleGroupCode;
		result = prime * result + scheduleId;
		result = prime * result
				+ ((scheduleName == null) ? 0 : scheduleName.hashCode());
		result = prime
				* result
				+ ((scheduleOrderDayTO == null) ? 0 : scheduleOrderDayTO
						.hashCode());
		result = prime * result + scheduleTypeCode;
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
		ScheduleTO other = (ScheduleTO) obj;
		if (destinationNumber != other.destinationNumber)
			return false;
		if (effectiveBeginDate == null) {
			if (other.effectiveBeginDate != null)
				return false;
		} else if (!effectiveBeginDate.equals(other.effectiveBeginDate))
			return false;
		if (effectiveEndDate == null) {
			if (other.effectiveEndDate != null)
				return false;
		} else if (!effectiveEndDate.equals(other.effectiveEndDate))
			return false;
		if (errorString == null) {
			if (other.errorString != null)
				return false;
		} else if (!errorString.equals(other.errorString))
			return false;
		if (originNumber == null) {
			if (other.originNumber != null)
				return false;
		} else if (!originNumber.equals(other.originNumber))
			return false;
		if (scheduleGroupCode != other.scheduleGroupCode)
			return false;
		if (scheduleId != other.scheduleId)
			return false;
		if (scheduleName == null) {
			if (other.scheduleName != null)
				return false;
		} else if (!scheduleName.equals(other.scheduleName))
			return false;
		if (scheduleOrderDayTO == null) {
			if (other.scheduleOrderDayTO != null)
				return false;
		} else if (!scheduleOrderDayTO.equals(other.scheduleOrderDayTO))
			return false;
		if (scheduleTypeCode != other.scheduleTypeCode)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ScheduleTO [originNumber=" + originNumber
				+ ", destinationNumber=" + destinationNumber
				+ ", scheduleTypeCode=" + scheduleTypeCode
				+ ", scheduleGroupCode=" + scheduleGroupCode
				+ ", scheduleName=" + scheduleName + ", scheduleId="
				+ scheduleId + ", effectiveBeginDate=" + effectiveBeginDate
				+ ", effectiveEndDate=" + effectiveEndDate + ", errorString="
				+ errorString + ", scheduleOrderDayTO=" + scheduleOrderDayTO
				+ "]";
	}

		
}
