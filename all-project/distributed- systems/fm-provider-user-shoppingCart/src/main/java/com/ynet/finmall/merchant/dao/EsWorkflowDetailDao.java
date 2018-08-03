package com.ynet.finmall.merchant.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ynet.finmall.user.model.EsWorkflowDetail;
import com.ynet.finmall.user.model.EsWorkflowDetailQuery;

public interface EsWorkflowDetailDao {
    int countByExample(EsWorkflowDetailQuery example);

    int deleteByExample(EsWorkflowDetailQuery example);

    int deleteByPrimaryKey(String workflowDetailId);

    int insert(EsWorkflowDetail record);

    int insertSelective(EsWorkflowDetail record);

    List<EsWorkflowDetail> selectByExample(EsWorkflowDetailQuery example);

    EsWorkflowDetail selectByPrimaryKey(String workflowDetailId);

    int updateByExampleSelective(@Param("record") EsWorkflowDetail record, @Param("example") EsWorkflowDetailQuery example);

    int updateByExample(@Param("record") EsWorkflowDetail record, @Param("example") EsWorkflowDetailQuery example);

    int updateByPrimaryKeySelective(EsWorkflowDetail record);

    int updateByPrimaryKey(EsWorkflowDetail record);
}