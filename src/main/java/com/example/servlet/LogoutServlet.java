package com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException{
        servletRequest.getSession().removeAttribute("user");
        servletRequest.getSession().invalidate();
        servletResponse.sendRedirect("login.jsp");
    }
}
