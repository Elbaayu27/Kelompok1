/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klp1.config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Elba
 */
public class Koneksi {
    
private static String url = "jdbc:mysql://localhost:3306/klp1";
    private static String user ="root";
    private static String pass = "";    
    private static Connection connection;
    
    public static Connection getConnection() throws SQLException{
        if (connection == null) {            
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection = (Connection) DriverManager.getConnection(url, user, pass);            
            } catch (SQLException ex) {
                throw ex;
            }            
        }
        return connection;
    }
}
