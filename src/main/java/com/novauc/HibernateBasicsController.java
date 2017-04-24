package com.novauc;/**
 * Created by Merlin on 3/15/17.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HibernateBasicsController {
    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Message> messagesList =(ArrayList) messages.findAll();
        model.addAttribute("messages", messagesList);
        return "home";
    }
    @RequestMapping(path = "/add-messages", method = RequestMethod.POST)
    public String addMessage(String messageNameof) {
        Message message = new Message(messageNameof);
        messages.save(message);
        return "redirect:/";
    }
    @RequestMapping(path = "/edit-messages", method = RequestMethod.POST)
    public String editMessage(String editNameof,int idNameof) {
        Message message = messages.findOne(idNameof);
        message.setName(editNameof);
        messages.save(message);
        return "redirect:/";
    }
}