package com.study.cache.service;

import java.math.BigDecimal;

import com.study.cache.entity.TOrderDetail;

public interface OrderDetailService {
	
	public TOrderDetail addOrderDetail(TOrderDetail detail);
	
	public void delOrderDetail(String id);
	
	public TOrderDetail updateOrderDetail(TOrderDetail detail);
	
	public BigDecimal getOrderAmount(String userCode);

	TOrderDetail getOrderDetail(String id);
	
}
