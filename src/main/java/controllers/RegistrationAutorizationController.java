package controllers;

import dao.DaoXml;
import objects.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RegistrationAutorizationController {


    DaoXml<User> daoXmlUsers = new DaoXml<>();
    String Path = "d:\\work\\users.xml";



    @RequestMapping("/autorization")
    public String Autorization(@RequestParam("user") String user,
                               @RequestParam("password") String password,
                               HttpServletRequest request) {
        List<User> fullusers = daoXmlUsers.getAll(Path, User.class);
        String page = "";
        for (User user1 : fullusers) {
            if (user1.getName().equals(user) && user1.getPass().equals(password)) {
                request.setAttribute("userName", user);
                request.setAttribute("password", password);
                page = "ChooseThema";
                return page;

            }else{
                page = "AutorizationAtOnce";
            }

        }

        return page;
    }
    @RequestMapping("/registration")
    public String Registration(@RequestParam(value = "user") String user,
                               @RequestParam("password") String password,
                               HttpServletRequest request) {
        List<User> fullusers = daoXmlUsers.getAll(Path, User.class);
        String page = "";
        User user2 = new User(user, password);
        for (User user1 : fullusers) {
            if (fullusers.isEmpty()) {
                daoXmlUsers.add(user2, Path, User.class, "users");
                page = "Autorization";
                return page;
            } else if (user1.getName().equals(user)) {
                page = "RegistrationAtOnce";
                return page;
            }
        }
        daoXmlUsers.add(user2, Path, User.class, "users");
        page = "Autorization";
        return page;
    }
}
