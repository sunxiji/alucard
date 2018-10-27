package com.alucard;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:11 2018/10/27
 */
public class BenzFactory {
    public static Car createCar(){
        return new Benz();
    }
}
