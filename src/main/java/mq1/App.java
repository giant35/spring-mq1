/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mq1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

/**
 *
 * @author sihai
 */
@Component
public class App {

    @Autowired
    JmsMessagingTemplate jmsTemplate;

    public static void main(String[] argv) throws InterruptedException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = ctx.getBean(App.class);
        List<String> aa = new ArrayList<>(Arrays.asList(argv));
        aa.add(0, "你好");
        aa.add(0, "我叫tom");
        for (String str : aa) {
            app.send(str);
            Thread.sleep(1000);
        }        
        ctx.close();
    }

    public void send(String str) {
        final Message<String> msg = MessageBuilder.withPayload(str).build();
        jmsTemplate.send(msg);
    }

}
