package com.alucard;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:11 2018/10/27
 */
public class AudiFactory {
    public static Car createCar(){
        return new Audi();
    }
}
