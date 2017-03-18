package com.novauc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by souporman on 3/16/17.
 */

@Controller
public class HibernateBasicsController {

    @Autowired
    MessageRepo message;

    @Autowired
    UserRepo users;

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName, String password) throws Exception {
        User user = users.findFirstByName(userName);
        if (user == null) {
            user = new User(userName, password);
            users.save(user);
        }
        else if (!password.equals(user.getPassword())) {
            throw new Exception("Incorrect password");
        }
        session.setAttribute("userName", userName);
        return "redirect:/";
    }


    @RequestMapping(path = "/logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }


    @RequestMapping(path = "/add-message", method = RequestMethod.POST)
    public String addMessage(HttpSession session, String messageInput) {
        String userName = (String) session.getAttribute("userName");
        User user = users.findFirstByName(userName);
        Message messageObj = new Message(messageInput, user);
        message.save(messageObj);
        return "redirect:/";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(HttpSession session ,Model model) {
        List<Message> messageList;
        User user = users.findFirstByName(String.valueOf(session.getAttribute("userName")));
        if (user != null) {
            messageList = message.findByUser(user);
            model.addAttribute("messagesOut", messageList);
        }
        return "home.html";
    }
}
