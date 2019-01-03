package router_receiver.router_receiver;

import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class client {
    
   public static void main(String[] args) throws Exception {
        DatagramChannel datagramChannel = DatagramChannel.open(StandardProtocolFamily.INET);
        

        Random random = new Random();
        
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
            
            int k = random.nextInt(vRealLogs.length);
            data = vRealLogs[k];
            
            
            ByteBuffer byteBuffer = charset.encode(data);
 
            int byteCount = datagramChannel.send(byteBuffer, new InetSocketAddress("14.63.168.58", 10523));
 
            //System.out.println("[send byte] " + byteCount + " bytes");
            Thread.sleep(1000);
        }
 
        //datagramChannel.close();
    }

   
   
   
   static String[] vRealLogs =
          { "<188>704: Feb 13 20:56:50 KST:%CDP-4-DUPLEX_MISMATCH: duplex mismatch discovered on FastEthernet0/12 (not half duplex), with Dreamport FastEthernet0/0 (half duplex)."
         , "<188>735: Feb 13 21:06:07 KST:%CDP-4-DUPLEX_MISMATCH: duplex mismatch discovered on FastEthernet0/12 (not half duplex), with Dreamport FastEthernet0/1 (half duplex)."
         , "<188>734: Feb 13 21:06:05 KST:%CDP-4-DUPLEX_MISMATCH: duplex mismatch discovered on FastEthernet0/19 (not half duplex), with Dreamport FastEthernet0/0 (half duplex)."
         , "<188>702: Feb 13 20:56:50 KST:%CDP-4-DUPLEX_MISMATCH: duplex mismatch discovered on FastEthernet0/19 (not half duplex), with Dreamport FastEthernet0/1 (half duplex)."
         , "<189>642: Feb  2 02:07:13.198:%CLEAR-5-COUNTERS: Clear counter on all interfaces by kspop on vty0 (192.168.3.1)"
         , "<189>823: Apr  2 14:49:02 KST:%CLEAR-5-COUNTERS: Clear counter on all interfaces by kspop on vty0 (192.168.3.7)"
         , "<189>777: Mar 26 21:01:57 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/10, changed state to down"
         , "<189>818: Mar 26 21:05:21 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/10, changed state to up"
         , "<189>802: Mar 26 21:05:17 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/11, changed state to down"
         , "<189>791: Mar 26 21:02:01 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/11, changed state to up"
         , "<189>645: Feb  3 13:51:03.229:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/12, changed state to down"
         , "<189>651: Feb  3 13:51:14.746:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/12, changed state to up"
         , "<189>778: Mar 26 21:01:57 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/14, changed state to down"
         , "<189>813: Mar 26 21:05:19 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/14, changed state to up"
         , "<189>803: Mar 26 21:05:17 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/15, changed state to down"
         , "<189>794: Mar 26 21:02:02 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/15, changed state to up"
         , "<189>779: Mar 26 21:01:57 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/17, changed state to down"
         , "<189>819: Mar 26 21:05:21 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/17, changed state to up"
         , "<189>804: Mar 26 21:05:17 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/18, changed state to down"
         , "<189>792: Mar 26 21:02:02 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/18, changed state to up"
         , "<189>644: Feb  3 13:51:03.187:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/19, changed state to down"
         , "<189>650: Feb  3 13:51:14.704:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/19, changed state to up"
         , "<189>775: Mar 26 21:01:56 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/2, changed state to down"
         , "<189>817: Mar 26 21:05:21 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/2, changed state to up"
         , "<189>769: Feb 21 16:20:53 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/23, changed state to down"
         , "<189>768: Feb 21 16:15:43 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/23, changed state to up"
         , "<189>800: Mar 26 21:05:16 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/3, changed state to down"
         , "<189>786: Mar 26 21:02:00 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/3, changed state to up"
         , "<189>508: Mar  1 03:47:15 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/6, changed state to down"
         , "<189>511: Mar  1 03:48:03 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/6, changed state to up"
         , "<189>776: Mar 26 21:01:57 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/8, changed state to down"
         , "<189>812: Mar 26 21:05:19 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/8, changed state to up"
         , "<189>801: Mar 26 21:05:17 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/9, changed state to down"
         , "<189>793: Mar 26 21:02:02 KST:%LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/9, changed state to up"
         , "<187>782: Mar 26 21:01:58 KST:%LINK-3-UPDOWN: Interface FastEthernet0/10, changed state to down"
         , "<187>815: Mar 26 21:05:20 KST:%LINK-3-UPDOWN: Interface FastEthernet0/10, changed state to up"
         , "<187>807: Mar 26 21:05:18 KST:%LINK-3-UPDOWN: Interface FastEthernet0/11, changed state to down"
         , "<187>787: Mar 26 21:02:00 KST:%LINK-3-UPDOWN: Interface FastEthernet0/11, changed state to up"
         , "<187>647: Feb  3 13:51:04.227:%LINK-3-UPDOWN: Interface FastEthernet0/12, changed state to down"
         , "<187>649: Feb  3 13:51:13.740:%LINK-3-UPDOWN: Interface FastEthernet0/12, changed state to up"
         , "<187>783: Mar 26 21:01:58 KST:%LINK-3-UPDOWN: Interface FastEthernet0/14, changed state to down"
         , "<187>811: Mar 26 21:05:18 KST:%LINK-3-UPDOWN: Interface FastEthernet0/14, changed state to up"
         , "<187>808: Mar 26 21:05:18 KST:%LINK-3-UPDOWN: Interface FastEthernet0/15, changed state to down"
         , "<187>790: Mar 26 21:02:01 KST:%LINK-3-UPDOWN: Interface FastEthernet0/15, changed state to up"
         , "<187>784: Mar 26 21:01:58 KST:%LINK-3-UPDOWN: Interface FastEthernet0/17, changed state to down"
         , "<187>816: Mar 26 21:05:20 KST:%LINK-3-UPDOWN: Interface FastEthernet0/17, changed state to up"
         , "<187>809: Mar 26 21:05:18 KST:%LINK-3-UPDOWN: Interface FastEthernet0/18, changed state to down"
         , "<187>788: Mar 26 21:02:01 KST:%LINK-3-UPDOWN: Interface FastEthernet0/18, changed state to up"
         , "<187>646: Feb  3 13:51:04.185:%LINK-3-UPDOWN: Interface FastEthernet0/19, changed state to down"
         , "<187>648: Feb  3 13:51:13.698:%LINK-3-UPDOWN: Interface FastEthernet0/19, changed state to up"
         , "<187>780: Mar 26 21:01:57 KST:%LINK-3-UPDOWN: Interface FastEthernet0/2, changed state to down"
         , "<187>797: Mar 26 21:04:14 KST:%LINK-3-UPDOWN: Interface FastEthernet0/2, changed state to up"
         , "<187>770: Feb 21 16:20:54 KST:%LINK-3-UPDOWN: Interface FastEthernet0/23, changed state to down"
         , "<187>767: Feb 21 16:15:42 KST:%LINK-3-UPDOWN: Interface FastEthernet0/23, changed state to up"
         , "<187>805: Mar 26 21:05:17 KST:%LINK-3-UPDOWN: Interface FastEthernet0/3, changed state to down"
         , "<187>785: Mar 26 21:01:59 KST:%LINK-3-UPDOWN: Interface FastEthernet0/3, changed state to up"
         , "<187>509: Mar  1 03:47:16 KST:%LINK-3-UPDOWN: Interface FastEthernet0/6, changed state to down"
         , "<187>510: Mar  1 03:48:02 KST:%LINK-3-UPDOWN: Interface FastEthernet0/6, changed state to up"
         , "<187>781: Mar 26 21:01:58 KST:%LINK-3-UPDOWN: Interface FastEthernet0/8, changed state to down"
         , "<187>810: Mar 26 21:05:18 KST:%LINK-3-UPDOWN: Interface FastEthernet0/8, changed state to up"
         , "<187>806: Mar 26 21:05:18 KST:%LINK-3-UPDOWN: Interface FastEthernet0/9, changed state to down"
         , "<187>789: Mar 26 21:02:01 KST:%LINK-3-UPDOWN: Interface FastEthernet0/9, changed state to up"
         , "<187>507: Feb 23 14:45:38 KST:%LINK-3-UPDOWN: Interface GigabitEthernet0/1, changed state to down"
         , "<189>505: Feb 23 14:45:33 KST:%LINK-5-CHANGED: Interface GigabitEthernet0/1, changed state to administratively down"
         , "<188>796: Mar 26 21:04:13 KST:%SW_MATM-4-MACFLAP_NOTIF: Host 0010.dbff.2000 in vlan 40 is flapping between port Fa0/2 and port Fa0/3"
         , "<188>820: Mar 26 21:05:32 KST:%SW_MATM-4-MACFLAP_NOTIF: Host 0010.dbff.2000 in vlan 40 is flapping between port Fa0/3 and port Fa0/2"
         , "<189>640: Feb  2 02:06:02.012:%SYS-5-CONFIG_I: Configured from console by kspop on vty0 (192.168.3.1)"
         , "<189>773: Feb 21 16:24:01 KST:%SYS-5-CONFIG_I: Configured from console by kspop on vty0 (192.168.3.240)"
         , "<189>504: Feb 23 14:45:05 KST:%SYS-5-CONFIG_I: Configured from console by vty0 (192.168.3.1)"
         , "<190>641: Feb  2 02:06:03.480:%SYS-6-LOGGINGHOST_STARTSTOP: Logging to host 222.122.122.251 Port 514 started - CLI initiated"
         , "<189>261: *Feb  7 10:40:27 KST: %CLEAR-5-COUNTERS: Clear counter on all interfaces by vty0 (192.168.1.21)"
         , "<189>317: *Mar  2 02:01:48.161: %CLEAR-5-COUNTERS: Clear counter on interface Serial0/0/0 by vty0 (172.16.1.1)"
         , "<189>255: *Feb  7 09:25:05 KST: %LINEPROTO-5-UPDOWN: Line protocol on Interface GigabitEthernet0/0, changed state to down"
         , "<189>252: *Feb  3 20:07:47 KST: %LINEPROTO-5-UPDOWN: Line protocol on Interface GigabitEthernet0/1, changed state to up"
         , "<189>236: *Feb  3 17:32:26 KST: %LINEPROTO-5-UPDOWN: Line protocol on Interface NVI0, changed state to up"
         , "<189>265: *Feb 13 08:15:46 KST: %LINEPROTO-5-UPDOWN: Line protocol on Interface Serial0/0/0, changed state to down"
         , "<189>266: *Feb 13 08:17:06 KST: %LINEPROTO-5-UPDOWN: Line protocol on Interface Serial0/0/0, changed state to up"
         , "<187>311: *Feb  2 01:48:46.929: %LINK-3-UPDOWN: Interface Serial0/0/1, changed state to down"
         , "<189>237: *Feb  3 17:34:23 KST: %SYS-5-CONFIG_I: Configured from console by console"
         , "<189>308: *Feb  2 01:47:56.809: %SYS-5-CONFIG_I: Configured from console by vty0 (172.16.1.1)"
         , "<189>253: *Feb  7 09:22:27 KST: %SYS-5-CONFIG_I: Configured from console by vty0 (192.168.1.21)"
         , "<189>267: *Feb 13 15:12:02 KST: %SYS-5-CONFIG_I: Configured from console by vty0 (211.230.57.8)"
         , "<189>241: *Feb  3 18:15:24 KST: %SYS-5-CONFIG_I: Configured from console by vty0/0/0 (211.230.57.1)"
         , "<189>239: *Feb  3 18:11:28 KST: %SYS-5-CONFIG_I: Configured from console by vty1 (192.168.1.21)"
         , "<189>262: *Feb  9 09:45:28 KST: %SYS-5-PRIV_AUTH_FAIL: Authentication to Privilage level 15 failed byvty0 (192.168.1.21)"
         , "<190>256: *Feb  7 09:25:11 KST: %SYS-6-LOGGINGHOST_STARTSTOP: Logging to host 222.122.122.251 port 514 started - reconnection"
         , "<190>309: *Feb  2 01:48:00.017: %SYS-6-LOGGINGHOST_STARTSTOP: Logging to host 222.122.122.251 started - CLI initiated"
         , "<189>505: 42w2d: %SYS-5-CONFIG_I: Configured from console by vty0 (192.168.3.1)"
         , "<129>Mar  8  0:52:56 na ALERTAlteonOS <ip>: cannot contact default gateway 172.16.10.1"
         , "<133>Mar  8  0:52:58 na NOTICEAlteonOS <ip>: default gateway 172.16.10.1 enabled"
         , "<133>Mar  8  0:52:58 na NOTICEAlteonOS <ip>: default gateway 172.16.10.1 operational"
         , "<133>Apr  1  0:00:24 na NOTICEAlteonOS <mgmt>: admin connection closed from Telnet/SSH"
         , "<133>Feb 21 21:15:10 na NOTICEAlteonOS <mgmt>: admin idle timeout from Console"
         , "<133>Feb 17 15:39:54 na NOTICEAlteonOS <mgmt>: admin idle timeout from Telnet/SSH"
         , "<133>Feb 12 21:56:51 na NOTICEAlteonOS <mgmt>: admin login from host 0.0.0.0"
         , "<133>Mar  9 14:31:31 na NOTICEAlteonOS <mgmt>: admin login from host 109.225.102.149"
         , "<133>Mar  7  2:42:50 na NOTICEAlteonOS <mgmt>: admin login from host 112.1.253.142"
         , "<133>Feb 14 19:27:57 na NOTICEAlteonOS <mgmt>: admin login from host 113.127.130.53"
         , "<133>Feb 25  9:34:42 na NOTICEAlteonOS <mgmt>: admin login from host 113.252.32.144"
         , "<133>Mar  4 22:30:35 na NOTICEAlteonOS <mgmt>: admin login from host 113.60.93.194"
         , "<133>Feb 12 23:54:33 na NOTICEAlteonOS <mgmt>: admin login from host 114.103.205.22"
         , "<133>Feb 25  9:46:24 na NOTICEAlteonOS <mgmt>: admin login from host 114.111.202.52"
         , "<133>Feb 14  9:07:09 na NOTICEAlteonOS <mgmt>: admin login from host 92.241.201.134"
         , "<133>Mar 10  1:00:11 na NOTICEAlteonOS <mgmt>: admin login from host 93.137.148.106"
         , "<133>Feb 21 21:10:09 na NOTICEAlteonOS <mgmt>: admin login on Console"
         , "<133>Apr  2 15:05:09 na NOTICEAlteonOS <mgmt>: admin logout from Telnet/SSH"
         , "<133>Feb 14 23:57:27 na NOTICEAlteonOS <mgmt>: Failed login attempt via TELNET from host 110.35.108.4"
         , "<133>Mar 13  5:19:56 na NOTICEAlteonOS <mgmt>: Failed login attempt via TELNET from host 211.75.231.191"
         , "<133>Feb 27 17:49:23 na NOTICEAlteonOS <mgmt>: Failed login attempt via TELNET from host 211.76.88.109"
         , "<133>Mar  2 17:50:12 na NOTICEAlteonOS <mgmt>: Failed login attempt via TELNET from host 218.64.32.221"
         , "<133>Mar  7 18:56:25 na NOTICEAlteonOS <mgmt>: Failed login attempt via TELNET from host 219.149.173.138"
         , "<133>Feb 26  9:46:01 na NOTICEAlteonOS <mgmt>: Failed login attempt via TELNET from host 221.158.159.251"
         , "<133>Mar  1 21:17:39 na NOTICEAlteonOS <mgmt>: Failed login attempt via TELNET from host 221.165.106.152"
         , "<133>Mar  4  2:36:41 na NOTICEAlteonOS <mgmt>: Failed login attempt via TELNET from host 46.107.242.152"
         , "<133>Feb 24 12:19:12 na NOTICEAlteonOS <mgmt>: Failed login attempt via TELNET from host 49.66.224.74"
         , "<133>Feb 26 23:47:51 na NOTICEAlteonOS <mgmt>: Failed login attempt via TELNET from host 59.1.109.120"
         , "<133>Feb 27 16:46:14 na NOTICEAlteonOS <mgmt>: Failed login attempt via TELNET from host 59.23.209.55"
         , "<133>Feb 22  5:25:00 na NOTICEAlteonOS <mgmt>: Failed login attempt via TELNET from host 84.240.202.57"
         , "<134>Feb 12 21:12:28 na INFOAlteonOS <mgmt>: new configuration applied"
         , "<134>Feb 12 21:12:46 na INFOAlteonOS <mgmt>: new configuration saved"
         , "<134>Feb 12 21:12:28 na INFOAlteonOS <mgmt>: Operational change made by Admin from Telnet:172.16.1.6"
         , "<132>Active: NetScreen device_id=Active"
         , "<188>1578014: Mar 16 11:02:52KST: %CDP-4-DUPLEX_MISMATCH: duplex mismatch discovered on FastEthernet0/24 (not full duplex), with JunYong_Router GigabitEthernet0/1 (full duplex)."
         , "<188>1577979: Mar 16 10:28:23KST: %CDP-4-DUPLEX_MISMATCH: duplex mismatch discovered on FastEthernet0/24 (not half duplex), with Switch FastEthernet0/2 (half duplex)."
         , "<188>1574343: Feb  2 10:48:04KST: %CDP-4-NATIVE_VLAN_MISMATCH: Native VLAN mismatch discovered on FastEthernet0/2 (30), with KS_Cat2960-1 FastEthernet0/24 (1)."
         , "<188>1574342: Feb  2 10:47:53KST: %CDP-4-NATIVE_VLAN_MISMATCH: Native VLAN mismatch discovered on FastEthernet0/23 (50), with KS_Cat2960-2 FastEthernet0/23 (1)."
         , "<189>1578005: Mar 16 10:38:25KST: %CLEAR-5-COUNTERS: Clear counter on all interfaces by console"
         , "<189>1578041: .Mar 26 20:49:19KST: %CLEAR-5-COUNTERS: Clear counter on all interfaces by vty1 (112.220.88.226)"
         , "<188>989474: *Feb  2 11:39:59KST: %CRYPTO-4-RECVD_PKT_NOT_IPSEC: Rec'd packet not an IPSEC packet. (ip) vrf/dest_addr= /62.25.122.10, src_addr= 62.25.122.11, prot= 132"
         , "<189>989470: *Feb  2 11:39:35KST: %CRYPTO-5-IKMP_AG_MODE_DISABLED: Unable to initiate or respond to Aggressive Mode while disabled"
         , "<189>1577965: Mar 15 15:37:19KST: %LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/10, changed state to down"
         , "<189>1577966: Mar 15 15:37:21KST: %LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/10, changed state to up"
         , "<189>1577957: Feb  3 20:02:32KST: %LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/24, changed state to down"
         , "<189>1577960: Feb  3 20:02:59KST: %LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/24, changed state to up"
         , "<189>1578027: Mar 26 19:56:49KST: %LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/3, changed state to down"
         , "<189>1578030: Mar 26 19:57:02KST: %LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/3, changed state to up"
         , "<189>1578045: .Mar 26 22:17:36KST: %LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/4, changed state to down"
         , "<189>1578048: .Mar 26 22:17:48KST: %LINEPROTO-5-UPDOWN: Line protocol on Interface FastEthernet0/4, changed state to up"
         , "<187>1577958: Feb  3 20:02:33KST: %LINK-3-UPDOWN: Interface FastEthernet0/24, changed state to down"
         , "<187>1577959: Feb  3 20:02:58KST: %LINK-3-UPDOWN: Interface FastEthernet0/24, changed state to up"
         , "<187>1578028: Mar 26 19:56:50KST: %LINK-3-UPDOWN: Interface FastEthernet0/3, changed state to down"
         , "<187>1578029: Mar 26 19:57:01KST: %LINK-3-UPDOWN: Interface FastEthernet0/3, changed state to up"
         , "<187>1578046: .Mar 26 22:17:37KST: %LINK-3-UPDOWN: Interface FastEthernet0/4, changed state to down"
         , "<187>1578047: .Mar 26 22:17:47KST: %LINK-3-UPDOWN: Interface FastEthernet0/4, changed state to up"
         , "<187>1577954: Feb  3 17:02:45KST: %LINK-3-UPDOWN: Interface GigabitEthernet0/1, changed state to down"
         , "<189>1577955: Feb  3 17:02:47KST: %LINK-5-CHANGED: Interface GigabitEthernet0/1, changed state to administratively down"
         , "<189>1574341: Feb  2 10:47:31KST: %SYS-5-CONFIG_I: Configured from consol"
         , "<189>1578007: Mar 16 10:39:08KST: %SYS-5-CONFIG_I: Configured from console by console"
         , "<189>989472: *Feb  2 11:39:36KST: %SYS-5-CONFIG_I: Configured from console by vty0 (192.168.0.9)"
         , "<189>1577956: Feb  3 17:02:49KST: %SYS-5-CONFIG_I: Configured from console by vty1 (112.220.88.226)"
         , "<189>1578024: Mar 16 14:16:26KST: %SYS-5-CONFIG_I: Configured from console by vty1 (192.168.0.11)"
         , "<189>1577963: Feb 13 15:08:49KST: %SYS-5-CONFIG_I: Configured from console by vty1 (192.168.1.22)"
         , "<189>1574341: Feb  2 10:47:31KST: %SYS-5-CONFIG_I: Configured from console by vty1 (192.168.3.14)"
         , "<189>1578025: Mar 16 17:02:22KST: %SYS-5-CONFIG_I: Configured from console by vty1 (192.168.3.241)"
         , "<189>1578042: .Mar 26 21:35:31KST: %SYS-5-CONFIG_I: Configured from console by vty2 (112.220.88.226)"
         , "<190>1578040: .Mar 26 20:49:00KST: %SYS-6-CLOCKUPDATE: System clock has been updated from 20:42:46 KST Mon Mar 26 2012 to 20:49:00 KST Mon Mar 26 2012, configured from console by vty1 (112.220.88.226)."
         , "<190>989471: *Feb  2 11:39:36KST: %SYS-6-LOGGINGHOST_STARTSTOP: Logging to host 222.122.122.251 port 514 started - CLI initiated"
         , "<190>998392: *Feb  3 17:21:13KST: %SYS-6-LOGGINGHOST_STARTSTOP: Logging to host 222.122.122.251 port 514 stopped - CLI initiated"
         , "<190>511: 43w2d: %SYS-6-CLOCKUPDATE: System clock has been updated from 21:47:20 UTC Wed Dec 29 1993 to 11:20:00 UTC Fri Mar 2 2012, configured from console by vty0 (192.168.3.1)."
          };
   
}