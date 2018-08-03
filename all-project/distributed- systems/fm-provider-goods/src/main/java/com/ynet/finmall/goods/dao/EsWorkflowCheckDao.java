package com.ynet.finmall.goods.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.ynet.finmall.goods.model.EsWorkflowCheck;
import com.ynet.finmall.goods.model.EsWorkflowCheckQuery;

public interface EsWorkflowCheckDao {
    int countByExample(EsWorkflowCheckQuery example);

    int deleteByExample(EsWorkflowCheckQuery example);

    int deleteByPrimaryKey(String checkId);

    int insert(EsWorkflowCheck record);

    int insertSelective(EsWorkflowCheck record);

    List<EsWorkflowCheck> selectByExample(EsWorkflowCheckQuery example);

    EsWorkflowCheck selectByPrimaryKey(String checkId);

    int updateByExampleSelective(@Param("record") EsWorkflowCheck record, @Param("example") EsWorkflowCheckQuery example);

    int updateByExample(@Param("record") EsWorkflowCheck record, @Param("example") EsWorkflowCheckQuery example);

    int updateByPrimaryKeySelective(EsWorkflowCheck record);

    int updateByPrimaryKey(EsWorkflowCheck record);
}