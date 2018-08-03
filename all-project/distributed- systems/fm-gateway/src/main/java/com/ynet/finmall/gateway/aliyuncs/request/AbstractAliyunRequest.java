package com.ynet.finmall.gateway.aliyuncs.request;

/**
 * 阿里云公共请求报文头
 * @author liuxin
 *
 */
public class AbstractAliyunRequest {

	private String Format				= "JSON";//返回值的类型，支持JSON与XML。默认为XML。
	private String Version				= "2014-05-26";//API版本号，为日期形式：YYYY-MM-DD，本版本对应为2014-05-26。
	private String AccessKeyId					;//阿里云颁发给用户的访问服务所用的密钥ID。
	private String Signature					;//签名结果串，关于签名的计算方法，请参见<签名机制>。
	private String SignatureMethod				;//签名方式，目前支持HMAC-SHA1。
	private String Timestamp					;//请求的时间戳。日期格式按照ISO8601标准表示，并需要使用UTC时间。格式为：YYYY-MM-DDThh:mm:ssZ	例如，2014-05-26T12:00:00Z（为北京时间2014年5月26日20点0分0秒）。
	private String SignatureVersion				;//签名算法版本，目前版本是1.0。
	private String SignatureNonce				;//唯一随机数，用于防止网络重放攻击。用户在不同请求间要使用不同的随机数值
	private String ResourceOwnerAccount			;//本次API请求访问到的资源拥有者账户，即登录用户名。此参数的使用方法，详见<借助RAM实现子账号对主账号的ECS资源访问>，（只能在RAM中可对ECS资源进行授权的Action中才能使用此参数，否则访问会被拒绝）
	
	public String getFormat() {
		return Format;
	}
	public void setFormat(String format) {
		Format = format;
	}
	public String getVersion() {
		return Version;
	}
	public void setVersion(String version) {
		Version = version;
	}
	public String getAccessKeyId() {
		return AccessKeyId;
	}
	public void setAccessKeyId(String accessKeyId) {
		AccessKeyId = accessKeyId;
	}
	public String getSignature() {
		return Signature;
	}
	public void setSignature(String signature) {
		Signature = signature;
	}
	public String getSignatureMethod() {
		return SignatureMethod;
	}
	public void setSignatureMethod(String signatureMethod) {
		SignatureMethod = signatureMethod;
	}
	public String getTimestamp() {
		return Timestamp;
	}
	public void setTimestamp(String timestamp) {
		Timestamp = timestamp;
	}
	public String getSignatureVersion() {
		return SignatureVersion;
	}
	public void setSignatureVersion(String signatureVersion) {
		SignatureVersion = signatureVersion;
	}
	public String getSignatureNonce() {
		return SignatureNonce;
	}
	public void setSignatureNonce(String signatureNonce) {
		SignatureNonce = signatureNonce;
	}
	public String getResourceOwnerAccount() {
		return ResourceOwnerAccount;
	}
	public void setResourceOwnerAccount(String resourceOwnerAccount) {
		ResourceOwnerAccount = resourceOwnerAccount;
	}
}
