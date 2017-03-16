package com.novauc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric on 3/15/17.
 */

@Controller
public class HibernateBasicsController {

    @Autowired
    MessageRepository messages;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Message> messageList = (ArrayList) messages.findAll();  //casted an arraylist?
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage (String messageTitle, String messageText) {
        Message message = new Message(messageTitle, messageText);
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String editMessage(int id, String title, String text) {
        Message message = messages.findOne(id);
        message.setTitle(title);
        message.setText(text);
        messages.save(message);
        return "redirect:/";
    }





}
