package org.clb.LeetCode.code1_10;

/**
 * ���� ���ɵ����ո�ָ���һ�鵥�ʣ��Ҳ���ǰ����β��ո�
 * ���磬"Hello World"��"HELLO"��"hello world hello world" ���Ƿ���Ҫ��ľ��ӡ�
 * ���� �� �ɴ�д��СдӢ����ĸ��ɡ��Ҵ�д��Сд��ĸ��������ͬ�ַ���
 * ���������������ȫ������������Ϊ����һ�� �ػ��� ��
 * ���ʵ����һ���ַ�����һ�����ʵĵ�һ���ַ���ȡ�
 * ���һ�����ʵ����һ���ַ��͵�һ�����ʵĵ�һ���ַ���ȡ�
 * ���磬"leetcode exercises sound delightful"��"eetcode"��"leetcode eats soul" ���ǻػ��䡣Ȼ����"Leetcode is cool"��"happy Leetcode"��"Leetcode" �� "I like Leetcode" �� �� �ǻػ��䡣
 * ����һ���ַ��� sentence �������ж����ǲ���һ���ػ��䡣����ǣ����� true �����򣬷��� false ��
 */
public class Code_2490 {

    public boolean isCircularSentence(String sentence) {
        String[] sentences = sentence.split(" ");
        char first = sentences[0].charAt(0);
        char last = sentences[sentences.length - 1].charAt(sentences[sentences.length - 1].length() - 1);
        if (first != last) {
            return false;
        }
        for (int i = 0; i < sentences.length; i++) {
            if (sentences[i].charAt(sentences[i].length() - 1) != sentences[(i + 1) % sentences.length].charAt(0)) {
                return false;
            }
        }
        return true;
    }
}
