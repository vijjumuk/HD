package com.homedepot.homer.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.MessageFormat;
import java.util.HashMap;

import com.isocra.util.DbToSqlUtility;
import com.isocra.util.WhereClauseHelper;

import org.apache.log4j.Logger;

public class HomerUnitTableDataExtractorUtil {

	private static final Logger LOGGER = Logger.getLogger(HomerUnitTableDataExtractorUtil.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		boolean getDaoTableData = true; // Change this to true to get the
											// latest DAO table contents
		boolean getDaoTableCreateStatement = true; // Change this to true to
													// get the latest DAO table
													// DDL data
		boolean addDaoTableDropStatementsBeforeCreate = true;
		
		boolean getIndividualTableDataToFile = false;

		if (getDaoTableData) {
			String daoUserName = "qa3tb01"; // DAO AD Credentials - DO NOT
											// DELETE
			String daoPassword = "ky6ytrs"; // DAO AD Credentials - DO NOT
											// DELETE
			StringBuffer sb = new StringBuffer();
			String table = null;
			String drop = "DROP TABLE IF EXISTS {0};\n";
			
			table = "DAO_CNTRC";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_CNTRCS";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_CNTRCS_SCTY";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_CNTRC_DATA_SRC";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_CNTRC_SCTY";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_CNTRC_SELR_VER";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_CNTRC_VER";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_DATA_SRC";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_DB_SCTY_OPN";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_DB_TYP_CD";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_ELM_COL_MAP";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_ISLTN_TYP_CD";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_QUERY_CLASS";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_QUERY_TYP_CD";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_SCTY";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_SCTY_ROLE";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_SCTY_ROLE_OPN";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_SELR";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_SELRS_SCTY";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_SELR_DATA_SRC";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_SELR_ELM_COL";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "DAO_SELR_SCTY";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD1AA", table, daoUserName, daoPassword,
					getDaoTableCreateStatement));
			table = "SRSRC";
			if(addDaoTableDropStatementsBeforeCreate){
				sb.append(MessageFormat.format(drop, table));
			}
			sb.append(DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"AD2AA", "SRSRC", daoUserName, daoPassword,
					getDaoTableCreateStatement));
			try {
				// Create file
				FileWriter fstream = new FileWriter(MessageFormat.format("test{0}{1}.sql", File.separator, "DAO"));
				BufferedWriter out = new BufferedWriter(fstream);
				out.write(sb.toString());
				// Close the output stream
				out.close();
			} catch (Exception e) {// Catch exception if any
				System.err.println("Error: " + e.getMessage());
			}
		}
		
		if(getIndividualTableDataToFile){
			
			String userName = "QA1MM02"; // Enter IBM credentials
			String password = "hvw5803c"; // Enter IBM credentials
			
//			String tableName = "ALLOC_ASN_PO";
	
			// **********************************************************************
			// This is how you get ALL the contents of a table dumped to console
			// **********************************************************************
//			String output = DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
//					"QA1MM", tableName, userName, password, true);
			
			/**String output = DbToSqlUtility.dumpTable(DbToSqlUtility.PR1,
			"PRTHD", "DEPT", userName, password, true);
			
			String output = DbToSqlUtility.dumpTable(DbToSqlUtility.PR1,
					"PRTHD", "DSVC_TYP_CD", userName, password, true);
			
			//Vendor Number between 10057 and 10161
			String output = DbToSqlUtility.dumpTable(DbToSqlUtility.PR1,
					"PRTHD", "MVNDR", userName, password, true);
			
			String output = DbToSqlUtility.dumpTable(DbToSqlUtility.PR1,
					"PRTHD", "RMETH_CD", userName, password, true);
	
			String output = DbToSqlUtility.dumpTable(DbToSqlUtility.PR1,
					"PRTHD", "OCYC_SOQ_RSN", userName, password, true);
			
			String output = DbToSqlUtility.dumpTable(DbToSqlUtility.PR1,
					"PRTHD", "N_OCYC_SOQ_RSN", userName, password, true);

			
			//SKU Number between 100000 and 100228
			String output = DbToSqlUtility.dumpTable(DbToSqlUtility.NP1,
					"QA1MM", "SKU", userName, password, true);
			*/
			HashMap<String, String> tableMap = new HashMap<String, String>();
//			tableMap.put("DC_ASN_PO_SKU", " and THD_ASN_ID IN (5222020, 5223904,5224311)");
//			tableMap.put("ALLOC_ASN_PO", " and crt_ts > '2014-06-11 00:00:00'");
//			tableMap.put("ALLOC_ASN_PO_SKU", " and THD_ASN_ID IN (5222020, 5223904,5224311)");
//			tableMap.put("AGG_RQST", " and AGG_NBR IN (4526094,2981727,4526235,2397522)");
//			tableMap.put("AGG_RQST_SKU", " and AGG_NBR IN (4526094,2981727,4526235,2397522)");
//			tableMap.put("AGG_RQST_SKU_LOC", " and AGG_NBR IN (4526094,2981727,4526235,2397522)");
//			tableMap.put("CRE_SKSTR_FSNSH", " and 2=1");
//			
//			tableMap.put("MVNDR", " and MVNDR_NBR IN (87961,30555,100849,100851)");
//			tableMap.put("ALLOC_ASN_PO_SKSTR", " and 2=1");
//			tableMap.put("SUB_SYS_CTRL_PARM", " and 2=1");
//			tableMap.put("CRE_CONFG_PARM", " and 2=1");
//			tableMap.put("MKT_RDC_TRNSN", " and 2=1");
//			tableMap.put("REPLE_RQST_COMBINV", " and 2=1");
//			tableMap.put("PO_AUTO_HORD_PARM", " and 2=1");
//			tableMap.put("PO_GRP_AHRD_PARM", " and 2=1");
//			tableMap.put("MVNDR_SKU_STR", " and 2=1");
//			tableMap.put("SKU_STR_LIST", " and 2=1");
//			tableMap.put("DC_SKU_STR", " and 2=1");
//			tableMap.put("MVNDR_MKT_DC", " and 2=1");
//			tableMap.put("STRSK_OH", " and 2=1");
//			tableMap.put("STR", " and 2=1");
//			tableMap.put("MKT", " and 2=1");
//			tableMap.put("STRSK_VIRT_ALLOC", " and 2=1");
//			tableMap.put("ALASN_PO_SKU_EXCPT", " and 2=1");
			tableMap.put("DC_ASN_PO", " and THD_ASN_ID=5222020");
			
			for (String tableName : tableMap.keySet()) {
				
				WhereClauseHelper wch = new WhereClauseHelper();
				String standardWhere = "WHERE 1=1";
				standardWhere += tableMap.get(tableName);
				
				wch.addTable(tableName, standardWhere);
			
				/* You can output the details of all of your custom where clause
	 			tables this way */
				String output = DbToSqlUtility.dumpTables(DbToSqlUtility.NP1,"QA1MM",userName,password,wch,true);
				LOGGER.error(output);
			}
			
			
//			try {
//				// Create file
//				FileWriter fstream = new FileWriter(MessageFormat.format("test{0}{1}.sql", File.separator, tableName));
//				BufferedWriter out = new BufferedWriter(fstream);
//				out.write(output);
//				// Close the output stream
//				out.close();
//			} catch (Exception e) {// Catch exception if any
//				System.err.println("Error: " + e.getMessage());
//			}
		}

		// **********************************************************************
		// This is how you can filter your query with a where clause
		// //
		// **********************************************************************
//		 WhereClauseHelper wch = new WhereClauseHelper();
//		
//		 // Tables Needed for 1 record of 11M
//		 String standardWhere = " WHERE MVNDR_NBR between 10057 and 10161 order by MVNDR_NBR WITH UR";
//		 wch.addTable("MVNDR", standardWhere);
//		
//		 /* You can output the details of all of your custom where clause
//		 tables this way */
//		 logger.debug(DbToSqlUtility.dumpTables(DbToSqlUtility.PR1,"PRTHD",userName,password,wch,true));
	}

}
