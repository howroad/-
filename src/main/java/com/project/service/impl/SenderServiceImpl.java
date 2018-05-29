package com.project.service.impl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.service.ISenderService;

@Service("senderService")
public class SenderServiceImpl implements ISenderService {


    private static final Logger logger = LoggerFactory.getLogger(SenderServiceImpl.class);

    @Resource(name = "jmsQueueTemplate")
    private JmsTemplate jmsTemplate;

    //目的地队列的明证，我们要向这个队列发送消息
    @Resource(name = "destinationQueue")
    private Destination destination;

    //向特定的队列发送消息
    @Override
    public void sendMsg(Object obj) {
        final String msg = Obj2Json(obj);
        try {
            logger.info("将要向队列{}发送的消息msg:{}", destination, msg);
            jmsTemplate.send(destination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(msg);
                }
            });

        } catch (Exception ex) {
        	ex.printStackTrace();
            logger.error("向队列{}发送消息失败，消息为：{}", destination, msg);
        }

    }
    private String Obj2Json(Object obj) {
    	String str = null;
    	try {
    		str = new ObjectMapper().writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
    	return str;
    }
	@Override
	public void sendMsg(String msg) {
        try {
            logger.info("将要向队列{}发送的消息msg:{}", destination, msg);
            jmsTemplate.send(destination, new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(msg);
                }
            });

        } catch (Exception ex) {
        	ex.printStackTrace();
            logger.error("向队列{}发送消息失败，消息为：{}", destination, msg);
        }
		
	}
}