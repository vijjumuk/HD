package com.homedepot.di.xd.efs.to;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="reportType")
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportTypeTO implements Serializable {

	private static final long serialVersionUID = 7746388672889678699L;
	private int reportTypeCode;
	private String shortDescription = null;
	private String description = null;
	public int getReportTypeCode() {
		return reportTypeCode;
	}
	public void setReportTypeCode(int reportTypeCode) {
		this.reportTypeCode = reportTypeCode;
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
		result = prime * result + reportTypeCode;
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
		ReportTypeTO other = (ReportTypeTO) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (reportTypeCode != other.reportTypeCode)
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
		return "ReportTypeTO [reportTypeCode=" + reportTypeCode
				+ ", shortDescription=" + shortDescription + ", description="
				+ description + "]";
	}
	
	
}
