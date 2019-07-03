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

public class ToLoginController extends HttpServlet {
    @RequestMapping(value = "/ToLoginController")
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        System.out.println("xx");
        session.setAttribute("login", "true");
        request.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(request, response);
       // return "login";

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
