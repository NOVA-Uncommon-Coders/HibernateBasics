package com.novauc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class MessageTrackerController {

    @Autowired
    MessageRepository messageRepository;


    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
model.addAttribute("messages", messageRepository.findAll());


        return "templates";

    }


    @RequestMapping(path = "/add-message",method = RequestMethod.POST)
    public String lol(String messageName, String messageType, String messageStyle, int messageYear){
        Message littlePost = new Message(messageName, messageStyle, messageType, messageYear);

        messageRepository.save(littlePost);

        return "redirect:/";

    }
    @RequestMapping(path = "/edit-message" ,method = RequestMethod.POST)
    public String lo(String messageEdit, int id){
        Message editMessage = messageRepository.findOne(id);
        editMessage.setName(messageEdit);

        messageRepository.save(editMessage);

        return "redirect:/";
    }
}
