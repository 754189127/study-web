package com.study.cache.service;

import javax.annotation.Resource;

import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service
public class RedisCacheServiceImpl implements RedisCacheService {

	@Resource
	private CacheManager cm;
	
	@Override
	public <V> V cacheResult(String key, String cacheName) {
		ValueWrapper valueWrapper = cm.getCache(cacheName).get(key);
		return (V) (valueWrapper == null ? null : valueWrapper.get());
	}

	@Override
	public void cacheRemove(String key, String cacheName) {
		cm.getCache(cacheName).evict(key);
	}

	@Override
	public <V> void cachePut(String key, V value, String cacheName) {
		cm.getCache(cacheName).put(key, value);

	}

}
