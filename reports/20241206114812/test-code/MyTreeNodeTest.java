package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;

public class MyTreeNodeTest {

    @Test
    public void testSetParent() {
        MyTreeNode<Integer> parent = new MyTreeNode<Integer>(10);
        MyTreeNode<Integer> child = new MyTreeNode<Integer>(20);

        // 使用反射获取私有方法setParent
        try {
            Method method = MyTreeNode.class.getDeclaredMethod("setParent", MyTreeNode.class);
            method.setAccessible(true); // 暴露私有方法，使其可以在测试中调用

            method.invoke(child, parent); // 调用私有方法setParent
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }

        assertEquals(parent, child.getParent());
    }

    // 其他测试用例...
}