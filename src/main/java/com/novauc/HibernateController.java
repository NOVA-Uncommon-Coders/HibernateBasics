package com.novauc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HibernateController {

    @Autowired
    MessageRepository messages;
    @Autowired
    UserRepository users;

    /***********************
     * GET routes
     ***********************/

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index(Model model, HttpSession session) {
        List<Message> messageList = (List<Message>) messages.findAll();
        model.addAttribute("user", session.getAttribute("user"));
        model.addAttribute("messages", messageList);
        return "home";
    }

    /***********************
     * POST routes
     ***********************/

    @RequestMapping(path ="/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName){
            User user = null;
            
            if (user == null){
                user = new User(userName);
                users.save(user);
            }

            session.setAttribute("user", user);
            return "redirect:/";
    }
    @RequestMapping(path ="/logout", method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
    @RequestMapping(path ="/add-message", method = RequestMethod.POST)
    public String addMessage(HttpSession session, String message){
        User user = (User)session.getAttribute("user");
        messages.save(new Message(message, user.getId()));
        return "redirect:/";
    }
    @RequestMapping(path ="/edit-message", method = RequestMethod.POST)
    public String updateMessage(HttpSession session, int id, String message){
        Message messageObj = messages.findOne(id);
        messageObj.setMessage(message);
        messages.save(messageObj);
        return "redirect:/";
    }
}

