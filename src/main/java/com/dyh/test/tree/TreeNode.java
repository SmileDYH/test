package com.dyh.test.tree;

import java.util.List;

/**
 * description: TreeNode <br>
 * date: 2021/3/31 16:57 <br>
 * author: wangpeng <br>
 * version: 1.0 <br>
 */
public class TreeNode {
    String nodeCode;
    String nodeName;
    List<TreeNode> children;

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public TreeNode(String nodeCode, String nodeName) {
        this.nodeCode = nodeCode;
        this.nodeName = nodeName;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

}
