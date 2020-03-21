package com.hkb.Dao;

import com.hkb.Bean.Park;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StateDao extends BaseDao{
    public ArrayList<Park> getParkState() throws SQLException {
        ArrayList<Park>stateList = new ArrayList<Park>();
        String sql = "SELECT * FROM park";
        Connection conn = dataSource.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rst = pstmt.executeQuery();
        while (rst.next()) {
            Park state = new Park();
            state.setParkno(rst.getString("Parkno"));
            state.setCarno(rst.getString("Carno"));
            state.setCartype(rst.getString("Cartype"));
            state.setIntime(rst.getTimestamp("Intime"));
            stateList.add(state);
        }
        conn.close();
        return stateList;
    }
}
