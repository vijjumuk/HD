package com.homedepot.di.xd.efs.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.homedepot.di.xd.efs.constants.EFSConstants;
import com.homedepot.di.xd.efs.exception.DataOperationException;
import com.homedepot.di.xd.efs.to.ReportTypeTO;
import com.homedepot.ta.aa.dao.Inputs;
import com.homedepot.ta.aa.dao.Query;
import com.homedepot.ta.aa.dao.Results;
import com.homedepot.ta.aa.dao.ResultsReader;
import com.homedepot.ta.aa.dao.builder.DAO;
import com.homedepot.ta.aa.dao.exceptions.PropertyNotFoundException;
import com.homedepot.ta.aa.dao.exceptions.QueryException;

public class ReportTypeDAO {

	private static final Logger LOGGER = Logger.getLogger(ReportTypeDAO.class);
	public static final String US_LANG_CODE = "en_US";
	
	private static final String RETRIEVE_ALL_REPORT_TYPES_SQL = 
			"SELECT A.SCHN_COLLAB_RPT_TYP_CD, B.S_TYP_DESC, B.TYP_DESC " +
			"FROM SCHN_COLLAB_RPT_TYP_CD A, " +
			"N_SCHN_COLLAB_RPT_TYP B " +
			"WHERE A.SCHN_COLLAB_RPT_TYP_CD = B.SCHN_COLLAB_RPT_TYP_CD " +
			"AND B.LANG_CD = ?";
	
	private ReportTypeDAO(){}
	
	/**
	 * This method will return all of the report type codes.
	 * 
	 * @return list of ReporTypeTO objects
	 * @throws DataOperationException if a database error occurs.
	 */
	public static List<ReportTypeTO> getReportTypeCodes() throws DataOperationException {
		
		final List<ReportTypeTO> reportTypesList = new ArrayList<ReportTypeTO>();
		
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("In the method getReportTypeCodes()");
		}
		
		try {
			
			DAO.useJNDI(EFSConstants.EMAILER_ORACLE_JNDI_NAME).
					setSQL(RETRIEVE_ALL_REPORT_TYPES_SQL, US_LANG_CODE).
					results( new ResultsReader() {
						
						@Override
						public void readResults(Results results, Query query, Inputs inputs)
														throws QueryException {
							while(results.next()){
								reportTypesList.add(createReportTypeFromResult(results));
							}
						}
					});
			
		} catch (QueryException qe) {
			throw new DataOperationException(qe.getMessage(), qe);
		}
		
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("Finished getReportTypeCodes and retrieved " + reportTypesList.size() + " report types.");
		}
		
		return reportTypesList;
	}

	/**
	 * This method will create a ReportTypeTO object from a DAO Results object.
	 * 
	 * @param results
	 * @throws PropertyNotFoundException 
	 */
	private static ReportTypeTO createReportTypeFromResult(Results results) throws PropertyNotFoundException {
		ReportTypeTO reportTypeTO = new ReportTypeTO();
		
		reportTypeTO.setReportTypeCode(results.getInt("SCHN_COLLAB_RPT_TYP_CD"));
		reportTypeTO.setShortDescription(results.getString("S_TYP_DESC"));
		reportTypeTO.setDescription(results.getString("TYP_DESC"));
		
		return reportTypeTO;
	}

}
