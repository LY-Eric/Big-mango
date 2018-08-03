package com.ynet.finmall.assets.server.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ynet.finmall.core.config.FMPropertiesSetting;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FMPropertiesSetting.class})
public class ExampleServerImplTest {

	private static Logger logger = LoggerFactory.getLogger(ExampleServerImplTest.class);

	@Value("${spring.profiles.active}")
	private String profiles;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Test
	public void ex(){
		logger.debug(username);
		logger.debug(password);
		logger.debug(profiles);
//		throw new FinMallException(ErrorConstants.PARAM_ERROR);
	}
	
}
