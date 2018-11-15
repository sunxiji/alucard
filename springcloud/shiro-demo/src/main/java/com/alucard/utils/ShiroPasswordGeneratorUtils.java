package com.alucard.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:31 2018/11/15
 */
public class ShiroPasswordGeneratorUtils {

    /**
     * 用来测试的算出密码password盐值加密后的结果
     * @param userName 用户名
     * @param salt 盐值
     * @param hashAlgorithmName 加密方式
     * @param password  明文密码
     * @param hashIterations 散列的次数，比如散列两次，相当于 md5(md5(""));
     * @return
     */
    public static String generatorPassword(String userName,String salt,String hashAlgorithmName,String password,int hashIterations){

        // 最终的盐值 = 用户名 + 盐
        String saltSource = userName + salt;

        String newPassword =
                new SimpleHash(hashAlgorithmName,password,
                        ByteSource.Util.bytes(saltSource),hashIterations).toHex();

        return newPassword;
    }

    //
    public static void main(String[] args) {
        System.out.println(generatorPassword("vip","8d78869f470951332959580424d4bf4f","MD5","123456",2));
    }
}
