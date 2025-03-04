package finctional_interface;

import java.util.function.Consumer;

class ConsumerImpl implements Consumer<String>{
    @Override
    public void accept(String input) {
        System.out.println(input);
    }
}
public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = new ConsumerImpl();
        consumer.accept("Satish");

        Consumer<String> consumerLambda = (s)-> System.out.println(s);
        consumerLambda.accept("Ratan Kishan");
    }
}
