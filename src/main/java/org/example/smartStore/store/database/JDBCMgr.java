package org.example.smartStore.store.database;

import org.springframework.jdbc.support.JdbcUtils;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class JDBCMgr { // h2 DB 연결

    private JDBCMgr() {
    }

    public Connection getConnection() {
        Connection conn = null;

        try {
            DriverManager.registerDriver(new org.h2.Driver());
            conn = DriverManager.getConnection("jdbc:h2:~/JDBC", "sa", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }


    public void close(PreparedStatement stmt, Connection conn) {
        JdbcUtils.closeStatement(stmt);
        JdbcUtils.closeConnection(conn);
    }

    // ResultSet: SQL 실행결과 저장 객체
    // PreparedStatement: PreCompiled SQL 저장 객체
    // Connection: DB 커넥션 객체
    public  void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
        JdbcUtils.closeResultSet(rs);
        JdbcUtils.closeStatement(stmt);
        JdbcUtils.closeConnection(conn);

    }
}