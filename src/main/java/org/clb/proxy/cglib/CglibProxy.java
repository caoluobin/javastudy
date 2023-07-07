package org.clb.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description
 * @Classname CglibProxy
 * @Date 2023/3/22 1:31
 * @Author clb
 */
public class CglibProxy<T> implements MethodInterceptor {

    private T target;

    public CglibProxy(T target) {
        this.target = target;
    }

    // �����������

    public Object getProxyInstance() {

        // 1.cglib������
        Enhancer en = new Enhancer();
        // 2.���ø���
        en.setSuperclass(this.target.getClass());
        // 3.���ûص�����
        en.setCallback(this);

        return en.create();
    }

    //���ط���
    @Override
    public Object intercept(Object obj, Method method, Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        System.out.println("��ʼ����...");

        // ִ��Ŀ�����ķ���
        Object result = method.invoke(target, args);

        System.out.println("�ύ����...");
        return result;
    }

}
