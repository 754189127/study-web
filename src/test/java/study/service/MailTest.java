package study.service;

import com.study.AppApplication;
import com.study.mail.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;

/**
 * @author wguo
 * @date 2019/02/16 15:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppApplication.class)
public class MailTest {

    @Resource
    MailService mailService;

    @Resource
    TemplateEngine templateEngine;

    @Test
    public void sendSimpleMail(){
        String to="754189127@qq.com";
        String subject = "邮件测试";
        String content = "大家好，这是测试邮件";
        mailService.sendSimpleMail(to,subject,content);
    }

    @Test
    public void sendHtmlMail(){
        String to="754189127@qq.com";
        String subject = "html邮件测试";
        String content = "<html>" +
                "<body>" +
                "<h3>大家好，这是Html测试邮件!</h3>"+
                "</body>"+
                "</html>"
                ;
        mailService.sendHtmlMail(to,subject,content);
    }

    @Test
    public void sendAttachmentMail(){
        String to="754189127@qq.com";
        String subject = "带附件邮件测试";
        String content = "<html>" +
                "<body>" +
                "<h3>大家好，这是带附件邮件测试!</h3>"+
                "</body>"+
                "</html>";
        String fileName = "C:\\Users\\Administrator\\Pictures\\timg3.jpg";
        mailService.sendAttachmentMail(to,subject,content,fileName);
    }

    @Test
    public void sendInLineResourceMail(){
        String to="754189127@qq.com";
        String subject = "图片邮件测试";
        String resPath = "C:\\Users\\Administrator\\Pictures\\timg5.jpg";
        String resId = "001";
        String content = "<html>" +
                "<body>" +
                "<h3>大家好，这是内容中包含图片的邮件测试!<img src='cid:"+resId+"'/></h3>"+
                "</body>"+
                "</html>";
        mailService.sendInLineResourceMail(to,subject,content,resPath,resId);
    }

    @Test
    public void sendTemplateMail(){
        Context context = new Context();
        context.setVariable("word","sprngboot");
        String emailContent =templateEngine.process("emailTemplate",context);

        String to="754189127@qq.com";
        String subject = "模板邮件测试";

        mailService.sendHtmlMail(to,subject,emailContent);
    }


}
