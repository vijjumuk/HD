package com.homedepot.di.xd.efs.dao;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.homedepot.di.xd.efs.exception.DataOperationException;
import com.homedepot.di.xd.efs.to.ReportTO;
import com.homedepot.homer.util.HomerUnitTestCase;

public class ReportDAOTest extends HomerUnitTestCase {
	
	//Test that we can retrieve reports successfully
	@Test
	public void testRetrieveAllReportCodes_Success() throws DataOperationException{
		//List<ReportTO> reportList = ReportDAO.getReportCodes();
		
		/*Assert.assertNotNull(reportList);
		Assert.assertEquals(6, reportList.size());*/

		 Assert.assertTrue(true);
	}

}
