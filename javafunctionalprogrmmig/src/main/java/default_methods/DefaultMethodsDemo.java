package default_methods;

interface InterfaceOne{
    void print(String msg);
    default void defaultOne(){
        System.out.println("InterfaceOne: defaultOne");
    }

    default void defaultTwo(){
        System.out.println("InterfaceOne: defaultTwo");
    }
}

interface InterfaceTwo{
    void print(String msg);
    default void defaultOne(){
        System.out.println("InterfaceTwo: defaultOne");
    }

    default void defaultTwo(){
        System.out.println("InterfaceTwo: defaultTwo");
    }
}
class ClassOne implements InterfaceOne{

    @Override
    public void print(String msg) {
        // We can call the default methods from the override methods.
        //defaultOne();
        //defaultTwo();
        System.out.println("ClassOne: print()");
    }
}

class ClassTwo implements InterfaceOne, InterfaceTwo{

    @Override
    public void print(String msg) {
        System.out.println("ClassTwo:print");
    }

    @Override
    public void defaultOne() {
        InterfaceOne.super.defaultOne();
        InterfaceTwo.super.defaultOne();
    }

    @Override
    public void defaultTwo() {
        InterfaceOne.super.defaultTwo();
        InterfaceTwo.super.defaultTwo();
    }
}
public class DefaultMethodsDemo {
    public static void main(String[] args) {
       InterfaceOne i1 = new ClassOne();
       i1.defaultOne();
       i1.defaultTwo();

       ClassTwo c2 = new ClassTwo();
       c2.defaultOne();
       c2.defaultOne();
    }
}
