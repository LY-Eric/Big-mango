package com.eric.education.utils;

import org.apache.commons.lang.CharRange;
import org.apache.commons.lang.CharSet;
import org.w3c.dom.Document;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	/**
	 * 许可的文件名
	 */
	private static CharSet allowedFileName = CharSet.getInstance("!#$%&'()+,.;=@[]_`{}~ 0-9a-zA-Z-^");

	/**
	 * 许可的mail地址
	 */
	private static CharSet allowedMailAddress = CharSet.getInstance(".@_0-9a-zA-Z-");

	/**
	 * 许可的密码
	 */
	private static CharSet allowedPassword = CharSet.getInstance("`~!@#$%^&*()-_+=|\\{}\\[\\]'\":;,.<>/?0-9a-zA-Z-");

	/**
	 * ASCII 文字（英数字）
	 */
	private static CharSet alphaNumChar = CharSet.getInstance("0-9A-Za-z");

	/**
	 * ASCII 文字（数字）
	 */
	private static CharRange digit = new CharRange('\u0030', '\u0039');
	/**
	 * 汉字
	 */
	private static CharRange simplified = new CharRange('\u4e00', '\u9fa5');

	private StringUtils() {
	}

    private static Pattern NUMBER_PATTERN2 = Pattern.compile("^\\d+(\\.\\d{0,2})?$");
	/**
	 * 字符串是数字的判定方法。
	 *
	 * @param str 字符串
	 * @return 数字 0-9 true
	 */
	public static boolean isDigit(String str) {
		boolean isdigit = false;
		if (StringUtils.isEmpty(str)) {
			return isdigit;
		}
		isdigit = true;
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (!digit.contains(cs[i])) {
				isdigit = false;
			}
		}
		return isdigit;
	}

    private static Pattern NUMBER_PATTERN = Pattern.compile("^[0-9]*[1-9][0-9]*$");
	/**
	 * 字符串是数值(含小数)的判定方法。
	 *
	 * @param str 字符串
	 * @return 数值(含小数) true
	 */
	public static boolean isNumeric(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
        Matcher matcher = NUMBER_PATTERN2.matcher(str);
		return matcher.find();
	}

	/**
	 * 字符串是正整数的判定方法。
	 *
	 * @param str 字符串
	 * @return 正整数 true
	 */
	public static boolean isInteger(String str) {
		if (StringUtils.isEmpty(str)) {
			return false;
		}
        Matcher matcher = NUMBER_PATTERN.matcher(str);
        return matcher.find();
	}

	/**
	 * 字符串null或空文字判定方法。
	 *
	 * @param str
	 *            字符串
	 * @return true: 字符串null或空文字, false: 字符串不是null也不是空文字
	 */
	public static boolean isNull(String str) {
		return str == null || str.length() == 0;
	}

	/**
	 * 字符串null或空文字或者全是空白判定方法。
	 *
	 * @param str
	 *            字符串
	 * @return true: 字符串null或空文字, false: 字符串不是null也不是空文字
	 */
	public static boolean isEmpty(String str) {
		return isNull(str) || trim(str).length() == 0;
	}

	/**
	 * 字符串是中文(不包括中文符号)的判定方法。
	 *
	 * @param str 字符串
	 * @return 中文(不包括中文符号) true
	 */
	public static boolean isSimplified(String str) {
		boolean isSimplified = false;
		if (StringUtils.isEmpty(str)) {
			return isSimplified;
		}
		isSimplified = true;
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (!simplified.contains(cs[i])) {
				isSimplified = false;
			}
		}
		return isSimplified;
	}

	/**
	 * 文件名是否许可的检查。
	 *
	 * @param fileName 文件名
	 * @return 许可  true
	 */
	public static boolean isAllowedFileName(String fileName) {
		if (StringUtils.isEmpty(fileName)) {
			return false;
		}
		boolean allowed = true;
		char[] cs = fileName.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (!allowedFileName.contains(cs[i])) {
				allowed = false;
				break;
			}
		}
		if (allowed && isVistaData(fileName)) {
			allowed = false;
		}
		return allowed;
	}

	/**
	 * mail地址是否许可的检查。
	 *
	 * @param mailAddress mail地址
	 * @return 许可  true
	 */
	public static boolean isAllowedMailAddress(String mailAddress) {
		if (StringUtils.isEmpty(mailAddress)) {
			return false;
		}
		boolean allowed = true;
		char[] cs = mailAddress.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (!allowedMailAddress.contains(cs[i])) {
				allowed = false;
				break;
			}
		}
		return allowed;
	}

	/**
	 * 字符串是英数字的判定方法。
	 *
	 * @param str 字符串
	 * @return 英数字 true
	 */
	public static boolean isAsciiAlphaNumCharOnly(String str) {
		boolean asciiOnly = true;
		if (StringUtils.isEmpty(str)) {
			return asciiOnly;
		}
		char[] cs = str.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (!alphaNumChar.contains(cs[i])) {
				asciiOnly = false;
			}
		}
		return asciiOnly;
	}

    private static Pattern NUMBER_PATTERN3 = Pattern.compile(".*&#\\d+?;.*");

	/**
	 * 从Windows Vista被POST数据中含有的文字列是否存在的检查方法。
	 *
	 * @param str 文字列
	 * @return 存在 true,不存在 false
	 */
	public static boolean isVistaData(String str) {
		Matcher m = NUMBER_PATTERN3.matcher(str);
		return m.find();
	}

	/**
	 * 字符串前后空格（全角，半角）的trim
	 *
	 * @param orgstr 文字列
	 * @return trim后的文字列
	 */
	public static String trim(String orgstr) {
		while (orgstr.startsWith(" ") || orgstr.startsWith("　")) {
			orgstr = orgstr.substring(1);
		}
		while (orgstr.endsWith(" ") || orgstr.endsWith("　")) {
			orgstr = orgstr.substring(0, orgstr.length() - 1);
		}
		return orgstr;
	}

	/**
	 * 取得UUID。
	 *
	 * @return UUID
	 */
	public static String getUUID() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString().replace("-", "");
	}


	/**
	 * 取得UUID。
	 *
	 * @return UUID
	 */
	public static String getShopingUUID() {
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		sb.append(System.currentTimeMillis())
				.append(random.nextInt(6))
				.append(random.nextInt(7))
				.append(random.nextInt(8));
		return sb.toString();
	}

	/**
	 * 密码是否许可的检查。
	 *
	 * @param password 密码
	 * @return 许可  true
	 */
	public static boolean isAllowedPassword(String password) {
		if (StringUtils.isEmpty(password)) {
			return false;
		}
		boolean allowed = true;
		char[] cs = password.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			if (!allowedPassword.contains(cs[i])) {
				allowed = false;
				break;
			}
		}
		return allowed;
	}

	public static boolean isLoginId(String str) {
		String regex = "^[a-zA-z][a-zA-Z0-9_]{3,15}$";
		return match(regex, str);
	}

	public static boolean isMobileNum(String str) {
		String regex = "^13[0-9]{9}$|14[0-9]{9}|15[0-9]{9}$|17[0-9]{9}$|18[0-9]{9}$";
		return match(regex, str);
	}

	public static boolean isPasswordStrength(String str) {
		String regex = "^(?![0-9]+$)(?![a-zA-Z]+$)(?![`~!@#$%^&*()_+=\\\\|{}\\[\\]'\":;,.<>/?-]+$)[`~!@#$%^&*()_+=\\\\|{}\\[\\]'\":;,.<>/?0-9a-zA-Z-]{6,20}$";
		return match(regex, str);
	}

	public static boolean isTelNum(String str) {
		String regex = "\\d{3,5}-\\d{7,8}(-\\d{1,})?$";
		return match(regex, str);
	}

	public static boolean isUrl(String str) {
		String regex = "^(\\w+:\\/\\/)?\\w+(\\.\\w+)+.*$";
		return match(regex, str);
	}

	public static boolean isMoney(String str) {
		String regex = "^[0-9]+(\\.[0-9]{1,2})?$";
		return match(regex, str);
	}

	public static boolean isAnnualRate(String str) {
		String regex = "^([1-9]\\d{0,1})$|^(0|[1-9]\\d{0,1})\\.(\\d{1,2})$|^0$|^100$";
		return match(regex, str);
	}

	public static boolean isPermillage(String str) {
		String regex = "^([1-9]\\d{0,2})$|^(0|[1-9]\\d{0,2})\\.(\\d{1,2})$|^0$|^1000$";
		return match(regex, str);
	}

	public static boolean isSettingNum(String str) {
		String regex = "^([1-9]\\d*)$|^(0|[1-9]\\d*)\\.(\\d{1,2})$|^0$";
		return match(regex, str);
	}

	public static boolean isFourNum(String str) {
		String regex = "^([1-9]\\d*)$|^(0|[1-9]\\d*)\\.(\\d{1,4})$|^0$";
		return match(regex, str);
	}

	public static boolean isEmail(String str) {
		String regex = "^\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
		return match(regex, str);
	}

	/**
	 * 检查充值金额是否正确的方法。<br />
	 * 充值的金额，100的倍数，不大于10,000,000。
	 *
	 * @param str 要验证的字符串
	 * @return 正确返回true，否则返回false
	 */
	public static boolean isRechargeAmount(String str) {
		String regex = "^(\\d{1,5}|100000)0{2}$";
		return match(regex, str);
	}

	/**
	 * 功能：判断字符串是否为日期格式
	 *
	 * @param str
	 * @return
	 */
	public static boolean isDate(String strDate) {
		Pattern pattern = Pattern
				.compile("^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))(\\s(((0?[0-9])|([1-2][0-3]))\\:([0-5]?[0-9])((\\s)|(\\:([0-5]?[0-9])))))?$");
		Matcher m = pattern.matcher(strDate);
		if (m.matches()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	* @param regex
	* 正则表达式字符串
	* @param str
	* 要匹配的字符串
	* @return 如果str 符合 regex的正则表达式格式,返回true, 否则返回 false;
	*/
	public static boolean match(String regex, String str) {
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	/**
	 * 生成随机登录密码（默认8位长度）
	 * @return 登录密码的字符串
	 */
	public static String genUserPassword() {
		return genRandomNum(8);
	}

	/**
	 * 生成随机支付密码（默认8位长度）
	 * @return 支付密码的字符串
	 */
	public static String genPaymentPassword() {
		return genRandomNum(8);
	}

	/**
	 * 生成随机密码
	 * @param pwdLen 生成的密码的总长度
	 * @return 密码的字符串
	 */
	public static String genRandomNum(int pwdLen) {
		//35是因为数组是从0开始的，26个字母+10个 数字
		final int maxNum = 36;
		int i;  //生成的随机数
		int count = 0; //生成的密码的长度
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'j', 'k',
				'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while(count < pwdLen){
			//生成随机数，取绝对值，防止 生成负数，
			i = Math.abs(r.nextInt(maxNum));  //生成的数最大为36-1
			if (i >= 0 && i < str.length) {
				if (i%2 ==0) {
					pwd.append(Character.toUpperCase(str[i]));
				} else {
					pwd.append(str[i]);
				}
				count ++;
			}
		}

		return pwd.toString();
	}

	/**
	 * 将Document内容 写入XML字符串并返回
	 * @param doc
	 * @param encoding
	 * @return
	 */
	public static String callWriteXmlString(Document doc, String encoding) {

		try {
			Source source = new DOMSource(doc);
			ByteArrayOutputStream outStream = new ByteArrayOutputStream();
			OutputStreamWriter write = new OutputStreamWriter(outStream);
			Result result = new StreamResult(write);

			Transformer xformer = TransformerFactory.newInstance()
					.newTransformer();
			xformer.setOutputProperty(OutputKeys.ENCODING, encoding);

			xformer.transform(source, result);
			return outStream.toString();

		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			return null;
		} catch (TransformerException e) {
			e.printStackTrace();
			return null;
		}
	}


	/**
	 * 字符串截取固定Byte。
	 *
	 * @return 截取后字符串
	 */
	public static String getSubString(String str, int length) {
		int count = 0;
		int offset = 0;
		char[] c = str.toCharArray();
		for (int i = 0; i < c.length; i++) {
			if (c[i] > 256) {
				offset = 2;
				count += 2;
			} else {
				offset = 1;
				count++;
			}
			if (count == length) {
				int countRemain = 0;
				for (int j = i + 1; j < c.length; j++) {
					if (c[i] > 256) {
						countRemain += 2;
					} else {
						countRemain++;
					}
				}
				if (countRemain <= 3) {
					return str;
				} else {
                    // + "...";
					return str.substring(0, i + 1);
				}
			}
			if ((count == length + 1 && offset == 2)) {
				int countRemain = 0;
				for (int j = i + 1; j < c.length; j++) {
					if (c[i] > 256) {
						countRemain += 2;
					} else {
						countRemain++;
					}
				}
				if (countRemain <= 3) {
					return str;
				} else {
                    // + "...";
					return str.substring(0, i);
				}
			}
		}
		return str;
	}

	/**
	 * 字符串替换。
	 *
	 * @return 替换后字符串
	 */
	public static String replaceStr(String strInput, String strBefore, String strAfter) {
		if (strInput == null || "".equals(strInput)) {
			return "";
		} else {
			return strInput.replace(strBefore, strAfter);
		}
	}

	/**
	 * 手机号中间4位用*显示。
	 *
	 * @return 替换后手机号
	 */
	public static String encryptMobile(String mobile) {
		if (mobile == null || "".equals(mobile)) {
			return "";
		} else {
			String ret = mobile.substring(0,3);
			ret = ret + "****";
			ret = ret + mobile.substring(7,11);
			return ret;
		}
	}

	public static String encryptEmail(String email) {
		if (email == null || "".equals(email)) {
			return "";
		} else {
			String ret = email.substring(0,1);
			ret = ret + "****";
			ret = ret + email.substring(email.length() - 1);
			return ret;
		}
	}


	public static String digitToChinese(int str) {
		switch (str) {
			case 1:
				return "一";
			case 2:
				return "二";
			case 3:
				return "三";
			case 4:
				return "四";
			case 5:
				return "五";
			case 6:
				return "六";
			case 7:
				return "七";
			case 8:
				return "八";
			case 9:
				return "九";
			case 10:
				return "十";
		}
		return "";
	}

	public static String getPeriodDisplayValue(String periodType) {
		String str = "";
		if (StringUtils.isEmpty(periodType)) {
			return str;
		}
		switch (periodType) {
			case "1":
				str = "个月";
				break;
			case "2":
				str = "个季度";
				break;
			case "3":
				str = "天";
				break;
			default:
				str = "个月";
				break;
		}
		return str;
	}

	public static String strToConceal(String userId) {
		String subUserId = "";
		if ("".equals(userId)) {
			return subUserId;
		}
		char[] charArray = userId.toCharArray();
		int len = charArray.length;
		if (len < 4) {
			subUserId = String.valueOf(charArray[0]) + "***";
		} else if (len < 5){
			subUserId = String.valueOf(charArray[0]) + String.valueOf(charArray[1]) + "***" + String.valueOf(charArray[len - 2])
					+ String.valueOf(charArray[len - 1]);
		} else {
			subUserId = String.valueOf(charArray[0]) + String.valueOf(charArray[1]) + String.valueOf(charArray[2]) + "***" + String.valueOf(charArray[len - 2])
					+ String.valueOf(charArray[len - 1]);
		}
		return subUserId;
	}



}
