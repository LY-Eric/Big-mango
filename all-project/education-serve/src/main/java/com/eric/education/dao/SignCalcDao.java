package com.eric.education.dao;

import com.eric.education.model.SignCalc;
import java.util.List;

import com.eric.education.model.SignCalcQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SignCalcDao {

    int countByExample(SignCalcQuery example);

    int deleteByExample(SignCalcQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(SignCalc record);

    int insertSelective(SignCalc record);

    List<SignCalc> selectByExample(SignCalcQuery example);

    SignCalc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SignCalc record, @Param("example") SignCalcQuery example);

    int updateByExample(@Param("record") SignCalc record, @Param("example") SignCalcQuery example);

    int updateByPrimaryKeySelective(SignCalc record);

    int updateByPrimaryKey(SignCalc record);
}