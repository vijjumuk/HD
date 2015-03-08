/*
 * Created on Mar 27, 2007
 * $Author: x3aydjb $
 * $Date: 2007/12/11 17:05:04 $ 
 * $Revision: 54889225 $
 * $Header: UploadException.java 54889225 /main/OdmComp_dev_Int/1 2007/12/11 17:05:04 x3aydjb $
 * $Id: @(#) UploadException.java@@/main/OdmComp_dev_Int/1 54889225 2007/12/11 17:05:04 x3aydjb $
 * $Name: UploadException.java $
 * $Source: /mm_po_01/OdmComp/OdmCompWeb/JavaSource/com/homedepot/odm/upload/UploadException.java $
 * $Log: $ 
 */
package com.homedepot.di.xd.efs.upload;

/**
 * @author x3aydjb
 *
 */
public class UploadException extends Exception {


	private static final long serialVersionUID = 2425870072077971639L;

	public UploadException(String s) {
		super(s);
	}
	public UploadException(String s, Throwable t) {
		super(s, t);
	}
	public String toString() {
		return "UploadException(" + super.toString() + ")";
	}
}
