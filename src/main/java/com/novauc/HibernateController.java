package com.novauc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HibernateController {

    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model)
    {
        List<Message> messageList = (List<Message>) messages.findAll();
        model.addAttribute("messages", messageList);
        return "home";
    }
}

