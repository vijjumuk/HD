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
import com.homedepot.di.xd.efs.to.LocationTO;
import com.homedepot.ta.aa.dao.Inputs;
import com.homedepot.ta.aa.dao.Query;
import com.homedepot.ta.aa.dao.Results;
import com.homedepot.ta.aa.dao.ResultsReader;
import com.homedepot.ta.aa.dao.builder.BatchData;
import com.homedepot.ta.aa.dao.builder.DAO;
import com.homedepot.ta.aa.dao.builder.UnitOfWork;
import com.homedepot.ta.aa.dao.exceptions.QueryException;

public class LocationUploadDAO {

	private static final Logger LOGGER = Logger
			.getLogger(LocationUploadDAO.class);

	// Data source constant
	private static final String SupplyChainDistributionNetwork = "java:comp/env/jdbc/SupplyChainDistributionNetwork.1";

	// Location Column count
	private static final int EFS_LOC_CLOUMN = 17;
	private static final int EFS_LOC_XREF_CLOUMN = 5;
	private static final int LOC_UPDATE_COLUMN_COUNT = 16;

	// SQL Query Constants

	/**
	 * Insert query - Location table (SCHN_EFS_LOC)
	 */
	private static final String INSERT_EFS_LOC_QUERY = "INSERT INTO SCHN_EFS_LOC "
			+ " (SCHN_LOC_ID, "
			+ " CRT_SYSUSR_ID, "
			+ " CRT_TS, "
			+ " LAST_UPD_SYSUSR_ID, "
			+ " LAST_UPD_TS, "
			+ " ADDR_LINE1_TXT, "
			+ " ADDR_LINE2_TXT, "
			+ " ADDR_LINE3_TXT, "
			+ " ADDR_LINE4_TXT, "
			+ " ADDR_LINE5_TXT, "
			+ " CITY_NM, "
			+ " ST_CD, "
			+ " PSTL_CD, "
			+ " CNTRY_CD, "
			+ " LAT_NBR, "
			+ " LNG_NBR, "
			+ "SCHN_EFS_LOC_TYP_CD, "
			+ " SCHN_EFS_LOC_NM, "
			+ " ACTV_FLG) "
			+ " VALUES (?,?,CURRENT_TIMESTAMP,?,CURRENT_TIMESTAMP,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	/**
	 * Select query for sequence object for Location id (SCHN_EFS_LOC_SEQ).
	 */
	private static final String LOCATION_SEQ_NBR = "SELECT SCHN_EFS_LOC_SEQ.NEXTVAL FROM DUAL";

	/**
	 * Insert query - Location XREF table (SCHN_EFS_LOC_XREF).
	 */
	private static final String INSERT_EFS_LOC_XREF_QUERY = "INSERT INTO SCHN_EFS_LOC_XREF "
			+ " (SCHN_LOC_ID, "
			+ " SCHN_EFS_LOC_SRC_SYS_CD, "
			+ " CRT_SYSUSR_ID, "
			+ " CRT_TS, "
			+ " LAST_UPD_SYSUSR_ID, "
			+ " LAST_UPD_TS, "
			+ " SRC_LOC_ID) "
			+ " VALUES (?, ?, ?, CURRENT_TIMESTAMP, ?, CURRENT_TIMESTAMP, ?)";

