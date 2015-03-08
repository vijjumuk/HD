package com.homedepot.di.xd.efs.businesshelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.csvreader.CsvReader;
import com.homedepot.di.xd.efs.constants.EFSConstants;
import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.dao.LocationUploadDAO;
import com.homedepot.di.xd.efs.exception.EFSException;
import com.homedepot.di.xd.efs.to.InputFileTO;
import com.homedepot.di.xd.efs.to.LocationTO;
import com.homedepot.di.xd.efs.to.ResponseTO;
import com.homedepot.di.xd.efs.util.EFSUtil;
import com.homedepot.di.xd.efs.util.ValidationUtil;

public class LocationUploadProcessor implements IUploadProcessor {

	private static final Logger LOGGER = Logger
			.getLogger(LocationUploadProcessor.class);
	
	@Override
	public void processFile(InputFileTO fileObj, ResponseTO responseTO)
			throws IOException, EFSException {
		processDataForLocation(fileObj, responseTO);
	}

	/**
	 * Read each record from uploaded file and validate all the input values 
	 * valid records will be inserted/updated , error out invalid records 
	 * @param fileObj
	 * @param responseTo
	 * @throws EFSException
	 */
	public void processDataForLocation(InputFileTO fileObj,
			ResponseTO responseTo) throws EFSException {
		
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug(UploadConstants.ENTERING_METHOD + "processDataForLocation" );
		}
		

