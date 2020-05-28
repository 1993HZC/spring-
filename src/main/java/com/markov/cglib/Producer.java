package com.markov.cglib;

public class Producer implements IProducer {

    @Override
    public void saleProduct(float money) {
        System.out.println(money);
    }

    @Override
    public void afterService(float money) {

    }
}
