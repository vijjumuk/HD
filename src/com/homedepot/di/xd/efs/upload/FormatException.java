package com.homedepot.di.xd.efs.upload;

import java.util.HashMap;
import java.util.Map;

public class FormatException extends Exception {

	private static final long serialVersionUID = 8828917090334192658L;

	Map<Field, String> mErrors = new HashMap<Field, String>();
	
	
	public FormatException(String s) {
		super(s);
	}
	public FormatException(String s, Throwable t) {
		super(s, t);
	}
	public FormatException(String msg, Map<Field, String> errors) {
		super(msg);
		if (errors != null) {
			mErrors = errors;
		}
	}
	
	@Override
	public String getMessage() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.getMessage());
		sb.append("[");
		for (Map.Entry<Field, String> errorEntry : mErrors.entrySet()) {
			Field field = errorEntry.getKey();
			String msg = errorEntry.getValue();
			sb.append(field.getName()).append(":");
			sb.append(msg);
		}
		sb.append("]");
		return sb.toString();
	}
	
			
}
