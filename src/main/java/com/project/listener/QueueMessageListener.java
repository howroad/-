package com.project.listener;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.vo.ReplyQueueDto;

public class QueueMessageListener implements MessageListener{
	@Autowired  
	private HttpSession session; 
	@Override
	public void onMessage(Message message) {
		System.out.println("session注入成功"+session);
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("QueueMessageListener监听到了文本消息：\t"
                    + tm.getText());
            ReplyQueueDto rqd = new ObjectMapper().readValue(tm.getText(), ReplyQueueDto.class);
            System.out.println("[查看是否转换成功了]"+rqd);
            //do something ...
        } catch (JMSException | IOException e) {
            e.printStackTrace();
        }
		
	}

}
