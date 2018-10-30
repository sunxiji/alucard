package com.alucard.socket;

import java.io.IOException;
import java.net.*;

/**
 * @author alucard
 * @Description
 * @Date Create in 15:23 2018/10/27
 */
public class UdpCleint {
    public static void main(String[] args) throws IOException {
        System.out.println("udp客户端启动连接....");
        DatagramSocket ds = new DatagramSocket();
        String str = "alucard";
        byte[] bytes = str.getBytes();
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length, InetAddress.getByName("127.0.0.1"),8080);
        ds.send(dp);
        ds.close();
    }
}
