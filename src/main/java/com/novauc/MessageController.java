package com.novauc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class MessageController {
    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model) {
        ArrayList<Message> messageArrayList = (ArrayList) messages.findAll();
        model.addAttribute("messages", messageArrayList);
        return "index";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String author, Integer user_id, String text, String location, Integer time_hours) {
        Message message = new Message(author, user_id.intValue(), text, location, time_hours.intValue());
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String editMessage(int id, String editor) {
        Message message = messages.findOne(id);
        message.setText(editor);
        messages.save(message);
        return "redirect:/";
    }

}
