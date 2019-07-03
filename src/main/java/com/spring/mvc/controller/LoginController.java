package com.spring.mvc.controller;

import com.spring.mvc.actions.LoginAction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/index")
public class LoginController extends HttpServlet {
   // @RequestMapping(value = "/index",method = RequestMethod.GET)
//    protected String Index(){
//        System.out.println("welcome");
//        return "login";
//    }

    @RequestMapping("/LoginController")
    protected String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("login");
        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");

        System.out.print(username + userpassword);


        HttpSession session = request.getSession();

        LoginAction lc = new LoginAction();

        if (lc.isLogin(username, userpassword)) {
            return "loginSuccess";
//            session.setAttribute("login", "true");
//            request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);

        } else {

            //request.getRequestDispatcher("Login_failure.jsp").forward(request, response);
            return "loginSuccess";
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}