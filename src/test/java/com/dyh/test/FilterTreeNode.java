package com.dyh.test;

import com.alibaba.fastjson.JSON;
import com.dyh.test.algorithm_design.tree.TreeNode;
import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 树，获取节点的所有父节点
 */
public class FilterTreeNode {
    private Logger logger = LoggerFactory.getLogger(FilterTreeNode.class);
    private TreeNode node0;
    //private List<String> targetNode = Lists.newArrayList("B1","D1");
    private List<String> targetNode = Lists.newArrayList("B1","C1");

    @Before
    public void init(){
        node0 = new TreeNode("0","A");

        TreeNode node1 = new TreeNode("1","B");
        TreeNode node2 = new TreeNode("2","C");
        TreeNode node3 = new TreeNode("3","D");

        TreeNode node4 = new TreeNode("4","B1");
        TreeNode node5 = new TreeNode("5","B2");
        TreeNode node6 = new TreeNode("6","C1");
        TreeNode node7 = new TreeNode("7","D1");
        TreeNode node8 = new TreeNode("8","D2");



        node1.setChildren(Lists.newArrayList(node4,node5));
        node2.setChildren(Lists.newArrayList(node6));
        node3.setChildren(Lists.newArrayList(node7,node8));

        node0.setChildren(Lists.newArrayList(node1,node2,node3));
        //node0.setChildren(Lists.newArrayList(node1,node2));
    }

    @Test
    public void filterTest(){
        logger.info("before filter node0: {}", JSON.toJSON(node0));
        List<TreeNode> retNodes = filterNode(node0);
        if (retNodes.size() >0){
            node0.setChildren(retNodes);
        }
        logger.info("after filter node0: {}",JSON.toJSON(node0));
    }

    private List<TreeNode> filterNode(TreeNode treeNode){

        List<TreeNode> nodes = treeNode.getChildren();
        List<TreeNode> newNodes = Lists.newArrayList();
        List<TreeNode> tagNodes = Lists.newArrayList();

        for(TreeNode node : nodes){
            if (targetNode.contains(node.getNodeName())){
                newNodes.add(node);
            }
            if (node.getChildren() != null && node.getChildren().size() >0){
                List<TreeNode> retNodes = filterNode(node);
                if (retNodes.size()>0){
                    node.setChildren(retNodes);
                }else {
                    node.setChildren(null);
                    tagNodes.add(node);
                }
            }
        }
        nodes.removeAll(tagNodes);
        return newNodes;
    }
}
