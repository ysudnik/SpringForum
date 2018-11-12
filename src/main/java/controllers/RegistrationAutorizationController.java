package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RegistrationAutorizationController {
    @RequestMapping("/registration")
    private String Registration(@RequestParam(value = "userName") String userName,
                                @RequestParam("passwordName") String passwordName,
                                HttpServletRequest request) {


        return "";
    }


    @RequestMapping("/autorization")
    private String Autorization(@RequestParam(value = "user") String user,
                                @RequestParam("password") String password,
                                HttpServletRequest request) {


        return "";
    }
}