	private static final String SELECT_EFS_LOC_QUERY = "SELECT LOC.schn_loc_id as SCHN_LOC_ID, "
			+ "LOC.crt_sysusr_id as CRT_SYSUSR_ID, "
			+ "LOC.crt_ts as CRT_TS, "
			+ "LOC.last_upd_sysusr_id as LAST_UPD_SYSUSR_ID, "
			+ "LOC.last_upd_ts as LAST_UPD_TS, "
			+ "LOC.addr_line1_txt as ADDR_LINE1_TXT, "
			+ "LOC.addr_line2_txt as ADDR_LINE2_TXT, "
			+ "LOC.addr_line3_txt as ADDR_LINE3_TXT, "
			+ "LOC.addr_line4_txt as ADDR_LINE4_TXT, "
			+ "LOC.addr_line5_txt as ADDR_LINE5_TXT, "
			+ "LOC.city_nm as CITY_NM, "
			+ "LOC.st_cd as ST_CD, "
			+ "LOC.pstl_cd as PSTL_CD, "
			+ "LOC.cntry_cd as CNTRY_CD, "
			+ "LOC.lat_nbr as LAT_NBR, "
			+ " LOC.lng_nbr as LNG_NBR, "
			+ "LOC.schn_efs_loc_typ_cd as SCHN_EFS_LOC_TYP_CD, "
			+ "LOC.schn_efs_loc_nm as SCHN_EFS_LOC_NM, "
			+ "LOC.actv_flg as ACTV_FLG, "
			+ "XREF.src_loc_id as SRC_LOC_ID "
			+ "FROM schn_efs_loc LOC "
			+ "LEFT OUTER JOIN schn_efs_loc_xref XREF "
			+ "ON LOC.schn_loc_id = XREF.schn_loc_id ";

	private static final String UPDATE_LOC_DETAILS = "UPDATE SCHN_EFS_LOC "
			+ "SET LAST_UPD_SYSUSR_ID = ?, "
			+ "LAST_UPD_TS = CURRENT_TIMESTAMP,"
			+ "ADDR_LINE1_TXT = ?, "
			+ "ADDR_LINE2_TXT = ?, " 
			+ "ADDR_LINE3_TXT = ?, "
			+ "ADDR_LINE4_TXT = ?, " 
			+ "ADDR_LINE5_TXT = ?, " 
			+ "CITY_NM = ?, "
			+ "ST_CD = ?, " 
			+ "PSTL_CD = ?, " 
			+ "CNTRY_CD = ?, "
			+ "LAT_NBR = ?, " 
			+ "LNG_NBR = ?, " 
			+ "SCHN_EFS_LOC_TYP_CD = ?, "
			+ "SCHN_EFS_LOC_NM = ?, "
			+ "ACTV_FLG = ? "
			+ "WHERE SCHN_LOC_ID = ?";

