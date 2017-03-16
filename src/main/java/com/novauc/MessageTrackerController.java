package com.novauc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import sun.misc.resources.Messages;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ANVIL_OCTOPUS on 3/15/17.
 */
@Controller
public class MessageTrackerController {

    @Autowired
    MessageRepository messages;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Message> messageList = (ArrayList) messages.findAll();
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String messageName) {
        Message message = new Message(messageName);
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping(path ="/edit-message", method = RequestMethod.POST)
    public String editMessage(int id, String editor) {
        Message message = messages.findOne(id);
        message.setText(editor);
        messages.save(message);
        return "redirect:/";



    }




}