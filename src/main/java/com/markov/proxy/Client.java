package com.markov.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client {
    public static void main(String args[]){
        final Producer producer =new Producer();
        /**
         * newProxyInstance的前两个参数是固定写法
         * */
        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
                producer.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    /**
                     * method是被代理的方法，例如saleProduct方法
                     * args是saleProduct的参数
                     * */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //调用的方法返回什么值 就返回什么值，这里Object可以是任何类型
                        Object returnValue=null;
                        //
                        if ("saleProduct".equals(method.getName())){
//                            saleProduct函数传入的第一个参数
                            Float money=(Float) args[0];
                            //正式执行被代理的方法
                            returnValue=method.invoke(producer,money*0.8f) ;
                        }
                        return returnValue;
                    }
                });
        proxyProducer.saleProduct((float) 10000);
    }

}
