package example1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MqMessageReceiver {
    public static void main(String args[]) throws JMSException, InterruptedException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://127.0.0.1:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        final Session session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue("my-queue");

        MessageConsumer consumer = session.createConsumer(destination);

        TextMessage message = (TextMessage) consumer.receive();
        while (message != null) {
            String text = message.getText();
            System.out.println(text);
            session.commit();
        }
        consumer.close();
        session.close();
        connection.close();
    }
}
