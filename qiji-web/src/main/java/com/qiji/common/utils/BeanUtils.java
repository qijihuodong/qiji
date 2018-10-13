package com.qiji.common.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/****************************************************************
 * 程序名 BeanUtils.java
 * <p>
 * 描 述 TODO
 * <p>
 * 
 * @author fengzhch@adtec.com.cn
 * @version v1.0 date 2012-2-18
 **************************************************************/
public class BeanUtils {


	/**
	 * 根据字段参数COPY信息
	 * 
	 * @param sourceObj
	 *            源对象
	 * @param targetObj
	 *            目标对象
	 * @param par
	 *            参数字段
	 * @return
	 * 
	 */
	@SuppressWarnings("unchecked")
	public static Object copyClassByParValue(Object sourceObj,
			Object targetObj, Object[] par) {

		if (sourceObj == null || targetObj == null) {
			try {
				throw new Exception("参数不合法");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			// log.trace("开始拷贝" + sourceObj.getClass().getName() + "的内容到" +
			// targetObj.getClass().getName());
			BeanInfo sourceBean;
			BeanInfo targetBean;
			sourceBean = Introspector.getBeanInfo(sourceObj.getClass());
			targetBean = Introspector.getBeanInfo(targetObj.getClass());

			PropertyDescriptor[] sourceParObj = sourceBean
					.getPropertyDescriptors();
			PropertyDescriptor[] targetParObj = targetBean
					.getPropertyDescriptors();
			Map<Object, PropertyDescriptor> sourceParMap = new HashMap<Object, PropertyDescriptor>();
			Map<Object, PropertyDescriptor> targetParMap = new HashMap<Object, PropertyDescriptor>();
			if (par == null || par.length == 0) {
				List<String> tempList = new ArrayList<String>();
				for (int i = 0; i < targetParObj.length; i++) {
					if (!"class".equals(targetParObj[i].getName())) {
						for (int j = 0; j < sourceParObj.length; j++) {
							if (sourceParObj[j].getName().equals(
									targetParObj[i].getName())) {
								tempList.add(sourceParObj[j].getName());
							}
						}
					}
				}
				par = (Object[]) tempList.toArray();
			}
			for (int i = 0; i < par.length; i++) {
				if (par[i] == null) {
					continue;
				}
				for (int j = 0; j < targetParObj.length; j++) {
					if (par[i].equals(targetParObj[j].getName())) {
						targetParMap.put(par[i], targetParObj[j]);
						break;
					}
				}
				for (int j = 0; j < sourceParObj.length; j++) {
					if (par[i].equals(sourceParObj[j].getName())) {
						sourceParMap.put(par[i], sourceParObj[j]);
						break;
					}
				}
			}

			for (int i = 0; i < par.length; i++) {
				if (sourceParMap.get(par[i]) != null
						&& targetParMap.get(par[i]) != null) {
					PropertyDescriptor source = (PropertyDescriptor) sourceParMap
							.get(par[i]);
					PropertyDescriptor target = (PropertyDescriptor) targetParMap
							.get(par[i]);
					// 如果源对象与目标对象的字段类型相同则直接COPY
					if (target.getPropertyType().getCanonicalName().equals(
							source.getPropertyType().getCanonicalName())) {
						target.getWriteMethod().invoke(
								targetObj,
								source.getReadMethod().invoke(sourceObj,
										new Object[] {}));
					} else if ("java.lang.String".equals(target
							.getPropertyType().getCanonicalName())) {
						if (isNotNull(source.getReadMethod().invoke(sourceObj,
								new Object[] {})))
							target.getWriteMethod().invoke(
									targetObj,
									String
											.valueOf(source.getReadMethod()
													.invoke(sourceObj,
															new Object[] {})));
					} else if ("java.util.List".equals(target.getPropertyType()
							.getCanonicalName())
							&& "java.util.List".equals(source.getPropertyType()
									.getCanonicalName())) {
						if (isNotNull(source.getReadMethod().invoke(sourceObj,
								new Object[] {})))
							target.getWriteMethod().invoke(
									targetObj,
									new ArrayList((Collection) source
											.getReadMethod().invoke(sourceObj,
													new Object[] {})));
					} else {
						if (isNotEmpty(source.getReadMethod().invoke(sourceObj,
								new Object[] {}))) {
							if ("java.util.Date".equals(target
									.getPropertyType().getCanonicalName())) {
								if (source.getReadMethod().invoke(sourceObj,
										new Object[] {}).toString().length() == 8) {
									target
											.getWriteMethod()
											.invoke(
													targetObj,
													new SimpleDateFormat(
															"yyyyMMdd")
															.parse(source
																	.getReadMethod()
																	.invoke(
																			sourceObj,
																			new Object[] {})
																	.toString()));
								} else if (source.getReadMethod().invoke(
										sourceObj, new Object[] {}).toString()
										.length() == 10) {
									target
											.getWriteMethod()
											.invoke(
													targetObj,
													new SimpleDateFormat(
															"yyyy-MM-dd")
															.parse(source
																	.getReadMethod()
																	.invoke(
																			sourceObj,
																			new Object[] {})
																	.toString()));
								}
							} else if ("int".equals(target.getPropertyType()
									.getCanonicalName())) {
								target.getWriteMethod().invoke(
										targetObj,
										Integer.valueOf(source.getReadMethod()
												.invoke(sourceObj,
														new Object[] {})
												.toString()));
							} else if ("double".equals(target.getPropertyType()
									.getCanonicalName())) {
								target.getWriteMethod().invoke(
										targetObj,
										Double.valueOf(source.getReadMethod()
												.invoke(sourceObj,
														new Object[] {})
												.toString()));
							} else if ("float".equals(target.getPropertyType()
									.getCanonicalName())) {
								target.getWriteMethod().invoke(
										targetObj,
										Float.valueOf(source.getReadMethod()
												.invoke(sourceObj,
														new Object[] {})
												.toString()));
							} else if ("long".equals(target.getPropertyType()
									.getCanonicalName())) {
								target.getWriteMethod().invoke(
										targetObj,
										Long.valueOf(source.getReadMethod()
												.invoke(sourceObj,
														new Object[] {})
												.toString()));
							} else if ("boolean".equals(target
									.getPropertyType().getCanonicalName())) {
								target.getWriteMethod().invoke(
										targetObj,
										Boolean.valueOf(source.getReadMethod()
												.invoke(sourceObj,
														new Object[] {})
												.toString()));
							} else if ("byte".equals(target.getPropertyType()
									.getCanonicalName())) {
								target.getWriteMethod().invoke(
										targetObj,
										Byte.valueOf(source.getReadMethod()
												.invoke(sourceObj,
														new Object[] {})
												.toString()));
							} else if ("java.lang.Integer".equals(target
									.getPropertyType().getCanonicalName())) {
								target.getWriteMethod().invoke(
										targetObj,
										Integer.valueOf(source.getReadMethod()
												.invoke(sourceObj,
														new Object[] {})
												.toString()));
							} else if ("java.lang.Double".equals(target
									.getPropertyType().getCanonicalName())) {
								target.getWriteMethod().invoke(
										targetObj,
										Double.valueOf(source.getReadMethod()
												.invoke(sourceObj,
														new Object[] {})
												.toString()));
							} else if ("java.lang.Float".equals(target
									.getPropertyType().getCanonicalName())) {
								target.getWriteMethod().invoke(
										targetObj,
										Float.valueOf(source.getReadMethod()
												.invoke(sourceObj,
														new Object[] {})
												.toString()));
							} else if ("java.lang.Long".equals(target
									.getPropertyType().getCanonicalName())) {
								target.getWriteMethod().invoke(
										targetObj,
										Long.valueOf(source.getReadMethod()
												.invoke(sourceObj,
														new Object[] {})
												.toString()));
							} else if ("java.lang.Boolean".equals(target
									.getPropertyType().getCanonicalName())) {
								target.getWriteMethod().invoke(
										targetObj,
										Boolean.valueOf(source.getReadMethod()
												.invoke(sourceObj,
														new Object[] {})
												.toString()));
							} else if ("java.lang.Byte".equals(target
									.getPropertyType().getCanonicalName())) {
								target.getWriteMethod().invoke(
										targetObj,
										Byte.valueOf(source.getReadMethod()
												.invoke(sourceObj,
														new Object[] {})
												.toString()));
							} else if ("java.math.BigDecimal".equals(target
									.getPropertyType().getCanonicalName())) {
								target.getWriteMethod().invoke(
										targetObj,
										new BigDecimal(source.getReadMethod()
												.invoke(sourceObj,
														new Object[] {})
												.toString()));
							}
						}
					}
				}
			}
		} catch (Exception e) {
			// throw new FrameworkAppException("FA250", "参数不合法");
		}
		// log.trace("拷贝成功");
		return targetObj;
	}

	/**
	 * 判断对象是否为NULL
	 * 
	 * @param strValue
	 * @return
	 */
	public static boolean isNotNull(Object strValue) {
		if (strValue == null) {
			return false;
		}
		return true;
	}

	/**
	 * 判断字符串是否为空
	 * 
	 * @param strValue
	 * @return
	 */
	public static boolean isNotEmpty(Object strValue) {
		if (strValue == null || "".equals(strValue.toString().trim())) {
			return false;
		}
		return true;
	}

	/**
	 * 判断字符串是否为空或者是NULL
	 * 
	 * @param strValue
	 * @return
	 */
	public static boolean isNullorEmpty(String value) {
		if (value == null || "".equals(value.trim())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 查找某个异常的最底层异常
	 * 
	 * @param Throwable
	 * @return Throwable
	 */
	public static Throwable getBottomExcepton(Throwable ex) {
		while (isNotNull(ex.getCause())) {
			ex = ex.getCause();
		}
		return ex;
	}

}
