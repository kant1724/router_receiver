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
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://14.63.168.58:3306/router_apm" , "chatbot", "chatbot");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void insertRow(String ip, String log) {
        PreparedStatement psmt = null;
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sdf2 = new SimpleDateFormat("HHmmss");
            Date a = new Date();
            Date b = new Date();
            String date = sdf1.format(a);
            String time = sdf2.format(b);
            StringBuffer sql = new StringBuffer("INSERT INTO LOG_LIST (DATE, HOUR, MINUTE, SECONDS, LOG, IP) VALUES (CURRENT_TIMESTAMP, ?, ?, ?, ?, ?) ");
            psmt = connection.prepareStatement(sql.toString());
            psmt.setString(1, time.substring(0, 2));
            psmt.setString(2, time.substring(2, 4));
            psmt.setString(3, time.substring(4, 6));
            psmt.setString(4, log);
            psmt.setString(5, ip);
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
