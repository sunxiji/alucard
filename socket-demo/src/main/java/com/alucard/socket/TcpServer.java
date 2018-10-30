package com.alucard.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author alucard
 * @Description
 * @Date Create in 15:48 2018/10/27
 */
public class TcpServer {
    public static void main(String[] args) throws IOException {
        System.out.println("tcp协议服务器端启动...");
        ExecutorService executorService = Executors.newCachedThreadPool();
        //创建服务器端连接
        ServerSocket serverSocket = new ServerSocket(8080);
        try {
            while(true) {
                //接受客户端请求,阻塞功能
                Socket accept = serverSocket.accept();
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            InputStream inputStream = accept.getInputStream();
                            byte[] bytes = new byte[1024];
                            int read = inputStream.read(bytes);
                            String result = new String(bytes, 0, read);
                            System.out.println("服务器端接受到客服端内容:" + result);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }

    }
}
