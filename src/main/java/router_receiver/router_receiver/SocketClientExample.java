package router_receiver.router_receiver;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class SocketClientExample {
  public static void main(String[] args) {
      try {
          InetSocketAddress crunchifyAddr = new InetSocketAddress("14.63.168.58", 8080);
          SocketChannel crunchifyClient = SocketChannel.open();

          System.out.println("Connecting to Server on port 1111...");

          ArrayList<String> companyDetails = new ArrayList<String>();

          // create a ArrayList with companyName list
          companyDetails.add("Facebook");
          companyDetails.add("Twitter");
          companyDetails.add("IBM");
          companyDetails.add("Google");
          companyDetails.add("Crunchify");

          crunchifyClient.configureBlocking(false);

      crunchifyClient.socket().setTcpNoDelay(true);
        Selector socketSelector = Selector.open();
        boolean ok = false;
          crunchifyClient.register(socketSelector, SelectionKey.OP_CONNECT, null);
          if (crunchifyClient.connect(crunchifyAddr) != true) {
        	  socketSelector.select(3000);  
              Set<SelectionKey> keys = socketSelector.selectedKeys();
              Iterator<SelectionKey> it = keys.iterator();
              while (it.hasNext()) {
                  System.out.println("select key exists!!!!!!...");
                  SelectionKey key = (SelectionKey) it.next();
                  if (key.isConnectable()) {
                      crunchifyClient.finishConnect();
                  }
                  ok = true;
              }
              if (!ok) {
                  System.out.println("@@@@@@@@select key empty!!!!!!!!!!!!!!!!...");
              }
          }
      } catch (Exception e) {
          e.printStackTrace();
      }
  	}
}
