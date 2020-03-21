package com.hkb.Dao;

import com.hkb.Bean.Recond;

import java.sql.*;
import java.util.ArrayList;

public class RecondDao extends BaseDao{
    public ArrayList<Recond> searchRecond(String carno, Timestamp begin,Timestamp end){
        ArrayList<Recond> reconds = new ArrayList<>();
        String sql = "select * from recond where Carno=? and Outtime<? and Outtime>?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,carno);
            pstmt.setTimestamp(2,end);
            pstmt.setTimestamp(3,begin);
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                Recond recond = new Recond();
                recond.setParkno(rst.getString("Parkno"));
                recond.setCarno(rst.getString("Carno"));
                recond.setCartype(rst.getString("Cartype"));
                recond.setCost(rst.getInt("Cost"));
                recond.setIntime(rst.getTimestamp("Intime"));
                recond.setOuttime(rst.getTimestamp("Outtime"));
                recond.setWaittime(rst.getInt("Waittime"));
                reconds.add(recond);
            }
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return reconds;
    }
}
