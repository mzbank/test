package job.PageHelper.controller;

import job.PageHelper.service.PageSerV;
import job.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PageControl {

    List<User> list = null;
    @Autowired
    private PageSerV pageSerV;

    @RequestMapping("/user")
    @ResponseBody
    public List<User> findUser(Integer currentPage, Integer pagesize){
        list = pageSerV.findByName(currentPage, pagesize);
        return list;
    }
}
