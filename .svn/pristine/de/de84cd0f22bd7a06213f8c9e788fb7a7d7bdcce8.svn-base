/*
 * This program is proprietary to The Home Depot and is not to be 
 * reproduced, used, or disclosed without permission of:
 *    
 *  The Home Depot
 *  2455 Paces Ferry Road, N.W.
 *  Atlanta, GA 30339-4053
 * 
 * File Name: LaneUploadProcessor.java 
 * author: The Home Depot Inc
 */
package com.homedepot.di.xd.efs.businesshelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import com.csvreader.CsvReader;
import com.homedepot.di.xd.efs.constants.EFSConstants;
import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.dao.LaneUploadDAO;
import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.InputFileTO;
import com.homedepot.di.xd.efs.to.LaneLoadGroupTO;
import com.homedepot.di.xd.efs.to.LaneLoadGroupVendorTO;
import com.homedepot.di.xd.efs.to.LaneTO;
import com.homedepot.di.xd.efs.to.ResponseTO;
import com.homedepot.di.xd.efs.util.EFSUtil;
import com.homedepot.di.xd.efs.util.UploadValidationUtil;

public class LaneUploadProcessor implements IUploadProcessor {

	private static final Logger LOGGER = Logger
			.getLogger(LaneUploadProcessor.class);
	
	@Override
	public void processFile(InputFileTO fileObj, ResponseTO responseTO)
			throws IOException, EFSException {
		processValidHeaderDataForLane(fileObj, responseTO);
	}

	/**
	 * This method is to validate the uploaded file headers
	 */
	public int validateHeader(String[] uploadedHeader) {
		
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug( UploadConstants.ENTERING_METHOD + "validateHeader");
		}
		
