package com.hkb.Controler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Skip")
public class SkipServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("in")){
            response.sendRedirect("jsp/in.jsp");
        }
        else if(action.equals("index")){
            response.sendRedirect("index.jsp");
        }
        else if(action.equals("out")){
            response.sendRedirect("jsp/out.jsp");
        }
    }
}
