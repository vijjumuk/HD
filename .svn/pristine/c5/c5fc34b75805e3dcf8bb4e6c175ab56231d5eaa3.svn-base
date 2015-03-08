/*
 * This program is proprietary to The Home Depot and is not to be 
 * reproduced, used, or disclosed without permission of:
 *    
 *  The Home Depot
 *  2455 Paces Ferry Road, N.W.
 *  Atlanta, GA 30339-4053
 * 
 * File Name: UploadDAOImpl.java 
 * author: The Home Depot Inc
 */

package com.homedepot.di.xd.efs.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.LaneLoadGroupTO;
import com.homedepot.di.xd.efs.to.LaneLoadGroupVendorTO;
import com.homedepot.di.xd.efs.to.LaneTO;
import com.homedepot.di.xd.efs.util.UploadValidationUtil;
import com.homedepot.ta.aa.dao.Inputs;
import com.homedepot.ta.aa.dao.Query;
import com.homedepot.ta.aa.dao.Results;
import com.homedepot.ta.aa.dao.ResultsReader;
import com.homedepot.ta.aa.dao.builder.DAO;
import com.homedepot.ta.aa.dao.builder.UnitOfWork;
import com.homedepot.ta.aa.dao.exceptions.QueryException;

public class LaneUploadDAO {

	private static final Logger LOGGER = Logger.getLogger(LaneUploadDAO.class);
	
	// Data source constant
	private static final String SupplyChainDistributionNetwork = "java:comp/env/jdbc/SupplyChainDistributionNetwork.1";
	
	private static final String SELECT_MVNDR_QUERY = "SELECT MVNDR_NBR, MER_DEPT_NBR FROM MVNDR WHERE 1=1 ";
	
	private static final String SELECT_EFS_LOC_ID_QUERY = "SELECT SCHN_LOC_ID, SRC_LOC_ID FROM SCHN_EFS_LOC_XREF WHERE 1=1 ";
	
	private static final String SELECT_MVNDR_DESTINATION_QUERY = " SELECT DISTINCT XREF.SRC_LOC_ID AS SRC_LOC_ID, VNDR.MBAS_MVNDR_NBR AS MVNDR_NMBR "
			+ " FROM SCHN_EFS_LOC_XREF XREF "
			+ " INNER JOIN SCHN_SHPG_LANE LANE "
			+ " ON LANE.SHP_TO_SCHN_LOC_ID = XREF.SCHN_LOC_ID "
			+ " INNER JOIN SCHN_SHPG_LANE_LOAD_GRP LGRP "
			+ " ON LGRP.SCHN_SHPG_LANE_ID = LANE.SCHN_SHPG_LANE_ID "
			+ " INNER JOIN SCHN_SHLANE_LGRP_VNDR VNDR "
			+ " ON VNDR.SCHN_SHPG_LANE_LOAD_GRP_ID = LGRP.SCHN_SHPG_LANE_LOAD_GRP_ID WHERE 1=1 ";
	                                                                                      
	// SQL Query Constants
	private static final String INSERT_EFS_LANE_QUERY = "INSERT INTO SCHN_SHPG_LANE " 
		            + " (SCHN_SHPG_LANE_ID, " 
		            + " CRT_SYSUSR_ID, " 
		            + " CRT_TS, " 
		            + " LAST_UPD_SYSUSR_ID, " 
		            + " LAST_UPD_TS, " 
		            + " ORIG_SCHN_LOC_ID, " 
		            + " SHP_TO_SCHN_LOC_ID, " 
		            + " SCHN_SHPG_LANE_NM, " 
		            + " ACTV_FLG) " 
		+ " VALUES (?,?,CURRENT_TIMESTAMP,?,CURRENT_TIMESTAMP,?,?,?,?)";
	
