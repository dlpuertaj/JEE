/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servletfilter.conn;

import java.sql.Connection;
import javax.servlet.ServletRequest;

/**
 *
 * @author dlpuertaj
 */
public class MyUtils {
    public static final String ATT_NAME = "MY_CONNECTION_ATTRIBUTE";
 
    // Store Connection to attribute of request
    // Information stored only exists during request
    // until the data is returned to the user browser.
    public static void storeConnection(ServletRequest request, Connection conn) {
        request.setAttribute(ATT_NAME, conn);
    }
 
    // Get the Connection object that has been stored in one attribute of the request.
    public static Connection getStoredConnection(ServletRequest request) {
        Connection conn = (Connection) request.getAttribute(ATT_NAME);
        return conn;
    }
}
