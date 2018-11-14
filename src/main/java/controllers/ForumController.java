package controllers;

import dao.DaoXml;
import objects.Message;
import objects.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class ForumController {
    DaoXml<User> daoXmlUsers = new DaoXml<>();
    DaoXml<Message> daoXmlMessages = new DaoXml<>();
    String Path = "d:\\sportmessages.xml";
    String page;
    String Path2 = "d:\\automessages.xml";
    Date date = new Date();
    Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String data2 = formatter.format(date);

    @RequestMapping(value = "/sport", method = RequestMethod.POST)
    public String Sport(@RequestParam(value = "userName") String userName,
                        HttpServletRequest request) {

        ArrayList<Message> messages = daoXmlMessages.getAll(Path, Message.class);
        if (!messages.isEmpty()) {
            request.setAttribute("messagesSport", messages);
            request.setAttribute("userName", userName);
            page = "SportForum";
        } else {
            request.setAttribute("userName", userName);
            page = "SportFirstMessage";
        }

        return page;
    }

    @RequestMapping("/auto")
    public String Auto(@RequestParam(value = "userName") String userName,
                       HttpServletRequest request) {
        ArrayList<Message> messages = daoXmlMessages.getAll(Path2, Message.class);
        if (!messages.isEmpty()) {
            request.setAttribute("messagesAuto", messages);
            request.setAttribute("userName", userName);
            page = "AutoForum";
        } else {
            request.setAttribute("userName", userName);
            page = "AutoFirstMessage";
        }
        return page;
    }

    @RequestMapping(value = "/sportMessage", method = RequestMethod.POST)
    public String Sport2(@RequestParam(value = "userName") String userName,
                         @RequestParam(value = "message") String message,
                         HttpServletRequest request) {
        if (message != null) {
            User user = new User(userName);
            Message newMsg = new Message(user, message, data2);
            daoXmlMessages.add(newMsg, Path, Message.class, "sportmessages");
        }
        ArrayList<Message> messages = daoXmlMessages.getAll(Path, Message.class);
        request.setAttribute("messagesSport", messages);
        request.setAttribute("userName", userName);
        return "SportForum";
    }

    @RequestMapping(value = "/autoMessage", method = RequestMethod.POST)
    public String Auto2(@RequestParam(value = "userName") String userName,
                        @RequestParam(value = "message") String message,
                        HttpServletRequest request) {
        if (message != null) {
            User user2 = new User(userName);
            Message newMsg = new Message(user2, message, data2);
            daoXmlMessages.add(newMsg, Path2, Message.class, "automessages");
        }
        ArrayList<Message> messages = daoXmlMessages.getAll(Path2, Message.class);
        request.setAttribute("messagesAuto", messages);
        request.setAttribute("userName", userName);
        return "AutoForum";
    }

//    @RequestMapping(value = "/autoMessage", method = RequestMethod.GET)
//    public String Auto3(@RequestParam(value = "userName") String userName,
//                        @RequestParam(value = "message") String message,
//                        HttpServletRequest request) {
//        if (message != null) {
//            ArrayList<Message> messages = daoXmlMessages.getAll(Path2, Message.class);
//            request.setAttribute("messagesAuto", messages);
//            request.setAttribute("userName", userName);
//            page = "AutoForum";
//        }
//
//        return page;
//    }
//
//    @RequestMapping(value = "/sportMessage", method = RequestMethod.GET)
//    public String Sport3(@RequestParam(value = "userName") String userName,
//                         @RequestParam(value = "message") String message,
//                         HttpServletRequest request) {
//        if (message != null) {
//            ArrayList<Message> messages = daoXmlMessages.getAll(Path, Message.class);
//            request.setAttribute("messagesSport", messages);
//            request.setAttribute("userName", userName);
//            page = "SportForum";
//        }
//        ArrayList<Message> messages = daoXmlMessages.getAll(Path, Message.class);
//        request.setAttribute("messagesSport", messages);
//        request.setAttribute("userName", userName);
//        return page;
//    }

}
