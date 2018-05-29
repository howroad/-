package com.project.listener;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.service.ITaskService;
import com.project.vo.TaskTopicDto;

public class TopicMessageListener implements MessageListener{
	@Autowired
	private ITaskService taskService;
	@Override
	public void onMessage(Message message) {
        TextMessage tm = (TextMessage) message;
        try {
            System.out.println("TopicMessageListener监听到了文本消息：\t"
                    + tm.getText());
            TaskTopicDto ttd = new ObjectMapper().readValue(tm.getText(),TaskTopicDto.class);
            taskService.addTaskPending(ttd);
            System.out.println("添加待处理事件成功!");
            //do something ...
        } catch (JMSException | IOException e) {
            e.printStackTrace();
        }
		
	}

}
