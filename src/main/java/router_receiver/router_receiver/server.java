package router_receiver.router_receiver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

public class server extends Thread {
	public static void main(String[] args) throws IOException {
        final DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET);
        datagramChannel.bind(new InetSocketAddress(10523));
 
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("[���� ����]");
 
                try {
                    while (true) {
                        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(100);
                        SocketAddress socketAddress = datagramChannel.receive(byteBuffer);
                        byteBuffer.flip();
 
                        Charset charset = Charset.forName("UTF-8");
                        String data = charset.decode(byteBuffer).toString();
                        System.out.println("[���� ����: " + socketAddress.toString() + "] " + data);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                	System.out.println("[���� ����]");
                }
            }
        };
        thread.start();
	}
}
