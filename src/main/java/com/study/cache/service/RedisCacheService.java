package com.study.cache.service;

public interface RedisCacheService {
	
	public <V> V cacheResult(String key,String cacheName);
	
	public void cacheRemove(String key,String cacheName);
	
	public <V> void cachePut(String key, V value,String cacheName);

}
