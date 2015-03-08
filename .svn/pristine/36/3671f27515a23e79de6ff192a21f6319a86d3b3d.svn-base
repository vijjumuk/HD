package com.homedepot.di.xd.efs.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.ScheduleOrderDayTO;
import com.homedepot.di.xd.efs.to.ScheduleTO;
import com.homedepot.ta.aa.dao.builder.DAO;
import com.homedepot.ta.aa.dao.builder.UnitOfWork;
import com.homedepot.ta.aa.dao.exceptions.QueryException;

public class ScheduleUploadDAO {

	private static final Logger LOGGER = Logger.getLogger(ScheduleUploadDAO.class);
	
	// Data source constant
	private static final String SupplyChainDistributionNetwork = "java:comp/env/jdbc/SupplyChainDistributionNetwork.1";
	
	// SQL Query Constants
	private static final String SELECT_SCHN_EFS_SCH_TYP_CD_QUERY = "SELECT SCHN_EFS_SCH_TYP_CD FROM SCHN_EFS_SCH_TYP_CD "
			+ " WHERE 1=1 ";
			//AND SCHN_EFS_SCH_TYP_CD IN ( ?, ?)";
	
	private static final String SELECT_SCHN_EFS_SCH_GRP_QUERY = "SELECT SCHN_EFS_SCH_GRP_ID FROM SCHN_EFS_SCH_GRP "
			+ " WHERE 1=1 "; 
			//AND SCHN_EFS_SCH_TYP_CD IN ( ?, ?)";
	
	private static final String SELECT_LOC_HOURS = "SELECT XREF.SRC_LOC_ID, HRS.START_TM, HRS.END_TM FROM "
			+ " SCHN_EFS_LOC_XREF XREF " 
			+ " INNER JOIN SCHN_EFS_LOC LOC "
			+ " ON XREF.SCHN_LOC_ID = LOC.SCHN_LOC_ID "
			+ " INNER JOIN SCHN_EFS_LOC_OPS_HRS HRS "
			+ " ON HRS.SCHN_LOC_ID = LOC.SCHN_LOC_ID "
			+ " WHERE 1=1 ";
			//+ " XREF.SRC_LOC_ID IN (?)"; //9100	

	private static final String SCHEDULE_SEQ_NBR =	"SELECT SCHN_EFS_SCH_SEQ.NEXTVAL AS SCHN_EFS_SCH_SEQ FROM DUAL";
	
	private static final String INSERT_SCHN_EFS_SCH_QUERY = "INSERT INTO SCHN_EFS_SCH " 
            + " (SCHN_EFS_SCH_ID, " 
            + " CRT_SYSUSR_ID, " 
            + " CRT_TS, " 
            + " LAST_UPD_SYSUSR_ID, " 
            + " LAST_UPD_TS, " 
            + " EFF_BGN_DT, " 
            + " EFF_END_DT, " 
            + " SCHN_EFS_SCH_NM, " 
            + " SCHN_EFS_SCH_GRP_ID) " 
            + " VALUES (?,?,CURRENT_TIMESTAMP,?,CURRENT_TIMESTAMP,?,?,?,?)";
	
	private static final String INSERT_SCHN_EFS_SCH_ORD_DAY_QUERY = "INSERT INTO SCHN_EFS_SCH "
			 + "(SCHN_EFS_SCH_ID , "
			 + "PO_WK_DAY_NBR , "
			 + "CRT_SYSUSR_ID , "
			 + "CRT_TS , "
			 + "LAST_UPD_SYSUSR_ID , "
			 + "LAST_UPD_TS , "
			 + "TNDR_DAY_OF_WK_CD , "
			 + "TNDR_RLTV_WK_NBR , "
			 + "VNDR_TRN_TM_HRS , "
			 + "SHP_BGN_DAY_OF_WK_CD , "
			 + "SHP_BGN_RLTV_WK_NBR , "
			 + "SHP_END_DAY_OF_WK_CD , "
			 + "SHP_END_RLTV_WK_NBR , "
			 + "ORIG_LOC_SHP_BGN_TM , "
			 + "ORIG_LOC_SHP_END_TM , "
			 + "EXPCTD_CARR_DPRT_TM , "
			 + "EXPCTD_SHP_TRST_TM_HRS , "
			 + "ARVL_BGN_DAY_OF_WK_CD , "
			 + "ARVL_BGN_RLTV_WK_NBR , "
			 + "ARVL_END_DAY_OF_WK_CD , "
			 + "ARVL_END_RLTV_WK_NBR , "
			 + "EXPCTD_CARR_ARVL_BGN_TM , "
			 + "EXPCTD_CARR_ARVL_END_TM , "
			 + "DC_BGN_SHP_WRK_DAY_OF_WK_CD , "
			 + "DC_BGN_SHP_WRK_RLTV_WK_NBR, "
			 + "DC_END_SHP_WRK_DAY_OF_WK_CD , "
			 + "DC_END_SHP_WRK_RLTV_WK_NBR, "
			 + "DC_BGN_WRK_SHFT_SEQ_NBR , "
			 + "DC_END_WRK_SHFT_SEQ_NBR , "
			 + "DC_SHP_WRK_SHFT_CNT , "
			 + "DC_SHP_WRK_HRS ) "
			 + "VALUES (?,?,?,CURRENT_TIMESTAMP,?,CURRENT_TIMESTAMP,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
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
	
