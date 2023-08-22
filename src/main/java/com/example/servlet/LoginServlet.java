package com.example.servlet;

import com.example.Users;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        Users user = (Users) servletRequest.getSession().getAttribute("user");
        if (user == null) {
            servletResponse.sendRedirect("login.jsp");
        } else {
            servletResponse.sendRedirect("user/hello.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {
        String login = servletRequest.getParameter("login");
        String password = servletRequest.getParameter("password");

        Users users = Users.getInstance();


        if (users.getUsers().contains(login) && !password.isEmpty()) {
            servletRequest.getSession().setAttribute("user", login);
            servletResponse.sendRedirect("user/hello.jsp");
        } else {
            servletRequest.getRequestDispatcher("login.jsp").forward(servletRequest, servletResponse);
        }
    }
}
