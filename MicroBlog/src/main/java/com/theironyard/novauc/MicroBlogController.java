package com.theironyard.novauc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.persistence.GeneratedValue;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by octavio on 3/15/17.
 */

@Controller
public class MicroBlogController {

    @Autowired
    MessageRepository messages;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model) {
        List<Message> messageList = (ArrayList) messages.findAll();
        model.addAttribute("messages", messageList);
        return "home";
    }

    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(String messageMensaje) {
        Message message = new Message(messageMensaje);
        messages.save(message);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message", method = RequestMethod.POST)
    public String editMessage(String messageMensaje, int messageId) {
        Message message = messages.findOne(messageId);
        message.setMensaje(messageMensaje);
        messages.save(message);
        return "redirect:/";
    }

}
