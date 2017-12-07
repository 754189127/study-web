package com.study.cache;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-test.xml")
public class BloomFilterTest {
	
	@Test
	public void bfTest(){
		int sum = 1000000;
		int testNum = 10000;
		
		int right = 0;
		int wrong =0;
		
		BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8), sum);
		List<String> list = new ArrayList<String>(sum);
		Set<String> set = new HashSet<String>(sum);
		
		for (int i = 0; i < sum; i++) {
			String uuid = UUID.randomUUID().toString();
			bf.put(uuid);
			list.add(uuid);
			set.add(uuid);
		}
		for (int i = 0; i < testNum; i++) {
			String test = i % 100 ==0 ?list.get(i):UUID.randomUUID().toString();
			
			if(bf.mightContain(test)){
				if(set.contains(test)){
					right++;
				}else{
					wrong++;
				}
			}
			
		}
		System.out.println("=============right============"+right);
		System.out.println("=============wrong============"+wrong);
		
		
		
	}

}
