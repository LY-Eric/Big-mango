package com.eric.education.dao;

import java.util.List;

import com.eric.education.model.SignDetail;
import com.eric.education.model.SignDetailQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SignDetailDao {
    int countByExample(SignDetailQuery example);

    int deleteByExample(SignDetailQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(SignDetail record);

    int insertSelective(SignDetail record);

    List<SignDetail> selectByExample(SignDetailQuery example);

    SignDetail selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SignDetail record, @Param("example") SignDetailQuery example);

    int updateByExample(@Param("record") SignDetail record, @Param("example") SignDetailQuery example);

    int updateByPrimaryKeySelective(SignDetail record);

    int updateByPrimaryKey(SignDetail record);
}