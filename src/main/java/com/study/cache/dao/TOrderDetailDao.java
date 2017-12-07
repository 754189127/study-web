package com.study.cache.dao;

import java.math.BigDecimal;
import java.util.List;

import com.study.cache.entity.TOrderDetail;

public interface TOrderDetailDao {
    int deleteByPrimaryKey(String code);

    int insert(TOrderDetail record);

    int insertSelective(TOrderDetail record);

    TOrderDetail selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(TOrderDetail record);

    int updateByPrimaryKey(TOrderDetail record);

	BigDecimal getOrderAmount(String userCode);
	
	List<String> getDistinctUcode();
}