package com.homedepot.di.xd.efs.businesshelper;

import java.io.IOException;

import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.InputFileTO;
import com.homedepot.di.xd.efs.to.ResponseTO;

/**
 * UploadProcessor interface
 * @author MXG8621
 * @version $Revision: 1.0 $
 */
public interface IUploadProcessor {

	/**
	 * Method processFile.
	 * @param fileObj InputFileTO
	 * @param responseTO ResponseTO
	 * @throws IOException
	 * @throws EFSException
	 */
	public void processFile(InputFileTO fileObj, ResponseTO responseTO)
			throws IOException, EFSException;
/*
	*//**
	 * Method validateHeader.
	 * @param uploadedHeader String[]
	 * @return int
	 *//*
	public int validateHeader(String[] uploadedHeader);*/

}


