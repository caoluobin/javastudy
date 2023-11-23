package org.clb.structure.prefix_tree;

import java.util.HashMap;

/**
 * @Description
 * @Classname PreNode
 * @Date 2021/6/13 10:32
 * @Author clb
 */
public class PreNode {
    public Integer pass;
    public Integer end;
    public HashMap<Integer, PreNode> nextNode;//用Ascci值表示字符

    public Integer getPass() {
        return pass;
    }

    public void setPass(Integer pass) {
        this.pass = pass;
    }

    public Integer getEnd() {
        return end;
    }

    public void setEnd(Integer end) {
        this.end = end;
    }

    public HashMap<Integer, PreNode> getNextNode() {
        return nextNode;
    }

    public void setNextNode(HashMap<Integer, PreNode> nextNode) {
        this.nextNode = nextNode;
    }
}
