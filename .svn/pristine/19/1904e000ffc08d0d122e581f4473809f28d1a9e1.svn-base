package com.homedepot.di.xd.efs.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.homedepot.di.xd.efs.constants.EFSConstants;
import com.homedepot.di.xd.efs.exception.DataOperationException;
import com.homedepot.di.xd.efs.to.ReportTO;
import com.homedepot.ta.aa.dao.Inputs;
import com.homedepot.ta.aa.dao.Query;
import com.homedepot.ta.aa.dao.Results;
import com.homedepot.ta.aa.dao.ResultsReader;
import com.homedepot.ta.aa.dao.builder.DAO;
import com.homedepot.ta.aa.dao.exceptions.PropertyNotFoundException;
import com.homedepot.ta.aa.dao.exceptions.QueryException;

public class ReportDAO {
	
	private static final Logger LOGGER = Logger.getLogger(ReportDAO.class);
	public static final String US_LANG_CODE = "en_US";
	
	private static final String RETRIEVE_ALL_REPORTS_SQL = 
		"SELECT A.SCHN_COLLAB_RPT_CD, B.D_SCHN_COLLAB_RPT_CD, B.SCHN_COLLAB_RPT_DESC " +
		"FROM SCHN_COLLAB_RPT_CD A, " +
		"N_SCHN_COLLAB_RPT B " +
		"WHERE A.SCHN_COLLAB_RPT_CD = B.SCHN_COLLAB_RPT_CD " +
		"AND B.LANG_CD = ?";
	
	private ReportDAO() {}
	
	/**
	 * This method will return all of the existing reports
	 * 
	 * @return a list of ReportTO objects
	 * @throws DataOperationException
	 */
	public static List<ReportTO> getReportCodes() throws DataOperationException {
		
		final List<ReportTO> reportsList = new ArrayList<ReportTO>();
	
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("In the method getReportCodes()");
		}
		
		try {
			DAO.useJNDI(EFSConstants.EMAILER_ORACLE_JNDI_NAME).
					setSQL(RETRIEVE_ALL_REPORTS_SQL, US_LANG_CODE).
					results( new ResultsReader() {
						
						@Override
						public void readResults(Results results, Query query, Inputs inputs)
														throws QueryException {
							while(results.next()){
								reportsList.add(createReportFromResult(results));
							}
						}
					});
			
		} catch (QueryException qe) {
			throw new DataOperationException(qe.getMessage(), qe);
		}
		
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("Finished getReportCodes and retrieved " + reportsList.size() + " reports.");
		}
		return reportsList;
	}
	
	private static ReportTO createReportFromResult(Results results) throws PropertyNotFoundException {
		ReportTO reportTO = new ReportTO();
		
		reportTO.setReportCode(results.getInt("SCHN_COLLAB_RPT_CD"));
		reportTO.setShortDescription(results.getString("D_SCHN_COLLAB_RPT_CD"));
		reportTO.setDescription(results.getString("SCHN_COLLAB_RPT_DESC"));
		
		return reportTO;
	}

}
