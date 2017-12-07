package com.study.cache.service;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dongnao.cache.lock.DistributedLock;
import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import com.study.cache.dao.TOrderDetailDao;
import com.study.cache.entity.TOrderDetail;


@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	
	@Resource
	private TOrderDetailDao mapper;
	
	@Resource
	private RedisCacheService cs;
	
	@Resource
	private DistributedLock lock;
	
	
	private BloomFilter<String> bf;
	
	
	@PostConstruct
	public void init(){
		List<String> distinctUcode = mapper.getDistinctUcode();
		if(!CollectionUtils.isEmpty(distinctUcode)){
			bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), distinctUcode.size());
			for (String ucode : distinctUcode) {
				bf.put(ucode);
			}
		}
	}
	
	
	private static final String CACHE_NAME = "amount";
	private static final String CACHE_NAME_BACKUP = "amount_backup";
	
	

	private Logger logger = LoggerFactory.getLogger(OrderDetailServiceImpl.class);

	@Override
	public TOrderDetail addOrderDetail(TOrderDetail detail) {
		mapper.insert(detail);
		return detail;
	}

	@Override
	public void delOrderDetail(String id) {
		mapper.deleteByPrimaryKey(id);

	}

	@Override
	public TOrderDetail updateOrderDetail(TOrderDetail detail) {
		mapper.updateByPrimaryKeySelective(detail);
		return detail;
	}
	
	@Override
	public TOrderDetail getOrderDetail(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public BigDecimal getOrderAmount(String userCode) {
		
		if(!bf.mightContain(userCode)){
			return null;
		}
		
		BigDecimal cacheResult = cs.cacheResult(userCode, CACHE_NAME);
		if(cacheResult!=null){
			logger.info("======================get data from cache============================");
			return cacheResult;
		}
		
		logger.info("======================get data from db============================");
		BigDecimal orderAmount = mapper.getOrderAmount(userCode);
		cs.cachePut(userCode, orderAmount, CACHE_NAME);
		return orderAmount;
		
//		if(lock.getLock()){
//			logger.info("======================get data from db============================");
//			BigDecimal orderAmount = mapper.getOrderAmount(userCode);
//			cs.cachePut(userCode, orderAmount, CACHE_NAME);
//			cs.cachePut(userCode+"_backup", orderAmount, CACHE_NAME_BACKUP);
//			lock.releaseLock();
//			return orderAmount;
//		}else{
//			logger.info("======================get data from backup cache============================");
//			return cs.cacheResult(userCode+"_backup", CACHE_NAME_BACKUP);
//		}
		
		
		//如果缓存没有值，从数据库里面取
//		synchronized (logger) {
//			cacheResult = cs.cacheResult(userCode, CACHE_NAME);
//			if(cacheResult!=null){
//				logger.info("======================get data from cache============================");
//				return cacheResult;
//			}
//			logger.info("======================get data from db============================");
//			BigDecimal orderAmount = mapper.getOrderAmount(userCode);
//			cs.cachePut(userCode, orderAmount, CACHE_NAME);
//			return orderAmount;
//		}
		
//		logger.info("======================get data from db============================");
//		BigDecimal orderAmount = mapper.getOrderAmount(userCode);
//		cs.cachePut(userCode, orderAmount, CACHE_NAME);
//		return orderAmount;
	}

}
