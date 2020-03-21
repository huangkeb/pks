package com.hkb.Controler;

import com.hkb.Bean.Recond;
import com.hkb.Dao.RecondDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet("/recond")
public class RecondServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String carno = new String(request.getParameter("carno").getBytes("iso-8859-1"),"Utf-8");//车牌号
        String begin = request.getParameter("begintime");
        String end = request.getParameter("endtime");
        java.sql.Timestamp begintime = null;
        java.sql.Timestamp endtime = null;
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = format.parse(begin);
            date2 = format.parse(end);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        begintime = new java.sql.Timestamp(date1.getTime());//开始时间
        endtime = new java.sql.Timestamp(date2.getTime());//结束时间
        RecondDao recondDao = new RecondDao();
        ArrayList<Recond> reconds = recondDao.searchRecond(carno, begintime, endtime);
        request.setAttribute("recondlist", reconds);
        RequestDispatcher rd = request.getRequestDispatcher("/jsp/display.jsp");
        rd.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
