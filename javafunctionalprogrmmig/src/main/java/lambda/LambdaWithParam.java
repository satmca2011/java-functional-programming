package lambda;

@FunctionalInterface
interface Calculator{
    int add(int a, int b);
}

class Basic implements Calculator{
    @Override
    public int add(int a, int b) {
        System.out.println("Basic add() starts...");
        int sum = a+b;
        System.out.println("Basic add() ends...");
        return sum;
    }
}
public class LambdaWithParam {
    public static void main(String[] args) {
        System.out.println("Traditional Way:");
        int num1 =100;
        int num2 = 200;
        Calculator basic = new Basic();
        int result = basic.add(num1,num2);
        System.out.println("Sum is: "+result);

        System.out.println("Using Lambda:");
        Calculator basicLambda = (a,b)->{
            int c = a+b;
            return c;
        };
        System.out.println("Sum using Lambda is: "+basicLambda.add(100,200));
    }
}
