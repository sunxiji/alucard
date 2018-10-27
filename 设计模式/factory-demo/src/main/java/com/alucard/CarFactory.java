package com.alucard;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:06 2018/10/27
 */
public class CarFactory {

    public static Car createCar(String name){
        Car  car = null;
        if (name.equals("audi")){
            car = new Audi();
        }else if(name.equals("benz")){
            car = new Benz();
        }
        return car;
    }
}