	private static final String INSERT_EFS_LANE_GRP_QUERY = "INSERT INTO SCHN_SHPG_LANE_LOAD_GRP " 
            + " (SCHN_SHPG_LANE_LOAD_GRP_ID, " 
            + " CRT_SYSUSR_ID, " 
            + " CRT_TS, " 
            + " LAST_UPD_SYSUSR_ID, " 
            + " LAST_UPD_TS, " 
            + " SCHN_SHPG_LANE_ID, " 
            + " EFF_BGN_DT, " 
            + " EFF_END_DT, " 
            + " SHPG_LANE_LOAD_GRP_NM) " 
            + " VALUES (?,?,CURRENT_TIMESTAMP,?,CURRENT_TIMESTAMP,?,?,?,?)";

	private static final String INSERT_EFS_LGRP_VENDOR_QUERY = "INSERT INTO SCHN_SHLANE_LGRP_VNDR " 
            + " (SCHN_SHLANE_LGRP_VNDR_ID, " 
            + " CRT_SYSUSR_ID, " 
            + " CRT_TS, " 
            + " LAST_UPD_SYSUSR_ID, " 
            + " LAST_UPD_TS, " 
            + " MBAS_MVNDR_NBR, " 
            + " MBAS_DEPT_NBR, " 
            + " SCHN_SHPG_LANE_LOAD_GRP_ID, " 
            + " EFF_BGN_DT, " 
            + " EFF_END_DT, " 
/*            + " MER_BASE_CD) "
            + " VALUES (?,?,CURRENT_TIMESTAMP,?,CURRENT_TIMESTAMP,?,?,?,?,?,?)";*/
            //TODO: Need to enable below line once this column added to the table
			+ " MER_BASE_CD, "
            + " PRIM_VNDR_SHPG_LANE_FLG) "
			+ " VALUES (?,?,CURRENT_TIMESTAMP,?,CURRENT_TIMESTAMP,?,?,?,?,?,?,?)";
			
	private static final String LANE_SEQ_NBR =	"SELECT SCHN_SHPG_LANE_SEQ.NEXTVAL AS SCHN_SHPG_LANE_SEQ FROM DUAL";
	
	private static final String LANE_GRP_SEQ_NBR =	"SELECT SCHN_SHPG_LANE_LOAD_GRP_SEQ.NEXTVAL AS SCHN_SHPG_LANE_LOAD_GRP_SEQ FROM DUAL";
	
	private static final String LGRP_VENDOR_SEQ_NBR =	"SELECT SCHN_SHLANE_LGRP_VNDR_SEQ.NEXTVAL AS SCHN_SHLANE_LGRP_VNDR_SEQ FROM DUAL";
	
	private static final String SELECT_LANE_ID = "SELECT SCHN_SHPG_LANE_ID FROM SCHN_SHPG_LANE" 
			+ " WHERE ORIG_SCHN_LOC_ID = ? "
			+ " AND SHP_TO_SCHN_LOC_ID = ? ";
	
	private static final String SELECT_LANE_GRP = "SELECT SCHN_SHPG_LANE_LOAD_GRP_ID FROM SCHN_SHPG_LANE_LOAD_GRP "
			+ " WHERE SCHN_SHPG_LANE_ID = ? "
			+ " AND UPPER(SHPG_LANE_LOAD_GRP_NM) LIKE UPPER (?) ";
	
	private static final String SELECT_LGRP_VENDOR = "SELECT SCHN_SHLANE_LGRP_VNDR_ID FROM SCHN_SHLANE_LGRP_VNDR "
			+ " WHERE SCHN_SHPG_LANE_LOAD_GRP_ID = ? "
			+ " AND MBAS_MVNDR_NBR = ? ";
	
	
	/**
	 * To get the lane Id from the given origin and destination
	 * 
	 * @param origin
	 * @param destination
	 * @return lane id
	 * @throws EFSException
	 */
	public static int getLaneId(int origin, int destination) throws EFSException{
		try{
			
			Integer laneId = DAO.useJNDI(SupplyChainDistributionNetwork)
					            .setSQL(SELECT_LANE_ID, 
					            		origin,
					            		destination)
					            		.debug(true)
										.get(Integer.class);
			if(laneId !=null){
				return laneId;
			}
		}catch(QueryException qe){
			throw new EFSException(UploadConstants.EXCEPTION + qe.getMessage(),
					UploadConstants.QUERY_EXCEPTION_CD);
		}
		return 0;		
	}
	
