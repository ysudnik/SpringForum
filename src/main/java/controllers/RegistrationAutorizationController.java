package controllers;

import dao.DaoXml;
import objects.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class RegistrationAutorizationController {

    String Path3;
    DaoXml<User> daoXmlUsers;
    User user;
    File file;

    public String getPath3() {
        return Path3;
    }

    public void setPath3(String path3) {
        Path3 = path3;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public RegistrationAutorizationController() {
    }


    public DaoXml<User> getDaoXmlUsers() {
        return daoXmlUsers;
    }

    public void setDaoXmlUsers(DaoXml<User> daoXmlUsers) {
        this.daoXmlUsers = daoXmlUsers;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @RequestMapping("/autorization")
    public String Autorization(@RequestParam("user") String name,
                               @RequestParam("password") String password,
                               HttpServletRequest request) {
        String page = null;
        if ((new File(Path3)).exists()) {
            List<User> fullusers = daoXmlUsers.getAll(Path3, User.class);
            if (!fullusers.isEmpty()) {
                for (User user1 : fullusers) {
                    if (user1.getName().equals(name) && user1.getPass().equals(password)) {
                        request.setAttribute("userName", name);
                        request.setAttribute("password", password);
                        page = "ChooseThema";
                        return page;

                    } else {
                        page = "AutorizationAtOnce";
                    }

                }
            } else {
                page = "RegistrationAtOnce";
            }
        } else {
            page = "RegistrationAtOnce";
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return page;
    }

    @RequestMapping("/registration")
    public String Registration(@RequestParam(value = "user") String name,
                               @RequestParam("password") String password,
                               HttpServletRequest request) {

        String page = null;
        if ((new File(Path3)).exists()) {
            List<User> fullusers = daoXmlUsers.getAll(Path3, User.class);
            user.setName(name);
            user.setPass(password);
            for (User user1 : fullusers) {
                if (user1.getName().equals(name)) {
                    page = "RegistrationAtOnce";
                    return page;
                }
            }
            daoXmlUsers.add(user, Path3, User.class, "users");
            page = "Autorization";
            return page;
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            user.setName(name);
            user.setPass(password);
            daoXmlUsers.add(user, Path3, User.class, "users");
            page = "Autorization";
            return page;
        }

    }
}
