package com.alucard.template;

/**
 * @author alucard
 * @Description
 * @Date Create in 11:52 2018/10/26
 */
public class Bouilli extends DodishTemplate{

    @Override
    public void preparation() {
        System.out.println("切猪肉和土豆。");
    }

    @Override
    public void doing() {
        System.out.println("将切好的猪肉倒入锅中炒一会然后倒入土豆连炒带炖。");
    }

    @Override
    public void carriedDishes() {
        System.out.println("将做好的红烧肉盛进碗里端给客人吃。");
    }

}