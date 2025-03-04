package method_reference;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

@FunctionalInterface
interface Printable{
    void print(String msg);
}
public class MethodReferenceDemo {
    public static void main(String[] args) {
        // 1. Method reference to a static method

        // using lambda expression
        // className::methodName
        System.out.println("Using Lambda Expression:");
        Function<Integer, Double> function = (input)->Math.sqrt(input);
        System.out.println(function.apply(4));

        // using the method reference
        System.out.println("Using Method Ref:");
        Function<Integer, Double> functionMethodRef = Math::sqrt;
        System.out.println(functionMethodRef.apply(4));

        System.out.println("Example 2");
        BiFunction<Integer, Integer, Integer> biFuncLambda = (a, b) -> MethodReferenceDemo.addition(a,b);
        System.out.println(biFuncLambda.apply(3,4));

        BiFunction<Integer, Integer, Integer> biFuncMethodRef = MethodReferenceDemo::addition;
        System.out.println(biFuncMethodRef.apply(3,4));

        // 2. Method reference to an instance method of an object
        // using lambda
        // objectName::methodName
        MethodReferenceDemo methodReferenceDemo = new MethodReferenceDemo();
        Printable printableLambda = (msg)-> methodReferenceDemo.display(msg);
        printableLambda.print("hello");
        // using method ref
        Printable printableMethodRef = methodReferenceDemo::display;
        printableMethodRef.print("yuvan ratan");

        //3. Method reference to the instance method of an arbitrary object
        // Sometimes we call a method of an argument in the lambda expression
        // In such case, we can use method reference to such method of an arbitrary object
        // className::MethodName
        Function<String, String> stringFunction = (String input) -> input.toLowerCase();
        System.out.println(stringFunction.apply("Lambda: Method Reference while using method of an arbitrary OBJECT!!"));

        Function<String, String> stringFunctionMethodRef = String::toLowerCase;
        System.out.println(stringFunctionMethodRef.apply("MR: Method Reference while using method of an arbitrary OBJECT!!"));

        System.out.println("Another example for Method Ref - 3");
        String[] strArray = {"A", "E", "I", "O", "U","a","e","i","o","u"};
        loopStringArray(strArray);
        System.out.println("Lambda: sort array");
        Arrays.sort(strArray, (s1, s2)-> s1.compareToIgnoreCase(s2));
        loopStringArray(strArray);
        String[] strArray1 = {"A", "E", "I", "O", "U","a","e","i","o","u"};
        Arrays.sort(strArray1, String::compareToIgnoreCase);
        loopStringArray(strArray);

        //4. Reference to a constructor
        // want to convert a list to set
        List<String> fruits = new ArrayList<>();
        fruits.add("mango");
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("kiwi");
        System.out.println(fruits.getClass().getTypeName());
        // using Lambda, convert the list to set
        Function<List<String>, Set<String>> setFunction = (fruitsList)-> new HashSet<>(fruitsList);
        Set<String> hashSet = setFunction.apply(fruits);
        System.out.println(hashSet.getClass().getTypeName());

        // using method reference, convert set to list again
        Function<Set<String>, List<String>> setFunctionMethodRef = ArrayList::new;
        System.out.println(setFunctionMethodRef.apply(hashSet).getClass().getTypeName());

    }

    private static void loopStringArray(String[] strArray) {
        for(String s : strArray) {
            System.out.println(s);
        }
    }

    public void display(String msg){
        System.out.println(msg.toUpperCase());
    }
    public static int addition(int a, int b){
        return a+b;
    }
}
