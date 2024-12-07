package net.mooctest;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    private Product product;

    @Before
    public void setUp() {
        product = new Product("12345", "Test Product", 10.0, 100);
    }

    @Test
    public void testRestock() {
        product.restock(50);
        assertEquals(150, product.getQuantity());
    }

    @Test
    public void testRestockNegativeAmount() {
        try {
            product.restock(-10);
            fail("Exception not thrown for negative restock amount");
        } catch (IllegalArgumentException e) {
            assertEquals("Restock amount must be positive.", e.getMessage());
        }
    }

    @Test
    public void testSell() {
        product.sell(20);
        assertEquals(80, product.getQuantity());
    }

    @Test
    public void testSellNegativeAmount() {
        try {
            product.sell(-10);
            fail("Exception not thrown for negative sell amount");
        } catch (IllegalArgumentException e) {
            assertEquals("Sell amount must be positive.", e.getMessage());
        }
    }

    // 添加更多测试用例以覆盖其他方法

}