package router_receiver.router_receiver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dao {	
	Connection connection = null;
	
	public dao() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql:주소:포트/DB명" , "username", "password");
		} catch(Exception e) {}
	}
	
	public void insertRow(String ip, String log) {		
		PreparedStatement psmt = null;
	    try {
	    	Class.forName("com.mysql.jdbc.Driver");            
    		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("HHmmss");
            Date a = new Date();
            Date b = new Date();
            String date = sdf1.format(a);
            String time = sdf2.format(b);
            StringBuffer sql = new StringBuffer(" INSERT INTO poll (col1, col2 ) VALUES (?, ?) ");
            psmt = connection.prepareStatement(sql.toString());
            psmt.setString(1, ip);
            psmt.setString(2, date);
            psmt.setString(3, time.substring(0, 2));
            psmt.setString(4, time.substring(2, 4));
            psmt.setString(5, time.substring(4, 6));
            psmt.setString(6, log);
            psmt.executeUpdate();
            psmt.close();            
        } catch (SQLException se1) {
            se1.printStackTrace();            
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (psmt != null)
                	psmt.close();
            } catch (SQLException se2) {}            
        }
    }
}
