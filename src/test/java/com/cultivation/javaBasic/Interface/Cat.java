package com.cultivation.javaBasic.Interface;

public class Cat extends Anminal implements Bird {
    @Override
    public void canEat() {

    }

    @Override
    void canSay() {
        super.canSay();
    }

}
