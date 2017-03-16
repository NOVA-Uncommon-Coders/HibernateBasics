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
        List<Message> messageList = (List<Message>) messages.findAllByOrderByIdAsc();
        model.addAttribute("currentUser",  users.findFirstByUserName((String) session.getAttribute("userName")));
        model.addAttribute("messages", messageList);
        return "home";
    }

    /***********************
     * POST routes
     ***********************/

    @RequestMapping(path ="/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName){
            User user = users.findFirstByUserName(userName);
            if (user == null){
                user = new User(userName);
                users.save(user);
            }

            session.setAttribute("userName",userName );
            return "redirect:/";
    }
    @RequestMapping(path ="/logout", method = RequestMethod.POST)
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
    @RequestMapping(path ="/add-message", method = RequestMethod.POST)
    public String addMessage(HttpSession session, String message){
        messages.save(new Message(message, users.findFirstByUserName((String) session.getAttribute("userName"))));
        return "redirect:/";
    }
    @RequestMapping(path ="/edit-message", method = RequestMethod.POST)
    public String updateMessage(int id, String message){
        Message messageObj = messages.findOne(id);
        messageObj.setMessage(message);
        messages.save(messageObj);
        return "redirect:/";
    }
    @RequestMapping(path="/delete-message", method = RequestMethod.POST)
    public String deleteMessage(int id){
        messages.delete(id);
        return "redirect:/";
    }
}

