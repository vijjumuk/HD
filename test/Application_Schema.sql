DROP TABLE IF EXISTS SCHN_EFS_LOC;
CREATE TABLE SCHN_EFS_LOC (SCHN_LOC_ID NUMBER NOT NULL,CRT_SYSUSR_ID VARCHAR2(24) NOT NULL,CRT_TS TIMESTAMP NOT NULL,LAST_UPD_SYSUSR_ID VARCHAR2(24) NOT NULL,LAST_UPD_TS TIMESTAMP NOT NULL,ADDR_LINE1_TXT VARCHAR2(60) NULL,ADDR_LINE2_TXT VARCHAR2(60) NULL,ADDR_LINE3_TXT VARCHAR2(60) NULL,ADDR_LINE4_TXT VARCHAR2(60) NULL,ADDR_LINE5_TXT VARCHAR2(60) NULL,CITY_NM VARCHAR2(60) NOT NULL,ST_CD VARCHAR2(2) NULL,PSTL_CD VARCHAR2(10) NULL,CNTRY_CD VARCHAR2(2) NOT NULL,LAT_NBR NUMBER NOT NULL,LNG_NBR NUMBER NOT NULL,SCHN_EFS_LOC_TYP_CD NUMBER NOT NULL,SCHN_EFS_LOC_NM VARCHAR2(60) NOT NULL,ACTV_FLG VARCHAR2(1) NOT NULL);

DROP TABLE IF EXISTS SCHN_EFS_LOC_XREF;
CREATE TABLE SCHN_EFS_LOC_XREF (SCHN_LOC_ID NUMBER NOT NULL,SCHN_EFS_LOC_SRC_SYS_CD NUMBER NOT NULL,CRT_SYSUSR_ID VARCHAR2(24) NOT NULL,CRT_TS TIMESTAMP NOT NULL,LAST_UPD_SYSUSR_ID VARCHAR2(24) NOT NULL,LAST_UPD_TS TIMESTAMP NOT NULL,SRC_LOC_ID VARCHAR2(50) NOT NULL);
DROP TABLE IF EXISTS SCHN_SHPG_LANE;
CREATE TABLE SCHN_SHPG_LANE (SCHN_SHPG_LANE_ID NUMBER NOT NULL,CRT_SYSUSR_ID VARCHAR2(24) NOT NULL,CRT_TS TIMESTAMP NOT NULL,LAST_UPD_SYSUSR_ID VARCHAR2(24) NOT NULL,LAST_UPD_TS TIMESTAMP NOT NULL,ORIG_SCHN_LOC_ID NUMBER NOT NULL,SHP_TO_SCHN_LOC_ID NUMBER NOT NULL,SCHN_SHPG_LANE_NM VARCHAR2(60) NOT NULL,ACTV_FLG VARCHAR2(1) NOT NULL);
DROP TABLE IF EXISTS SCHN_SHPG_LANE_LOAD_GRP;
CREATE TABLE SCHN_SHPG_LANE_LOAD_GRP (SCHN_SHPG_LANE_LOAD_GRP_ID NUMBER NOT NULL,CRT_SYSUSR_ID VARCHAR2(24) NOT NULL,CRT_TS TIMESTAMP NOT NULL,LAST_UPD_SYSUSR_ID VARCHAR2(24) NOT NULL,LAST_UPD_TS TIMESTAMP NOT NULL,SCHN_SHPG_LANE_ID NUMBER NOT NULL,EFF_BGN_DT DATE NOT NULL,EFF_END_DT DATE NOT NULL,SHPG_LANE_LOAD_GRP_NM VARCHAR2(60) NOT NULL);
DROP TABLE IF EXISTS SCHN_SHLANE_LGRP_VNDR;
CREATE TABLE SCHN_SHLANE_LGRP_VNDR (SCHN_SHLANE_LGRP_VNDR_ID NUMBER NOT NULL,CRT_SYSUSR_ID VARCHAR2(24) NOT NULL,CRT_TS TIMESTAMP NOT NULL,LAST_UPD_SYSUSR_ID VARCHAR2(24) NOT NULL,LAST_UPD_TS TIMESTAMP NOT NULL,MBAS_MVNDR_NBR VARCHAR2(20) NOT NULL,MBAS_DEPT_NBR VARCHAR2(20) NOT NULL,SCHN_SHPG_LANE_LOAD_GRP_ID NUMBER NOT NULL,EFF_BGN_DT DATE NOT NULL,EFF_END_DT DATE NOT NULL,MER_BASE_CD NUMBER NOT NULL);
DROP TABLE IF EXISTS MVNDR;
CREATE TABLE MVNDR (MVNDR_NBR INTEGER NOT NULL,MER_DEPT_NBR SMALLINT NOT NULL,MVNDR_NM CHAR(24) NOT NULL,MVNDR_TYP_CD CHAR(1) NOT NULL,MSTR_MVNDR_NBR INTEGER NULL,CVNDR_NBR INTEGER NULL,CRT_DT DATE NOT NULL,EDI_FLG CHAR(1) NOT NULL,AD_COOP_FLG CHAR(1) NOT NULL,REBT_FLG CHAR(1) NOT NULL,CAPTN_BYO_NBR SMALLINT NOT NULL,UPC_DT DATE NULL,RQST_DEL_DT DATE NULL,CURR_CURNC_TYP_CD CHAR(3) NOT NULL,PREV_CURNC_TYP_CD CHAR(3) NOT NULL,OLD_CURNC_TYP_CD CHAR(3) NOT NULL,CURR_EXCH_RT DECIMAL NULL,CURR_EXCH_EFF_DT DATE NULL,PREV_EXCH_RT DECIMAL NULL,PREV_EXCH_EFF_DT DATE NULL,OLD_EXCH_RT DECIMAL NULL,OLD_EXCH_EFF_DT DATE NULL,GST_ID CHAR(10) NULL,MVNDR_STAT_CD SMALLINT NOT NULL,PRTNR_ID CHAR(15) NULL,LAST_UPD_TS TIMESTAMP NOT NULL,LAST_UPD_USER_ID CHAR(8) NOT NULL,INCOTERM_CD CHAR(3) NOT NULL,THD_PLIAB_INSR_FLG CHAR(1) NOT NULL,PLIAB_CHRGB_FLG CHAR(1) NOT NULL,THD_IMPREC_FLG CHAR(1) NOT NULL,EDI_PAYMT_METH_CD CHAR(1) NOT NULL,THD_WIRE_FEE_FLG CHAR(1) NOT NULL,FRTFWD_USE_FLG CHAR(1) NOT NULL,SHPCON_TYP_CD CHAR(4) NOT NULL,MER_COST_BASIS_IND CHAR(1) NOT NULL,CERT_RECV_FLG CHAR(1) NOT NULL,PVNDR_NBR INTEGER NOT NULL,LONG_MVNDR_NM VARCHAR(100) NULL,MAX_DROP_CHRG_AMT SMALLINT NULL,PALLET_CHRG_AMT DECIMAL NULL,SO_SHP_DIR_FLG CHAR(1) NOT NULL,INSP_REQD_FLG CHAR(1) NOT NULL,MAX_DSTRY_DOL_AMT SMALLINT NULL,REPL_PART_FLG CHAR(1) NOT NULL,RGA_REQD_FLG CHAR(1) NOT NULL,RSTK_DOL_AMT SMALLINT NULL,RSTK_PCT DECIMAL NULL,RTV_FRT_TRM_CD CHAR(1) NOT NULL,RTV_TYP_CD CHAR(2) NOT NULL,RTV_CMT_TXT CHAR(50) NULL,SHPG_INSTR_TXT CHAR(20) NULL);


