/**
 * 
 */
package com.homedepot.di.xd.efs.to;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Test;

import com.homedepot.di.xd.efs.to.ResponseTO;

/**
 * @author 588893
 *
 */
public class ResponseTOTest {

	@Test
	public void testSetAndGetReturnCode() {
		
		ResponseTO responseTo = new ResponseTO();
		int returnCode = 1;
		responseTo.setReturnCode(returnCode);
		assertEquals(returnCode, responseTo.getReturnCode());
		
	}
	
	@Test
	public void testSetAndGetReturnMessage() {
		
		ResponseTO responseTo = new ResponseTO();
		String returnMessage = "Tested Return Message";
		responseTo.setReturnMessage(returnMessage);
		assertEquals(returnMessage, responseTo.getReturnMessage());
		
	}

	@Test
	public void testSetAndGetErrorMsg(){
		
		ResponseTO responseTo = new ResponseTO();
		String errorMsg = "Tested Error Message";
		responseTo.setErrorMsg(errorMsg);
		assertEquals(errorMsg, responseTo.getErrorMsg());
	}
	
	@Test
	public void testSetAndGetResults(){
		
		ResponseTO responseTo = new ResponseTO();
		ArrayList<?> results = new ArrayList<>();
		responseTo.setResults(results);
		assertNotNull(responseTo.getResults());
		
	}
}
