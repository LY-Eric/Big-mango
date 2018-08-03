package com.ynet.finmall.assets.exception;

import org.junit.Test;

import com.ynet.exception.FinMallException;
import com.ynet.finmall.merchant.exception.ErrorConstants;

/**
 * 
 * @author liuxin
 *
 */
public class FinMallExceptionTest {

	@Test
	public void es(){
		throw new FinMallException(ErrorConstants.PARAM_ERROR);
	}
	
}
