package com.ynet.finmall.merchant.server.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ynet.finmall.merchant.server.ExampleServer;

@Component("exampleServer")
public class ExampleServerImpl implements ExampleServer{

	private static Logger logger = LoggerFactory.getLogger(ExampleServerImpl.class);

	@Override
	public String es() {
		logger.debug("exampleServerImpl.es");
		return null;
	}

}