DROP TABLE IF EXISTS DUAL;
CREATE TABLE DUAL (DUMMY VARCHAR2(1) NOT NULL);


DROP TABLE IF EXISTS SCHN_COLLAB_RPT_TYP_CD;
CREATE TABLE SCHN_COLLAB_RPT_TYP_CD
(
   SCHN_COLLAB_RPT_TYP_CD decimal(5,0) PRIMARY KEY NOT NULL,
   LAST_UPD_SYSUSR_ID varchar2(24) NOT NULL,
   LAST_UPD_TS timestamp NOT NULL
);

DROP TABLE IF EXISTS N_SCHN_COLLAB_RPT_TYP;
CREATE TABLE N_SCHN_COLLAB_RPT_TYP
(
   SCHN_COLLAB_RPT_TYP_CD decimal(5,0) NOT NULL,
   LANG_CD varchar2(5) NOT NULL,
   LAST_UPD_SYSUSR_ID varchar2(24) NOT NULL,
   LAST_UPD_TS timestamp NOT NULL,
   D_TYP_CD varchar2(10) NOT NULL,
   S_TYP_DESC varchar2(20) NOT NULL,
   TYP_DESC varchar2(150) NOT NULL,
   PRIMARY KEY (SCHN_COLLAB_RPT_TYP_CD,LANG_CD)
);

DROP TABLE IF EXISTS SCHN_COLLAB_RPT_CD;
CREATE TABLE SCHN_COLLAB_RPT_CD
(
   SCHN_COLLAB_RPT_CD decimal(5,0) PRIMARY KEY NOT NULL,
   LAST_UPD_SYSUSR_ID varchar2(24) NOT NULL,
   LAST_UPD_TS timestamp NOT NULL
);

DROP TABLE IF EXISTS N_SCHN_COLLAB_RPT;
CREATE TABLE N_SCHN_COLLAB_RPT
(
   SCHN_COLLAB_RPT_CD decimal(5,0) NOT NULL,
   LANG_CD varchar2(5) NOT NULL,
   LAST_UPD_SYSUSR_ID varchar2(24) NOT NULL,
   LAST_UPD_TS timestamp NOT NULL,
   D_SCHN_COLLAB_RPT_CD varchar2(10) NOT NULL,
   S_SCHN_COLLAB_RPT_DESC varchar2(20) NOT NULL,
   SCHN_COLLAB_RPT_DESC varchar2(150) NOT NULL,
   PRIMARY KEY (SCHN_COLLAB_RPT_CD,LANG_CD)
);