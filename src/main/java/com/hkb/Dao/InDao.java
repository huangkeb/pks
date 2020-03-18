package com.hkb.Dao;

import com.hkb.Bean.Park;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InDao extends BaseDao{
    public boolean updatepark(Park park){
        String sql = "UPDATE Park SET Carno=?,Cartype=?,Intime=? WHERE Parkno = ?";
        try(
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, park.getCarno());
            pstmt.setString(2, park.getCartype());
            pstmt.setTimestamp(3, park.getIntime());
            pstmt.setString(4, park.getParkno());
            pstmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}
