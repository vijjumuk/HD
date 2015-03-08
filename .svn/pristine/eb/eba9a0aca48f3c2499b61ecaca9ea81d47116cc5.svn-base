package com.homedepot.di.xd.efs.util;

import java.io.IOException;
import java.util.EnumMap;

import com.csvreader.CsvReader;
import com.homedepot.di.xd.efs.constants.EFSConstants.StateCodeEnum;
import com.homedepot.di.xd.efs.constants.UploadConstants;
import com.homedepot.di.xd.efs.exception.EFSException;

public class ValidationUtil {

	public static int getRecordCount(CsvReader reader) throws EFSException{

		int recCount = 0;
		int indx;
		boolean empty = true;
		try {
			while (reader.readRecord()) {
				empty = true;
				for (indx = 0; indx < reader.getColumnCount() && empty; indx++) {
					empty = (reader.get(indx).trim().length() == 0);
				}
				if (!empty) {
					recCount++;
				}
			}
		} catch (IOException e) {
			throw new EFSException(
					UploadConstants.EXCEPTION +"getRecordCount", e);
		}
		return recCount;
	
	}
	
	/**
	 * Checks if is null or empty.
	 * 
	 * @param input
	 *            String : str
	 * @return true, if input is null or Zero
	 */
	public static boolean isEmpty(final String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * To check the record is empty or not.
	 * 
	 * @param row
	 * @return boolean
	 */
	public static boolean isRowEmpty(String[] row)
	{
		for(String columnValue: row)
		{
			if(!isEmpty(columnValue))
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Validate Origin ID and return true if it is valid
	 * 
	 * @param origin
	 * @return
	 */
	public static boolean isOriginValid(String origin) {
		if (origin != null && (!origin.isEmpty())
				&& origin.matches(UploadConstants.ALPHA_NUMERIC_ONLY)
				&& origin.length() <= UploadConstants.ORIGIN_LENGTH) {

			return true;
		}
		return false;
	}
	
	/**
	 * Validate shipping location number and return true if it is valid
	 * 
	 * @param dest
	 * @return boolean
	 */
	public static boolean isDestinationValid(String dest) {

		if (dest != null && (!dest.isEmpty()) && dest.matches(UploadConstants.NUMBER_ONLY)
				&& dest.length() == UploadConstants.DEST_NBR_LENGTH) {

			return true;
		}
		return false;
	}

	public static boolean isLocationNameValid(String locName) {
		 
		if (locName != null && (!locName.isEmpty() && (locName.matches(UploadConstants.LOC_NAME_VALIDATION) || locName.matches(UploadConstants.ALPHABET_ONLY)) )){
			return true;
		} else {
			return false;
		}
			
	}

	/**
	 * Validation for Address columns, can be null.
	 * Length cannot exceed 60 characters.
	 * Allow digits, spaces, alphabets and some special characters.
	 * 
	 * @param addressLine
	 * @return boolean
	 */
	public static boolean isAddressLineValid(String addressLine) {
		if (addressLine == null) {
			return true;
		} else if(!(addressLine != null && (!addressLine.isEmpty()
				&& addressLine.length() <= UploadConstants.ADDRESS_OR_NAME_MAX_LENGTH && addressLine
					.matches(UploadConstants.ADDRESS_VALIDATION)))) {
			return false;
		}
		return true;
	}

	public static boolean isValidCity(String city) {
		if (city == null) {
			return true;
		} else if (!((city != null && (!city.isEmpty() && (city
				.matches(UploadConstants.CITY_VALIDATION) || city
				.matches(UploadConstants.ALPHABET_ONLY)))))) {
			return false;
		}
		return true;
	}

	public static boolean isStateCodeValid(String stateCd) {
		
		 if (!(stateCd != null && (!stateCd.isEmpty()
				&& stateCd.length() == UploadConstants.STAT_CD_LENGTH && stateCd
					.matches(UploadConstants.NUMBER_ONLY)))) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isPostalCodeValid(String postalCd) {
		if (postalCd == null) {
			return true;
		} else if (!(postalCd != null && (!postalCd.isEmpty()
				&& postalCd.length() <= UploadConstants.POSTAL_CD_LENGTH && postalCd
					.matches(UploadConstants.ALPHA_NUMERIC_ONLY)))) {
			return false;
		} else {
			return true;
		}
	}

	public static boolean isLatitudeValid(String latitude) {
		try {
			if (latitude == null) {
				return true;
			} else if (Double.parseDouble(latitude) <= UploadConstants.LATITUDE_MAX_VAL && Double.parseDouble(latitude) >= UploadConstants.LATITUDE_MIN_VAL
					&& UploadConstants.LATITUDE_PATTERN.matcher(latitude.substring(1, latitude.length())).find() ) {
				return true;
			}
		} catch (NumberFormatException ne) {
			return false;
		}
		return false;
	}
	
	public static boolean isLongitudeValid(String longitude) {
		try {
			if (longitude == null ) {
				return true;
			} else if (Double.parseDouble(longitude) <= UploadConstants.LONGITUDE_MAX_VAL
			&& Double.parseDouble(longitude) >= UploadConstants.LONGITUDE_MIN_VAL
			&& UploadConstants.LONGITUDE_PATTERN.matcher(longitude.substring(1, longitude.length())).find()) {
				return true;
			}
		} catch (NumberFormatException ne) {
			return false;
		}
		return false;
	}

	public static boolean isCountryCodeValid(String countryCd) {
		if (countryCd == null ) {
			return true;
		} else if (!(countryCd != null && (!countryCd.isEmpty()
				&& countryCd.length() == UploadConstants.COUNTRY_CD_LENGTH && countryCd
					.matches(UploadConstants.NUMBER_ONLY)))) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Validates location type code. It is a number. It cannot be empty or null.
	 * 
	 * @param locTypCd
	 * @return boolean
	 */
	public static boolean isLocationTypeCd(String locTypCd) {
		if (!(locTypCd != null && (!locTypCd.isEmpty() && locTypCd
				.matches(UploadConstants.NUMBER_ONLY)))) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Validate the flag value and return true if it is valid
	 * 
	 * @param flg
	 * @return boolean
	 */
	public static boolean isFlagValid(String flg) {
		if (flg != null && (!flg.isEmpty())
				&& (flg.equalsIgnoreCase(UploadConstants.YES) || flg.equalsIgnoreCase(UploadConstants.NO))) {
			return true;
		}
		return false;
	}
	
	/**
	 * Convert empty string into null 
	 * @param emptyValue
	 * @return
	 */
	public static String changeEmptyToNull(String emptyValue) {
		if(emptyValue.isEmpty()) {
			return null;
		}  
		return emptyValue;
		
		
	}
	
	public static String stateCodeMap(int code){
		EnumMap<StateCodeEnum, String> enumMap = new EnumMap<StateCodeEnum, String>(
				StateCodeEnum.class);
		enumMap.put(StateCodeEnum.PA, "PA");
		enumMap.put(StateCodeEnum.GU, "GU");
		enumMap.put(StateCodeEnum.AK, "AK");
		enumMap.put(StateCodeEnum.AR, "AR");
		enumMap.put(StateCodeEnum.IA, "IA");
		enumMap.put(StateCodeEnum.NH, "NH");
		enumMap.put(StateCodeEnum.MN, "MN");
		enumMap.put(StateCodeEnum.ID, "ID");
		enumMap.put(StateCodeEnum.NC, "NC");
		enumMap.put(StateCodeEnum.KS, "KS");
		enumMap.put(StateCodeEnum.WV, "WV");
		enumMap.put(StateCodeEnum.AL, "AL");
		enumMap.put(StateCodeEnum.MD, "MD");
		enumMap.put(StateCodeEnum.TX, "TX");
		enumMap.put(StateCodeEnum.CO, "CO");
		enumMap.put(StateCodeEnum.FL, "FL");
		enumMap.put(StateCodeEnum.RI, "WA");
		enumMap.put(StateCodeEnum.DE, "DE");
		enumMap.put(StateCodeEnum.CT, "CT");
		enumMap.put(StateCodeEnum.HI, "HI");
		enumMap.put(StateCodeEnum.NM, "NM");
		enumMap.put(StateCodeEnum.OK, "OK");
		enumMap.put(StateCodeEnum.UT, "UT");
		enumMap.put(StateCodeEnum.WI, "PA");
		enumMap.put(StateCodeEnum.NMariana, "NMariana");
		enumMap.put(StateCodeEnum.MI, "MI");
		enumMap.put(StateCodeEnum.NJ, "NJ");
		enumMap.put(StateCodeEnum.WY, "WY");
		enumMap.put(StateCodeEnum.IL, "IL");
		enumMap.put(StateCodeEnum.SD, "SD");
		enumMap.put(StateCodeEnum.GA, "GA");
		enumMap.put(StateCodeEnum.MO, "MO");
		enumMap.put(StateCodeEnum.MT, "MT");
		enumMap.put(StateCodeEnum.SC, "SC");
		enumMap.put(StateCodeEnum.AZ, "AZ");
		enumMap.put(StateCodeEnum.VA, "VA");
		enumMap.put(StateCodeEnum.KY, "KY");
		enumMap.put(StateCodeEnum.OR, "OR");
		enumMap.put(StateCodeEnum.TN, "IN");
		enumMap.put(StateCodeEnum.VT, "VT");
		enumMap.put(StateCodeEnum.MA, "MA");
		enumMap.put(StateCodeEnum.PR, "PR");
		enumMap.put(StateCodeEnum.IN, "IN");
		enumMap.put(StateCodeEnum.OH, "OH");
		enumMap.put(StateCodeEnum.LA, "LA");
		enumMap.put(StateCodeEnum.ND, "ND");
		enumMap.put(StateCodeEnum.VI, "VI");
		enumMap.put(StateCodeEnum.MA, "MA");
		enumMap.put(StateCodeEnum.NY, "NY");
		enumMap.put(StateCodeEnum.NE, "NE");
		enumMap.put(StateCodeEnum.AmerSamoa, "AmerSamoa");
		enumMap.put(StateCodeEnum.DC, "DC");
		enumMap.put(StateCodeEnum.NV, "NV");
		for (EnumMap.Entry<StateCodeEnum, String> entry : enumMap.entrySet()) {
			if (code == entry.getKey().getCode()){
				return entry.getValue();
			}
		}

		return null;

	} 
}
