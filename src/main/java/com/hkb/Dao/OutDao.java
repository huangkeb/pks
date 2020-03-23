package com.hkb.Dao;

import com.hkb.Bean.Recond;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OutDao extends BaseDao{//数据库事务，确保车辆出库、保存记录两件事全部正确或全部错误
    public boolean carOut(Recond recond,String Cno){
        String sql1 = "INSERT INTO recond VALUES(?,?,?,?,?,?,?)";
        String sql2 = "UPDATE park SET Carno=NULL,Cartype=NULL,Intime=NULL WHERE Carno = ?";
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            PreparedStatement pstmt1 = conn.prepareStatement(sql1);
            pstmt1.setString(1,recond.getParkno());
            pstmt1.setString(2,recond.getCarno());
            pstmt1.setString(3,recond.getCartype());
            pstmt1.setTimestamp(4, recond.getIntime());
            pstmt1.setTimestamp(5, recond.getOuttime());
            pstmt1.setInt(6, recond.getWaittime());
            pstmt1.setInt(7, recond.getCost());
            pstmt1.executeUpdate();
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setString(1, Cno);
            pstmt2.executeUpdate();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
                return false;
            }
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
