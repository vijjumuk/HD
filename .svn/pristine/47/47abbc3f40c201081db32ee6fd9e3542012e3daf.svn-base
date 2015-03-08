package com.homedepot.di.xd.efs.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.homedepot.di.xd.efs.to.ScheduleOrderDayTO;
import com.homedepot.di.xd.efs.to.ScheduleTO;
import com.homedepot.homer.util.HomerUnitTestCase;

/**
 * The class <code>ScheduleUploadDAOTest</code> contains tests for the class <code>{@link ScheduleUploadDAO}</code>.
 *
 * @generatedBy CodePro at 3/6/15 6:30 PM
 * @author 565581
 * @version $Revision: 1.0 $
 */
public class ScheduleUploadDAOTest extends HomerUnitTestCase {


	/**
	 * Run the boolean createSchedule(ScheduleTO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/6/15 6:30 PM
	 */
	@Test(expected = com.homedepot.di.xd.efs.exception.EFSException.class)
	public void testCreateSchedule()
		throws Exception {
		ScheduleTO scheduleTO = new ScheduleTO();
		scheduleTO.setScheduleGroupCode((short) 1);
		scheduleTO.setScheduleName("");
		scheduleTO.setEffectiveBeginDate(new Date(1L));
		scheduleTO.setEffectiveEndDate(new Date(1L));
		scheduleTO.setScheduleId(1);

		boolean result = ScheduleUploadDAO.createSchedule(scheduleTO);

		// add additional test code here
		assertTrue(result);
	}


	/**
	 * Run the boolean createScheduleOrderDay(ScheduleOrderDayTO) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/6/15 6:30 PM
	 */
	@Test
	public void testCreateScheduleOrderDay_1()
		throws Exception {
		ScheduleOrderDayTO orderDayTo = new ScheduleOrderDayTO();

		boolean result = ScheduleUploadDAO.createScheduleOrderDay(orderDayTo);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the int getNextSeqId(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/6/15 6:30 PM
	 */
	@Test(expected = com.homedepot.di.xd.efs.exception.EFSException.class)
	public void testGetNextSeqId_1()
		throws Exception {
		String seqQuery = "";

		int result = ScheduleUploadDAO.getNextSeqId(seqQuery);

		// add additional test code here
		assertEquals(0, result);
	}

	/**
	 * Run the boolean insertRecords(List<ScheduleTO>,List<ScheduleTO>) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 3/6/15 6:30 PM
	 */
	@Test
	public void testInsertRecords_1()
		throws Exception {
		List<ScheduleTO> laneTOList = new LinkedList();
		List<ScheduleTO> inValidLaneTOList = new LinkedList();

		boolean result = ScheduleUploadDAO.insertRecords(laneTOList, inValidLaneTOList);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 3/6/15 6:30 PM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 3/6/15 6:30 PM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 3/6/15 6:30 PM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(ScheduleUploadDAOTest.class);
	}
}