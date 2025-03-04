package finctional_interface;

/* What is Functional Interface?
- Introduced in Java 8
- use @FunctionalInterface to mark an interface as functional interface
- Has only one abstract method
- May have many default and static methods
*/

@FunctionalInterface
interface FunctionalInterfaceDemo{
    void print (String msg);
    default void display(){
        System.out.println("default method 1");
    }

    static void m2(){
        System.out.println("static method m2");
    }

    static void m3(){
        System.out.println("static method m3");
    }
}
public class Demo1 {

}
