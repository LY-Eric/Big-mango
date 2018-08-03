package com.ynet.finmall.merchant.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ynet.finmall.merchant.model.EsWorkflow;
import com.ynet.finmall.merchant.model.EsWorkflowQuery;

public interface EsWorkflowDao {
    int countByExample(EsWorkflowQuery example);

    int deleteByExample(EsWorkflowQuery example);

    int deleteByPrimaryKey(String workflowId);

    int insert(EsWorkflow record);

    int insertSelective(EsWorkflow record);

    List<EsWorkflow> selectByExample(EsWorkflowQuery example);

    EsWorkflow selectByPrimaryKey(String workflowId);

    int updateByExampleSelective(@Param("record") EsWorkflow record, @Param("example") EsWorkflowQuery example);

    int updateByExample(@Param("record") EsWorkflow record, @Param("example") EsWorkflowQuery example);

    int updateByPrimaryKeySelective(EsWorkflow record);

    int updateByPrimaryKey(EsWorkflow record);
}