	/**
	 * To get the lane group id from given laneId
	 * 
	 * @param laneId
	 * @return lane group id
	 * @throws EFSException
	 */
	public static int getLaneGroupId(int laneId, String groupName) throws EFSException{
		try{
			
			Integer laneGroupId = DAO.useJNDI(SupplyChainDistributionNetwork)
					            .setSQL(SELECT_LANE_GRP, 
					            		laneId,
					            		groupName)
					            		.debug(true)
										.get(Integer.class);
			if(laneGroupId !=null){
				return laneGroupId;
			}
		}catch(QueryException qe){
			throw new EFSException(UploadConstants.EXCEPTION + qe.getMessage(),
					UploadConstants.QUERY_EXCEPTION_CD);
		}
		return 0;		
	}
	
	/**
	 * To get the lane load group vendor id from the given load group id
	 * 
	 * @param laneGroupId
	 * @return
	 * @throws EFSException
	 */
	public static int getLaneLoadGroupVendorId(int laneGroupId, String vendorNumber) throws EFSException{
		try{
			
			Integer laneGroupVendorId = DAO.useJNDI(SupplyChainDistributionNetwork)
					            .setSQL(SELECT_LGRP_VENDOR, 
					            		laneGroupId,
					            		vendorNumber)
					            		.debug(true)
										.get(Integer.class);
			if(laneGroupVendorId !=null){
				return laneGroupVendorId;
			}
		}catch(QueryException qe){
			throw new EFSException(UploadConstants.EXCEPTION + qe.getMessage(),
					UploadConstants.QUERY_EXCEPTION_CD);
		}
		return 0;		
	}
	
	/**
	 * To find the list of valid vendor numbers from the input list
	 * 
	 * @param vndrList
	 * @return
	 * @throws QueryException
	 */
	public static List<String> validateMvendorNumbers(List<String> vndrList) throws QueryException{
		
		List<String> mvndrList = null;
		
		String validVendorNbrQuery = SELECT_MVNDR_QUERY;
				
		validVendorNbrQuery += inListBuilder("MVNDR_NBR",vndrList,"vndrList", 500);

		mvndrList = DAO.useJNDI(SupplyChainDistributionNetwork)
				.setSQL( validVendorNbrQuery)
						.debug(true)
						.list(String.class);
		return mvndrList;
		
	}
	
	/**
	 * To find the list of valid vendor numbers from the input list
	 * and to get their department information
	 * 
	 * @param vndrList
	 * @param validVendorNbrMap
	 * @throws QueryException
	 */
	public static void validateMvendorAndGatherInformation(List<String> vndrList, final Map<String, Short> validVendorNbrMap) throws QueryException{
		
		try{	
			String validVendorNbrQuery = SELECT_MVNDR_QUERY;
			validVendorNbrQuery += inListBuilder("MVNDR_NBR",vndrList,"vndrList", 500);
	
			DAO.useJNDI(SupplyChainDistributionNetwork)
					.setSQL( validVendorNbrQuery)
							.debug(true)
							.results(new ResultsReader()
							{
								@Override
								public void readResults(Results results, Query query, Inputs inputs)
										throws QueryException {
									while(results.next()){
										if(!UploadValidationUtil.isEmptyString(results.getString("MVNDR_NBR")) 
												&& results.getInt("MER_DEPT_NBR") > 0 ){
											validVendorNbrMap.put(results.getString("MVNDR_NBR"), results.getShort("MER_DEPT_NBR"));
										}
									}
								}
		
							});
			} catch (QueryException e) {
				e.printStackTrace();
			}
	}
	
