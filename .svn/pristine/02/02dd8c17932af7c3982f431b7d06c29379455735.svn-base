package com.homedepot.di.xd.efs.upload;


public class RecordFormatImpl  implements RecordFormat {
	private Field[] mFields;
	private FileType mUploadType;
		
	public RecordFormatImpl(FileType uploadType, Field[] fields) {
		mFields = fields;
		mUploadType = uploadType;
	}

	public FileType getUploadType() {
		return mUploadType;
	}
	
	public int getFieldCount() {
		return mFields.length;
	}
	public Field[] getFields() {
		return mFields;
	}
	
}
