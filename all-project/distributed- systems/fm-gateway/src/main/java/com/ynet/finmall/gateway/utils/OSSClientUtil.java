package com.ynet.finmall.gateway.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;

public class OSSClientUtil {

	private static final Logger logger = LoggerFactory.getLogger(OSSClientUtil.class);
	/**
	 * oss上传相关参数
	 */
	private String endpoint = "http://oss-cn-qingdao.aliyuncs.com";
	private String accessKeyId = "LTAI3nl51iph58YY";
	private String accessKeySecret = "fjpsURzE4yQObi1FdimBQG1NsATzCW";
	private String bucketName = "ynetoss";

	// 文件存储目录
	Calendar date = Calendar.getInstance();
	String year = new SimpleDateFormat("yyyy").format(date.getTime());
	String month = new SimpleDateFormat("MM").format(date.getTime());
	String day = new SimpleDateFormat("dd").format(date.getTime());
	private String filedir = "scm/" + year + "/" + month + "/" + day + "/";

	private OSSClient ossClient;

	public OSSClientUtil() {
		ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}

	/**
	 * 初始化
	 */
	public void init() {
		ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
	}

	/**
	 * 销毁
	 */
	public void destory() {
		ossClient.shutdown();
	}

	/**
	 * 上传图片
	 *
	 * @param url
	 */
	public void uploadImg2Oss(String url) {
		File fileOnServer = new File(url);
		FileInputStream fin;
		try {
			fin = new FileInputStream(fileOnServer);
			String[] split = url.split("/");
			this.uploadFile2OSS(fin, split[split.length - 1]);
		} catch (FileNotFoundException e) {
			logger.error("--->>>" + e);
			// throw new FinMallException("000020");
		}
	}

	public String uploadImg2Oss(File file) {
		// if (file.length() > 3*1024 * 1024) {
		// throw new FinMallException("上传图片大小不能超过3M！");
		// }

		String fileName = file.getName();
		String substring = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
		Random random = new Random();
		String name = System.currentTimeMillis() + substring;
		try {
			InputStream inputStream = new FileInputStream(file);
			this.uploadFile2OSS(inputStream, name);
			return name;
		} catch (Exception e) {
			// throw new YwException("图片上传失败");
			logger.error("--->>>" + e);
			//throw new FinMallException("000020");
		}
		return null;
	}

	public String uploadImg2Oss(MultipartFile file) {
		// if (file.getSize() > 3*1024 * 1024) {
		// throw new YwException("上传图片大小不能超过3M！");
		// }

		String originalFilename = file.getOriginalFilename();
		String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
		Random random = new Random();
		String name = System.currentTimeMillis() + substring;
		try {
			InputStream inputStream = file.getInputStream();
			this.uploadFile2OSS(inputStream, name);
			return name;
		} catch (Exception e) {
			// throw new YwException("图片上传失败");
			logger.error("--->>>" + e);
			//throw new FinMallException("000020");
		}
		return null;
	}

	/**
	 * 获得图片路径
	 *
	 * @param fileUrl
	 * @return
	 */
	public String getImgUrl(String fileUrl) {
		if (!StringUtils.isEmpty(fileUrl)) {
			String[] split = fileUrl.split("/");
			return this.getUrl(this.filedir + split[split.length - 1]);
		}
		return null;
	}

	/**
	 * 上传到OSS服务器 如果同名文件会覆盖服务器上的
	 *
	 * @param instream
	 *            文件流
	 * @param fileName
	 *            文件名称 包括后缀名
	 * @return 出错返回"" ,唯一MD5数字签名
	 */
	public String uploadFile2OSS(InputStream instream, String fileName) {
		String ret = "";
		try {
			// 创建上传Object的Metadata
			ObjectMetadata objectMetadata = new ObjectMetadata();
			objectMetadata.setContentLength(instream.available());
			objectMetadata.setCacheControl("no-cache");
			objectMetadata.setHeader("Pragma", "no-cache");
			objectMetadata.setContentType(getcontentType(fileName.substring(fileName.lastIndexOf("."))));
			objectMetadata.setContentDisposition("inline;filename=" + fileName);
			// 上传文件

			PutObjectResult putResult = ossClient.putObject(bucketName, filedir + fileName, instream, objectMetadata);
			ret = putResult.getETag();
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			try {
				if (instream != null) {
					instream.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	/**
	 * Description: 判断OSS服务文件上传时文件的contentType
	 *
	 * @param FilenameExtension
	 *            文件后缀
	 * @return String
	 */
	public static String getcontentType(String FilenameExtension) {
		if (FilenameExtension.equalsIgnoreCase(".bmp")) {
			return "image/bmp";
		}
		if (FilenameExtension.equalsIgnoreCase(".gif")) {
			return "image/gif";
		}
		if (FilenameExtension.equalsIgnoreCase(".jpeg") || FilenameExtension.equalsIgnoreCase(".jpg")
				|| FilenameExtension.equalsIgnoreCase(".png")) {
			return "image/jpeg";
		}
		if (FilenameExtension.equalsIgnoreCase("html")) {
			return "text/html";
		}
		if (FilenameExtension.equalsIgnoreCase(".txt")) {
			return "text/plain";
		}
		if (FilenameExtension.equalsIgnoreCase(".vsd")) {
			return "application/vnd.visio";
		}
		if (FilenameExtension.equalsIgnoreCase(".pptx") || FilenameExtension.equalsIgnoreCase(".ppt")) {
			return "application/vnd.ms-powerpoint";
		}
		if (FilenameExtension.equalsIgnoreCase(".docx") || FilenameExtension.equalsIgnoreCase(".doc")) {
			return "application/msword";
		}
		if (FilenameExtension.equalsIgnoreCase(".xml")) {
			return "text/xml";
		}
		if (FilenameExtension.equalsIgnoreCase(".pdf")) {
			return "application/pdf";
		}
		return "image/jpeg";
	}

	/**
	 * 获得url链接
	 *
	 * @param key
	 * @return
	 */
	public String getUrl(String key) {
		// 设置URL过期时间为10年 3600l* 1000*24*365*10
		Date expiration = new Date(new Date().getTime() + 3600l * 1000 * 24 * 365 * 10);
		// 生成URL
		URL url = ossClient.generatePresignedUrl(bucketName, key, expiration);
		if (url != null) {
			return url.toString();
		}
		return null;
	}

	/**
	 * 
	 * oss服务器删除图片
	 * 
	 * @param key
	 */
	public void delete(String key) {
		ossClient.deleteObject(bucketName, key);
	}

	/**
	 * @Description: 根据key获取oss服务器上的图片地址
	 * @param key
	 * @return
	 * @ReturnType:String
	 */
	public InputStream getObject(String key) {

		OSSObject object = ossClient.getObject(bucketName, key);
		// 获取Object的输入流
		InputStream objectContent = object.getObjectContent();
		return objectContent;
	}

	public static String getUrl(File file) throws IOException {
		OSSClientUtil ossClientUtil = new OSSClientUtil();
		String name = ossClientUtil.uploadImg2Oss(file);
		String imgUrl = ossClientUtil.getImgUrl(name);
		ossClientUtil.destory();
		int i = imgUrl.indexOf("?");
		String url = imgUrl.substring(0, i);
		return url;
	}
}
