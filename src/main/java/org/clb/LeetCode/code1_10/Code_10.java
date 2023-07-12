package org.clb.LeetCode.code1_10;

/**
 * ����һ���ַ��� s ��һ���ַ����� p��������ʵ��һ��֧�� '.' �� '*' ��������ʽƥ�䡣
 * '.' ƥ�����ⵥ���ַ�
 * '*' ƥ���������ǰ�����һ��Ԫ��
 * ��νƥ�䣬��Ҫ���� ���� �ַ��� s�ģ������ǲ����ַ�����
 */
public class Code_10 {

    public static void main(String[] args) {
        System.out.println(new Code_10().isMatch("aaabacbacasdc", ".*a.*bac.*c.*"));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }
        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p.charAt(j - 1) == '.') {
            return true;
        }
        return s.charAt(i - 1) == p.charAt(j - 1);
    }
    public Match isMatch2(char[] sChars, String pdd,Match match) {

        char[] pChars = pdd.toCharArray();
        int index = match.index;
        for (int i = 0; i < pChars.length; i++) {
            char pChar = pChars[i];
            if (index>=sChars.length) {
                match.index=index;
                match.isMatch=false;
                return match;
            }
            for (; index< sChars.length;) {
                if (pChar=='.') {
                    index++;
                    break;
                }else if (pChar=='*') {
                    if (i == 0) {
                        match.index=index;
                        match.isMatch=false;
                        return match;
                    }
                    if (pChars[i - 1] == '.') {
                        match.index=index;
                        match.isMatch=true;
                        return match;
                    } else {
                        while (index < sChars.length && sChars[index] == pChars[i - 1]) {
                            index++;
                        }
                        break;
                    }
                } else {
                    if (pChar==sChars[index]) {
                        index++;
                        break;
                    }else {
                        match.index=index;
                        match.isMatch=false;
                        return match;
                    }
                }
            }
        }
        if (index!=sChars.length) {
            match.index=index;
            match.isMatch=false;
            return match;
        }
        match.index=index;
        match.isMatch=true;
        return match;
    }

    private class Match {
        Integer index;
        boolean isMatch;

        public Match(Integer index, boolean isMatch) {
            this.index = index;
            this.isMatch = isMatch;
        }
    }
}
