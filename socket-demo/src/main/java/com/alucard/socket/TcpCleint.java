package com.alucard.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author alucard
 * @Description
 * @Date Create in 15:48 2018/10/27
 */
public class TcpCleint {
    public static void main(String[] args) throws IOException {
        System.out.println("socket tcp客户端启动....");
        Socket socket = new Socket("127.0.0.1", 8080);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("我是alucard".getBytes());
        socket.close();
    }
}
