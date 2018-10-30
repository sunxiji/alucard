package com.alucard.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author alucard
 * @Description
 * @Date Create in 15:23 2018/10/27
 */
public class UdpServer {
    public static final Integer PORT = 8080;

    public static void main(String[] args) throws IOException {
        //1.ip地址+端口号
        System.out.println("udp服务器已经启动..." + PORT);
        //创建服务器端端口号 默认使用本机ip地址
        DatagramSocket ds = new DatagramSocket(PORT);
        //服务器接受客户端1024个字节
        byte[] bytes = new byte[1024];
        //定义数据包
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        //接受客户端请求,将数据分装给数据包 如果客户端不往服务器端发送请求,就一直阻塞
        ds.receive(dp);
        System.out.println("来源ip地址:" + dp.getAddress() + ",端口号:" + dp.getPort());
        String result = new String(dp.getData(), 0, dp.getLength());
        System.out.println(result);
        ds.close();
    }
}
