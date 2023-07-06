package org.clb.LeetCode.code1_10;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Code20 {

    public boolean isValid(String s) {
        if (s.length()%2==1) return false;
        char[] split = s.toCharArray();
        Deque<Character> stack = new LinkedList<Character>();
        for (Character now : split) {
            if ('{'==now||'['==now||'('==now) {
                stack.push(now);
            } else {
                if (stack.isEmpty()) return false;
                Character pop = stack.pop();
                if (('}'==now&&'{'!=pop)||
                        (']'==now&&'['!=pop)||
                        (')'==now&&'('!=pop)
                )
                    return false;

            }

        }
        return stack.isEmpty();
    }
}
