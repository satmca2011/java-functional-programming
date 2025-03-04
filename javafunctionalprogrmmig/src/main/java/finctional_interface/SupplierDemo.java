package finctional_interface;

import java.time.LocalDateTime;
import java.util.function.Supplier;

class SupplierImpl implements Supplier<LocalDateTime>{

    @Override
    public LocalDateTime get() {
        return LocalDateTime.now();
    }
}
public class SupplierDemo {
    public static void main(String[] args) {
        Supplier<LocalDateTime> localTime = new SupplierImpl();
        System.out.println("Current Date is: "+localTime.get());

        Supplier<LocalDateTime> localTimeLambda = () -> LocalDateTime.now();
        System.out.println("Lambda -> Current Date is: "+localTimeLambda.get());
    }
}
