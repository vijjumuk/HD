package com.homedepot.di.xd.efs.to;

import java.io.Serializable;
import java.util.Date;

public class LaneLoadGroupTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2739959446853627352L;
	private int laneLoadGrpId;
	private String createdUserId;
	private Date createdTs;
	private String lastUptdUserId;
	private Date lastUptdTs;
	private int laneId;
	private Date effectiveBeginDate;
	private Date effectiveEndDate;
	private String laneLoadGroupName;
	
	@Override
	public String toString() {
		
		return "LaneLoadGroupTO ["
				+ "laneLoadGrpId :" +laneLoadGrpId
				+ " createdUserId :"+createdUserId
				+ " lastUptdUserId :"+lastUptdUserId
				+ " laneId :"+laneId
				+ " effectiveBeginDate :"+effectiveBeginDate
				+ " effectiveEndDate :"+effectiveEndDate
				+ " laneLoadGroupName :"+laneLoadGroupName
				+"]";
	}
	
	// To store the Vendor info
	private LaneLoadGroupVendorTO laneLoadGroupVendorTo;

	public LaneLoadGroupVendorTO getLaneLoadGroupVendorTo() {
		return laneLoadGroupVendorTo;
	}
	public void setLaneLoadGroupVendorTo(LaneLoadGroupVendorTO laneLoadGroupVendorTo) {
		this.laneLoadGroupVendorTo = laneLoadGroupVendorTo;
	}
	public int getLandLoadGroupId() {
		return laneLoadGrpId;
	}
	public void setLandLoadGroupId(int landLoadGroupId) {
		this.laneLoadGrpId = landLoadGroupId;
	}
	public String getCreatedUserId() {
		return createdUserId;
	}
	public void setCreatedUserId(String createdUserId) {
		this.createdUserId = createdUserId;
	}
	public Date getCreatedTs() {
		return createdTs;
	}
	public void setCreatedTs(Date createdTs) {
		this.createdTs = createdTs;
	}
	public String getLastUptdUserId() {
		return lastUptdUserId;
	}
	public void setLastUptdUserId(String lastUptdUserId) {
		this.lastUptdUserId = lastUptdUserId;
	}
	public Date getLastUptdTs() {
		return lastUptdTs;
	}
	public void setLastUptdTs(Date lastUptdTs) {
		this.lastUptdTs = lastUptdTs;
	}
	public int getLaneId() {
		return laneId;
	}
	public void setLaneId(int laneId) {
		this.laneId = laneId;
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
	public String getLaneLoadGroupName() {
		return laneLoadGroupName;
	}
	public void setLaneLoadGroupName(String laneLoadGroupName) {
		this.laneLoadGroupName = laneLoadGroupName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createdTs == null) ? 0 : createdTs.hashCode());
		result = prime * result
				+ ((createdUserId == null) ? 0 : createdUserId.hashCode());
		result = prime
				* result
				+ ((effectiveBeginDate == null) ? 0 : effectiveBeginDate
						.hashCode());
		result = prime
				* result
				+ ((effectiveEndDate == null) ? 0 : effectiveEndDate.hashCode());
		result = prime * result + laneId;
		result = prime
				* result
				+ ((laneLoadGroupName == null) ? 0 : laneLoadGroupName
						.hashCode());
		result = prime
				* result
				+ ((laneLoadGroupVendorTo == null) ? 0 : laneLoadGroupVendorTo
						.hashCode());
		result = prime * result + laneLoadGrpId;
		result = prime * result
				+ ((lastUptdTs == null) ? 0 : lastUptdTs.hashCode());
		result = prime * result
				+ ((lastUptdUserId == null) ? 0 : lastUptdUserId.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LaneLoadGroupTO other = (LaneLoadGroupTO) obj;
		if (createdTs == null) {
			if (other.createdTs != null)
				return false;
		} else if (!createdTs.equals(other.createdTs))
			return false;
		if (createdUserId == null) {
			if (other.createdUserId != null)
				return false;
		} else if (!createdUserId.equals(other.createdUserId))
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
		if (laneId != other.laneId)
			return false;
		if (laneLoadGroupName == null) {
			if (other.laneLoadGroupName != null)
				return false;
		} else if (!laneLoadGroupName.equals(other.laneLoadGroupName))
			return false;
		if (laneLoadGroupVendorTo == null) {
			if (other.laneLoadGroupVendorTo != null)
				return false;
		} else if (!laneLoadGroupVendorTo.equals(other.laneLoadGroupVendorTo))
			return false;
		if (laneLoadGrpId != other.laneLoadGrpId)
			return false;
		if (lastUptdTs == null) {
			if (other.lastUptdTs != null)
				return false;
		} else if (!lastUptdTs.equals(other.lastUptdTs))
			return false;
		if (lastUptdUserId == null) {
			if (other.lastUptdUserId != null)
				return false;
		} else if (!lastUptdUserId.equals(other.lastUptdUserId))
			return false;
		return true;
	}
}
