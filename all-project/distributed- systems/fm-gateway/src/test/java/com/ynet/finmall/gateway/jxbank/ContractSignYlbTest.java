package com.ynet.finmall.gateway.jxbank;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ynet.finmall.core.FMConfig;
import com.ynet.finmall.gateway.jxbank.request.JxContractSignYlbRequest;
import com.ynet.finmall.gateway.jxbank.response.JxContractSignYlbResponse;
import com.ynet.finmall.gateway.jxbank.service.JxbankGateway;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FMConfig.class})
public class ContractSignYlbTest {

	@Autowired
	private JxbankGateway jxbankGateway;
	
	@Test
	public void contractSignYlb(){
		JxContractSignYlbRequest request = new JxContractSignYlbRequest();
		request.setApply_id("1");
		request.setComerchant_apply_no("2");
		request.setContract_file("453483244");
		request.setCustomer("zhangsan");
		request.setPro_id("4345");
		request.setTrans_date("2017-09-11");
		request.setTrans_tradetime("2017-09-11 16:53:20");

		JxContractSignYlbResponse contractSignYlbResponse = jxbankGateway.contractSignYlb(request);
		//System.out.println("=========="+contractSignYlbResponse.toString());
	}
	
}
