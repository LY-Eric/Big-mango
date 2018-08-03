package com.ynet.finmall.gateway.yulebao.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import com.ynet.finmall.gateway.exception.GatewayErrorConstants;
import com.ynet.finmall.gateway.exception.YLBGatewayException;

public class CopyUtils {

	public static void Copy(Object source, Object dest) {
		// 获取属性
		PropertyDescriptor[] sourceProperty = new PropertyDescriptor[0];
		PropertyDescriptor[] destProperty = new PropertyDescriptor[0];
		try {
			BeanInfo sourceBean = Introspector.getBeanInfo(source.getClass(), Object.class);
			sourceProperty = sourceBean.getPropertyDescriptors();

			BeanInfo destBean = Introspector.getBeanInfo(dest.getClass(), Object.class);
			destProperty = destBean.getPropertyDescriptors();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}

		try {
			for (int i = 0; i < sourceProperty.length; i++) {

				for (int j = 0; j < destProperty.length; j++) {

					if (!"serverCode".equals(sourceProperty[i].getName())
							&& sourceProperty[i].getName().equals(destProperty[j].getName())
							&& sourceProperty[i].getPropertyType() == destProperty[j].getPropertyType()) {
						// 调用source的getter方法和dest的setter方法
						destProperty[j].getWriteMethod().invoke(dest, sourceProperty[i].getReadMethod().invoke(source));
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// throw new Exception("属性复制失败:" + e.getMessage());
			throw new YLBGatewayException(GatewayErrorConstants.YLB_FIELD_ERROR);
		}
	}

}
