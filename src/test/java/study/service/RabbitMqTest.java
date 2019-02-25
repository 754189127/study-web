package study.service;

import com.study.AppApplication;
import com.study.rabbitmq.FanoutSender;
import com.study.rabbitmq.SimpleSender;
import com.study.rabbitmq.WorkSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author wguo
 * @date 2019/02/18 17:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppApplication.class)
public class RabbitMqTest {
    @Autowired
    private SimpleSender simpleSender;

    @Autowired
    private WorkSender workSender;

    @Autowired
    private FanoutSender fanoutSender;


    /**
     * 简单模式测试(一个生产者，一个消费者)
     * @throws Exception
     */
    @Test
    public void simpleSend() throws Exception {
       simpleSender.send();
    }

    /**
     * work模式测试（一个生产者，多个消费者，竞争抢消息，每个消费者获取到的消息唯一）
     * @throws Exception
     */
    @Test
    public void workSend() throws Exception {
        workSender.send();
    }

    /**
     * 发布订阅模式测试(一个生产者发送的消息会被多个消费者获取)
     */
    @Test
    public void setFanoutSender(){
        fanoutSender.send();
    }


}