package controllers;

import dao.DaoXml;
import objects.Message;
import objects.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class ForumController {
    DaoXml<Message> daoXmlMessages = new DaoXml<>();
    String Path;
    String page;
    String Path2;
    Date date = new Date();
    Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String data = formatter.format(date);
//    User user;
//    Message message;
    File fileAuto;
    File fileSport;

    public File getFileAuto() {
        return fileAuto;
    }

    public void setFileAuto(File fileAuto) {
        this.fileAuto = fileAuto;
    }

    public File getFileSport() {
        return fileSport;
    }

    public void setFileSport(File fileSport) {
        this.fileSport = fileSport;
    }

    public ForumController() {
    }

//    public DaoXml<Message> getDaoXmlMessages() {
//        return daoXmlMessages;
//    }
//
//    public void setDaoXmlMessages(DaoXml<Message> daoXmlMessages) {
//        this.daoXmlMessages = daoXmlMessages;
//    }

    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPath2() {
        return Path2;
    }

    public void setPath2(String path2) {
        Path2 = path2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public Message getMessage() {
//        return message;
//    }
//
//    public void setMessage(Message message) {
//        this.message = message;
//    }

    @RequestMapping(value = "/sport", method = RequestMethod.POST)
    public String Sport(@RequestParam(value = "userName") String userName,
                        HttpServletRequest request) {
        if ((new File(Path)).exists()) {
            ArrayList<Message> messages = daoXmlMessages.getAll(Path, Message.class);
            if (!messages.isEmpty()) {
                request.setAttribute("messagesSport", messages);
                request.setAttribute("userName", userName);
                page = "SportForum";
            } else {
                request.setAttribute("userName", userName);
                page = "SportFirstMessage";
            }
        } else {
            page = "SportFirstMessage";
            try {
                fileSport.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return page;
        }
        return page;
    }

    @RequestMapping("/auto")
    public String Auto(@RequestParam(value = "userName") String userName,
                       HttpServletRequest request) {
        if ((new File(Path2)).exists()) {
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
        }else {
                page = "AutoFirstMessage";
                try {
                    fileAuto.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return page;
        }
    }

        @RequestMapping(value = "/sportMessage", method = RequestMethod.POST)
        public String Sport2 (@RequestParam(value = "userName") String userName,
                @RequestParam(value = "message") String message,
                HttpServletRequest request){
            if (message != null) {
                User user = new User(userName);
                Message newMsg = new Message(user,message,data);
                daoXmlMessages.add(newMsg,Path, Message.class, "sportmessages");
                ArrayList<Message> messages = daoXmlMessages.getAll(Path, Message.class);
            request.setAttribute("messagesSport", messages);
            request.setAttribute("userName", userName);
            page = "SportForum";
        }
        ArrayList<Message> messages = daoXmlMessages.getAll(Path, Message.class);
        request.setAttribute("messagesSport", messages);
        request.setAttribute("userName", userName);
        return page;
        }

        @RequestMapping(value = "/autoMessage", method = RequestMethod.POST)
        public String Auto2 (@RequestParam(value = "userName") String userName,
                @RequestParam(value = "message") String message,
                HttpServletRequest request){
            if (message != null) {
                User user = new User(userName);
                Message newMsg = new Message(user,message,data);
                daoXmlMessages.add(newMsg,Path2, Message.class, "sportmessages");
            ArrayList<Message> messages = daoXmlMessages.getAll(Path2, Message.class);
            request.setAttribute("messagesAuto", messages);
            request.setAttribute("userName", userName);
            page = "AutoForum";
        }

        return page;
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
