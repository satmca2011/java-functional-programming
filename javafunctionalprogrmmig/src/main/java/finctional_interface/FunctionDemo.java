package finctional_interface;

/*
    Function<T, R> -> Takes the input and provides the result
* */

import java.util.function.Function;

class FuncImpl implements Function<String, Integer>{

    @Override
    public Integer apply(String s) {
        return s.length();
    }
}
public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> result = new FuncImpl();
        System.out.println("Length of the string is: "+result.apply("Yuvan"));

        Function<String, Integer> resultLambda = (s) -> s.length();
        System.out.println("Length of the string is: "+resultLambda.apply("Yuvan Charan"));
    }
}
