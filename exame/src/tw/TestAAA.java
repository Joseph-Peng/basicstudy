package tw;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Joseph Peng
 * @date 2022/8/24 17:20
 */
public class TestAAA {

    @Test
    public void test1(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("a", 100));
        products.add(new Product("b", 10));
        assertEquals(products.contains(""), false);
    }

    public static void main(String[] args) {
        List<String> str = new ArrayList<>();
        System.out.println(str.remove("aaa"));

        List<Product> products = new ArrayList<>();
        products.add(new Product("a", 100));
        products.add(new Product("b", 10));
        products.remove("aaa");
    }

    static class Product{
        String name;
        double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }


}
