package com.eric.education.service.impl;

import com.eric.education.common.enums.CommonStatus;
import com.eric.education.dao.FileDao;
import com.eric.education.model.File;
import com.eric.education.model.FileQuery;
import com.eric.education.service.IFileService;
import com.eric.education.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eric
 * @create 2018-06-18 上午1:03
 * @desc
 */
@Service
public class FileServiceImpl implements IFileService {

    @Autowired
    private FileDao fileDao;

    @Override
    public void insertFile(File file) {

        file.setCreateTime(DateUtils.getNowTime());
        file.setUpdateTime(DateUtils.getNowTime());
        file.setFileStatus(CommonStatus.NORMAL.getCode());

        fileDao.insertSelective(file);
    }

    @Override
    public List<String> queryAllFileByUserId(Integer id) {
        FileQuery query = new FileQuery();
        query.createCriteria().andUserIdEqualTo(id);

        List<File> fileList = fileDao.selectByExample(query);
        List<String> urlList = new ArrayList<>();
        if (fileList != null && !fileList.isEmpty()){
            fileList.stream().forEach(value ->{
                urlList.add(value.getFileAddress());
            });
        }

        return urlList;
    }
}
