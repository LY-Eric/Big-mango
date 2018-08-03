package com.ynet.finmall.gateway.jxbank;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ynet.finmall.core.FMConfig;
import com.ynet.finmall.gateway.jxbank.request.AccInfoOpenAccRequest;
import com.ynet.finmall.gateway.jxbank.request.TradeDetailsQueryTradeListRequest;
import com.ynet.finmall.gateway.jxbank.service.JxbankGateway;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FMConfig.class})
public class HttpClientTest {

	@Autowired
	private JxbankGateway jxbankGateway;
	
	@Test
	public void accInfo_openAcc(){
		AccInfoOpenAccRequest request = new AccInfoOpenAccRequest();
		
		/**
		 * ----请求报文----:{"id_startdate":"2017-10-10","primary_account":"6221321104849734","open_date":"2017-09-11","sign_data":"65a4b29b63ee862e0a9a0a2efd7060cf","id_enddate":"2027-10-10","job":"1","open_tradetime":"2017-09-11 16:53:20","serial_no":"e37bf11a67b94688b4d9e4666f6830c4","account_property":"1","account_name":"张三","sign_name":"北京市来广营派出所","app_no":"32","channel_no":"0001","id_no":"522722198005129716","mobile":"1369876543"}
		 * ----响应报文----:{"sign_data":"10b282a16e43daebc763f610673856e8","recode":"000000","recode_info":"交易成功","account_no":"666601000000019982","customer_no":"22000092"}
		 */
		request.setAccount_property("1");
		request.setJob("1");
		request.setSerial_no(UUID.randomUUID().toString().replaceAll("-", ""));
		request.setAccount_name("张三");
		request.setId_no("522722198005129716");
		request.setId_startdate("2017-10-10");
		request.setId_enddate("2027-10-10");
		request.setSign_name("北京市来广营派出所");
		request.setMobile("1369876543");
		request.setPrimary_account("6221321104849734");
		request.setOpen_date("2017-09-11");
		request.setOpen_tradetime("2017-09-11 16:53:20");
		
		jxbankGateway.accInfo_openAcc(request);
	}
	
	@Test
	public void  tradeDetails_queryTradeList(){
		TradeDetailsQueryTradeListRequest request = new TradeDetailsQueryTradeListRequest();
		request.setAccount_no("666601000000018726");
		request.setTrans_date("2017-12-19");
//		request.setSerial_no("31201801051353331515131615");
		request.setSerial_no(UUID.randomUUID().toString().replaceAll("-", ""));
		
		jxbankGateway.tradeDetails_queryTradeList(request);
	}
	

//	@Test
//	public void  tradeDetails_queryTradeList(){
//		TradeDetailsQueryTradeListRequest request = new TradeDetailsQueryTradeListRequest();
//		request.setAccount_no("666601000000018726");
//		request.setTrans_date("2017-12-19");
////		request.setSerial_no("31201801051353331515131615");
//		request.setSerial_no(UUID.randomUUID().toString().replaceAll("-", ""));
//		
//		jxbankGateway.tradeDetails_queryTradeList(request);
//	}
	
}
