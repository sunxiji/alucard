package com.alucard.template;

/**
 * @author alucard
 * @Description
 * @Date Create in 11:55 2018/10/26
 */
public class Test {
    public static void main(String[] args) {
        DodishTemplate eggsWithTomato = new EggsWithTomato();
        eggsWithTomato.dodish();

        System.out.println("-----------------------------");

        DodishTemplate bouilli = new Bouilli();
        bouilli.dodish();
    }
}
