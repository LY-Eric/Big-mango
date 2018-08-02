package com.eric.education.service;

import com.eric.education.model.File;

import java.util.List;

/**
 * @author Eric
 * @create 2018-06-18 上午1:03
 * @desc
 */
public interface IFileService {

    /**
     * 保存文件
     * @param file
     */
    void insertFile(File file);

    /**
     * 根据用户ID查询所有的照片info
     * @param id
     * @return
     */
    List<String> queryAllFileByUserId(Integer id);
}
