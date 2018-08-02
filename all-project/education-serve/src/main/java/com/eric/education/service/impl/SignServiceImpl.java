package com.eric.education.service.impl;

import com.eric.education.dao.SignCalcDao;
import com.eric.education.dao.SignDetailDao;
import com.eric.education.model.SignCalc;
import com.eric.education.model.SignCalcQuery;
import com.eric.education.model.SignDetail;
import com.eric.education.model.SignDetailQuery;
import com.eric.education.service.ISignService;
import com.eric.education.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<SignDetail> queryCondition(Integer userId, Date date1, Date date2){

        SignDetailQuery query = new SignDetailQuery();
        SignDetailQuery.Criteria criteria = query.createCriteria();

        criteria.andUserIdEqualTo(userId);
        criteria.andSigndateBetween(date1, date2);

        List<SignDetail> signDetails = signDetailDao.selectByExample(query);

        if (signDetails != null && !signDetails.isEmpty()) {

            return signDetails;
        }

        return null;
    }

    @Override
    public List<SignDetail> signToday(Integer userId) {

        List<SignDetail> signDetails = queryCondition(userId, DateUtils.getTodayStartTime(), DateUtils.getTodayEndTime());

        return signDetails;
    }

    @Override
    public List<SignDetail> yesterdayDetail(Integer userId) {

        List<SignDetail> signDetails = queryCondition(userId, DateUtils.getPreDayStartTime(), DateUtils.getPreDayEndTime());

        return signDetails;
    }

    @Override
    public List<SignCalc> signCalc(Integer userId) {

        SignCalcQuery query = new SignCalcQuery();
        query.createCriteria().andUserIdEqualTo(userId);
        List<SignCalc> signCalcs = signCalcDao.selectByExample(query);

        if (signCalcs != null && !signCalcs.isEmpty()) {

            return signCalcs;
        }

        return null;
    }

    @Override
    public void addSignDetail(Integer userId) {

        SignDetail signDetail = new SignDetail();
        signDetail.setUserId(userId);
        signDetail.setSigndate(new Date());

        signDetailDao.insert(signDetail);
    }

    @Override
    public void addSignCalc(Integer userId) {

        SignCalc signCalc = new SignCalc();
        signCalc.setContinueDays(1);
        signCalc.setUserId(userId);

        signCalcDao.insert(signCalc);
    }

    @Override
    public void updateSignCalc(Integer userId, Integer times) {
        SignCalcQuery query = new SignCalcQuery();
        SignCalcQuery.Criteria criteria = query.createCriteria();
        criteria.andUserIdEqualTo(userId);

        List<SignCalc> signCalcs = signCalcDao.selectByExample(query);
        SignCalc signCalc = signCalcs.get(0);

        signCalc.setContinueDays(signCalc.getContinueDays() + times);

        signCalcDao.updateByPrimaryKey(signCalc);
    }

}
