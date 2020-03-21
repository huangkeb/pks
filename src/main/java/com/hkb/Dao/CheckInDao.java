package com.hkb.Dao;

import com.hkb.Bean.Park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CheckInDao extends BaseDao{
    public ArrayList<Park> getEmptyPark() throws SQLException {//检测入库时是否有空车位
        ArrayList<Park> emptyList = new ArrayList<Park>();
        String sql = "SELECT Parkno FROM Park WHERE Carno IS NULL";
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rst = pstmt.executeQuery();
        while(rst.next()){
            Park empty = new Park();
            empty.setParkno(rst.getString("Parkno"));
            emptyList.add(empty);
        }
        conn.close();
        return emptyList;
    }

    public ArrayList<Park> ifexistCno(String Cno) throws SQLException {//检测入库时是否已存在
        ArrayList<Park>ParkList = new ArrayList<Park>();
        String sql = "SELECT * FROM park WHERE Carno = ?";
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,Cno);
        ResultSet rst = pstmt.executeQuery();
        while(rst.next()){
            Park state = new Park();
            state.setParkno(rst.getString("Parkno"));
            state.setCarno(rst.getString("Carno"));
            state.setCartype(rst.getString("Cartype"));
            state.setIntime(rst.getTimestamp("Intime"));
            ParkList.add(state);
        }
        conn.close();
        return ParkList;
    }
}
