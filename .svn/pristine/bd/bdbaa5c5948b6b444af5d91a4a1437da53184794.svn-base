package com.homedepot.homer.util;

import net.codemate.DbAssert;
import net.codemate.DbSource;

import com.homedepot.mm.rd.homerunitdb.HomerUnit;
import com.homedepot.mm.rd.homerunitdb.datasources.DataSourceCollection;

public class HomerUnitTestCase {
	private static DataSourceCollection dsc = new DataSourceCollection("DAO.sql");
	
	public static DbAssert da = null;
	public static DbSource ds = null;
	
	static{
		dsc.addMemoryDataSource("jdbc/TA.AA.DAO-ADMIN.001");
		dsc.addMemoryDataSource("jdbc/SupplyChainDistributionNetwork");
		dsc.addMemoryDataSource("jdbc/SupplyChainDistributionNetwork.1");
		dsc.addMemoryDataSource("jdbc/Oracle.DS.1");
		
		da = HomerUnit.init(dsc).getDbAssert();
		ds = da.source("jdbc/SupplyChainDistributionNetwork");
		ds = da.source("jdbc/SupplyChainDistributionNetwork.1");
		ds.loadSchemaFile("Application_Schema.sql");
		ds.loadSchemaFile("Application_SQL.sql");
	}
}