		int hdrValidationCode = UploadValidationUtil.validateHeaderFields(uploadedHeader,
				UploadConstants.getShippingLaneHeader());
		
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("Lane Upload header validation return code is "+hdrValidationCode);
			LOGGER.debug( UploadConstants.EXIT_METHOD + "validateHeader");
		}
		return hdrValidationCode;
	}


	/**
	 * Method will find the valid & invalid records from the file and
	 * Insert/update the records based on the inputs Invalid records will be
	 * mailed to user
	 * 
	 * @param file
	 */
	public void processValidHeaderDataForLane(InputFileTO fileObj,
			ResponseTO responseTO) throws EFSException{
		
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug( UploadConstants.ENTERING_METHOD + "processValidHeaderDataForLane");
		}
		int totalNoOfRecordProcessed = 0;
		//valid 
		List<LaneTO> validLaneTOList = new ArrayList<>();
		
		//invalid
		List<LaneTO> inValidLaneTOList = new ArrayList<>();
		
		Map<Integer, Object[]> fileContents = null;
		
		List<String> vndrDestKeyList = new ArrayList<String>();
		int duplicateRecords = 0;
		
		try{
			
			StringBuilder errString = null;
			int recCurPosition = 0, count = 0, totalNoOfRecords = 0;
			
			//Read the file content
			fileContents = fileObj.getFileContents();
			
			List<String> vendorNbrList = new ArrayList<>();
			List<String> locationNbrList = new ArrayList<>();
			List<String> dcNmbrList = new ArrayList<String>();
			
			// Read each record in the file and validate
			for (Map.Entry<Integer, Object[]> entry : fileContents.entrySet()){
				
				if(entry.getKey() == 0){
					continue;
				}
				
				Object[] row = entry.getValue();
				
				/*if(EFSUtil.isRowEmpty(row)){
					continue;
				}*/
				
				errString = new StringBuilder();
				LaneTO laneTO = new LaneTO();
				LaneLoadGroupTO laneLoadGrpTO = new LaneLoadGroupTO();
				LaneLoadGroupVendorTO laneVndrTO = new LaneLoadGroupVendorTO();
				
				//Setting Uploaded User Id
				laneTO.setCreatedUserId(fileObj.getUserId());
				laneTO.setLastUptdUserId(fileObj.getUserId());
				laneLoadGrpTO.setCreatedUserId(fileObj.getUserId());
				laneLoadGrpTO.setLastUptdUserId(fileObj.getUserId());
				laneVndrTO.setCreatedUserId(fileObj.getUserId());
				laneVndrTO.setLastUptdUserId(fileObj.getUserId());
				
				/**
				 * If Origin ID is invalid add it to error string
				 */
				laneTO.setOriginId(row[UploadConstants.FIRST].toString());
				if (!UploadValidationUtil.isOriginValid(row[UploadConstants.FIRST].toString())) {
					errString.append(UploadConstants.INVALID_ORIGIN);
				}
				
				/**
				 * If Destination ID is invalid add it to error string
				 */
				laneTO.setDestinationId(row[UploadConstants.SECOND].toString());//the method should be setDestinationId
				if (!UploadValidationUtil.isDestinationValid(row[UploadConstants.SECOND].toString())) {
					errString.append(UploadConstants.INVALID_DESTINATION);
				}
				
				// Check if Lane name exist
				laneTO.setShppingLaneName(row[UploadConstants.THIRD].toString());
				if (!UploadValidationUtil.isValidStringLength(row[UploadConstants.THIRD].toString(), 100)) {
					errString.append(UploadConstants.INVALID_LANE_NAME);
				} 
				
				// Check if vendor number exist
				laneVndrTO.setMvndrNbr(row[UploadConstants.FOURTH].toString());
				if(!UploadValidationUtil.isVendorValid(row[UploadConstants.FOURTH].toString() )){
					errString.append(UploadConstants.INVALID_VNDR);
				}
				
				//Check to see if Different group name is provided if not considered it as DEFAULT
				if(UploadValidationUtil.isEmptyString(row[UploadConstants.EIGHT].toString())){
					laneLoadGrpTO.setLaneLoadGroupName(UploadConstants.DEFAULT);
				}else{
					laneLoadGrpTO.setLaneLoadGroupName(row[UploadConstants.EIGHT].toString().trim().toUpperCase());
				}
				
				//check if primary location exist
				if(row[UploadConstants.FIVE].toString().trim().equalsIgnoreCase(UploadConstants.YES))
					laneVndrTO.setPrimaryLocation(UploadConstants.YES);
				else
					laneVndrTO.setPrimaryLocation(UploadConstants.NO);
				
				// Check if Vendor Effective begin date exist
				// if exist then convert that into Util.Date format
				if(row[UploadConstants.SIX] == null){
					errString.append(UploadConstants.INVALID_VENDOR_EFF_BGN_DT);
				}else{
					laneVndrTO.setEffectiveBeginDate(UploadValidationUtil.convertSUtilDateToSqlDate(row[UploadConstants.SIX]));
				}
					
				
				// Check if Vendor Effective end date exist
				// if exist then convert that into Util.Date format
				if(row[UploadConstants.SEVEN] == null){
					errString.append(UploadConstants.INVALID_VENDOR_EFF_END_DT);
				}else{
					laneVndrTO.setEffectiveEndDate(UploadValidationUtil.convertSUtilDateToSqlDate(row[UploadConstants.SEVEN]));
				}
				
				// Check if Load Group Effective begin date exist
				// if exist then convert that into Util.Date format
				if(row[UploadConstants.NINE] == null){
					errString.append(UploadConstants.INVALID_LOAD_GRP_EFF_BGN_DT);
				}else{
					laneLoadGrpTO.setEffectiveBeginDate(UploadValidationUtil.convertSUtilDateToSqlDate(row[UploadConstants.NINE]));
				}
				
				// Check if Load Group Effective end date exist
				// if exist then convert that into Util.Date format
				if(row[UploadConstants.TEN] == null){
					errString.append(UploadConstants.INVALID_LOAD_GRP_EFF_END_DT);
				}else{
					laneLoadGrpTO.setEffectiveEndDate(UploadValidationUtil.convertSUtilDateToSqlDate(row[UploadConstants.TEN]));
				}
				
				// check if Lane Active flag exists if doesn't exist set it as N
				if(row[UploadConstants.ELEVEN].toString().equalsIgnoreCase(UploadConstants.YES)){
					laneTO.setActiveFlag(true);
				}else{
					laneTO.setActiveFlag(false);
				}
				
				/*
				 * checking for vendor + destination combination
				 */
				String vndrDest = row[UploadConstants.SECOND].toString()+"_"+row[UploadConstants.FOURTH].toString();
				String primaryLocation = laneVndrTO.getPrimaryLocation();
				if(primaryLocation.equalsIgnoreCase(UploadConstants.YES)){
					if(vndrDestKeyList.contains(vndrDest)){
						errString.append(UploadConstants.PRIMARY_LANE_ALREADY_EXIST);
					}
					vndrDestKeyList.add(vndrDest);
				}
				
				laneLoadGrpTO.setLaneLoadGroupVendorTo(laneVndrTO);
				laneTO.setLaneLoadGroupTo(laneLoadGrpTO);
				
				/*
				 * If there is no error message found proceed with 
				 * data processing logic
				 */
				if (errString.toString().isEmpty()) {
					/*
					 *  Adding the vendor number, Origin, destination 
					 *  to list for later database validation
					 */
					locationNbrList.add(row[UploadConstants.FIRST].toString());
					locationNbrList.add(row[UploadConstants.SECOND].toString());
					dcNmbrList.add(row[UploadConstants.SECOND].toString());
					vendorNbrList.add(row[UploadConstants.FOURTH].toString());
					
					validLaneTOList.add(laneTO);
					
					if(LOGGER.isDebugEnabled()){
						LOGGER.debug( "Adding to Valid List : " + laneTO.toString());
					}
				} 
				else {
					laneTO.setErrorString(errString.toString());
					inValidLaneTOList.add(laneTO);
					responseTO.setErrorMsg(errString.toString());
					if(LOGGER.isDebugEnabled()){
						LOGGER.debug( "Adding to InValid List : " + laneTO.toString());
					}
				}
				
				totalNoOfRecords++;

			} //end of While()
			
			//Temporary list to iterate the main list and perform DB operation
			List<LaneTO> laneTOList;
			
			if(validLaneTOList !=null && validLaneTOList.size()>0 ){
				
				if(LOGGER.isDebugEnabled()){
					LOGGER.debug( "Size of validLaneTOList : " + validLaneTOList.size());
				}
				
				/*
				 * To remove the TO's with same vndr + origin + destination + grp name
				 */
				
				Set<LaneTO> validLaneSet = new TreeSet<LaneTO>();
				validLaneSet.addAll(validLaneTOList);
				if(validLaneTOList.size() > validLaneSet.size()) {
					duplicateRecords = validLaneTOList.size() - validLaneSet.size();
					if(LOGGER.isDebugEnabled()){
						LOGGER.debug( "No of Duplicate records present : " + (validLaneTOList.size() - validLaneSet.size()));
					}
				}
				validLaneTOList = new ArrayList<LaneTO>(validLaneSet);
				
				if(LOGGER.isDebugEnabled()){
					LOGGER.debug( "ValidTO list after removing duplicates size : " + validLaneTOList.size() +  "list values :" + validLaneTOList.toString());
				}
				
				// Validate the MVENDOR Exists
				int totalVendorSize = vendorNbrList.size();
				List<String> inputVendorList;
				Map<String, Short> validVendorNbrMap = new HashMap<>();
				for(int i = 0;i < totalVendorSize; i += UploadConstants.MAX_SEL_MULTIPLE) {
					inputVendorList = new ArrayList<>();
					inputVendorList.addAll(vendorNbrList.subList(i, Math.min(i + UploadConstants.MAX_SEL_MULTIPLE, totalVendorSize)));
					LaneUploadDAO.validateMvendorAndGatherInformation(inputVendorList, validVendorNbrMap);
				}
				
				//get the valid EFS Location id for all the locations and populate them in validOriginDestinationMap
				int totalLocationSize = locationNbrList.size();
				Map<String, Integer> validOriginDestinationMap = new HashMap<>();
				List<String> inputLocationList;
				for(int i = 0;i < totalLocationSize; i += UploadConstants.MAX_SEL_MULTIPLE) {
					inputLocationList = new ArrayList<>();
					inputLocationList.addAll(locationNbrList.subList(i, Math.min(i + UploadConstants.MAX_SEL_MULTIPLE, totalLocationSize)));
					LaneUploadDAO.getValidEFSLocationIds(inputLocationList, validOriginDestinationMap);
				}
				
				//get the valid vendor and destination combination from the db which are present
				//Remove the values from the validLaneList which are present in DB
				totalLocationSize = dcNmbrList.size();
				List<String> vndrDestinationList = new ArrayList<>();
				for(int i=0, j=0; i < totalVendorSize; 
						i += UploadConstants.MAX_SEL_MULTIPLE, j += UploadConstants.MAX_SEL_MULTIPLE )
				{
					inputVendorList = new ArrayList<String>();
					inputLocationList = new ArrayList<String>();
					inputVendorList.addAll(vendorNbrList.subList(i, Math.min(i + UploadConstants.MAX_SEL_MULTIPLE, totalVendorSize)));
					inputLocationList.addAll(dcNmbrList.subList(j, Math.min(j + UploadConstants.MAX_SEL_MULTIPLE, totalLocationSize)));
					
					LaneUploadDAO.validateVendorDestinationInfo(inputVendorList, inputLocationList, vndrDestinationList);
				}
				/*
				 *  Below logic is to cut the input list size to 500 
				 *  so the DB insert can be handled without any issues
				 */
				for (int readCount = 0; readCount < (validLaneTOList.size() / UploadConstants.MAX_SEL_MULTIPLE + 1); readCount++) {
					laneTOList = new ArrayList<>();
					for (int index = recCurPosition; (index < validLaneTOList
							.size() && count <= UploadConstants.MAX_SEL_MULTIPLE); count++, index++) {
						
						LaneTO laneTO = validLaneTOList.get(index);
						
						// check for valid origin
						if(validOriginDestinationMap.get(laneTO.getOriginId()) == null ){
							laneTO.setErrorString(UploadConstants.INVALID_ORIGIN);
							inValidLaneTOList.add(laneTO);
							continue;
						}else{
							laneTO.setOriginLocId(validOriginDestinationMap.get(laneTO.getOriginId()));
						}
						
						// check for valid destination 
						if(validOriginDestinationMap.get(laneTO.getDestinationId()) == null ){
							laneTO.setErrorString(UploadConstants.INVALID_DESTINATION);
							inValidLaneTOList.add(laneTO);
							continue;
						}else{
							laneTO.setDestinationLocId(validOriginDestinationMap.get(laneTO.getDestinationId()));
						}
						
						//Check to see the vendor number is valid 
						if(laneTO.getLaneLoadGroupTo()!=null){
							if(laneTO.getLaneLoadGroupTo().getLaneLoadGroupVendorTo()!=null ){
								String vendorNbr = laneTO.getLaneLoadGroupTo().getLaneLoadGroupVendorTo().getMvndrNbr(); 
								if(validVendorNbrMap.get(vendorNbr)!=null){
									short deptNbr = validVendorNbrMap.get(vendorNbr);
									laneTO.getLaneLoadGroupTo().getLaneLoadGroupVendorTo().setDepartmentNbr(deptNbr);
									laneTO.getLaneLoadGroupTo().getLaneLoadGroupVendorTo().setMerchendiseBaseCode(UploadConstants.MER_BASE_CODE);
								}else{
									laneTO.setErrorString(UploadConstants.INVALID_VNDR);
									inValidLaneTOList.add(laneTO);
									continue;
								}
							}
						}
						
						//Check to see if Primary Lane for Destination & Vendor already exist in DB.
						String vendorDestination = laneTO.getLaneLoadGroupTo().getLaneLoadGroupVendorTo().getMvndrNbr()
								+"_"+ laneTO.getDestinationId();
						if(vndrDestinationList.contains(vendorDestination)){
							laneTO.setErrorString(UploadConstants.PRIMARY_LANE_ALREADY_EXIST);
							inValidLaneTOList.add(laneTO);
						}
						//Adding the TO to valid list so it can be populated to table
						laneTOList.add(laneTO);
					}

					//Removing the error TOs from the valid list
					laneTOList.removeAll(inValidLaneTOList);
					
					// To insert the valid records from uploaded file
					LaneUploadDAO.insertRecords(laneTOList, inValidLaneTOList);
					totalNoOfRecordProcessed = totalNoOfRecords - inValidLaneTOList.size() - duplicateRecords;
					
					recCurPosition += (count - 1);
					count = 0;
				}
			}
			
			responseTO.setReturnMessage(totalNoOfRecordProcessed +"/"+totalNoOfRecords 
					+" successful records uploaded");
			LOGGER.debug(totalNoOfRecordProcessed +"/"+totalNoOfRecords 
					+" successful records uploaded");
			//Sending back the invalid TOs as response.
			if(inValidLaneTOList.size() > 0 ){
				/*responseTO.setReturnMessage("No of Records Processed is " + totalNoOfRecordProcessed +
						" and No of Records errored out is " + inValidLaneTOList.size());
				responseTO.setResults(new ArrayList<LaneTO>(inValidLaneTOList));
				*/
				LOGGER.debug("No of Records Processed is " + totalNoOfRecordProcessed +
						" and No of Records errored out is " + inValidLaneTOList.size());
				LOGGER.debug("Invalid List : "+inValidLaneTOList.toString());
			}
			if(duplicateRecords > 0 ){
				LOGGER.debug("No of Records Processed is " + totalNoOfRecordProcessed +
						" and No of Records errored out due to Duplication is " + duplicateRecords);
			}
			if(LOGGER.isDebugEnabled()){
				LOGGER.debug( UploadConstants.EXIT_METHOD + "processValidHeaderDataForLane");
			}
		}catch(Exception e){
			throw new EFSException(
					EFSConstants.EXCEPTION_OCCURED, e);
		}
	}
}
