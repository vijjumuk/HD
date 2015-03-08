package com.homedepot.di.xd.efs.exception;

import com.homedepot.ta.aa.exceptions.WrapperException;

/**
 */
public class EFSException extends WrapperException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Field isWarning.
	 */
	private boolean isWarning;
	
	/**
	 * Field errorCode.
	 */
	private int errorCode;
	
	/**
	 * Field errorMsg.
	 */
	private String errorMsg;
	
	/**
	 * Field BUSINESS_ERROR_RETURN_CODE.
	 */
	private int BUSINESS_ERROR_RETURN_CODE = 999;
	/**
	 * Constructor for EFSException.
	 */
	public EFSException(){
		super();
		initialize();
	}
	
	/**
	 * Constructor for EFSException.
	 * @param errMsg String
	 */
	public EFSException(String errMsg) {
		super(errMsg);
		initialize();
	}
	
	/**
	 * Constructor for EFSException.
	 * @param errMsg String
	 * @param errCode int
	 */
	public EFSException(String errMsg,int errCode){
		this(errMsg,errCode,true);
	}
	
		
	/**
	 * Constructor for EFSException.
	 * @param errMsg String
	 * @param errCode int
	 * @param isWarning boolean
	 */
	public EFSException(String errMsg,int errCode, boolean isWarning){
		super(errMsg);
		this.errorCode = errCode;
		this.isWarning = isWarning;
	}
	
	
	/**
	 * Constructor for EFSException.
	 * @param errMsg String
	 * @param cause Throwable
	 */
	public EFSException(String errMsg, Throwable cause) {
		super(errMsg, cause);
		initialize();
	}

	/**
	 * Method isWarning.
	 * @return boolean
	 */
	public boolean isWarning() {
		return isWarning;
	}

	/**
	 * Method setWarning.
	 * @param isWarning boolean
	 */
	public void setWarning(boolean isWarning) {
		this.isWarning = isWarning;
	}

	/**
	 * Method getErrorCode.
	 * @return int
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * Method getErrorMsg.
	 * @return String
	 */
	public String getErrorMsg() {
		if (errorMsg != null) {
			return errorMsg;
		} 
		
		return super.getMessage();
	}
	
	public void setErrorMsg(String eMsg){
		errorMsg  = eMsg;
	}


	/**
	 * Method initialize.
	 */
	private void initialize(){
		isWarning = true;
		errorCode = BUSINESS_ERROR_RETURN_CODE;
	}
	
	
}
