package fp_overview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FunctionalProgrammingDemo {
    private static final String COMPLETED = "Completed";
    private static final String PENDING  = "Pending";
    private static final String CANCELLED = "Cancelled";

    public static void main(String[] args) {
        // Filter orders above 10000 using lambda
        List<Order> expensiveOrders = mockOrders().stream()
                .filter(order -> order.getAmount() > 10000)
                .collect(Collectors.toList());
        System.out.println("Expensive orders: "+expensiveOrders);

        // Get ids of orders using map
        List<Integer> orderIds = mockOrders().stream()
                .map(Order :: getId)
                .collect(Collectors.toList());

        System.out.println("Ids orders: "+orderIds);

        // calculate total revenue using reduce
        double totalRevenue = mockOrders().stream()
                .map(Order::getAmount)
                .reduce(0.0, Double::sum);

        System.out.println("Total revenue: "+totalRevenue);

        // Predicate to identify free delivery
        Predicate<Order> eligibleFreeDelivery = order -> order.getAmount() > 5000;
        eligibleFreeDelivery.test(new Order(111,13000, PENDING));
        System.out.println("Is order eligible for free delivery:  "+totalRevenue);

        // sort orders
        List<Order> sortedOrders = mockOrders().stream()
                .sorted(Comparator.comparingDouble(Order::getAmount))
                .collect(Collectors.toList());

        System.out.println("Sorted orders: "+sortedOrders);

        // get completed orders
        List<Order> completedOrders = mockOrders().stream()
                .filter(order -> COMPLETED.equalsIgnoreCase(order.getStatus()))
                .collect(Collectors.toList());
        System.out.println("Completed orders: "+completedOrders);

        // min order
        //List<Order> higestOrder = mockOrders().stream().filter()

        // max order

        // no of orders greater than 10000

        // group orders by stats
    }
    private static List<Order> mockOrders(){
            return Arrays.asList(
                    new Order(101,12000, COMPLETED),
                    new Order(102,12500, CANCELLED),
                    new Order(103,13000, PENDING),
                    new Order(104,15000, COMPLETED),
                    new Order(105,10000, PENDING),
                    new Order(106,13000, COMPLETED),
                    new Order(107, 14000,PENDING),
                    new Order(108,13000,CANCELLED),
                    new Order(109, 16000, COMPLETED),
                    new Order(110, 20000,CANCELLED)
            );
    }
}

class Order{
    private int id;
    private double amount;
    private String status;

    public Order(int id, double amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
