package org.clb.util;

/**
 * @Description
 * @Classname Asserts
 * @Date 2021/5/12 15:23
 * @Author clb
 */
public class Asserts {

    public static void objectNotNull(Object obj, String msg) throws Exception {
        boolean a = obj == null ? true : false;
        if (a) {
            throw new Exception(msg);
        }
    }

    public static boolean objectNotNull2(Object obj) throws Exception {
        return obj == null ? false : true;
    }
}
