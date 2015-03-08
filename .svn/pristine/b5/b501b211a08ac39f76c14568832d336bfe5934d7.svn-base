/*
 * This program is proprietary to The Home Depot and is not to be 
 * reproduced, used, or disclosed without permission of:
 *    
 *  The Home Depot
 *  2455 Paces Ferry Road, N.W.
 *  Atlanta, GA 30339-4053
 * 
 * File Name: EFSConstants.java 
 * author: The Home Depot Inc
 */

package com.homedepot.di.xd.efs.constants;

public final class EFSConstants {
	
	private EFSConstants(){}

	public static final String SUCCESS = "Success";
	public static final String EXCEPTION_OCCURED = "Excepiton occured";
	
	public static final String YES = "Y";
	public static final String NO = "N";
	
	public static final String EMAILER_ORACLE_JNDI_NAME = "java:comp/env/jdbc/Oracle.DS.1";
	
	//REPORT TYPE ERROR CODES
	public static final int GET_ALL_REPORT_TYPES_ERROR_CODE = 3000;
	
	private static final int US_CD = 223;

	public static enum CountryCode {
		US(223);

		private int code;

		private CountryCode(final int code) {
			this.code = code;
		}

		public int getCountryCode() {
			return this.code;
		}

		public static CountryCode get(int code) {
			switch (code) {
			case US_CD:
				return US;

			}
			return null;
		}
	} 
	
	public static enum StateCodeEnum {
		PA(1675), GU(1646), AK(1634), AR(1636),IA(1648),NH(1667),MN(1659),ID(1649),NC(1664),KS(1652),
		WV(1688),AL(1635),MD(1656),TX(1681),CO(1640),FL(1644),RI(1677),WA(1686),DE(1643),CT(1641),
		HI(1647),NM(1669),ME(1657),OK(1673),UT(1682),WI(1687),NMariana(1661),MI(1658),NJ(1668),WY(1689),
		IL(1650),SD(1679),GA(1645),MO(1660),MT(1663),SC(1678),AZ(1638),VA(1683),KY(1653),OR(1674),
		TN(1680),VT(1685),MS(1662),PR(1676),IN(1651),OH(1672),LA(1654),ND(1665),VI(1684),MA(1655),
		CA(1639),NY(1671),NE(1666),AmerSamoa(1637),DC(1642),NV(1670);
		private int code;

		private StateCodeEnum(int c) {
			code = c;
		}

		public int getCode() {
			return code;
		}

	}
	
}