	/**
	 * To insert data to Location and location XREF tables.
	 * 
	 * @param locationList
	 * @return boolean
	 * @throws EFSException
	 */
	public static boolean createLocationDetails(
			final List<LocationTO> locationList) throws EFSException {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD
					+ "insertLocationDetails");
		}
		try {
			new UnitOfWork<Boolean>() {

				@Override
				public Boolean runQueries() throws Exception {
					// get next sequence number for each valid record 
					//And insert into location table 
					insertLocationDetails(locationList);
					
					// insert location number into Location XREF table for the corresponding location ID 
					insertLocationReferenceDetails(locationList);
					return true;
				}
			};
		} catch (QueryException qe) {
			throw new EFSException(UploadConstants.EXCEPTION + qe.getMessage(),
					UploadConstants.QUERY_EXCEPTION_CD);
		}
		return true;
	}

	/**
	 * Insert data into Location table.
	 * get next sequence number for each valid record
	 * 
	 * @param locationList
	 * @return boolean
	 * @throws QueryException
	 * @throws EFSException
	 */
	public static boolean insertLocationDetails(List<LocationTO> locationList)
			throws QueryException, EFSException {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD
					+ "insertLocationDetails");
		}

		BatchData locationData = new BatchData(EFS_LOC_CLOUMN);
		int rowsInserted;
		int seqNbr;
		if (locationList != null && locationList.size() > 0) {
			int row = 0;
			for (LocationTO locationTO : locationList) {
				seqNbr = getNextLocationSeqId();
				locationData.add(row, 0, seqNbr);
				locationData.add(row, 1, locationTO.getCreateUserId());
				locationData.add(row, 2, locationTO.getLastUpdatedUserId());
				locationData.add(
						row,
						3,
						locationTO.getAddressLine1() != null ? locationTO
								.getAddressLine1() : null);
				locationData.add(
						row,
						4,
						locationTO.getAddressLine2() != null ? locationTO
								.getAddressLine2() : null);
				locationData.add(
						row,
						5,
						locationTO.getAddressLine3() != null ? locationTO
								.getAddressLine3() : null);
				locationData.add(
						row,
						6,
						locationTO.getAddressLine4() != null ? locationTO
								.getAddressLine4() : null);
				locationData.add(
						row,
						7,
						locationTO.getAddressLine5() != null ? locationTO
								.getAddressLine5() : null);
				locationData.add(
						row,
						8,
						locationTO.getCityName() != null ? locationTO
								.getCityName() : null);
				locationData.add(
						row,
						9,
						locationTO.getStateCode() != null ? locationTO
								.getStateCode() : null);
				locationData.add(
						row,
						10,
						locationTO.getPostalCode() != null ? locationTO
								.getPostalCode() : null);
				locationData.add(
						row,
						11,
						locationTO.getCountryCode() != null ? locationTO
								.getCountryCode() : null);
				locationData.add(
						row,
						12,
						locationTO.getLatitude() != null ? Double
								.parseDouble(locationTO.getLatitude()) : null);
				locationData.add(
						row,
						13,
						locationTO.getLongitude() != null ? Double
								.parseDouble(locationTO.getLongitude()) : null);
				locationData.add(row, 14,
						Integer.parseInt(locationTO.getLocationTypeCd()));
				locationData.add(row, 15, locationTO.getLocationName());
				locationData.add(row, 16, locationTO.getActiveFlg());
				locationTO.setLocationId(seqNbr);
				row++;
			}

			rowsInserted = DAO.useJNDI(SupplyChainDistributionNetwork)
					.setSQL(INSERT_EFS_LOC_QUERY).batch(locationData).length;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(UploadConstants.EXIT_METHOD
						+ "Inseerted Records count" + rowsInserted);
			}
			if (rowsInserted == locationList.size()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * To get the sequence number for Location ID.
	 * 
	 * @return integer- sequence next value
	 * @throws EFSException
	 */
	public static int getNextLocationSeqId() throws EFSException {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD
					+ "getNextLocationSeqId");
		}
		List<BigDecimal> seqNbrList = new LinkedList<BigDecimal>();
		List<Integer> seqNbr = new ArrayList<Integer>();
		try {
			seqNbrList = DAO.useJNDI(SupplyChainDistributionNetwork)
					.setSQL(LOCATION_SEQ_NBR).list(BigDecimal.class);
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
	 * Insert Location details in XREF table.
	 * 
	 * @param locationList
	 * @return boolean
	 * @throws QueryException
	 */
	public static boolean insertLocationReferenceDetails(
			List<LocationTO> locationList) throws QueryException {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD
					+ "insertLocationReferenceDetails");
		}

		BatchData locationReferenceData = new BatchData(EFS_LOC_XREF_CLOUMN);
		if (locationList != null && locationList.size() > 0) {
			int row = 0;
			int rowsInserted;
			for (LocationTO locationTO : locationList) {
				locationReferenceData.add(row, 0, locationTO.getLocationId());
				locationReferenceData.add(row, 1,
						UploadConstants.SCHN_EFS_LOC_SRC_SYS_CD);
				locationReferenceData.add(row, 2, locationTO.getCreateUserId());
				locationReferenceData.add(row, 3,
						locationTO.getLastUpdatedUserId());
				locationReferenceData.add(row, 4,
						locationTO.getSourceLocationNbr());
				row++;
			}
			rowsInserted = DAO.useJNDI(SupplyChainDistributionNetwork)
					.setSQL(INSERT_EFS_LOC_XREF_QUERY)
					.batch(locationReferenceData).length;
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(UploadConstants.EXIT_METHOD
						+ "insertLocationReferenceDetails reocrds inserted"
						+ rowsInserted);
			}
			if (locationList.size() == rowsInserted) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Read all the existing records from Location & Location XREF table
	 * 
	 * @return
	 * @throws EFSException
	 */
	public static Map<String, Integer> readLocationDetailsForUpdate()
			throws EFSException {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD
					+ "readLocationDetailsForUpdate");
		}

		final Map<String, Integer> locationAndXrefDetailsMap = new HashMap<String, Integer>();
		try {

			DAO.useJNDI(SupplyChainDistributionNetwork)
					.setSQL(SELECT_EFS_LOC_QUERY).debug(LOGGER)
					.results(new ResultsReader() {

						@Override
						public void readResults(Results results, Query query,
								Inputs inputs) throws QueryException {

							StringBuilder key = new StringBuilder();

							while (results.next()) {

								if (results.getString("SRC_LOC_ID") != null) {

									key.append(
											results.getString("SCHN_EFS_LOC_TYP_CD"))
											.append('-')
											.append(results
													.getString("SRC_LOC_ID"));

									locationAndXrefDetailsMap.put(
											key.toString(),
											results.getInt("SCHN_LOC_ID"));
									key.setLength(0);

								}

							}
						}
					});

		} catch (QueryException qe) {
			throw new EFSException(UploadConstants.EXCEPTION + qe.getMessage(),
					UploadConstants.QUERY_EXCEPTION_CD);
		}

		return locationAndXrefDetailsMap;
	}

	/**
	 * Update table with new updated data 
	 * 
	 * @param locationList
	 * @return boolean 
	 * @throws EFSException
	 */
	public static boolean updateLocationDetails(List<LocationTO> locationList)
			throws EFSException {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD
					+ "updateLocationDetails");
		}

		try {
			return DAO.useJNDI(SupplyChainDistributionNetwork)
					.setSQL(UPDATE_LOC_DETAILS).debug(LOGGER)
					.batch(populateUpdateDetails(locationList)) != null;
		} catch (QueryException e) {
			throw new EFSException(UploadConstants.EXCEPTION + e.getMessage(),
					UploadConstants.QUERY_EXCEPTION_CD);
		}
	}

	
	/**
	 * set all the input values into location List
	 * 
	 * @param locationList
	 * @return Batch Data
	 */
	private static BatchData populateUpdateDetails(List<LocationTO> locationList) {

		BatchData locationData = new BatchData(LOC_UPDATE_COLUMN_COUNT);
		int row = 0;

		for (LocationTO locationTO : locationList) {

			locationData.add(row, 0, locationTO.getLastUpdatedUserId());
			locationData.add(
					row,
					1,
					locationTO.getAddressLine1() != null ? locationTO
							.getAddressLine1() : null);
			locationData.add(
					row,
					2,
					locationTO.getAddressLine2() != null ? locationTO
							.getAddressLine2() : null);
			locationData.add(
					row,
					3,
					locationTO.getAddressLine3() != null ? locationTO
							.getAddressLine3() : null);
			locationData.add(
					row,
					4,
					locationTO.getAddressLine4() != null ? locationTO
							.getAddressLine4() : null);
			locationData.add(
					row,
					5,
					locationTO.getAddressLine5() != null ? locationTO
							.getAddressLine5() : null);
			locationData.add(row, 6,
					locationTO.getCityName() != null ? locationTO.getCityName()
							: null);
			locationData.add(
					row,
					7,
					locationTO.getStateCode() != null ? locationTO
							.getStateCode() : null);
			locationData.add(
					row,
					8,
					locationTO.getPostalCode() != null ? locationTO
							.getPostalCode() : null);
			locationData.add(
					row,
					9,
					locationTO.getCountryCode() != null ? locationTO
							.getCountryCode() : null);
			locationData.add(row, 10,
					locationTO.getLatitude() != null ? Double
							.parseDouble(locationTO.getLatitude()) : null);
			locationData.add(row, 11,
					locationTO.getLongitude() != null ? Double
							.parseDouble(locationTO.getLongitude()) : null);
			locationData.add(row, 12,
					Integer.parseInt(locationTO.getLocationTypeCd()));
			locationData.add(row, 13, locationTO.getLocationName());
			locationData.add(row, 14, locationTO.getActiveFlg());
			locationData.add(row, 15, locationTO.getLocationId());
			row++;
		}
		return locationData;
	}

}
