package com.alucard;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NioApplicationTests {
    public static final String FILE1PATH = "E:\\DingTalk_v4.5.0.22.exe";
    public static final String FILE2PATH = "E:\\DingTalk_v4.5.0.23.exe";
    public static final String FILE3PATH = "E:\\test.txt";
    public static final String FILE4PATH = "E:\\test2.txt";

    @Test
    public void contextLoads() {
    }

    @Test
    public void test1(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("-----------------");
        System.out.println("往bytebuffer存放数据.....");
        byteBuffer.put("abcd1".getBytes());
        System.out.println(byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());
        System.out.println("----------------");
        System.out.println("读取值.....");
        //开启读取模式,如果不用这行,会报错
        byteBuffer.flip();
        System.out.println("position位置:"+byteBuffer.position());
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        System.out.println(new String(bytes,0,bytes.length));

        System.out.println("---------------------");
        System.out.println("---------重复读---------");
        byteBuffer.rewind();
        System.out.println("position位置:"+byteBuffer.position());
        byte[] bytes2 = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes2);
        System.out.println(new String(bytes2,0,bytes2.length));

        System.out.println("------------------");
        System.out.println("---------清空缓冲区-----------");
        byteBuffer.clear();
        System.out.println("position位置:"+byteBuffer.position());
        System.out.println(byteBuffer.limit());
        System.out.println(byteBuffer.capacity());

        System.out.println("--------------------");
        System.out.println("-------清空后值依然可以取到,只是值表面被清空了----------");
        System.out.println((char)byteBuffer.get());
    }

    /**
     * 非直接缓冲区 读写操作
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        long startTime = System.currentTimeMillis();
        //读入流
        FileInputStream fileInputStream = new FileInputStream(FILE1PATH);
        //写入流
        FileOutputStream fileOutputStream = new FileOutputStream(FILE2PATH);
        //创建通道
        FileChannel in = fileInputStream.getChannel();
        FileChannel out = fileOutputStream.getChannel();
        //分配指定大小缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(in.read(buffer)!=-1){
            buffer.flip();
            out.write(buffer);
            buffer.clear();
        }
        //关闭通道,关闭连接
        in.close();
        out.close();
        fileInputStream.close();
        fileOutputStream.close();
        long endTime = System.currentTimeMillis();
        System.out.println("操作非直接缓冲区耗时:"+(endTime-startTime));
    }

    /**
     * 直接缓冲区
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        long startTime = System.currentTimeMillis();
        FileChannel in = FileChannel.open(Paths.get(FILE1PATH), StandardOpenOption.READ);
        FileChannel out = FileChannel.open(Paths.get(FILE2PATH), StandardOpenOption.READ,StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        MappedByteBuffer inMbb = in.map(FileChannel.MapMode.READ_ONLY, 0, in.size());
        MappedByteBuffer outMbb = out.map(FileChannel.MapMode.READ_WRITE, 0, in.size());
        //直接对缓冲区操作
        byte[] bytes = new byte[inMbb.limit()];
        inMbb.get(bytes);
        outMbb.put(bytes);
        in.close();
        out.close();
        long endTime = System.currentTimeMillis();
        System.out.println("操作直接缓冲区耗时:"+(endTime-startTime));
    }

    @Test
    public void test4() throws IOException {
        RandomAccessFile raf = new RandomAccessFile(FILE3PATH, "rw");
        //获取通道
        FileChannel channel = raf.getChannel();
        ByteBuffer buffer1 = ByteBuffer.allocate(100);
        ByteBuffer buffer2 = ByteBuffer.allocate(1024);
        ByteBuffer[] bufs = {buffer1,buffer2};
        channel.read(bufs);
        for (ByteBuffer buf : bufs) {
            buf.flip();
        }
        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
        System.out.println("---------------------------------");
        System.out.println(new String(bufs[1].array(),1,bufs[1].limit()));
        System.out.println("------------聚集读取-------------");
        RandomAccessFile raf2 = new RandomAccessFile(FILE4PATH, "rw");
        //获取通道
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufs);
        raf2.close();
        raf.close();
    }

    @Test
    public void test5() throws IOException {
        //获取编码器
        Charset charset = Charset.forName("GBK");
        CharsetEncoder ce = charset.newEncoder();

        //获取解码器
        CharsetDecoder cd = charset.newDecoder();

        CharBuffer charBuffer = CharBuffer.allocate(1024);

        charBuffer.put("aaaaaaaaaassssssssssddddddd");
        charBuffer.flip();
        //编码
        ByteBuffer buBuff = ce.encode(charBuffer);
        buBuff.flip();
//        CharBuffer decode = cd.decode(encode);
        Charset c2 = Charset.forName("GBK");
        CharBuffer decode2 = c2.newDecoder().decode(buBuff);
        System.out.println(decode2.toString());

    }
}
