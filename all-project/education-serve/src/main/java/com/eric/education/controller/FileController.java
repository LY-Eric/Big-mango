package com.eric.education.controller;

import com.eric.education.model.File;
import com.eric.education.common.enums.ResultCode;
import com.eric.education.model.User;
import com.eric.education.result.EducationResult;
import com.eric.education.service.IFileService;
import com.eric.education.service.IRedisService;
import com.eric.education.service.IUserService;
import com.eric.education.utils.DateUtils;
import com.eric.education.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import net.sf.json.JSONArray;

import static com.eric.education.utils.FtpUtils.uploadFile;


/**
 * @author Eric
 * @create 2018-06-17 上午12:47
 * @desc
 */
@Controller
@RequestMapping("/file")
public class FileController {

    private static Logger log = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private IFileService fileService;
    @Autowired
    private IRedisService redisService;
    @Autowired
    private IUserService userService;

    @Value("${local.path}")
    private String localPath;
    @Value("${ftp.host}")
    private String host;
    @Value("${ftp.username}")
    private String username;
    @Value("${ftp.password}")
    private String password;
    @Value("${ftp.basepath}")
    private String basepath;
    @Value("${ftp.port}")
    private String port;
    @Value(("${image.serve}"))
    private String imageServe;

    @Value("${REDIS.TOKEN.KEY}")
    private String REDIS_TOKEN_KEY;

    @RequestMapping("/upload")
    @ResponseBody
    public EducationResult uploadPicture(HttpServletRequest request, HttpServletResponse response, String token) throws Exception {

        EducationResult result = new EducationResult();

        //从redis中拿到用户openid
        String userInfo = (String) redisService.get(REDIS_TOKEN_KEY + ":" + token);
        if (StringUtils.isEmpty(userInfo)){
            result.setStatus(ResultCode.FAIL.getCode());
            result.setMsg("登录信息不存在，请重新登录");
            return result;
        }
        String openId = userInfo.split(",")[1];
        User user = userService.queryUserByOpenId(openId);

        //设置编码
        request.setCharacterEncoding("utf-8");


        try {
            StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
            Iterator<String> iterator = req.getFileNames();
            while (iterator.hasNext()) {
                MultipartFile file = req.getFile(iterator.next());

                // 获取文件名
                String fileNames = file.getOriginalFilename();
                int split = fileNames.lastIndexOf(".");
                //获取上传文件的后缀
                String extName = fileNames.substring(split + 1, fileNames.length());
                //申明UUID
                String uuid = UUID.randomUUID().toString().replace("-", "");
                //组成新的图片名称
                String newName = uuid + "." + extName;
                String filepath = new SimpleDateFormat("yyyy-MM-dd").format(DateUtils.getNowTime());
                InputStream in = file.getInputStream();

                boolean flag = uploadFile(host, Integer.valueOf(port), username, password, basepath, filepath, newName, in);
                if (flag) {
                    log.info("图片上传成功");
                    //将上传图片信息存入库中
                    File newFile = new File();
                    newFile.setUserId(user.getId());
                    newFile.setFileAddress(imageServe + filepath + "/" + newName);
                    fileService.insertFile(newFile);
//                    res.put("url", imageServe + filepath + "/" + newName);
//                    jsonArray.add(res);
                }else {
                    log.info("图片上传失败");
                    result.setStatus(ResultCode.FAIL.getCode());
                    result.setMsg("图片上传失败");
                    return result;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        //返回前端用户所有的照片info
        HashMap<String, Object> res = new HashMap<>(16);
//        JSONArray jsonArray = new JSONArray();
        List<String> urlList = fileService.queryAllFileByUserId(user.getId());
        JSONArray json = JSONArray.fromObject(urlList);
        System.out.println(json);
        result.setData(json);
        return result;

    }

}
