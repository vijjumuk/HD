package com.homedepot.di.xd.efs.upload;

import java.io.Serializable;

public class Field  implements Serializable {
	
	private static final long serialVersionUID = 2014093014070001L;
	
	private String mName;
	private Class<? extends Object> mType;
	private boolean mNullable;
	private int position;
	
	public Field(String name, Class<? extends Object> type, boolean nullable) {
		mType = type;
		mName = name;
		mNullable = nullable;
	}
	
	public Field(String name, Class<? extends Object> type) {
		mType = type;
		mName = name;
		mNullable = false;
	}
	public Field(int pos, String name, Class<? extends Object> type, boolean nullable) {
		this(name, type, nullable);
		position = pos;
	}
	
	public int getPosition() {
		return position;
	}
	
	public Field(String name) {
		this(name, java.lang.String.class);
	}		
	public Class<? extends Object> getType() {
		return mType;
	}
	public String getName() {
		return mName;
	}
	public boolean isNullable() {
		return mNullable;
	}
	
	public String toString() {
		return "UploadField(" + mName + "," + mType.getName() + ")";
	}
}
