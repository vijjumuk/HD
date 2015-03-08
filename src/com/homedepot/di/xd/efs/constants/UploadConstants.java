/*
 * This program is proprietary to The Home Depot and is not to be 
 * reproduced, used, or disclosed without permission of:
 *    
 *  The Home Depot
 *  2455 Paces Ferry Road, N.W.
 *  Atlanta, GA 30339-4053
 * 
 * File Name: UploadConstants.java 
 * author: The Home Depot Inc
 */

package com.homedepot.di.xd.efs.constants;

import java.util.Arrays;
import java.util.regex.Pattern;

public final class UploadConstants {

	private UploadConstants()
	{
		
	}
	
	// Upload File types
	public static final String LANE_UPLOAD = "LANE";
	
	// Upload files header details
	private static final String[] SHPG_LANE_UPLOAD_HEADERS = {"Location Number","Location Destination","Lane Name",
		"MVNDR","Primary Location","Vendor Effective Begin Date","Vendor Effective End Date","Load Group Name",
		"LG Effective Begin Date","LG Effective End Date","Lane Active flag"};
	
	private static final String[] SCHEDULE_UPLOAD_HEADERS = { "Location Number", "Destination", 
		"Schedule Type Code", "Schedule Group Code", "Schedule Name", "Order Day", "VTT (days)", "Ship Day", 
		"Arrive Day",  "Vendor Ready Time", "Expected Carrier Depart Time", "Transit Time (in hours)", 
		"DC Appointment Time",  "DC Start Work Day", "DC End Work Day", "Start Shift Sequence Number", 
		"End Shift Sequence Number",  "Number of Shifts Worked",  
		"Order Week Number",  "Tender Week Number", "Ship Week Number", "Arrive Week Number", 
		"DC Start Work Week Number",  "DC End Work Week Number", 
		"Effective Begin Date",  "Effective End Date"
};
	
	private static final String[] EFS_LOC_UPLOAD_HEADERS = {"Location Number","Location Description","Address 1","Address 2","Address 3","Address 4","Address 5","City"
		,"State","Zip","Latitude","Longitude","Country Code","Location Type Code","Active flag"};
	
	public enum UploadHeaders {
		SHPG_LANE_UPLOAD_HEADERS
	}

	//Lane upload Dept nmbr and Mer base code
	public static final short MER_BASE_CODE = 1;
	
	//Response message
	public static final String INVALID_USER_ID = "User ID is Null/Empty.";
	public static final String INVALID_FILE_NAME = "File Name is Null/Empty.";
	public static final String FAILED_MSG = "Failed to process.";


	// File reader constant
	public static final int EXCEP_ERR_CD = 1;
	public static final int INVALID_HEADER_STAT_CD = 4;
	
	public static final int NO_DATA_STAT_CD = 2;
	public static final int REC_SIZE_STAT_CD = 3;

	public static final String UPLOAD_SUCCESS = "Uploaded Successfully!";

	// return codes
	public static final int SUCCESSFUL_RETURN_CODE = 0;

	//Efs Upload constants
	public static final String SUCCESS = "Success";
	public static final int FIRST = 0;
	public static final int SECOND = 1;
	public static final int THIRD = 2;
	public static final int FOURTH = 3;
	public static final int FIVE = 4;
	public static final int SIX = 5;
	public static final int SEVEN = 6;
	public static final int EIGHT = 7;
	public static final int NINE = 8;
	public static final int TEN = 9;
	public static final int ELEVEN = 10;
	public static final int TWELVE = 11;
	public static final int THIRTEEN = 12;
	public static final int FOURTEEN = 13 ;
	public static final int FIFTEEN = 14;
	public static final int SIXTEEN = 15;
	public static final int SEVENTEEN = 16;
	public static final int EIGHTEEN = 17;
	public static final int NINETEEN = 18;
	public static final int TWENTY = 19;
	public static final int TWENTYONE = 20;
	public static final int TWENTYTWO = 21;
	public static final int TWENTYTHREE = 22;
	public static final int TWENTYFOUR = 23;
	

	public static final int TWENTYFIVE = 24;
	public static final int TWENTYSIX = 25;
	
	
	public static final Boolean FALSE = false;
	//Location Type code 
	private static final String[] ORIGIN_TYP_CD = {"9","10","11","12"};
	private static final String[] DEST_TYP_CD = {"13"};
	
