package org.clb.structure.prefix_tree;

//import com.google.common.base.Strings;

/**
 * @Description
 * @Classname PrefixTree
 * @Date 2021/6/13 10:34
 * @Author clb
 */
public class PrefixTree {
    private PreNode firstNode;

    public PrefixTree(PreNode firstNode) {
        this.firstNode = firstNode;
    }

    public PreNode getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(PreNode firstNode) {
        this.firstNode = firstNode;
    }

    public void insert(String word) {
        //if (Strings.isNullOrEmpty(word)) return;
        PreNode node = this.firstNode;
        node.pass++;
        char[] chars = word.toCharArray();
        for (int a : chars) {
            node = node.nextNode.get(a);
            node.pass++;
        }
        node.end++;
    }

    /**
     * 所有加入的字符中，有多少个是以pre这个字符串作为前缀的。
     *
     * @param pre
     * @return
     */
    public int prefixNumber(String pre) {
        if (pre == null) return 0;
        char[] chars = pre.toCharArray();
        PreNode node = this.firstNode;
        for (int c : chars) {
            node = node.nextNode.get(c);
        }
        return node.pass;
    }

    public int search(String word) {
        if (word == null) return 0;
        char[] chars = word.toCharArray();
        PreNode node = this.firstNode;
        for (int c : chars) {
            node = node.nextNode.get(c);
        }
        return node.end;
    }


    public void delete(String word) {
        if (search(word) == 0) return;
        char[] chars = word.toCharArray();
        PreNode node = this.firstNode;
        node.pass--;
        for (int c : chars) {
            if (--node.nextNode.get(c).pass == 0) {
                node.nextNode.put(c, null);
                return;
            }
            node = node.nextNode.get(c);
            node.pass--;
        }
    }
}
