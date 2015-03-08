/**
 * 
 */
package com.homedepot.di.xd.efs.businesshelper;

import java.util.Map;

import org.apache.log4j.Logger;

import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.InputFileTO;
import com.homedepot.di.xd.efs.to.ResponseTO;

/**
 * @author 588893
 * 
 * @version $Revision: 1.0 $
 */
public class UploadManager {

	/**
	 * Field LOGGER.
	 */
	private static final Logger LOGGER = Logger.getLogger(UploadManager.class);
	
	/**
	 * Process the uploaded file.
	 * 
	 * @param uploadedInputStream
	 * @param response
	 * @throws Exception
	 */
	public void processUploadedFile(final InputFileTO fileObj
			, ResponseTO responseTO) throws Exception {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Start processUploadedFile()");
		}
		boolean headerValidation = false;
		
		headerValidation = validateHeaders(fileObj, responseTO);
		
		if (headerValidation && fileObj.getFileType() != null && 
				 responseTO != null && responseTO.getErrorMsg() == null) { 
			
			IUploadProcessor uploadfile = FileUploadFactory.getUploadObj(fileObj.getFileType());
			
			if(uploadfile != null){
				
				uploadfile.processFile(fileObj, responseTO);
			}

		} 

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("End processUploadedFile()");
		}
	}
	
	/**
	 * Method validateHeaders.
	 * @param reader CsvReader
	 * @param fileInput InputFileTO
	 * @param responseTO ResponseTO
	 * @return boolean
	 * @throws EFSException
	 */
	boolean validateHeaders(InputFileTO fileInput,
			ResponseTO responseTO) throws EFSException{

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Entering Method validateHeaders ");
		}

		int isValidHeader = 0;
		int recordCount;
		boolean isHeaderValid = false;
		
		Map<Integer, Object[]> fileContents = fileInput.getFileContents();
		
		if(fileContents == null || fileContents.isEmpty()){
			responseTO.setErrorMsg(UploadConstants.EMPTY_CSV);
			return isHeaderValid;
		}
		
		//reader.readHeaders();
		final String[] uploadedHeader = (String[])fileContents.get(0);
		
		if(uploadedHeader == null || uploadedHeader.length == 0){
			
			responseTO.setErrorMsg(UploadConstants.EMPTY_CSV);
			return isHeaderValid;
		}
		
		switch(UploadManager.identifyFileType(uploadedHeader)){
		
		case UploadConstants.EFS_LOCATION:
			isValidHeader = validateHeaderFields(uploadedHeader,
					UploadConstants.getLocationHeader());
			fileInput.setFileTypeCode(UploadConstants.EFS_LOCATION_UPLOAD);
			fileInput.setFileType(UploadConstants.EFS_LOCATION);
			break;
			
		case UploadConstants.EFS_LANE:
			isValidHeader = validateHeaderFields(uploadedHeader,
					UploadConstants.getShippingLaneHeader());
			fileInput.setFileTypeCode(UploadConstants.EFS_ORDER_GROUP_UPLOAD);
			fileInput.setFileType(UploadConstants.EFS_LANE);
			break;

		case UploadConstants.EFS_SCHEDULE:
			isValidHeader = validateHeaderFields(uploadedHeader,
					UploadConstants.getScheduleHeader());
			fileInput.setFileTypeCode(UploadConstants.EFS_SCHEDULE_UPLOAD);
			fileInput.setFileType(UploadConstants.EFS_SCHEDULE);
			break;
		
		default:
			responseTO.setErrorMsg(UploadConstants.INVALID_HDR_MSG);
		}
		
		if (isValidHeader != 0) {
			responseTO.setErrorMsg(UploadConstants.INVALID_HDR_MSG);
		}
		else {
			// Record Count validation
			isHeaderValid = true;
			
			recordCount = fileContents.keySet().size();

			if (recordCount < UploadConstants.MIN_ROW_COUNT) {
				responseTO.setReturnCode(UploadConstants.NO_DATA_STAT_CD);
				responseTO.setErrorMsg(UploadConstants.EMPTY_INPUT_FILE_MSG);
				isHeaderValid = false;
			}
			if (recordCount > UploadConstants.MAX_ROW_COUNT) {
				responseTO.setReturnCode(UploadConstants.REC_SIZE_STAT_CD);
				responseTO.setErrorMsg(UploadConstants.INPUT_FILE_LIMIT_MSG);
				isHeaderValid = false;
			}
		}
		
		
		return isHeaderValid;
	}


	/**
	 * Method to verify the uploaded file header fields are valid.
	 * 
	 * @param uploadedHeader String[]
	 * @param reqHeader String[]
	 * @return int
	 */
	public static int validateHeaderFields(String[] uploadedHeader,
			String[] reqHeader) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Entering Method validateHeaderFields ");
		}

		if (uploadedHeader.length != reqHeader.length) {
			return 1;
		}
		for (int i = 0; i <= reqHeader.length - 1; i++) {
			if (!reqHeader[i].equalsIgnoreCase(uploadedHeader[i])) {
				return -1;
			}
		}

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("Exiting Method validateHeaderFields ");
		}
		return 0;
	}

	/**
	 * Based on header field it returns the uploaded file type.
	 * 
	 * @param uploadedHeader String[]
	 * @return String - upload type.
	 */
	public static String identifyFileType(String[] uploadedHeader) {

		// Verify field Location Number for Location Upload
		if (uploadedHeader[0].equals(UploadConstants.getLocationHeader()[0])
				&& uploadedHeader[1].equals(UploadConstants.getLocationHeader()[1])) {
			return UploadConstants.EFS_LOCATION;
		}
		
		// For Lane - Verifying header field 
		if (uploadedHeader[0]
				.equals(UploadConstants.getShippingLaneHeader()[0])
				&& uploadedHeader[2]
						.equals(UploadConstants.getShippingLaneHeader()[2])) {
			return UploadConstants.EFS_LANE;
		}
		
		// For Schedule - Verifying header field 
		if (uploadedHeader[0]
				.equals(UploadConstants.getScheduleHeader()[0])
				&& uploadedHeader[2]
						.equals(UploadConstants.getScheduleHeader()[2])) {
			return UploadConstants.EFS_SCHEDULE;
		}
		
		return null;
	}
}