		try {
			// Read the CSV file.
			final CsvReader reader = new CsvReader(new BufferedReader(
					new InputStreamReader(null, "UTF-8")));

			// to store error String.
			StringBuilder errString = null;

			// Key to find duplicate records.
			List<String> key = new ArrayList<String>();

			// Skip header record.
			reader.skipRecord();

			int rowNumber = 1;

			// List to store valid Location data
			List<LocationTO> validLocationDetailsList = new ArrayList<LocationTO>();

			// List to store invalid Location data.
			List<LocationTO> inValidLocationDetailsList = new ArrayList<LocationTO>();

			Map<String, Integer> locationAndXrefDetailsMap = new HashMap<String, Integer>();
			
			List<LocationTO> updateLocationDetailsList = new ArrayList<LocationTO>();

			// Read each record in the file and validate
			while (reader.readRecord()) {

				// Contains row values for all columns.
				String row[] = reader.getValues();

				rowNumber++;

				// If the row is empty continue to next record.
				if (ValidationUtil.isRowEmpty(row)) {
					continue;
				}

				LocationTO locationTO = new LocationTO();

				// to store error messages.
				errString = new StringBuilder();

				// Set row number, create and update user id.
				locationTO.setRowNumber(rowNumber);
				locationTO.setCreateUserId(fileObj.getUserId());
				locationTO.setLastUpdatedUserId(fileObj.getUserId());

				// Validate Location, Address and city details.
				validateLocationDetail(row, errString, locationTO);
				validateAddressLines(row, errString, locationTO);
				validateCityDetails(row, errString, locationTO);

				// Set the active flag, default to Y.
				if (ValidationUtil.isEmpty(row[UploadConstants.FIFTEEN].trim())) {
					locationTO.setActiveFlg(UploadConstants.YES);
				}
				else if (ValidationUtil.isFlagValid(row[UploadConstants.FIFTEEN]
						.trim())) {
					locationTO
							.setActiveFlg(row[UploadConstants.FIFTEEN].trim().toUpperCase());
				} else {
					errString.append(UploadConstants.INVALID_ACTIVE_FLG);
				}

				// check for duplicate rows - if multiple rows with same
				// location Number
				if (errString == null || errString.toString().isEmpty()) {
					if (key.contains(locationTO.getSourceLocationNbr())) {
						locationTO.setError(rowNumber + "-"
								+ UploadConstants.DUPLICATE_RECORD);
						inValidLocationDetailsList.add(locationTO);
					} else {
						key.add(locationTO.getSourceLocationNbr());
						validLocationDetailsList.add(locationTO);
					}

				} else {
					locationTO.setError(rowNumber + "-" + errString.toString());
					inValidLocationDetailsList.add(locationTO);
				}
			}

			/**
			 * Read all the existing records from location table 
			 * valid records will be validated against existing data for update & insert   
			 */
			if(!EFSUtil.isEmpty(validLocationDetailsList)){
				
				locationAndXrefDetailsMap = LocationUploadDAO
						.readLocationDetailsForUpdate();
			
				// separate insert records & update records
				updateLocationDetailsList = getInsertAndUpdateLocationDetails(
						locationAndXrefDetailsMap, validLocationDetailsList);
				
				// insert records into location table & location XREF table in single transaction
				LocationUploadDAO
						.createLocationDetails(validLocationDetailsList);
			}
			
			// update existing table with new updated values 
			if(!EFSUtil.isEmpty(updateLocationDetailsList)){
				
				LocationUploadDAO.updateLocationDetails(updateLocationDetailsList);
			}
			// If any invalid list set Return message
			/*if (EFSUtil.isEmpty(inValidLocationDetailsList)) {
				responseTo.setReturnMessage((validLocationDetailsList.size()+updateLocationDetailsList.size())
						+ " records processed successfully.");
			} else {
				responseTo.setReturnMessage(validLocationDetailsList.size()
						+ " in " + (rowNumber - 1)
						+ " records processed successfully.");
			}*/
			
			responseTo
					.setReturnMessage("No of Records Processed is "
							+ (validLocationDetailsList.size() + updateLocationDetailsList
									.size())
							+ " and No of Records errored out is "
							+ inValidLocationDetailsList.size());
			
			if (LOGGER.isDebugEnabled()){
				LOGGER.debug(UploadConstants.EXIT_METHOD + "processDataForLocation" );
			}
			/*responseTo
					.setResults((ArrayList<LocationTO>) inValidLocationDetailsList);*/

		} catch (IOException io) {
			throw new EFSException(UploadConstants.EXCEPTION + io.getMessage());
		} catch (EFSException efs) {
			throw new EFSException(UploadConstants.EXCEPTION
					+ efs.getErrorMsg());
		}
	}

	/**
	 * Validate location based on location type.
	 * 
	 * @param row
	 * @param errString
	 * @param locationTO
	 */
	public void validateLocationDetail(String row[], StringBuilder errString,
			LocationTO locationTO) {

		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD + "validateLocationDetail");
		}
		/**
		 * Based on location Type code, validates the location. For Origin -
		 * location type codes are 9, 10, 11, 12 For DC - Location type codes
		 * are 2 and 13
		 */
		locationTO.setLocationTypeCd((row[UploadConstants.FOURTEEN].trim()));
		if (!(ValidationUtil.isLocationTypeCd(row[UploadConstants.FOURTEEN]
				.trim()))) {
			errString.append(UploadConstants.INVALID_LOCATION_TYP_CD);
			errString.append(',');
		} else if (Arrays.asList(UploadConstants.getOriginTypeCodes()).contains(
				row[UploadConstants.FOURTEEN].trim())) {
			locationTO.setSourceLocationNbr(row[UploadConstants.FIRST].trim());
			if (!(ValidationUtil.isOriginValid(row[UploadConstants.FIRST]
					.trim()))) {

				errString.append(UploadConstants.INVALID_LOCATION);
				errString.append(',');
			}
		} else if (Arrays.asList(UploadConstants.getDestinationTypeCodes()).contains(
				row[UploadConstants.FOURTEEN].trim())) {
			locationTO.setSourceLocationNbr(row[UploadConstants.FIRST].trim());
			if (!(ValidationUtil.isDestinationValid(row[UploadConstants.FIRST]
					.trim()))) {

				errString.append(UploadConstants.INVALID_LOCATION);
				errString.append(',');
			}
		} else {
			locationTO.setSourceLocationNbr(row[UploadConstants.FIRST].trim());
			errString.append(UploadConstants.INVALID_LOCATION_TYP_CD);
			errString.append(',');
			errString.append(UploadConstants.INVALID_LOCATION);
			errString.append(',');
		}

		/*
		 * Validate Location Name No Special characters. Cannot be null.
		 */
		locationTO.setLocationName(row[UploadConstants.SECOND].trim());
		if (!(ValidationUtil.isLocationNameValid(row[UploadConstants.SECOND]
				.trim()))) {
			errString.append(UploadConstants.INVALID_LOCATION_NAME);
			errString.append(',');
		}
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.EXIT_METHOD + "validateLocationDetail");
		}
	}

	/**
	 * Validates Address Columns in Location upload.
	 * 
	 * @param row
	 * @param errString
	 * @param locationTO
	 */
	public void validateAddressLines(String row[], StringBuilder errString,
			LocationTO locationTO) {
		
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD + "validateAddressLines");
		}
		/**
		 * Validation for all Address columns, can be null.
		 */
		locationTO.setAddressLine1(ValidationUtil.changeEmptyToNull(row[UploadConstants.THIRD].trim()));
		if (!(ValidationUtil.isAddressLineValid(locationTO.getAddressLine1()))) {

			errString.append(UploadConstants.INVALID_ADDRESS_LINE_1);
			errString.append(',');
		}

		locationTO.setAddressLine2(ValidationUtil.changeEmptyToNull(row[UploadConstants.FOURTH].trim()));
		if (!(ValidationUtil.isAddressLineValid(locationTO.getAddressLine2()))) {

			errString.append(UploadConstants.INVALID_ADDRESS_LINE_2);
			errString.append(',');
		}

		locationTO.setAddressLine3(ValidationUtil.changeEmptyToNull(row[UploadConstants.FIVE].trim()));
		if (!(ValidationUtil.isAddressLineValid(locationTO.getAddressLine3()))) {

			errString.append(UploadConstants.INVALID_ADDRESS_LINE_3);
			errString.append(',');
		}

		locationTO.setAddressLine4(ValidationUtil.changeEmptyToNull(row[UploadConstants.SIX].trim()));
		if (!(ValidationUtil
				.isAddressLineValid(locationTO.getAddressLine4()))) {

			errString.append(UploadConstants.INVALID_ADDRESS_LINE_4);
			errString.append(',');
		}

		locationTO.setAddressLine5(ValidationUtil.changeEmptyToNull(row[UploadConstants.SEVEN].trim()));
		if (!(ValidationUtil.isAddressLineValid(locationTO.getAddressLine5()))) {

			errString.append(UploadConstants.INVALID_ADDRESS_LINE_5);
			errString.append(',');
		}
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.EXIT_METHOD + "validateAddressLines");
		}
	}

	/**
	 * Validates Location State, City, postal code and other details for
	 * location upload.
	 * 
	 * @param row
	 * @param errString
	 * @param locationTO
	 */
	public void validateCityDetails(String row[], StringBuilder errString,
			LocationTO locationTO) {
		
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD + "validateCityDetails");
		}
		/**
		 * Validates City name.
		 */
		locationTO.setCityName(ValidationUtil.changeEmptyToNull(row[UploadConstants.EIGHT].trim()));
		if (!(ValidationUtil.isValidCity(locationTO.getCityName()))) {
			errString.append(UploadConstants.INVALID_CITY_NAME);
			errString.append(',');
		}

		/**
		 * Validates State Code.
		 */
		locationTO.setStateCode(ValidationUtil.changeEmptyToNull(row[UploadConstants.NINE].trim()));
		if (row[UploadConstants.NINE].trim().isEmpty()) {
			locationTO.setStateCode(row[UploadConstants.NINE].trim());
		}  else if (ValidationUtil.isStateCodeValid(row[UploadConstants.NINE]
				.trim())) {
			locationTO.setStateCode(ValidationUtil.stateCodeMap(Integer
					.parseInt(row[UploadConstants.NINE].trim())));
		} else {
			locationTO.setStateCode(row[UploadConstants.NINE].trim());
			errString.append(UploadConstants.INVALID_STATE_CD);
			errString.append(',');
		}

		/**
		 * Validates Postal Code.
		 */
		locationTO.setPostalCode(ValidationUtil.changeEmptyToNull(row[UploadConstants.TEN].trim()));
		if (!(ValidationUtil.isPostalCodeValid(locationTO.getPostalCode()))) {
			errString.append(UploadConstants.INVALID_POSTAL_CD);
			errString.append(',');
		}

		/**
		 * Validates Latitude Value.
		 */
		locationTO.setLatitude(ValidationUtil.changeEmptyToNull(row[UploadConstants.ELEVEN].trim()));
		if (!(ValidationUtil
				.isLatitudeValid(locationTO.getLatitude()))) {
			errString.append(UploadConstants.INVALID_LATITUDE_VAL);
			errString.append(',');
		}

		/**
		 * Validates Longitude Value.
		 */
		locationTO.setLongitude(ValidationUtil.changeEmptyToNull(row[UploadConstants.TWELVE].trim()));
		if (!(ValidationUtil.isLongitudeValid(locationTO.getLongitude()))) {

			errString.append(UploadConstants.INVALID_LONGITUDE_VAL);
			errString.append(',');
		}

		/**
		 * Validates Country Code.
		 */
		if (row[UploadConstants.THIRTEEN].trim().isEmpty()) {
			locationTO.setCountryCode(ValidationUtil.changeEmptyToNull(row[UploadConstants.THIRTEEN].trim()));
		} else if (ValidationUtil
				.isCountryCodeValid(row[UploadConstants.THIRTEEN].trim())) {
			locationTO.setCountryCode(EFSConstants.CountryCode.get(
					Integer.parseInt(row[UploadConstants.THIRTEEN].trim())) != null ? EFSConstants.CountryCode.get(
							Integer.parseInt(row[UploadConstants.THIRTEEN].trim())).name(): null);
		} else {
			locationTO.setCountryCode(row[UploadConstants.THIRTEEN].trim());
			errString.append(UploadConstants.INVALID_COUNTRY_CD);
			errString.append(',');
		}
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.EXIT_METHOD + "validateCityDetails");
		}

	}
	/**
	 * Validate with existing data in Location table 
	 * Update the existing records & insert new records 
	 * @param locationAndXrefDetailsMap
	 * @param locationToList
	 * @return
	 */
	public List<LocationTO> getInsertAndUpdateLocationDetails(
			Map<String, Integer> locationAndXrefDetailsMap,
			List<LocationTO> locationToList) {
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.ENTERING_METHOD + "getInsertAndUpdateLocationDetails");
		}
		StringBuilder key = new StringBuilder();
		List<LocationTO> updateLocationList = new ArrayList<LocationTO>();
		if(locationAndXrefDetailsMap != null && !(locationAndXrefDetailsMap.isEmpty())){
			
		for (LocationTO locTo : locationToList) {

			key = key.append(locTo.getLocationTypeCd()).append('-')
					.append(locTo.getSourceLocationNbr());

			if (locationAndXrefDetailsMap.containsKey(key.toString())) {

				locTo.setLocationId(locationAndXrefDetailsMap.get(key.toString()));
				updateLocationList.add(locTo);
			}

			key.setLength(0);
		}
	}
		locationToList.removeAll(updateLocationList);
		
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(UploadConstants.EXIT_METHOD
					+ "getInsertAndUpdateLocationDetails - "
					+ "Update Record(s) count :" + updateLocationList.size()
					+ "\t Insert Record(s) count :" + locationToList.size());
		}
		return updateLocationList;
		
	}
	
}
