package router_receiver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

public class server extends Thread {
	public static void main(String[] args) throws IOException {
        DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET);
        datagramChannel.bind(new InetSocketAddress(10523));
 
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("[수신 시작]");
 
                try {
                    while (true) {
                        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
                        SocketAddress socketAddress = datagramChannel.receive(byteBuffer);
                        byteBuffer.flip();
 
                        Charset charset = Charset.forName("UTF-8");
                        String data = charset.decode(byteBuffer).toString();
                        System.out.println("[받은 내용: " + socketAddress.toString() + "] " + data);
                    }
                } catch (Exception e) {
                    System.out.println("[수신 종료]");
                }
            }
        };
        thread.start();
        try {
        	Thread.sleep(10000);
        } catch (Exception e) {}
        datagramChannel.close();
	}
}
