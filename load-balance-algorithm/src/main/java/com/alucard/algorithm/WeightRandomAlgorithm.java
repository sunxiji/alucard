package com.alucard.algorithm;

import java.util.*;

/**
 * 加权随机（Weight Random）法
 * @author alucard
 * @Description
 * @Date Create in 14:03 2018/11/7
 */
public class WeightRandomAlgorithm {
    private static Map<String, Integer> serviceWeightMap = new HashMap<>();

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

    public static String testWeightRandom() {
        // 重新创建一个map，避免出现由于服务器上线和下线导致的并发问题
        Map<String, Integer> serverMap = new HashMap<String, Integer>();
        serverMap.putAll(serviceWeightMap);

        //取得IP地址list
        Set<String> keySet = serverMap.keySet();
        List<String> serverList = new ArrayList<String>();
        Iterator<String> it = keySet.iterator();

        while (it.hasNext()) {
            String server = it.next();
            Integer weight = serverMap.get(server);
            for (int i=0; i<weight; i++) {
                serverList.add(server);
            }
        }

        Random random = new Random();
        int randomPos = random.nextInt(serverList.size());

        String server = serverList.get(randomPos);

        return server;
    }

    public static void main(String[] args) {
        //循环调用30次
        for (int i = 0; i < 30; i++) {
            System.out.println(testWeightRandom());
        }
    }
}
