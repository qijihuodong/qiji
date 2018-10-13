package com.qiji.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/****************************************************************
 * 程序名    DateUtils.java <p>
 * 描    述     TODO<p>
 * @author   xinglj@adtec.com.cn
 * @version  v1.0 
 * date      2012-7-5
**************************************************************/
public class DateUtils {


	// 获取当前的日期
	public static String getCurrDateStr(String  dateFormat) {
		if (dateFormat == null) {
			dateFormat = "yyyy-MM-dd";
		}
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(new Date());
	}
	
	/**
	 * dateStr 格式为 YYYY-MM-DD 2012-9-9
	 * 
	 * @param dateStr
	 * @return str 格式为 20120909
	 */
	public static String getDateString(String dateStr) {
		String str = "";
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		if (dateStr != null) {
			Date date;
			try {
				date = sd.parse(dateStr);
				str = sdf.format(date);
			}
			catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return str;
	}
	
	public static Date getDateStrDate(String dateStr) {
		Date  dt = null;
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		if (dateStr != null) {
		 
			try {
			 dt = sd.parse(dateStr);
			}
			catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return dt;
	}
	

	/**
	 * 校验日期合法性
	 * @param strDate 日期
	 * @param dateFormat 日期格式
	 * @return true:有校的日期   false:无效的日期
	 */
	public static boolean isValidDate(String strDate, String dateFormat) {
		boolean isValid = true;
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		try {
			sdf.parse(strDate);
		} catch (ParseException e) {
			//e.printStackTrace();
			isValid = false;
		}
		return isValid;
	}
	
	public static String getStrDateFromDate(Object date, String dateFormat){
		String strDate = "";
		if (date != null && dateFormat != null && "".equals(dateFormat)) {
			SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
			strDate = sdf.format(date);
		}
		return strDate;
	}
}
