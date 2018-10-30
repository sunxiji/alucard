package com.alucard.buffer;

import java.nio.ByteBuffer;

/**
 * 缓冲区是NIO 提高给传输文件和通道一起配合使用,存储数据
 * Buffer
 * ByteBuffer
 * LongBuffer
 * @author alucard
 * @Description
 * @Date Create in 16:24 2018/10/27
 */
public class Buffer {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        String str = "abcd";
        byteBuffer.put(str.getBytes());
        //开启读的模式
        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes,0,2);
        byteBuffer.mark();
        System.out.println(new String(bytes,0,2));
        System.out.println(byteBuffer.position());
        System.out.println("-------------");
        byteBuffer.get(bytes,0,2);
        System.out.println(new String(bytes,0,2));
        System.out.println(byteBuffer.position());
        byteBuffer.reset();
        System.out.println("重置还原到mark标记");
        System.out.println(byteBuffer.position());
    }
}
