package com.pst.sms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    private static Connection con = null;

    public static Connection getConn() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/sms","root","lavish");
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return con;
    }
}
