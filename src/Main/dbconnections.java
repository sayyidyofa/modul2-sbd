/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author Yoffa
 */
public class dbconnections {
    Connection c;
    Statement script;
    
    public dbconnections(){
        try{ 
            //sebagai class reference untuk conect ke database
            Class.forName("oracle.jdbc.driver.OracleDriver");
            c = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:8002/xe", "system", "basisdata");
            script = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            //memberikan peringatan bila bila koneksi ke database berhasil
            System.out.println("Koneksi Sukses");
        } catch(SQLException | ClassNotFoundException ex) {
            System.err.print(ex);
        }
    }
}
