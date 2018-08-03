package com.ynet.finmall.order.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ynet.finmall.file.model.EsWorkflowCheckDetail;
import com.ynet.finmall.file.model.EsWorkflowCheckDetailQuery;

public interface EsWorkflowCheckDetailDao {
    int countByExample(EsWorkflowCheckDetailQuery example);

    int deleteByExample(EsWorkflowCheckDetailQuery example);

    int deleteByPrimaryKey(String workflowResultId);

    int insert(EsWorkflowCheckDetail record);

    int insertSelective(EsWorkflowCheckDetail record);

    List<EsWorkflowCheckDetail> selectByExample(EsWorkflowCheckDetailQuery example);

    EsWorkflowCheckDetail selectByPrimaryKey(String workflowResultId);

    int updateByExampleSelective(@Param("record") EsWorkflowCheckDetail record, @Param("example") EsWorkflowCheckDetailQuery example);

    int updateByExample(@Param("record") EsWorkflowCheckDetail record, @Param("example") EsWorkflowCheckDetailQuery example);

    int updateByPrimaryKeySelective(EsWorkflowCheckDetail record);

    int updateByPrimaryKey(EsWorkflowCheckDetail record);
}