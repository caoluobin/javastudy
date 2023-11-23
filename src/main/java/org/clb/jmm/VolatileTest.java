package org.clb.jmm;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Classname VolatileTest
 * @Date 2022/12/1 6:36
 * @Author clb
 */
public class VolatileTest {
    static boolean flag1 = true;
    static volatile boolean flag2 = true;
    static Boolean flag3 = true;
    static VolatileP p = new VolatileP();
    static volatile VolatileP pv = new VolatileP();
    static Map<String, VolatileP> map = new HashMap() {
        {
            put("1", new VolatileP());
        }
    };

    public static void main(String[] args) throws InterruptedException {
        test2();
    }

    public static void test1() throws InterruptedException {
        System.out.println(pv.flag);
        new Thread(() -> {
            while (pv.flag) {

            }
            System.out.println("flag值被改为" + flag1);

        }, "t1").start();

        TimeUnit.SECONDS.sleep(1);
        pv.setFlag(false);
        System.out.println(pv.flag);
    }

    public static void test2() throws InterruptedException {
        System.out.println(map.get("1"));
        new Thread(() -> {
            while (map.get("1").flag) {

            }
            System.out.println("flag值被改为" + map.get("1"));

        }, "t1").start();

        TimeUnit.SECONDS.sleep(1);

        VolatileP volatileP = map.get("1");
        volatileP.setFlag(false);
        System.out.println(map.get("1"));
    }
}