	// Validation constant
	public static final String NUMBER_ONLY = "[0-9]+";
	public static final String WEEKDAYS="[1-7]";
	public static final String TIMEFORMAT ="([0-9]|0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]";
	public static final String TIMEFORMAT_IN24HRS = "([01]?[0-9]|2[0-3]):[0-5][0-9]"; //"([0-9]|0[0-9]|1[0-9]|2[0-3])";
	public static final String ALPHA_NUMERIC_ONLY = "[A-Za-z0-9]+";
	public static final String LOC_NAME_VALIDATION = "[A-Za-z]+[\\s]+[A-Za-z]+";
	public static final String CITY_VALIDATION = "[A-Za-z]+\\s+[A-Za-z]";
	public static final String ADDRESS_VALIDATION = "(.{1,60})[a-zA-Z0-9'#.,-]+[\\s]+[a-zA-Z0-9'#.,-]+"; 
	public static final String ALPHABET_ONLY = "[A-Za-z]+";
	public static final Pattern RATE_PATTERN = Pattern.compile("^[0-9]{0,5}+(\\.)+([0-9]{0,3})$");
	public static final Pattern RATE_PATTERN_DEC2 = Pattern
			.compile("^[0-9]{0,5}+(\\.)+([0-9]{0,2})$");	
	public static final Pattern LATITUDE_PATTERN = Pattern.compile("^[0-9]{0,5}+\\.{0,1}+([0-9]{0,7})$");
	public static final Pattern LONGITUDE_PATTERN = Pattern
			.compile("^[0-9]{0,5}+\\.{0,1}+([0-9]{0,7})$");

	// Input Field constant
	public static final int ORIGIN_LENGTH = 16;
	public static final int DEST_NBR_LENGTH = 4;
	public static final int STAT_CD_LENGTH = 4;
	public static final int POSTAL_CD_LENGTH = 10;
	public static final int COUNTRY_CD_LENGTH = 3;
	public static final double LATITUDE_MAX_VAL =  90;
	public static final double LATITUDE_MIN_VAL = -90;
	
	public static final double LONGITUDE_MAX_VAL =  180;
	public static final double LONGITUDE_MIN_VAL = -180;
	public static final String YES = "Y";
	public static final String NO = "N";
	public static final String DEFAULT = "DEFAULT";
	public static final int ADDRESS_OR_NAME_MAX_LENGTH = 60; 
	
	// Error Message 
	public static final String INVALID_LOCATION = "Invalid Location Number";
	public static final String INVALID_LOCATION_NAME = "Invalid Location Name";
	public static final String INVALID_ADDRESS_LINE_1 = " Invalid Address Line 1";
	public static final String INVALID_ADDRESS_LINE_2 = " Invalid Address Line 2";
	public static final String INVALID_ADDRESS_LINE_3 = " Invalid Address Line 3";
	public static final String INVALID_ADDRESS_LINE_4 = " Invalid Address Line 4";
	public static final String INVALID_ADDRESS_LINE_5 = " Invalid Address Line 5";
	public static final String INVALID_CITY_NAME = " Invalid City Name";
	public static final String INVALID_STATE_CD = " Invalid State code";
	public static final String INVALID_POSTAL_CD = " Invalid Postal code";
	public static final String INVALID_LATITUDE_VAL = " Invalid latitude Value";
	public static final String INVALID_LONGITUDE_VAL = " Invalid Longitude Value";
	public static final String INVALID_COUNTRY_CD = " Invalid Country code";
	public static final String INVALID_LOCATION_TYP_CD = " Invalid Location type code";
	public static final String INVALID_ACTIVE_FLG = " Invalid active flag";
	public static final String DUPLICATE_RECORD = "DUPLICATE_RECORD";
	
	// Logger Constant
	public static final String ENTERING_METHOD = "Entring Method -";
	
	public static final String EXIT_METHOD = "EXIT Method -";
	
	public static final String EXCEPTION = "Exception Occured in";
	public static final String INSERTED_SUCCESSFULLY = "Records Inserted Successfully";
	
	// Hardcoded Value for Sprint1 
	public static short SCHN_EFS_LOC_SRC_SYS_CD = 1;

	
	// Error code Constant
	public static final int QUERY_EXCEPTION_CD = 100;
	
	// Response Messages
	public static final String EMPTY_CSV = "Empty CSV file uploaded. Please upload the valid CSV file";	
	public static final String INVALID_HDR_MSG = "Invalid Header received. Please check the file header.";
	public static final String INVALID_HDR_COUNT = "Invalid Header name in uploaded file.";
	public static final String EMPTY_INPUT_FILE_MSG = "No data found in the uploaded file.";
	public static final String INPUT_FILE_LIMIT_MSG = "Number of Records exceeds maximum limit.";
	
	public static final short EFS_LOCATION_UPLOAD = 1;
	public static final short EFS_ORDER_GROUP_UPLOAD = 2;
	public static final short EFS_SCHEDULE_UPLOAD = 6;
	public static final String EFS_LOCATION = "LOCATION";
	public static final String EFS_LANE = "LANE";
	public static final String EFS_SCHEDULE = "SCHEDULE";
	
	public static final int MAX_ROW_COUNT = 10000;
	public static final int MIN_ROW_COUNT = 2; // Changing to 2 since 1 row for Header and 1 row for Data
	
	
	
	
	//////////////////////
	
	
	
	public static final String INVALID_CSV_FILE = "Invalid CSV File";

