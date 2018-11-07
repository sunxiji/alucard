package com.alucard.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 轮询（Round Robin）法
 * @author alucard
 * @Description
 * @Date Create in 11:08 2018/11/7
 */
public class RoundRobinAlgorithm {
    private static Map<String, Integer> serviceWeightMap = new HashMap<>();

    private static Integer pos = 0;


    /**
     * 模拟
     */
    static {
        serviceWeightMap.put("192.168.1.100", 1);
        serviceWeightMap.put("192.168.1.101", 1);
        serviceWeightMap.put("192.168.1.102", 4);//权重为4
        serviceWeightMap.put("192.168.1.103", 1);
        serviceWeightMap.put("192.168.1.104", 1);
        serviceWeightMap.put("192.168.1.105", 3);//权重为3
        serviceWeightMap.put("192.168.1.106", 1);
        serviceWeightMap.put("192.168.1.107", 2);//权重为2
        serviceWeightMap.put("192.168.1.108", 1);
        serviceWeightMap.put("192.168.1.109", 1);
        serviceWeightMap.put("192.168.1.110", 1);
    }

    public static String testRoundRobin() {

        // 重新创建一个map，避免出现由于服务器上线和下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<>();
        serverMap.putAll(serviceWeightMap);



        //取得IP地址list
        ArrayList<String> keyList = new ArrayList<>();

        serverMap.forEach((k,v)-> keyList.add(k));

        String server;

        synchronized (pos) {
            if (pos > keyList.size()-1) {
                pos = 0;
            }

            server = keyList.get(pos);

            pos++;
        }

        return server;
    }

    public static void main(String[] args) {
        //循环调用30次
        for(int i = 0;i<30;i++){
            System.out.println(testRoundRobin());
        }
    }
}
