package org.clb.designpattern.Prototype_pattern;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Classname ProTest
 * @Date 2021/5/31 15:42
 * @Author clb
 */
public class ProTest {

    public static void main(String[] args) throws CloneNotSupportedException {
//        Letter letter=new Letter("2333","clb",new Stamp("a"));
//        Letter clone = letter.clone();
//        System.out.println(clone.stamp);
//        System.out.println(letter.stamp);
        Map map=new HashMap();
        map.put("a",null);
        Object a = map.get("a");
        Object b = map.get("b");
        System.out.println(process("330724199706083933"));
        System.out.println("330724199706083934".substring(16, 17));
    }
    public static  String process(String word) {
        if (word == null || word.trim().length() == 0) {
            return word;
        }

        int len = word.length();
        String tmp = "";
        String head = word.substring(0, 1);
        ;//显示第一位
        String foot = word.substring(len - 1, len);//显示最后一位
        String body = "";//中间部分
        String bodySt = "";//星号部分


        if (len == 1) {
            tmp = "*";
        } else if (len == 2) {
            tmp = head + "*";
        } else if (len < 5) {
            for (int i = 0; i < len - 2; i++) {
                bodySt += "*";
            }
            tmp = head + bodySt + foot;
        } else if (len == 15) {
            body = word.substring(1, 12);//递10位数
            tmp = head + body + "***" + foot;
        } else if (len == 18) {
            //            body = "*************";//递12位数
            //            String a = ;
            tmp = head + "***" + word.substring(4, 12) + "*****" + foot;
        } else {
            int partLen = (len - 2) / 3;
            for (int i = 0; i < partLen; i++) {
                bodySt += "*";
            }
            int bodyLen = len - 1 - partLen;
            body = word.substring(1 + partLen, bodyLen);
            tmp = head + bodySt + body + bodySt + foot;

        }

        return tmp;
    }
}
