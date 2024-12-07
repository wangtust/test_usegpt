package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class MyTreeNodeTest {

    @Test
    public void testAddChild() {
        MyTreeNode<Integer> parentNode = new MyTreeNode<>(5);
        MyTreeNode<Integer> childNode = new MyTreeNode<>(10);
        
        parentNode.addChild(childNode);
        
        List<MyTreeNode> children = parentNode.getChildren();
        
        assertEquals(1, children.size());
        assertEquals(childNode, children.get(0));
    }

    @Test
    public void testSetAlpha() {
        MyTreeNode<Integer> node = new MyTreeNode<>(5);
        
        node.setAlpha(-10);
        
        assertEquals(-10, node.getAlpha());
    }

    @Test
    public void testSetValue() {
        MyTreeNode<Integer> node = new MyTreeNode<>(5);
        
        node.setValue(15);
        
        assertEquals(15, node.getValue());
    }

    // 可以根据需要继续编写其他测试方法

}