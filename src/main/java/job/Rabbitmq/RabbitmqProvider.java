package job.Rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class RabbitmqProvider {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void Send(){
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = dateFormat.format(date);
        System.out.println("这条消息发送的时间是: " + format);
        for (int i = 0; i < 100; i++) {
            amqpTemplate.convertAndSend("Job",format);
        }
    }
}
