
package com.homedepot.di.xd.efs.upload;

/**
 * 
 * 
 * @author m8v3tmm
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class UnsupportedFormatException extends Exception {
	
	private static final long serialVersionUID = 5394403432612433111L;
	
	public UnsupportedFormatException(String s) {
		super(s);
	}
	public UnsupportedFormatException(String s, Throwable t) {
		super(s, t);
	}
	public String toString() {
		return "UnsupportedFormatException(" + super.toString() + ")";
	}	

}
