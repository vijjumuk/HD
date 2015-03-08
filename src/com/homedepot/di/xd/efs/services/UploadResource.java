/*
 * This program is proprietary to The Home Depot and is not to be 
 * reproduced, used, or disclosed without permission of:
 *    
 *  The Home Depot
 *  2455 Paces Ferry Road, N.W.
 *  Atlanta, GA 30339-4053
 * 
 * File Name: EFSUploadResource.java 
 * author: The Home Depot Inc
 */
package com.homedepot.di.xd.efs.services;

import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.homedepot.di.xd.efs.businesshelper.UploadManager;
import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.to.InputFileTO;
import com.homedepot.di.xd.efs.to.ResponseTO;
import com.homedepot.di.xd.efs.upload.FileParser;
import com.homedepot.di.xd.efs.upload.FileParserFactory;
import com.homedepot.di.xd.efs.upload.FileType;
import com.homedepot.di.xd.efs.util.MessageResponse;
import com.homedepot.di.xd.efs.util.ValidationUtil;
import com.homedepot.ta.aa.log4j.SimpleExceptionLogger;
import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

@Path("/EFSUploadResource")
public class UploadResource {
	
	private static final Logger LOGGER = Logger
			.getLogger(UploadResource.class);

	/**
	 * The service is to process the uploaded files from UI.
	 * 
	 * @param uploadedInputStream - uploaded file
	 * @param fileDetail - upload type
	 * @param fileName - Name of uploaded file.
	 * @param userId - uploaded user id
	 * @return
	 */
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/uploadFile")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String uploadFile(
			@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail,
			@FormDataParam("userId") String userId,
			@FormDataParam("fileType") String inputFileType)

	{
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Entering Method - uploadFile() ");
			LOGGER.debug("fileDetail :" + fileDetail);
			LOGGER.debug("userId :" + userId);
		}

		String result = null;
		//ResultResponse response = new ResultResponse();
		MessageResponse messageResponse = new MessageResponse();
		ResponseTO responseTO = null;
		InputFileTO fileObj = null;
		try {
			String fileName = fileDetail.getFileName();
			
			//Parse the file.
			FileType fileType = FileType.getFileTypeFor(Integer.parseInt(inputFileType));
			FileParser parser = FileParserFactory.getFileParserFor(fileType);
			
			fileObj = new InputFileTO(parser.parse(uploadedInputStream),
					fileName, userId);
			
			UploadManager processUploadfile = new UploadManager();

			responseTO = new ResponseTO();
			if (ValidationUtil.isEmpty(userId)) {
				responseTO.setErrorMsg(UploadConstants.INVALID_USER_ID);
				throw new Exception(UploadConstants.INVALID_USER_ID);
			}
			if (ValidationUtil.isEmpty(fileName)) {
				responseTO.setErrorMsg(UploadConstants.INVALID_FILE_NAME);
				throw new Exception(UploadConstants.INVALID_FILE_NAME);
			}
			
			processUploadfile.processUploadedFile(fileObj, responseTO);
			
			result = messageResponse.getSuccessfulJsonResponse(responseTO);
			
		} catch (Exception e) {
			if(responseTO != null ){
				responseTO = new ResponseTO();
				responseTO.setReturnCode(UploadConstants.EXCEP_ERR_CD);
				responseTO.setErrorMsg(UploadConstants.FAILED_MSG);
				result = messageResponse.getSuccessfulJsonResponse(responseTO);
				SimpleExceptionLogger.log(e, "WebServiceProject");
			}
			
			//DCMServiceOrangeLoggerHelper.dropRecordToOrangeLogger(fileObj, false, e.getMessage());
		}
		result = messageResponse.getSuccessfulJsonResponse(responseTO);
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("result: '" + result + "'");
			LOGGER.debug("End myMethod");
		}
		return result;
	}
}
