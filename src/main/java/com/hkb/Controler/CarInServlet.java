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

@WebServlet("/CarInServlet")
public class CarInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        String carno = request.getParameter("carno");
        System.out.println(carno);
        CheckInDao checkInDao = new CheckInDao();
        ArrayList<Park> exist = null;
        ArrayList<Park> emptyList = null;
        try {
            exist = checkInDao.ifexistCno(carno);
            if(exist.isEmpty()) {//是否存在，若为空表示不存在，判断是否有空车位
                emptyList = checkInDao.getEmptyPark();
                if(emptyList.isEmpty()){//是否有空车位，若为空表示满
                    response.getWriter().print("full");
                }
            }
            else{
                System.out.println("经过了这里！");
                response.getWriter().print("exist");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
