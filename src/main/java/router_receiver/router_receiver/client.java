package router_receiver.router_receiver;

import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class client {
	 
	public static void main(String[] args) throws Exception {
        DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET);
        
        while (true) {
            String data = "log list";
            Charset charset = Charset.forName("UTF-8");
            ByteBuffer byteBuffer = charset.encode(data);
 
            int byteCount = datagramChannel.send(byteBuffer, new InetSocketAddress("14.63.168.58", 10523));
 
            System.out.println("[send byte] " + byteCount + " bytes");
            Thread.sleep(1000);
        }
 
        //datagramChannel.close();
    }

}
