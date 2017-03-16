package com.novauc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HibernateBasicsController {

    @Autowired
    HibernateRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Message> messagesList =(ArrayList) messages.findAll();
        model.addAttribute("messages", messagesList);
        return "home";
    }


    @RequestMapping(path = "/add-messages", method = RequestMethod.POST)
    public String addMessage(String messageName) {
        Message message = new Message(messageName);
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-messages", method = RequestMethod.POST)
    public String editMessage(String editName,int idName) {
        Message message = messages.findOne(idName);
        message.setName(editName);
        messages.save(message);
        return "redirect:/";
    }
}

