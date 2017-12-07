package com.study.cache;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.CountDownLatch;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.study.cache.entity.TOrderDetail;
import com.study.cache.service.OrderDetailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-test.xml")
public class CacheCrashTest {


	@Resource
	private OrderDetailService ods;
	
	
	private static final String USER_CODE="u001xxoo";
	
	private static final int threadNum = 200;
	
	
	private CountDownLatch cdl = new CountDownLatch(threadNum);
	
	@Before
	public void init(){
		ods.getOrderAmount(USER_CODE);
	}
	
	
	
	
	@Test
	public void crashTest(){
		for (int i = 0; i < threadNum; i++) {
			new Thread(new UserRequest()).start();
			cdl.countDown();
		}
		
		try {
			Thread.currentThread().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	private class UserRequest implements Runnable{
		

		public void run() {
			try {
				cdl.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(Thread.currentThread().getName()+"==============>"+ods.getOrderAmount(UUID.randomUUID().toString()));
			BigDecimal orderAmount = ods.getOrderAmount(USER_CODE);
			System.out.println(Thread.currentThread().getName()+"==============>"+orderAmount);
		}
		
	}
	
	
	public void mockData(){
		for (int i = 0; i < 100000; i++) {
			System.out.println(i);
			TOrderDetail info = new TOrderDetail();
			info.setCode(UUID.randomUUID().toString());
			info.setCreattime(new Date());
			info.setGcode("xxoo");
			info.setGtype("2");
			info.setPrice(BigDecimal.valueOf(13.14D));
			info.setUcode("u91134");
			ods.addOrderDetail(info);
		}
	}

//	@Test
//	public void testLock(){
//		System.out.println(lock.getLock());
//		lock.releaseLock();
//	}


}
