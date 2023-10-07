package lab3;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestOrder {
    private Order order;
    private OrderItem[] items;
    private Product[] products;
    @Before
    public void setUp(){
        products = new Product[3];
        products[0] = new Product("1", "A", 10, "X");
        products[1] = new Product("2", "B", 20, "Y");
        products[2] = new Product("3", "C", 30, "X");
        items = new OrderItem[3];
        items[0] = new OrderItem(products[0], 1);
        items[1] = new OrderItem(products[1], 2);
        items[2] = new OrderItem(products[2], 3);
        order = new Order(items);
    }
    @Test
    public void testCost(){
        Assert.assertEquals(140, order.cost(), 0.01);
    }
    @Test
    public void testContains(){
        Assert.assertTrue(order.contains(products[0]));
        Assert.assertTrue(order.contains(products[1]));
        Assert.assertTrue(order.contains(products[2]));
        Assert.assertFalse(order.contains(new Product("4", "D", 40, "Z")));
    }
    @Test
    public void testFilter(){
        Product[] result = order.filter("X");
        Assert.assertEquals(2, result.length);
        Assert.assertEquals(products[0], result[0]);
        Assert.assertEquals(products[2], result[1]);
    }
    
}
