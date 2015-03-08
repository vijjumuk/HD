package com.homedepot.di.xd.efs.exception;

import org.junit.Test;

public class EFSExceptionTest {

	@Test(expected = EFSException.class)
	public void testEngineeredFlowException()
			throws EFSException {
		// EngineeredFlowScheduleException exception = new
		// EngineeredFlowScheduleException();
		throw new EFSException();

	}

	@Test(expected = EFSException.class)
	public void testEngineeredFlowExceptionWithErrorMessage()
			throws EFSException {
		// EngineeredFlowScheduleException exception = new
		// EngineeredFlowScheduleException();
		throw new EFSException("Exception Occured");

	}
	
	@Test(expected = EFSException.class)
	public void testEngineeredFlowExceptionWithErrorMessageAndErrorCode()
			throws EFSException {
		// EngineeredFlowScheduleException exception = new
		// EngineeredFlowScheduleException();
		throw new EFSException("Exception Occured",1);

	}
	
	@Test(expected = EFSException.class)
	public void testEngineeredFlowExceptionWithWarning()
			throws EFSException {
		// EngineeredFlowScheduleException exception = new
		// EngineeredFlowScheduleException();
		throw new EFSException("Exception Occured",1,true);

	}
	
	@Test(expected = EFSException.class)
	public void testEngineeredFlowExceptionWithErrMsgAndCause()
			throws EFSException {
		// EngineeredFlowScheduleException exception = new
		Throwable cause = null;
		throw new EFSException("Exception Occured",cause);

	}

}
