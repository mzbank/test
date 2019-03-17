package job.controller;


import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RabbitListener
@Controller
public class RabbitController {

    @RequestMapping("/receiveMsg")
    @ResponseBody
    @RabbitHandler
    public void receiveMsg(String content){
    }
}
