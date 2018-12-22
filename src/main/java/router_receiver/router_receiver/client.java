package router_receiver.router_receiver;

import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

public class client {
	 
	public static void main(String[] args) throws Exception {
        DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET);
        
        while (true) {
        	SimpleDateFormat sdf2 = new SimpleDateFormat("HHmmss");
            Date a = new Date();
            String time = sdf2.format(a);
            int seconds = Integer.parseInt(time.substring(4));
            String data = "ok";
            if (seconds >= 40) {
            	data = "not ok";
            }
            Charset charset = Charset.forName("UTF-8");
            ByteBuffer byteBuffer = charset.encode(data);
 
            int byteCount = datagramChannel.send(byteBuffer, new InetSocketAddress("14.63.168.58", 10523));
 
            System.out.println("[send byte] " + byteCount + " bytes");
            Thread.sleep(1000);
        }
 
        //datagramChannel.close();
    }

}
