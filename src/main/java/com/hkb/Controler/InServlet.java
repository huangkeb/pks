package com.hkb.Controler;

import com.hkb.Bean.Park;
import com.hkb.Dao.CheckInDao;
import com.hkb.Dao.InDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@WebServlet("/in")
public class InServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Carno =  new String(request.getParameter("carno").getBytes("iso-8859-1"),"UTF-8");
        String Cartype = request.getParameter("cartype");
        ArrayList<Park> emptyList = null;
        CheckInDao checkInDao = new CheckInDao();
        try {
            emptyList = checkInDao.getEmptyPark();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(Cartype.equals("1")){
            Cartype = "小型汽车";
        }
        else if(Cartype.equals("2")){
            Cartype = "大型客车";
        }
        else if(Cartype.equals("3")){
            Cartype = "载货卡车";
        }
        else if(Cartype.equals("4")){
            Cartype = "施工挂车";
        }
        else if(Cartype.equals("5")){
            Cartype = "小型轿车";
        }
        else if(Cartype.equals("6")){
            Cartype = "小型客车";
        }
        Date data_time = new Date();
        java.sql.Timestamp intime = new java.sql.Timestamp(data_time.getTime());
        Random ra =new Random();
        Park empty = emptyList.get(ra.nextInt(emptyList.size()));
        String Parkno = empty.getParkno();
        Park park = new Park(Parkno,Carno,Cartype,intime);
        InDao inDao = new InDao();
        boolean sucess = inDao.updatepark(park);
        if(sucess== false){
            String title = "车辆入库结果";
            String message = "系统错误，请稍后重试！";
            request.setAttribute("title", title);
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/result.jsp");
            rd.forward(request, response);
        }
        else{
            String title = "车辆入库结果";
            String message = "车辆入库成功，您的车位是"+Parkno+"号";
            request.setAttribute("title", title);
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/result.jsp");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
