package net.mooctest;

import org.junit.Test;
import static org.junit.Assert.*;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

public class FlatSegmentTreeTest {

    @Test(timeout = 4000)
    public void testInitialization() {
        LinkedList<SegmentTree.Data.QuadrantData> dataList = new LinkedList<>();
        SegmentTree.Data.QuadrantData data1 = new SegmentTree.Data.QuadrantData(2364L, 2364L, -6L, 2364L, -6L);
        SegmentTree.Data.QuadrantData data2 = new SegmentTree.Data.QuadrantData(-6L, 0L);

        dataList.add(data1);
        dataList.add(data2);

        FlatSegmentTree flatSegmentTree = new FlatSegmentTree(dataList, 26);
        assertNotNull(flatSegmentTree);
    }

    @Test(timeout = 4000)
    public void testQuery() {
        LinkedList<SegmentTree.Data.QuadrantData> dataList = new LinkedList<>();
        SegmentTree.Data.QuadrantData data1 = new SegmentTree.Data.QuadrantData(2364L, 2364L, -6L, 2364L, -6L);
        SegmentTree.Data.QuadrantData data2 = new SegmentTree.Data.QuadrantData(-6L, 0L);

        dataList.add(data1);
        dataList.add(data2);

        FlatSegmentTree flatSegmentTree = new FlatSegmentTree(dataList, 26);

        SegmentTree.Data.QuadrantData result1 = (SegmentTree.Data.QuadrantData) flatSegmentTree.query(-2781L, 0L);
        assertNotNull(result1);
        assertEquals(0L, result1.quad0);
        assertEquals(0L, result1.quad1);
        assertEquals(0L, result1.quad2);
        assertEquals(0L, result1.quad3);

        SegmentTree.Data.QuadrantData result2 = (SegmentTree.Data.QuadrantData) flatSegmentTree.query(0L, 19153L);
        assertNotNull(result2);
        assertEquals(2364L, result2.quad0);
        assertEquals(-6L, result2.quad1);
        assertEquals(2364L, result2.quad2);
        assertEquals(-6L, result2.quad3);

        SegmentTree.Data.QuadrantData result3 = (SegmentTree.Data.QuadrantData) flatSegmentTree.query(-6L, -6L);
        assertNotNull(result3);
        assertEquals(0L, result3.quad0);
        assertEquals(0L, result3.quad1);
        assertEquals(0L, result3.quad2);
        assertEquals(0L, result3.quad3);
    }

    @Test(timeout = 4000)
    public void testInvalidInitialization() {
        LinkedList<SegmentTree.Data.QuadrantData> dataList = new LinkedList<>();
        try {
            new FlatSegmentTree(dataList, 26);
            fail("Expected InvalidParameterException");
        } catch (InvalidParameterException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testNullData() {
        try {
            new FlatSegmentTree(null, 26);
            fail("Expected NullPointerException");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    @Test(timeout = 4000)
    public void testEmptyQuery() {
        LinkedList<SegmentTree.Data.QuadrantData> dataList = new LinkedList<>();
        SegmentTree.Data.QuadrantData data1 = new SegmentTree.Data.QuadrantData(2364L, 2364L, -6L, 2364L, -6L);
        dataList.add(data1);

        FlatSegmentTree flatSegmentTree = new FlatSegmentTree(dataList, 26);
        SegmentTree.Data.QuadrantData result = (SegmentTree.Data.QuadrantData) flatSegmentTree.query(9999L, 9999L);
        assertNull(result);
    }
}