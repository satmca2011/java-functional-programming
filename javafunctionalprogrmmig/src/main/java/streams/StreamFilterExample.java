package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterExample {
    public static void main(String[] args) {
        // Requirement : print the products on or above 5000 rs

        System.out.println("Using the traditional way");
        List<Product> productList = new ArrayList<>();
        for(Product prod : mockProducts()){
            if(prod.getPrice() >= 5000){
                productList.add(prod);
            }
        }
        productList.forEach(System.out::println);

        System.out.println("******************************************************");
        System.out.println("Using the stream");

        List<Product> filteredAbove5000 = mockProducts().stream()
                .filter(prod -> prod.getPrice() >= 5000)
                .collect(Collectors.toList());

        filteredAbove5000.forEach(System.out::println);

        System.out.println("******************************************************");
        System.out.println("Using the stream more concise");

        mockProducts().stream().filter(prod -> prod.getPrice() >= 5000).forEach(System.out::println);

    }

    private static List<Product> mockProducts(){
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1,"Table",2900));
        productList.add(new Product(2,"Chair",1500));
        productList.add(new Product(3,"Bedsheet",3000));
        productList.add(new Product(4,"Juice Maker",3300));
        productList.add(new Product(5,"Grinder",3890));
        productList.add(new Product(6,"Iron Box",2750));
        productList.add(new Product(7,"Laptop",80000));
        productList.add(new Product(8,"Study Table",3100));
        productList.add(new Product(9,"Fan",2700));
        productList.add(new Product(10,"Cooler",13000));
        return productList;
    }
}

class Product{
    private int id;
    private String name;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
