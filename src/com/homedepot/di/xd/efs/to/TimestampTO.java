package com.homedepot.di.xd.efs.to;

import java.io.Serializable;
import java.util.Date;

public class TimestampTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String createdUserId;
	private Date createdTs;
	private String lastUptdUserId;
	private Date lastUptdTs;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createdTs == null) ? 0 : createdTs.hashCode());
		result = prime * result
				+ ((createdUserId == null) ? 0 : createdUserId.hashCode());
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
		TimestampTO other = (TimestampTO) obj;
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
	@Override
	public String toString() {
		return "TimestampTO [createdUserId=" + createdUserId + ", createdTs="
				+ createdTs + ", lastUptdUserId=" + lastUptdUserId
				+ ", lastUptdTs=" + lastUptdTs + "]";
	}
	
	
}
