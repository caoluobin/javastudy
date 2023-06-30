package org.clb.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collections;

public class MyProxy implements InvocationHandler {
    public Object target;

    public MyProxy(Object target) {
        this.target = target;
    }

    public <T>T getInstance(Class<T> tClass) {
        return (T) Proxy.newProxyInstance(tClass.getClassLoader(),new Class[]{tClass},this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        System.out.println(proxy.hashCode());
//        method.invoke(proxy,args);
        return method.invoke(target,args);
    }


    public static void main(String[] args) {

    }
}
