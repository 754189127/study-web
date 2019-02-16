package com.study.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author wguo
 * @date 2019/02/16 15:19
 */
@Service
public class MailService {
    private Logger logger = LoggerFactory.getLogger(MailService.class);

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    public void sendSimpleMail(String to,String subject,String content) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(to);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(content);
            simpleMailMessage.setFrom(from);

            mailSender.send(simpleMailMessage);

            System.out.println("success");
        }catch (Exception e){
            logger.error("sendSimpleMail error. errorMsg={}",e.toString());
            System.out.println("faild");
        }
    }

    public void sendHtmlMail(String to,String subject,String content){
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content,true);
            messageHelper.setFrom(from);
            mailSender.send(message);

            System.out.println("success");
        }catch (Exception e){
            System.out.println("faild");
        }
    }

    public void sendAttachmentMail(String to,String subject,String content,String filePath){
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content,true);
            messageHelper.setFrom(from);

            FileSystemResource resource = new FileSystemResource(new File(filePath));
            String fileName = resource.getFilename();
            messageHelper.addAttachment(fileName,resource);

            mailSender.send(message);

            System.out.println("success");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("faild");
        }
    }

    public void sendInLineResourceMail(String to,String subject,String content,String resPath,String resId){
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(content,true);
            messageHelper.setFrom(from);

            FileSystemResource resource = new FileSystemResource(new File(resPath));
            messageHelper.addInline(resId,resource);

            mailSender.send(message);

            System.out.println("success");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("faild");
        }
    }
}