	/**
	 * Inserts a new Schedule Record
	 * 
	 * @param laneTO
	 * @return
	 * @throws EFSException
	 */
	public static boolean createSchedule(ScheduleTO scheduleTO) throws EFSException{
		try {
			if(scheduleTO == null){
				throw new QueryException("createSchedule : scheduleTO Can not be null");
			}
			
	    	if (LOGGER.isDebugEnabled()) {
	            LOGGER.debug("start createSchedule");
	        }
	    	
	    	boolean isSuccess = DAO.useJNDI(SupplyChainDistributionNetwork)
	    			            .setSQL(INSERT_SCHN_EFS_SCH_QUERY, 
	    			            		scheduleTO.getScheduleId(),
	    			            		scheduleTO.getCreatedUserId(),
	    			            		scheduleTO.getLastUptdUserId(),
	    			            		scheduleTO.getEffectiveBeginDate(),
	    			            		scheduleTO.getEffectiveEndDate(),
	    			            		scheduleTO.getScheduleName(),
	    			            		scheduleTO.getScheduleGroupCode())
	    			            		.debug(LOGGER)
	    					    .success();
	    	
	    	if (LOGGER.isDebugEnabled()) {
	            LOGGER.debug("finish createSchedule");
	            LOGGER.debug("Insert into Schedule success ? " + isSuccess);
	        }
	    	
			return isSuccess;
		} catch (QueryException qe) {
			throw new EFSException(UploadConstants.EXCEPTION + qe.getMessage(),
					UploadConstants.QUERY_EXCEPTION_CD);
		}
		
	}
	
	/**
	 * Inserts a Schedule Order day record
	 * 
	 * @param orderDayTo
	 * @return
	 * @throws EFSException
	 */
	public static boolean createScheduleOrderDay(ScheduleOrderDayTO orderDayTo) throws EFSException{
		
		
		
		return false;
	}
	
	
public static boolean insertRecords(final List<ScheduleTO> schToList, List<ScheduleTO> inValidList) throws EFSException {
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD + "insertRecords");
		}
		
		try{
			new UnitOfWork<Boolean>() {
				@Override
				public Boolean runQueries() throws Exception {
					
					for(ScheduleTO schTO:schToList)
					{
						int typCode=getscheduleTypeCode(schTO.getScheduleTypeCode());
						if(typCode>0)
						{
							int grpCode=getscheduleGroupId(schTO.getScheduleGroupCode());

							if(grpCode>0)
							{
								
			            		schTO.setScheduleId(getNextSeqId(SCHEDULE_SEQ_NBR));
								ScheduleUploadDAO.createSchedule(schTO);
								Map<Short, ScheduleOrderDayTO> orderDayToMap = new HashMap<Short, ScheduleOrderDayTO>(schTO.getScheduleOrderDayTO());
								
								
							}
							else
							{
								throw new EFSException(UploadConstants.SCHEDULED_GRP_CD_EXCEPTION);	
							}
						}
						else
						{
							throw new EFSException(UploadConstants.SCHEDULED_TYPE_CD_EXCEPTION);
						}

					}
					return value;
				}
			};
		}catch (QueryException qe) {
			throw new EFSException(UploadConstants.EXCEPTION + qe.getMessage(),
					UploadConstants.QUERY_EXCEPTION_CD);
		}
		return false;
	}

	

public static int getscheduleTypeCode(int  schEfsTypeCode) throws EFSException{
	try{
		
		Integer typeCode = DAO.useJNDI(SupplyChainDistributionNetwork)
				            .setSQL(SELECT_SCHN_EFS_SCH_TYP_CD_QUERY, 
				            		schEfsTypeCode
				            		)
				            		.debug(true)
									.get(Integer.class);
		if(typeCode !=null){
			return typeCode;
		}
	}catch(QueryException qe){
		throw new EFSException(UploadConstants.EXCEPTION + qe.getMessage(),
				UploadConstants.QUERY_EXCEPTION_CD);
	}
	return 0;		
}

public static int getscheduleGroupId(int  schEfsGrpId) throws EFSException{
	try{
		
		Integer typeCode = DAO.useJNDI(SupplyChainDistributionNetwork)
				            .setSQL(SELECT_SCHN_EFS_SCH_GRP_QUERY, 
				            		schEfsGrpId
				            		)
				            		.debug(true)
									.get(Integer.class);
		if(typeCode !=null){
			return typeCode;
		}
	}catch(QueryException qe){
		throw new EFSException(UploadConstants.EXCEPTION + qe.getMessage(),
				UploadConstants.QUERY_EXCEPTION_CD);
	}
	return 0;		
}

}
