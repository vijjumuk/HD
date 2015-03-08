package com.homedepot.di.xd.efs.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="report")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportTO implements Serializable {

	private static final long serialVersionUID = 9119557647492487079L;
	private int reportCode;
	private String shortDescription = null;
	private String description = null;
	public int getReportCode() {
		return reportCode;
	}
	public void setReportCode(int reportCode) {
		this.reportCode = reportCode;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + reportCode;
		result = prime
				* result
				+ ((shortDescription == null) ? 0 : shortDescription.hashCode());
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
		ReportTO other = (ReportTO) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (reportCode != other.reportCode)
			return false;
		if (shortDescription == null) {
			if (other.shortDescription != null)
				return false;
		} else if (!shortDescription.equals(other.shortDescription))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ReportTO [reportCode=" + reportCode + ", shortDescription="
				+ shortDescription + ", description=" + description + "]";
	}
	
}