	public static final String INVALID_ORIGIN = "Invalid Origin. ";
	public static final String INVALID_DESTINATION = "Invalid Destination. ";
	public static final String INVALID_VNDR= "Invalid Vendor Number. ";
	public static final String INVALID_LANE_NAME= "Invalid Lane Name. ";
	public static final String INVALID_VENDOR_EFF_BGN_DT= "Invalid Vendor Effective Begin Date. ";
	public static final String INVALID_VENDOR_EFF_END_DT= "Invalid Vendor Effective End Date. ";
	public static final String INVALID_LOAD_GRP_EFF_BGN_DT= "Invalid LG Effective Begin Date. ";
	public static final String INVALID_LOAD_GRP_EFF_END_DT= "Invalid LG Effective End Date. ";
	public static final String RECORD_ALREADY_EXIST = "Record already exist for this Origin/Destination/Vendor/Group combination. ";
	public static final String PRIMARY_LANE_ALREADY_EXIST = "Primary Lane already exists";
	

	public static final int SCHEDULE_NAME_LENGTH = 100;
	public static final String INVALID_SCHEDULE_TYP_CD = "Invalid Schedule Type Code. ";
	public static final String INVALID_SCHEDULE_NAME = "Invalid Schedule Name/Exceed total "+ SCHEDULE_NAME_LENGTH +" Characters. ";
	public static final String INVALID_EFF_BGN_DT= "Invalid Effective Begin Date. ";
	public static final String INVALID_EFF_END_DT= "Invalid Effective End Date. ";
	public static final String INVALID_ORDER_DAY_RECORD = "Duplicate Schedule Information for Existing Order Day ";
	public static final String INVALID_SHIP_DAY = "Invalid Ship day";
	public static final String INVALID_ARRIVAL_DAY = "Invalid Arrival Day";
	public static final String INVALID_VNDR_RD_TYM="Invalid Vendor Ready Time";
	public static final String INVALID_CARRIER_DEPT_TYM="Invalid Carrier Depart Time";
	public static final String INVALID_SHPMNT_TRANS_TIME="Invalid Shipment Transit Time";
	public static final String INVALID_DC_APP_TYM="Invalid DC Appointment  Time";
	public static final String INVALID_DC_START_WORK_DAY="Invalid DC Start Work Day";
	public static final String INVALID_DC_END_WORK_DAY="Invalid DC End Work Day";
	public static final String INVALID_DC_START_SHFT_SEQ_NBR="Invalid DC Start Shift Sequence Number";
	public static final String INVALID_DC_END_SHFT_SEQ_NBR="Invalid DC End Shift Sequence Number";
	public static final String INVALID_DC_SHIFT_CNT="Invalid DC Shift Count";
	//public static final String INVALID_ODR_WK_NBR="Invalid Order Week Number";
	public static final String INVALID_TNDR_RTV_WK_NBR="Invalid Tender Relative Week Number";
	public static final String INVALID_SHP_WK_NBR="Invalid Ship Week Number";
	public static final String INVALID_ARRIVE_WK_NBR="Invalid Arrive Week Number";
	public static final String INVALID_DC_STRT_WRK_WK_NBR="Invalid DC Start Work Week Number";
	public static final String  INVALID_DC_END_WRK_WK_NBR="Invalid DC End Work Week Number";
	public static final String INVALID_ORDER_DAY="Invalid Order Day";
	
	// Basic Validation constant
	public static final int VENDR_MIN_LENGTH = 0;
	public static final int VENDR_MAX_LENGTH = 10;
	public static final int MIN_LNGTH = 0;
	public static final int MAX_LIMIT = 1000;
	
	// DAO constants
	public static final int MAX_SEL_MULTIPLE = 500; // Maximum number of multiple column inputs in
								// select query

	public static final short LANE_TYP_CD = 1;

	public static final String LTL = "LTL";
	public static final int SKU_LENGTH1 = 6;
	public static final int SKU_LENGTH2 = 10;
	public static final int MAX_SKU_VALUE = 2147483647;

	// Index constant
	public static final short ZERO = 0;
	public static final short ONE = 1;
	public static final short TWO = 2;
	public static final short THREE = 3;
	public static final short FOUR = 4;

	public static String[] getShippingLaneHeader(){
		return Arrays.copyOf(SHPG_LANE_UPLOAD_HEADERS, SHPG_LANE_UPLOAD_HEADERS.length);
	}
	
	public static String[] getLocationHeader(){
		return Arrays.copyOf(EFS_LOC_UPLOAD_HEADERS, EFS_LOC_UPLOAD_HEADERS.length);
	}
	
	public static String[] getOriginTypeCodes(){
		return Arrays.copyOf(ORIGIN_TYP_CD, ORIGIN_TYP_CD.length);
	}
	
	public static String[] getDestinationTypeCodes(){
		return Arrays.copyOf(DEST_TYP_CD, DEST_TYP_CD.length);
	}
	
	public static String[] getScheduleHeader(){
		return Arrays.copyOf(SCHEDULE_UPLOAD_HEADERS, SCHEDULE_UPLOAD_HEADERS.length);
	}
	
	public static final String SCHEDULED_TYPE_CD_EXCEPTION = "Scheculed Type Code does not exist";
	
	public static final String SCHEDULED_GRP_CD_EXCEPTION = "Scheculed Group Code does not exist";
}
