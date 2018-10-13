package com.qiji.utils;

import java.util.UUID;

public class PayNumGenUtils {
	
//	public static void main(String[] args) {
//		System.out.println(PayNumGenUtils.genOrderIdByTime("A"));
//		System.out.println(PayNumGenUtils.getOrderIdByUUId("A"));
//	}
	
	/**
	 * 按时间获取订单号
	 * @param machineId 集群时的机器号
	 * @return
	 */
	public static String genOrderIdByTime(String machineId){
	    String orderId =
	            machineId +
	                    (System.currentTimeMillis() + "").substring(1) +
	                    (System.nanoTime() + "").substring(7, 10);
//	    System.out.println(orderId);
	    return orderId;
	}
	/**
	 * 按uuid的hashcode生成订单号
	 * @param machineId 集群时的机器号
	 * @return
	 */
	public static String getOrderIdByUUId(String machineId) {

	    int hashCodeV = UUID.randomUUID().toString().hashCode();
	    if (hashCodeV < 0) {//有可能是负数
	        hashCodeV = -hashCodeV;
	    }
	    // 0 代表前面补充0
	    // 4 代表长度为4
	    // d 代表参数为正数型
	    String orderId=machineId + String.format("%015d", hashCodeV);
//	    System.out.println(orderId);
	    return orderId;
	}
}
