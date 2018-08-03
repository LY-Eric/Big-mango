package com.ynet.finmall.order.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ynet.finmall.common.constant.ParamConstants;
import com.ynet.finmall.common.server.SerialNumber;
import com.ynet.finmall.redis.server.SharedJedisUtils;


/**
 * 注解的Handler
 */
@Controller
public class ExampleController {

	private static final Logger logger = LoggerFactory.getLogger(ExampleController.class);

	@Autowired
	@Qualifier("serialNumber")
	private SerialNumber serialNumber;

	@Autowired(required=false)
	@Qualifier("sharedJedisUtils")
	private SharedJedisUtils sharedJedisUtils;

    @RequestMapping("/query")
    public void queryItem(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
//    	serialNumber.getFlow(ParamConstants.WORKFLOW);
    	Object obj = new String("zhangsan");
    	sharedJedisUtils.setObject("key", "zhangsan", 5);
    	
        PrintWriter out = response.getWriter();
        out.println();
        out.flush();
        out.close();
    }


}
