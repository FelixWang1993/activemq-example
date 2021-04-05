package demo.consumer;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @JmsListener(destination = "${queue.name}")
    public void receiveMsg(String text) {
        System.out.println("接收到消息 : "+text);
    }}
