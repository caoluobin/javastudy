package org.clb.util.stringsplitter;

import java.util.Arrays;
import java.util.List;

public class StringReplaceUtils {

    /**
     * @description: 替换字符串中每两个b中间的内容(包括b)为 c
     *               例：update table set a='123' ==>update table set a=?
     * @author: clb
     * @date:  8:59
     * @since:
     */
    public static String replace(String a,String b,String c){
        List<String> list = Arrays.asList(a.split(b));
        StringBuffer result=new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            if (i%2==0&&i!=list.size()-1){
                result.append(list.get(i)+c);
            }
        }
        return result.toString();
    }
    /**
     * @description: 替换a中[b,c]之间的字符串为d
     * @author: clb
     * @date:  9:16
     * @since:
     */
    public static String replace2(String a,char b,char c,char d){
        boolean flag=true;
        StringBuffer result=new StringBuffer();
        char[] chars = a.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (flag){
                result.append(chars[i]);
            }
            if (chars[i]==b||chars[i]==c){
                if (chars[i]==b){
                    result.append(d);
                }
                if (chars[i]==c){
                    result.append(c);
                }
                flag=!flag;
            }
        }
        return result.toString();
    }

    public static String replace3(String a,String c,String pre,String after){
        String[] split = a.split(c);
        StringBuffer result=new StringBuffer();
        for (int i = 0; i < split.length; i++) {
            if (i%2==1){
                result.append(pre+split[i]+after);
                if (i!=split.length-2)result.append(",");
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String replace = replace3("UPDATE `yl_rcpx_pxjd` SET `PJDMC` =?, `PJDXZ` =?, `PSLJG` =?, `PJGHLCWZB` =?, `PDJZH` =?, `PXXDZ` =?, `PYZBM` =?, `PFRXM` =?, `PFRDH` =?, `PLXRXM` =?, `PLXRDH` =?, `PJGHDCW` =?, `PJGJZMJ` =?, `PJGRZL` =?, `PCDZYMJ` =?, `PJSZYGS` =?, `PJSZYMJ` =?, `PSXCDZYGS` =?, `PSXCDZYMJ` =?, `PBGCDZYGS` =?, `PBGCDZYMJ` =?, `PCDZLMJ` =?, `PJSZLGS` =?, `PJSZLMJ` =?, `PSXCDZLGS` =?, `PSXCDZLMJ` =?, `PBGCDZLGS` =?, `PBGCDZLMJ` =?, `PJZGZRS` =?, `PZZGLRS` =?, `PJZGLRS` =?, `PXYSSMJ` =?, `PXYSTMJ` =?, `PZZJSRS` =?, `PJZJSRS` =?, `PJDJB` =?, `PSFNS` =?, `SSJLX` =?, `WWTJSJ` =?, `WWTJZT` =?, `SAM00` =?, `SAM01` =?, `SAM02` =?, `SAM03` =?, `SAM04` =?, `SAM05` =?, `SAM06` =?, `SAM07` =?, `SAM08` =?, `SAM09` =?, `SAM10` =?, `SAM11` =?, `SAM12` =?, `SAM13` =?, `SAM14` =?, `SAM15` =?, `SAM16` =?, `SAM17` =?, `SAM18` =?, `SAM19` =?, `SAM20` =?, `NAM00` =?, `NAM01` =?, `NAM02` =?, `NAM03` =?, `NAM04` =?, `NAM05` =?, `NAM06` =?, `NAM07` =?, `NAM08` =?, `NAM09` =?, `NAM10` =?, `DAM00` =?, `DAM01` =?, `DAM02` =?, `DAM03` =?, `DAM04` =?, `DAM05` =?, `DAM06` =?, `DAM07` =?, `DAM08` =?, `DAM09` =?, `DAM10` =?, `XZQH` =?, `SYS_XZQH` =?, `QHMC` =?, `fjd` =?, `fwd` =?,  `post_time` = ? WHERE `PK_RCPX_PXJD` = ?; ", "`","pxjdBgField.get(\"", "\")");
        System.out.println(replace);
    }
}
