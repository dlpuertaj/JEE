/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletfilter.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dlpuertaj
 */
public class ConnectionUtils {
    public static Connection getConnection() throws SQLException {

        String connectionURL = "jdbc:mysql://localhost:3306/logindb?zeroDateTimeBehavior=convertToNull";
        // Create a Connection to database.
        Connection conn = DriverManager.getConnection(connectionURL,"root","root");
        return conn;
    }
 
    public static void closeQuietly(Connection conn) {
        try {
            conn.close();
        } catch (Exception e) {
        }
    }
 
    public static void rollbackQuietly(Connection conn) {
        try {
            conn.rollback();
        } catch (Exception e) {
        }
    }
}
