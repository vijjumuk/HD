/*
 * This program is proprietary to The Home Depot and is not to be 
 * reproduced, used, or disclosed without permission of:
 *    
 *  The Home Depot
 *  2455 Paces Ferry Road, N.W.
 *  Atlanta, GA 30339-4053
 * 
 * File Name: LaneUploadProcessor.java 
 * author: The Home Depot Inc
 */

package com.homedepot.di.xd.efs.to;

import java.io.Serializable;
/**
 * This DTO used to store the Lane information
 */
import java.util.Date;

public class LaneTO implements Serializable,Comparable<LaneTO>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2671161489763856369L;
	
	private int laneId;
	private String createdUserId;
	private Date createdTs;
	private String lastUptdUserId;
	private Date lastUptdTs;
	private int originLocId;
	private int destinationLocId;
	private String shppingLaneName;
	private boolean activeFlag;
	
	// To store the upload file value
	private String originId;
	private String destinationId;
	
	
	@Override
	public String toString() {
		
		return "LaneTO ["
				+ "laneId :" +laneId
				+ " createdUserId :"+createdUserId
				+ " lastUptdUserId :"+lastUptdUserId
				+ " origin :"+originId
				+ " destination :"+destinationId
				+ " originLocId :"+originLocId
				+ " destinationLocId :"+destinationLocId
				+ " shppingLaneName :"+shppingLaneName
				+ " activeFlag :"+activeFlag
				+ " errorString : "+errorString
				+"]";
	}
	
	
	// To store the load group info
	LaneLoadGroupTO laneLoadGroupTo;
	
	// to store the validate error message
	private String errorString;
	
	public int getLaneId() {
		return laneId;
	}
	public void setLaneId(int laneId) {
		this.laneId = laneId;
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
	public int getOriginLocId() {
		return originLocId;
	}
	public void setOriginLocId(int originLocId) {
		this.originLocId = originLocId;
	}
	public int getDestinationLocId() {
		return destinationLocId;
	}
	public void setDestinationLocId(int destinationLocId) {
		this.destinationLocId = destinationLocId;
	}
	public String getShppingLaneName() {
		return shppingLaneName;
	}
	public void setShppingLaneName(String shppingLaneName) {
		this.shppingLaneName = shppingLaneName;
	}
	public boolean isActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(boolean activeFlag) {
		this.activeFlag = activeFlag;
	}
	public String getOriginId() {
		return originId;
	}
	public void setOriginId(String originId) {
		this.originId = originId;
	}
	public String getDestinationId() {
		return destinationId;
	}
	public void setDestinationId(String destinationId) {
		this.destinationId = destinationId;
	}
	public LaneLoadGroupTO getLaneLoadGroupTo() {
		return laneLoadGroupTo;
	}
	public void setLaneLoadGroupTo(LaneLoadGroupTO laneLoadGroupTo) {
		this.laneLoadGroupTo = laneLoadGroupTo;
	}
	
	public String getErrorString() {
		return errorString;
	}

	public void setErrorString(String errorString) {
		this.errorString = errorString;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (activeFlag ? 1231 : 1237);
		result = prime * result
				+ ((createdTs == null) ? 0 : createdTs.hashCode());
		result = prime * result
				+ ((createdUserId == null) ? 0 : createdUserId.hashCode());
		result = prime * result
				+ ((destinationId == null) ? 0 : destinationId.hashCode());
		result = prime * result + destinationLocId;
		result = prime * result
				+ ((errorString == null) ? 0 : errorString.hashCode());
		result = prime * result + laneId;
		result = prime * result
				+ ((laneLoadGroupTo == null) ? 0 : laneLoadGroupTo.hashCode());
		result = prime * result
				+ ((lastUptdTs == null) ? 0 : lastUptdTs.hashCode());
		result = prime * result
				+ ((lastUptdUserId == null) ? 0 : lastUptdUserId.hashCode());
		result = prime * result
				+ ((originId == null) ? 0 : originId.hashCode());
		result = prime * result + originLocId;
		result = prime * result
				+ ((shppingLaneName == null) ? 0 : shppingLaneName.hashCode());
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
		LaneTO other = (LaneTO) obj;
		if (activeFlag != other.activeFlag)
			return false;
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
		if (destinationId == null) {
			if (other.destinationId != null)
				return false;
		} else if (!destinationId.equals(other.destinationId))
			return false;
		if (destinationLocId != other.destinationLocId)
			return false;
		if (errorString == null) {
			if (other.errorString != null)
				return false;
		} else if (!errorString.equals(other.errorString))
			return false;
		if (laneId != other.laneId)
			return false;
		if (laneLoadGroupTo == null) {
			if (other.laneLoadGroupTo != null)
				return false;
		} else if (!laneLoadGroupTo.equals(other.laneLoadGroupTo))
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
		if (originId == null) {
			if (other.originId != null)
				return false;
		} else if (!originId.equals(other.originId))
			return false;
		if (originLocId != other.originLocId)
			return false;
		if (shppingLaneName == null) {
			if (other.shppingLaneName != null)
				return false;
		} else if (!shppingLaneName.equals(other.shppingLaneName))
			return false;
		return true;
	}
	@Override
	public int compareTo(LaneTO o) {
		if(this.originId.equals(o.originId) &&
				this.destinationId.equals(o.destinationId) &&
				this.laneLoadGroupTo.getLaneLoadGroupName().equals(o.laneLoadGroupTo.getLaneLoadGroupName()) &&
				this.laneLoadGroupTo.getLaneLoadGroupVendorTo().getMvndrNbr().equals(o.laneLoadGroupTo.getLaneLoadGroupVendorTo().getMvndrNbr())){
			return 0;
		}
		return 1;
	}
	
	
}
