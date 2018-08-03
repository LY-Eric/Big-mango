package com.eric.education.service.impl;

import com.eric.education.dao.SignCalcDao;
import com.eric.education.dao.SignDetailDao;
import com.eric.education.exception.ErrorConstants;
import com.eric.education.model.SignCalc;
import com.eric.education.model.SignCalcQuery;
import com.eric.education.model.SignDetail;
import com.eric.education.model.SignDetailQuery;
import com.eric.education.response.SignResponse;
import com.eric.education.service.ISerialNumber;
import com.eric.education.service.ISignService;
import com.eric.education.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author liuyang
 * @create 2018-05-31 14:57
 * @desc
 */
@Service
public class SignServiceImpl implements ISignService {

    @Autowired
    private SignDetailDao signDetailDao;
    @Autowired
    private SignCalcDao signCalcDao;
    @Autowired
    @Qualifier("serialNumber")
    private ISerialNumber serialNumber;

    public SignResponse queryCondition(SignResponse response, String userId, Date date1, Date date2){

        SignDetailQuery query = new SignDetailQuery();
        SignDetailQuery.Criteria criteria = query.createCriteria();

        criteria.andUserIdEqualTo(userId);
        criteria.andSignDateBetween(date1, date2);

        List<SignDetail> signDetails = signDetailDao.selectByExample(query);
        if (signDetails != null && !signDetails.isEmpty()) {
            response.setSignDetail(signDetails.get(0));
            return response;
        }

        return null;
    }

    @Override
    public SignResponse signToday(String userId) {

        SignResponse response = new SignResponse();

        if (StringUtils.isBlank(userId)) {
            response.setReturnMsg("当前登录用户ID为空");
            response.setReturnCode(ErrorConstants.PARAM_NULL);
            return response;
        }

        return queryCondition(response, userId, DateUtils.getTodayStartTime(), DateUtils.getTodayEndTime());
    }

    @Override
    public SignResponse yesterdayDetail(String userId) {
        SignResponse response = new SignResponse();

        if (StringUtils.isBlank(userId)) {
            response.setReturnMsg("当前登录用户ID为空");
            response.setReturnCode(ErrorConstants.PARAM_NULL);
            return response;
        }

        return queryCondition(response, userId, DateUtils.getPreDayStartTime(), DateUtils.getPreDayEndTime());
    }

    @Override
    public SignResponse signCalc(String userId) {
        SignResponse response = new SignResponse();

        if (StringUtils.isBlank(userId)) {
            response.setReturnMsg("当前登录用户ID为空");
            response.setReturnCode(ErrorConstants.PARAM_NULL);
            return response;
        }

        SignCalcQuery query = new SignCalcQuery();
        SignCalcQuery.Criteria criteria = query.createCriteria();
        criteria.andUserIdEqualTo(userId);

        List<SignCalc> signCalc = signCalcDao.selectByExample(query);
        if (signCalc != null && !signCalc.isEmpty()) {
            response.setSignCalc(signCalc.get(0));
            return response;
        }

        return null;
    }

    @Override
    public void addSignDetail(String userId) {
        SignDetail signDetail = new SignDetail();
        signDetail.setUserId(userId);
        signDetail.setSignDetailId(serialNumber.getUUID());
        signDetail.setSignDate(new Date());

        signDetailDao.insert(signDetail);
    }

    @Override
    public void addSignCalc(String userId) {
        SignCalc signCalc = new SignCalc();
        signCalc.setContinueDays(1L);
        signCalc.setSignId(serialNumber.getUUID());
        signCalc.setUserId(userId);

        signCalcDao.insert(signCalc);
    }

    @Override
    public void updateSignCalc(String userId, Long times) {
        SignCalcQuery query = new SignCalcQuery();
        SignCalcQuery.Criteria criteria = query.createCriteria();
        criteria.andUserIdEqualTo(userId);

        List<SignCalc> signCalcs = signCalcDao.selectByExample(query);
        SignCalc signCalc = signCalcs.get(0);

        signCalc.setContinueDays(signCalc.getContinueDays() + times);

        signCalcDao.updateByPrimaryKey(signCalc);
    }

}
