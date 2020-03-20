package com.hkb.Controler;

import com.hkb.Bean.Park;
import com.hkb.Bean.Recond;
import com.hkb.Dao.CheckInDao;
import com.hkb.Dao.OutDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@WebServlet("/Out")
public class OutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String Carno =  new String(request.getParameter("carno").getBytes("iso-8859-1"),"UTF-8");
        CheckInDao checkInDao = new CheckInDao();
        ArrayList<Park> exist = null;
        try {
            exist = checkInDao.ifexistCno(Carno);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Park car = exist.get(0);
        Date data_time = new Date();
        java.sql.Timestamp outtime = new java.sql.Timestamp(data_time.getTime());
        Calendar cale = Calendar.getInstance();
        Calendar calendar = new GregorianCalendar(cale.get(Calendar.YEAR),cale.get(Calendar.MONTH),cale.get(Calendar.DAY_OF_MONTH),8,0,0);
        Date date = calendar.getTime();
        java.sql.Timestamp deadline = new java.sql.Timestamp(date.getTime());
        java.sql.Timestamp intime = car.getIntime();
        long waittime =  outtime.getTime() - intime.getTime();
        int wait = (int)(waittime/60000);
        int cost = 0;
        int waithour = wait/60;
        int waitmin = wait%60;
        int day = waithour/24;
        int waitHour = waithour%24;
        cost+=16*day;
        if(outtime.after(deadline)){
            if(waitmin<60&&waitmin>15&&waitHour ==0){
                cost+=4;
            }
            else if(waitHour<4&&waitHour>=1){
                cost+=4*waitHour;
                int minter = wait - day*24*60 - waitHour*60;
                minter /=30;
                minter+=1;
                cost+=minter*2;
            }
            else if(waitHour>=4){
                cost+=16;
            }
        }
        else{
            cost+=4;
        }
        if(car.getCartype().equals("大型客车")||car.getCartype().equals("施工挂车")||car.getCartype().equals("载货卡车")){
            cost*=2;
        }
        Recond recond = new Recond(car.getParkno(),car.getCarno(),car.getCartype(),car.getIntime(),outtime,wait,cost);
        //之前都获得存入记录的所有的数据
        OutDao outDao = new OutDao();
        if(outDao.carOut(recond,Carno)){
            String title = "费用支付";
            String message = "出库成功，您本次的费用为"+cost+"元,祝您一路平安！";
            request.setAttribute("title", title);
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/pay.jsp");
            rd.forward(request, response);
        }
        else{
            String title = "收费管理";
            String message = "系统故障无法出库！";
            request.setAttribute("title", title);
            request.setAttribute("message", message);
            RequestDispatcher rd = request.getRequestDispatcher("/jsp/result.jsp");
            rd.forward(request, response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
