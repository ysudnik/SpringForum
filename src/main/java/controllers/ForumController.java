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
    public DaoXml<Message> getDaoXmlMessages() {
        return daoXmlMessages;
    }

    public void setDaoXmlMessages(DaoXml<Message> daoXmlMessages) {
        this.daoXmlMessages = daoXmlMessages;
    }

    DaoXml<Message> daoXmlMessages;
    String Path;
    String Path2;
    Date date = new Date();
    Format formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    String data = formatter.format(date);
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


    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
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

    @RequestMapping(value = "/sport", method = RequestMethod.POST)
    public String Sport(@RequestParam(value = "userName") String userName,
                        HttpServletRequest request) {
        String attribute ="messagesSport";
        String forum= "SportForum";
        return method(request,userName,Path,attribute,forum);
    }

    @RequestMapping("/auto")
    public String Auto(@RequestParam(value = "userName") String userName,
                       HttpServletRequest request) {
        String attribute ="messagesAuto";
        String forum= "AutoForum";
        return method(request,userName,Path2,attribute,forum);
    }


    @RequestMapping(value = "/sportMessage", method = RequestMethod.POST)
    public String Sport2(@RequestParam(value = "userName") String userName,
                         @RequestParam(value = "message") String message,
                         HttpServletRequest request) {
        String attribute = "messagesSport";
        String forum = "SportForum";
        return method2 (request,userName,message,attribute,forum,Path);

    }

    private String method2(HttpServletRequest request,String userName, String message, String attribute, String forum,String way) {
        request.setAttribute("userName", userName);
        String page = null;
        if (message != null) {
            User user = new User(userName);
            Message newMsg = new Message(user, message, data);
            daoXmlMessages.add(newMsg, way, Message.class, attribute);
            ArrayList<Message> messages = daoXmlMessages.getAll(way, Message.class);
            request.setAttribute(attribute, messages);
            page = forum;
        }
        return page;
    }

    @RequestMapping(value = "/autoMessage", method = RequestMethod.POST)
    public String Auto2(@RequestParam(value = "userName") String userName,
                        @RequestParam(value = "message") String message,
                        HttpServletRequest request) {
        String attribute = "messagesAuto";
        String forum = "AutoForum";
        return method2 (request,userName,message,attribute,forum,Path2);
    }

    private String method (HttpServletRequest request,String userName,String way,String attribut,String forum){
        String page;
        request.setAttribute("userName", userName);
        if ((new File(way)).exists()) {
            ArrayList<Message> messages = daoXmlMessages.getAll(way, Message.class);
            if (!messages.isEmpty()) {
                request.setAttribute(attribut, messages);
                page = forum;
            } else {
                messages = null;
                request.setAttribute(attribut, messages);
                page = forum;
            }
        } else {
            page = forum;
            try {
                fileSport.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return page;
    }
}