	/**
	 * To get the valid EFS_LOC_ID
	 * 
	 * @param sourceId
	 * @param locationMap
	 * @return
	 */
	public static void getValidEFSLocationIds(List<String> sourceIdList, final Map<String, Integer> locationMap) {

		String sql = SELECT_EFS_LOC_ID_QUERY;
		try {
			
			sql += inListBuilder("SRC_LOC_ID", sourceIdList,"sourceIdList", 500);
						
			DAO.useJNDI(SupplyChainDistributionNetwork) 
			.setSQL( sql )
					.debug(true)
					.results(new ResultsReader()
					{
						@Override
						public void readResults(Results results, Query query, Inputs inputs)
								throws QueryException {
							while(results.next()){
								locationMap.put(results.getString("SRC_LOC_ID"), results.getInt("SCHN_LOC_ID"));
								
							}
						}

					});
		} catch (QueryException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * To get valid mvndr_nmbr and destination combination
	 * 
	 * @param inputVendorList
	 * @param inputLocationList
	 * @param vndrDestinationMap
	 */
	public static void validateVendorDestinationInfo(
			List<String> inputVendorList, List<String> inputLocationList, final List<String> vndrDestinationList) {
		
		String sql = SELECT_MVNDR_DESTINATION_QUERY;
		
		try {
			sql += inListBuilder("XREF.SRC_LOC_ID", inputLocationList,"sourceIdList", 500);
			sql += inListBuilder("VNDR.MBAS_MVNDR_NBR", inputVendorList,"vndrList", 500);
			
			DAO.useJNDI(SupplyChainDistributionNetwork) 
			.setSQL( sql )
			.debug(true)
			.results(new ResultsReader()
			{
				@Override
				public void readResults(Results results, Query query, Inputs inputs)
						throws QueryException {
					while(results.next()){
						String item = results.getString("MVNDR_NMBR") +"_"+ results.getString("SRC_LOC_ID");
						vndrDestinationList.add(item);
					}
				}

			});
		}
		catch (QueryException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Utility method to generate IN clause query string
	 * 
	 * @param columnName
	 * @param inList
	 * @param listName
	 * @param maxSize
	 * @return
	 * @throws QueryException
	 */
	private static String inListBuilder(String columnName, List<?> inList ,String listName, int maxSize) throws QueryException{
		StringBuilder buff = new StringBuilder();
		//checkPropertyIsNull(listName, inList);
		if(inList.size()==0 || inList.size()>maxSize){
			throw new QueryException(listName + " size is " + inList.size() + "; size must be between 1 and " + maxSize );
		}
		buff.append(" AND ");
		buff.append(columnName);
		buff.append(" IN ( '");
		for(int i = 0;i<inList.size();i++){
			if(i>0)
				buff.append("', '" + inList.get(i));
			else
				buff.append( inList.get(i));
		}
		buff.append("' ) ");
		return buff.toString();
	}
	

	/**
	 * Creates record in SCHN_SHPG_LANE, SCHN_SHPG_LANE_LOAD_GRP, SCHN_SHLANE_LGRP_VNDR tables
	 * 
	 * @param laneTOList
	 * @throws QueryException 
	 */
	public static boolean insertRecords(final List<LaneTO> laneTOList, final List<LaneTO> inValidLaneTOList) throws EFSException {
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD + "insertRecords");
		}
		
		try{
			
			new UnitOfWork<Boolean>() {

				@Override
				public Boolean runQueries() throws Exception {
					
					if (laneTOList != null && laneTOList.size() > 0) {
						
						for (LaneTO laneTO : laneTOList) {

							if(LOGGER.isDebugEnabled()){
								LOGGER.debug("Processing LaneTO : " + laneTO.toString());		
								LOGGER.debug("Processing LaneLoadGroupTO : " + laneTO.getLaneLoadGroupTo().toString());
								LOGGER.debug("Processing LaneLoadGroupVendorTO : " + laneTO.getLaneLoadGroupTo().getLaneLoadGroupVendorTo().toString());
							}
							
							/*
							 *  Check for lane existence
							 *  if not exist insert records SCHN_SHPG_LANE, SCHN_SHPG_LANE_LOAD_GRP, 
							 *  SCHN_SHLANE_LGRP_VNDR tables
							 */
							int laneId = getLaneId(laneTO.getOriginLocId(), laneTO.getDestinationLocId());
							
							if(laneId == 0 ){
								// populate the record in all three tables
								
						    	laneTO.setLaneId(getNextSeqId(LANE_SEQ_NBR));
						    	LOGGER.debug("Generated Lane Id : "+laneTO.getLaneId());
								createLane(laneTO);
								
								LaneLoadGroupTO laneLoadGroupTo = laneTO.getLaneLoadGroupTo();
								laneLoadGroupTo.setLaneId(laneTO.getLaneId());
								laneLoadGroupTo.setLandLoadGroupId(getNextSeqId(LANE_GRP_SEQ_NBR));
								LOGGER.debug("Generated LoadGroup Id : "+laneLoadGroupTo.getLandLoadGroupId());
								createLaneLoadGroup(laneLoadGroupTo);
								
								LaneLoadGroupVendorTO laneLoadGroupVendorTo = laneLoadGroupTo.getLaneLoadGroupVendorTo();
								laneLoadGroupVendorTo.setLaneLoadGrpId(laneLoadGroupTo.getLandLoadGroupId());
								laneLoadGroupVendorTo.setLaneLoadGrpVndrId(getNextSeqId(LGRP_VENDOR_SEQ_NBR));
								LOGGER.debug("Generated Lane LoadGroup Vendor Id : "+laneLoadGroupVendorTo.getLaneLoadGrpVndrId());
								createLaneLoadGroupVendor(laneLoadGroupVendorTo);
								
							}else{
								
								/*
								 * Check for group existence
								 * if not exists populate the SCHN_SHPG_LANE_LOAD_GRP, SCHN_SHLANE_LGRP_VNDR tables
								 */
								LaneLoadGroupTO laneLoadGroupTo = laneTO.getLaneLoadGroupTo();
								int groupId = getLaneGroupId(laneId, laneLoadGroupTo.getLaneLoadGroupName());
								LOGGER.debug("Group id : " +groupId +" for the Lane Id : "+laneId);
								if(groupId == 0){
									
									laneTO.setLaneId(laneId);
									
									//LaneLoadGroupTO laneLoadGroupTo = laneTO.getLaneLoadGroupTo();
									laneLoadGroupTo.setLaneId(laneTO.getLaneId());
									laneLoadGroupTo.setLandLoadGroupId(getNextSeqId(LANE_GRP_SEQ_NBR));
									LOGGER.debug("Generated LoadGroup Id : "+laneLoadGroupTo.getLandLoadGroupId());
									createLaneLoadGroup(laneLoadGroupTo);
									
									LaneLoadGroupVendorTO laneLoadGroupVendorTo = laneLoadGroupTo.getLaneLoadGroupVendorTo();
									laneLoadGroupVendorTo.setLaneLoadGrpId(laneLoadGroupTo.getLandLoadGroupId());
									laneLoadGroupVendorTo.setLaneLoadGrpVndrId(getNextSeqId(LGRP_VENDOR_SEQ_NBR));
									LOGGER.debug("Generated Lane LoadGroup Vendor Id : "+laneLoadGroupVendorTo.getLaneLoadGrpVndrId());
									createLaneLoadGroupVendor(laneLoadGroupVendorTo);
									
								}else{
									
									/*
									 * Check for Vendor group existence
									 * if not exists populate the SCHN_SHLANE_LGRP_VNDR table
									 */
									LaneLoadGroupVendorTO laneLoadGroupVendorTo = laneLoadGroupTo.getLaneLoadGroupVendorTo();
									int vendorGroupId = getLaneLoadGroupVendorId(groupId, laneLoadGroupVendorTo.getMvndrNbr());
									LOGGER.debug("Vendor Group id : " +vendorGroupId +" for the Group Id : "+groupId);
									if(vendorGroupId == 0){
										
										laneTO.setLaneId(laneId);
										//LaneLoadGroupTO laneLoadGroupTo = laneTO.getLaneLoadGroupTo();
										laneLoadGroupTo.setLaneId(laneTO.getLaneId());
										laneLoadGroupTo.setLandLoadGroupId(groupId);
										
										//LaneLoadGroupVendorTO laneLoadGroupVendorTo = laneLoadGroupTo.getLaneLoadGroupVendorTo();
										laneLoadGroupVendorTo.setLaneLoadGrpId(laneLoadGroupTo.getLandLoadGroupId());
										laneLoadGroupVendorTo.setLaneLoadGrpVndrId(getNextSeqId(LGRP_VENDOR_SEQ_NBR));
										LOGGER.debug("Generated Lane LoadGroup Vendor Id : "+laneLoadGroupVendorTo.getLaneLoadGrpVndrId());
										createLaneLoadGroupVendor(laneLoadGroupVendorTo);
									}else{
										/*
										 * There is a record already exist in table for this lane/group/vendor combination
										 * send back to user as error record  
										 */
										laneTO.setErrorString(UploadConstants.RECORD_ALREADY_EXIST);
										inValidLaneTOList.add(laneTO);
									}
								}
								
							}
							
						}
						
						if (LOGGER.isDebugEnabled()) {
							LOGGER.debug(UploadConstants.EXIT_METHOD + "insertRecords");
						}
					}
					return true;
				}
			};
			
		}catch (QueryException qe) {
			throw new EFSException(UploadConstants.EXCEPTION + qe.getMessage(),
					UploadConstants.QUERY_EXCEPTION_CD);
		}
		
		return false;
	}

	/**
	 * Inserts a new Lane Record and returns the LANE ID 
	 * 
	 * @param laneTO
	 * @return
	 * @throws EFSException
	 */
	public static boolean createLane(LaneTO laneTO) throws EFSException{
		try {
			if(laneTO == null){
				throw new QueryException("createLane : laneTO Can not be null");
			}
			
	    	if (LOGGER.isDebugEnabled()) {
	            LOGGER.debug("start createLane");
	        }
	    	
	    	boolean isSuccess = DAO.useJNDI(SupplyChainDistributionNetwork)
	    			            .setSQL(INSERT_EFS_LANE_QUERY, 
	    			            		laneTO.getLaneId(), 
	    			            		laneTO.getCreatedUserId(), 
	    			            		laneTO.getLastUptdUserId(), 
	    			            		laneTO.getOriginLocId(), 
	    			            		laneTO.getDestinationLocId(), 
	    			            		laneTO.getShppingLaneName()!= null?laneTO.getShppingLaneName():null, 
	    			            		laneTO.isActiveFlag()?UploadConstants.YES:UploadConstants.NO)
	    			            		.debug(LOGGER)
	    					    .success();
	    	
	    	if (LOGGER.isDebugEnabled()) {
	            LOGGER.debug("finish createLane");
	            LOGGER.debug("Insert into lane success ? " + isSuccess);
	        }
	    	
			return isSuccess;
		} catch (QueryException qe) {
			throw new EFSException(UploadConstants.EXCEPTION + qe.getMessage(),
					UploadConstants.QUERY_EXCEPTION_CD);
		}
		
	}
	
	/**
	 * Inserts a new record in SCHN_SHPG_LANE_LOAD_GRP
	 * 
	 * @param laneLoadGroupTo
	 * @return
	 * @throws EFSException
	 */
	public static boolean createLaneLoadGroup(LaneLoadGroupTO laneLoadGroupTo) throws EFSException{
		try {
			if(laneLoadGroupTo == null){
				throw new QueryException("createLaneLoadGroup : laneLoadGroupTo Can not be null");
			}
			
	    	if (LOGGER.isDebugEnabled()) {
	            LOGGER.debug("start createLane");
	        }
	    	
	    	boolean isSuccess = DAO.useJNDI(SupplyChainDistributionNetwork)
	    			            .setSQL(INSERT_EFS_LANE_GRP_QUERY, 
	    			            		laneLoadGroupTo.getLandLoadGroupId(), 
	    			            		laneLoadGroupTo.getCreatedUserId(), 
	    			            		laneLoadGroupTo.getLastUptdUserId(), 
	    			            		laneLoadGroupTo.getLaneId(), 
	    			            		laneLoadGroupTo.getEffectiveBeginDate(), 
	    			            		laneLoadGroupTo.getEffectiveEndDate(), 
			            				laneLoadGroupTo.getLaneLoadGroupName())
	    			            		.debug(LOGGER)
	    					    .success();
	    	
	    	if (LOGGER.isDebugEnabled()) {
	            LOGGER.debug("finish createLaneLoadGroup");
	            LOGGER.debug("Insert into lane load group success ? " + isSuccess);
	        }
	    	
			return isSuccess;
		} catch (QueryException qe) {
			throw new EFSException(UploadConstants.EXCEPTION + qe.getMessage(),
					UploadConstants.QUERY_EXCEPTION_CD);
		}
		
	}
	
	/**
	 * Inserts a new record in SCHN_SHLANE_LGRP_VNDR
	 * 
	 * @param laneLoadGroupVendorTO
	 * @return
	 * @throws EFSException
	 */
	public static boolean createLaneLoadGroupVendor(LaneLoadGroupVendorTO laneLoadGroupVendorTO) throws EFSException{
		try {
			if(laneLoadGroupVendorTO == null){
				throw new QueryException("createLaneLoadGroupVendor : laneLoadGroupVendorTO Can not be null");
			}
			
	    	if (LOGGER.isDebugEnabled()) {
	            LOGGER.debug("start createLane");
	        }
	    	
	    	boolean isSuccess = DAO.useJNDI(SupplyChainDistributionNetwork)
	    			            .setSQL(INSERT_EFS_LGRP_VENDOR_QUERY, 
	    			            		laneLoadGroupVendorTO.getLaneLoadGrpVndrId(), 
	    			            		laneLoadGroupVendorTO.getCreatedUserId(), 
	    			            		laneLoadGroupVendorTO.getLastUptdUserId(), 
	    			            		laneLoadGroupVendorTO.getMvndrNbr(),
	    			            		laneLoadGroupVendorTO.getDepartmentNbr(),
	    			            		laneLoadGroupVendorTO.getLaneLoadGrpId(), 
	    			            		laneLoadGroupVendorTO.getEffectiveBeginDate(), 
	    			            		laneLoadGroupVendorTO.getEffectiveEndDate(), 
	    			            		laneLoadGroupVendorTO.getMerchendiseBaseCode()
	    			            		//TODO: Need to enable below line once this column added to the table
	    			            		, laneLoadGroupVendorTO.getPrimaryLocation()
	    			            		)
	    			            		.debug(LOGGER)
	    					    .success();
	    	
	    	if (LOGGER.isDebugEnabled()) {
	            LOGGER.debug("finish createLaneLoadGroupVendor");
	            LOGGER.debug("Insert into lane load group Vendor success ? " + isSuccess);
	        }
	    	
			return isSuccess;
		} catch (QueryException qe) {
			throw new EFSException(UploadConstants.EXCEPTION + qe.getMessage(),
					UploadConstants.QUERY_EXCEPTION_CD);
		}
		
	}
	
	/**
	 * Generates new sequence id based on input sequence query
	 * 
	 * @return integer
	 * @throws EFSException
	 */
	public static int getNextSeqId(String seqQuery) throws EFSException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD + "getNextLocationSeqId");
		}
		List<BigDecimal> seqNbrList = new LinkedList<BigDecimal>();
		List<Integer> seqNbr = new ArrayList<Integer>();
		try {
			
			seqNbrList = DAO.useJNDI(SupplyChainDistributionNetwork)
					.setSQL(seqQuery).list(BigDecimal.class);
			
			for (BigDecimal id : seqNbrList) {
				seqNbr.add(id.intValue());
			}
			
		} catch (QueryException qe) {
			throw new EFSException(UploadConstants.EXCEPTION + qe.getMessage(),
					UploadConstants.QUERY_EXCEPTION_CD);
		}

		return seqNbr.get(0);
	}


}
