package com.homedepot.di.xd.efs.exception;

public class ReportTypeException extends Exception {

	private static final long serialVersionUID = 6354073484628623434L;

	public ReportTypeException() {
	}

	public ReportTypeException(String message) {
		super(message);
	}

	public ReportTypeException(Throwable cause) {
		super(cause);
	}

	public ReportTypeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReportTypeException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
