package study.service;

import java.net.URL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.manipulation.Filter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:config/applicationContext.xml" })
public class MapperTest {

	@Test
	public void testCRUD() {
		System.out.println("test");
		URL url = Filter.class.getProtectionDomain().getCodeSource().getLocation();
		System.out.println("path:" + url.getPath() + "  name:" + url.getFile());
	}

}
