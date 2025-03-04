package static_methods;

interface InterfaceOne{
    void print();
    static void instanceMethodOne(){
        System.out.println("InterfaceOne: instanceMethodOne");
    }

    static void instanceMethodTwo(){
        System.out.println("InterfaceOne: instanceMethodTwo");
    }
}

class ClassOne implements InterfaceOne{

    @Override
    public void print() {
        System.out.println("ClassOne: print()");
    }
}
public class StaticMethodsDemo {
    public static void main(String[] args) {
        ClassOne classOne = new ClassOne();
        classOne.print();
        // We can call static methods using interface only
        InterfaceOne.instanceMethodOne();
        InterfaceOne.instanceMethodTwo();
    }
}
