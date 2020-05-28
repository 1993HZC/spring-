package com.markov.cglib;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Client {
    public static void main(String args[]){
        final Producer producer=new Producer();
//        这个methodInterceptor就是Callback的子接口
        Producer cglibProducer=(Producer)Enhancer.create(producer.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object returnValue=null;

                if ("saleProduct".equals(method.getName())){
                    Float money=(Float) args[0];
                    returnValue=method.invoke(producer,money*0.8f);
                }
                return returnValue;
            }
        });
        cglibProducer.saleProduct(10000);
    }

}
