/**
 * 
 */
package com.homedepot.di.xd.efs.to;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author 588893
 *
 */
public class ResponseTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2284337887950257037L;
	
	private int returnCode;
	private String returnMessage;
	private String errorMsg;
	private ArrayList<?> results;
	
	@Override
	public String toString() {
		
		return "ResponseTO ["
				+ "returnCode :" +returnCode
				+ " returnMessage :"+returnMessage
				+ " errorMsg :"+errorMsg
				+ " results :"+results
				+"]";
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;		
	}

	public int getReturnCode() {
		return returnCode;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
		
	}

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
		
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setResults(ArrayList<?> results) {
		this.results = results;
		
	}

	public ArrayList<?> getResults() {
		return results;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((errorMsg == null) ? 0 : errorMsg.hashCode());
		result = prime * result + ((results == null) ? 0 : results.hashCode());
		result = prime * result + returnCode;
		result = prime * result
				+ ((returnMessage == null) ? 0 : returnMessage.hashCode());
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
		ResponseTO other = (ResponseTO) obj;
		if (errorMsg == null) {
			if (other.errorMsg != null)
				return false;
		} else if (!errorMsg.equals(other.errorMsg))
			return false;
		if (results == null) {
			if (other.results != null)
				return false;
		} else if (!results.equals(other.results))
			return false;
		if (returnCode != other.returnCode)
			return false;
		if (returnMessage == null) {
			if (other.returnMessage != null)
				return false;
		} else if (!returnMessage.equals(other.returnMessage))
			return false;
		return true;
	}

}
