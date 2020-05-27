package com.markov.proxy;

public class Producer implements IProducer{

    @Override
    public void saleProduct(float money) {
        System.out.println(money);
    }

    @Override
    public void afterService(float money) {

    }
}
