package com.eric.education.dao;

import com.eric.education.model.File;
import com.eric.education.model.FileQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FileDao {
    int countByExample(FileQuery example);

    int deleteByExample(FileQuery example);

    int deleteByPrimaryKey(Integer id);

    int insert(File record);

    int insertSelective(File record);

    List<File> selectByExample(FileQuery example);

    File selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") File record, @Param("example") FileQuery example);

    int updateByExample(@Param("record") File record, @Param("example") FileQuery example);

    int updateByPrimaryKeySelective(File record);

    int updateByPrimaryKey(File record);
}