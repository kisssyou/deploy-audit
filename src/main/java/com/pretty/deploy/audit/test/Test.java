package com.pretty.deploy.audit.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;

/**
 * @author haoxm
 * @description:
 * @date 2020/4/30 16:08
 */
@Component
@Slf4j
public class Test {

    @Autowired
    private JavaMailSender javaMailSender;

//    @Scheduled(initialDelay = 5000, fixedDelay = 20000)
    public void testSms(){
        log.info("发送邮件开始。。。。。。。");

        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//            simpleMailMessage .setFrom("15123020544@163.com");
//            simpleMailMessage .setTo("haoxm@asiainfo.com");
            simpleMailMessage .setFrom("haoxm@asiainfo.com");
            simpleMailMessage .setTo("15123020544@163.com");
            simpleMailMessage.setSubject("主题");
            simpleMailMessage.setText("内容dddddddd");
            //发送
            javaMailSender.send(simpleMailMessage);
        }catch(Exception e){
            log.error("发送失败", e);
        }

        log.info("发送邮件结束。。。。。。。");
    }

}
