package com.alucard;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:08 2018/10/27
 */
public class Test01 {
    public static void main(String[] args) {
        Car car = CarFactory.createCar("audi");
        car.run();
        System.out.println("---------------");
        Car car1 = BenzFactory.createCar();
        car1.run();
    }
}
