package com.homedepot.di.xd.efs.to;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Map;

public class InputFileTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4029558266871625966L;
	private String fileName;
	private String userId;
	private String fileType;
	private short fileTypeCode;
	Map<Integer, Object[]> fileContents = null;
	
	@Override
	public String toString() {
		return "InputFileTO [fileName=" + fileName + ", userId=" + userId
				+ ", fileType=" + fileType + ", fileTypeCode=" + fileTypeCode
				+ ", fileContents=" + fileContents + "]";
	}
	
	public InputFileTO(Map<Integer, Object[]> fileContents, String fileName,
			String userId) {
		this.fileContents = fileContents;
		this.fileName = fileName;
		this.userId = userId;
	}


	public Map<Integer, Object[]> getFileContents() {
		return fileContents;
	}

	public void setFileContents(Map<Integer, Object[]> fileContents) {
		this.fileContents = fileContents;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setUserId(String userId) {
		this.userId = userId;
		
	}

	public String getUserId() {
		return userId;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
		
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileTypeCode(short fileTypeCode) {
		this.fileTypeCode = fileTypeCode;		
	}

	public short getFileTypeCode() {
		return fileTypeCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((fileContents == null) ? 0 : fileContents.hashCode());
		result = prime * result
				+ ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result
				+ ((fileType == null) ? 0 : fileType.hashCode());
		result = prime * result + fileTypeCode;
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		InputFileTO other = (InputFileTO) obj;
		if (fileContents == null) {
			if (other.fileContents != null)
				return false;
		} else if (!fileContents.equals(other.fileContents))
			return false;
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (fileType == null) {
			if (other.fileType != null)
				return false;
		} else if (!fileType.equals(other.fileType))
			return false;
		if (fileTypeCode != other.fileTypeCode)
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}
