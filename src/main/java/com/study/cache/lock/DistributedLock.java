package com.study.cache.lock;

public interface DistributedLock {
	
	public Boolean getLock();
	
	public void releaseLock();

}
