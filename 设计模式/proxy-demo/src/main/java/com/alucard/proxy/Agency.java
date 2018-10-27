package com.alucard.proxy;

/**
 * @author alucard
 * @Description
 * @Date Create in 14:31 2018/10/27
 */
public class Agency implements House {

    private Person person;

    public Agency(Person person){
        this.person = person;
    }
    @Override
    public void buyHouse() {
        System.out.println("我是中介,你买房开始交给我了");
        person.buyHouse();
        System.out.println("我是中介,你买房结束了");
    }
}
