package com.homedepot.di.xd.efs.businesshelper;

import java.util.List;

import com.homedepot.di.xd.efs.dao.ReportTypeDAO;
import com.homedepot.di.xd.efs.exception.DataOperationException;
import com.homedepot.di.xd.efs.exception.ReportTypeException;
import com.homedepot.di.xd.efs.to.ReportTypeTO;

public class ReportTypeManager{

	public static List<ReportTypeTO> getReportTypeCodes() throws ReportTypeException{
		try {
			return ReportTypeDAO.getReportTypeCodes();
		} catch (DataOperationException e) {
			throw new ReportTypeException(e.getMessage(), e);
		}
	}
}
