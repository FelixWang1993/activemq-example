package demo.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

@Configuration
public class activemqConfig {
    @Value("${queue.name}")
    String queueName;

    @Bean
    public Queue queue() {
        return new ActiveMQQueue(queueName);
    }
}
