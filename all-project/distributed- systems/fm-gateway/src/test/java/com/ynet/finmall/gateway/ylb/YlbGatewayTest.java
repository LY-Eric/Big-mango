package com.ynet.finmall.gateway.ylb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.ynet.finmall.core.FMConfig;
import com.ynet.finmall.gateway.jxbank.client.request.JxRepayBatchNoticeRequest;
import com.ynet.finmall.gateway.jxbank.client.response.JxRepayBatchNoticeResponse;
import com.ynet.finmall.gateway.jxbank.event.RepayDetail;
import com.ynet.finmall.gateway.jxbank.service.JxLoanRepayService;

/**
 * 娱乐宝网关测试类
 * @author qiangjiyi
 * @date 2018年1月19日 上午11:14:04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {FMConfig.class})
public class YlbGatewayTest {

	private static Logger logger = LoggerFactory.getLogger(YlbGatewayTest.class);
	
	@Autowired
	private JxLoanRepayService jxLoanRepayService;
	
	/**
	 * 测试贷款归还回调异步通知（批量）
	 */
	@Test
	public void testAccInfoQueryBalance() {
		JxRepayBatchNoticeRequest request = new JxRepayBatchNoticeRequest();
		
		request.setPro_id("1121");
		request.setBatch_serial_no("12233");
		request.setTrans_date("2017-12-24");
		request.setTrans_tradetime("2017-12-24 20:30:45");
		
		List<RepayDetail> repayList = new ArrayList<RepayDetail>();
		RepayDetail repayDetail = new RepayDetail();
		repayDetail.setRepay_serial_no("12233");
		repayDetail.setCustomer("张三");
		repayDetail.setApply_id("284729401");
		repayDetail.setReceipt_id("20180801");
		repayDetail.setPeriod(12);
		repayDetail.setTrade_amount(BigDecimal.valueOf(189000));
		repayDetail.setRepay_status(1);
		repayDetail.setRepay_note("");
		repayDetail.setFinish_flag(1);
		
		repayList.add(repayDetail);
		
		repayDetail.setRepay_serial_no("12233");
		repayDetail.setCustomer("李四");
		repayDetail.setApply_id("284729402");
		repayDetail.setReceipt_id("20180802");
		repayDetail.setPeriod(18);
		repayDetail.setTrade_amount(BigDecimal.valueOf(270000));
		repayDetail.setRepay_status(2);
		repayDetail.setRepay_note("网关通讯异常");
		repayDetail.setFinish_flag(0);
		
		repayList.add(repayDetail);
		
//		request.setRepayList(repayList);
//		request.setTrans_teller("张三");
		
		JxRepayBatchNoticeResponse response = jxLoanRepayService.repay_batch_ylb_notice(request);
		logger.info("调用贷款归还异步通知(批量)的结果为：" + JSON.toJSONString(response));
	}
	
	
}
