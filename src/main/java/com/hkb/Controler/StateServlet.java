package com.hkb.Controler;

import com.hkb.Bean.Park;
import com.hkb.Dao.StateDao;
import com.hkb.Util.Constant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/State")
public class StateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StateDao stateDao = new StateDao();
        ArrayList<Park> parkList = null;
        try {
            parkList = stateDao.getParkState();
        } catch (SQLException e) {
            System.out.println(e);
        }
        if(!parkList.isEmpty()){
            for(int i = 0;i<parkList.size();i++){
                Park park = parkList.get(i);
            }
            request.getSession().setAttribute("stateList", parkList);
        }
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/state.jsp");
        rd.forward(request, response);
    }
}
