package com.hkb.Controler;

import com.hkb.Bean.Park;
import com.hkb.Dao.CheckInDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/CarOutServlet")
public class CarOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String carno = request.getParameter("carno");
        CheckInDao checkInDao = new CheckInDao();
        ArrayList<Park> exist = null;
        try {
            exist = checkInDao.ifexistCno(carno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(exist.isEmpty()){
            response.getWriter().print("false");
        }
        else {
            response.getWriter().print("true");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
