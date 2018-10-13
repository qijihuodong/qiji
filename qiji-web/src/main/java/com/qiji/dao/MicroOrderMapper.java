package com.qiji.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qiji.domain.MicroOrder;

public interface MicroOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MicroOrder record);

    int insertSelective(MicroOrder record);

    MicroOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MicroOrder record);

    int updateByPrimaryKey(MicroOrder record);
    
    public List<MicroOrder> queryOrderByTradeNo(String tradeNo);
    
    public List<MicroOrder> queryMyBuyOrder(@Param("buyUid")Integer buyUid, @Param("status")Byte status,@Param("tradeStatus")Byte tradeStatus);
    
    public void updateOrderByTradeNo(MicroOrder order);
}