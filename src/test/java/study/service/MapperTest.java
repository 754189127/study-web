package study.service;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/applicationContext.xml" })
public class MapperTest {
/*
	@Autowired
	private UserMapper userMapper;

	@Test
	public void testCRUD() {
		System.out.println("sssssssss");

		User user = userMapper.selectByPrimaryKey(1);
		System.out.println("user:" + user.getAccount());

		Thread t = new Thread(new Runnable() {
			public void run() {
				long start = System.currentTimeMillis();
				for (int i = 1001; i <= 5000; i++) {
					User record = new User();
					record.setAccount("s0000" + i);
					record.setPassword("123456");
					record.setLoginTime(new Date());
					int result = userMapper.insertSelective(record);
					System.out.println("row:" + i);
				}
				long end = System.currentTimeMillis();
				System.out.println("耗时:" + (end - start) / 1000);
			}
		});
		t.start();
	}
*/
}
