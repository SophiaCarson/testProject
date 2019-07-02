package com.spring.mvc.controller;

import actions.LoginAction;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequestMapping("login")
public class LoginController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");

        System.out.print(username + userpassword);


        HttpSession session = request.getSession();

        LoginAction lc = new LoginAction();

        if (lc.isLogin(username, userpassword)) {

            session.setAttribute("login", "true");
            request.getRequestDispatcher("Login_success.jsp").forward(request, response);

        } else {

            request.getRequestDispatcher("Login_failure.jsp").forward(request, response);
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}