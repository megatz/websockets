package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by marcos on 30-03-15.
 */

@Component
public class Service {
    @Autowired
    SimpMessagingTemplate brokerMessagingTemplate;

    @Scheduled(fixedRate = 1000)
    public void sendMessage(){
        try {
            System.out.println("damned");

            HelloMessage helloMessage= new HelloMessage();
            helloMessage.setName("asdf");
            helloMessage.setContent("jjjjjjjjjjjjj");

//            brokerMessagingTemplate.convertAndSendToUser("developer", "/topic/greetings", "User: " + System.currentTimeMillis());
//            brokerMessagingTemplate.convertAndSendToUser("notYou", "/topic/greetings", "Mr Developer Should Not See This: " + System.currentTimeMillis());

            brokerMessagingTemplate.convertAndSend("/topic/greetings", helloMessage);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
