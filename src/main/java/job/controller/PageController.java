package job.controller;

import job.Rabbitmq.RabbitmqProvider;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @Autowired
    private RabbitmqProvider rabbitmqProvider;

    @RequestMapping("/")
    public String page(){
        return "index";
    }
    @RequestMapping("/sendMsg")
    @ResponseBody
    public void sendMsg(){
        rabbitmqProvider.Send();
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/process")
    public String DataProcess(String name, String password, Model model){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(name , password);
        try {
            subject.login(token);
            return "shopping";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","用户密码错误");
            return "login";
        }
    }
}
