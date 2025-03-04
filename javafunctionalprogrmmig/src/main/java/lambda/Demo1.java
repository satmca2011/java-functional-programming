package lambda;
/*
   () -> {};
 */

interface Shape{
    void draw();
}

class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle draw() method call");
    }
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Square draw() method call");
    }
}

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Circle draw() method call");
    }
}
public class Demo1 {
    public static void main(String[] args) {
        // This is a traditional way with the boilerplate code to implement the methods
        System.out.println("------------Before Lambda------------");
        Shape rectange = new Rectangle();
        rectange.draw();
        Shape square = new Square();
        square.draw();
        Shape circle = new Circle();
        circle.draw();
        // With Lambda Expressions, we can create concise, readable and declarative code
        // get rid of the boilerplate code
        // improves the parallel execution
        System.out.println("------------After Lambda Introduce------------");
        Shape lambdaRectange = () -> System.out.println("Lambda -> Rectangle draw() method call");
        lambdaRectange.draw();
        Shape lambdaSquare = () -> System.out.println("Lambda -> Square draw() method call");
        lambdaSquare.draw();
        Shape lambdaCircle = () -> System.out.println("Lambda -> Circle draw() method call");
        lambdaCircle.draw();
        // We can also pass the lambda expression as an argument
        System.out.println("------------Passing Lambda object as an argument------------");
        print(lambdaRectange);
        print(lambdaSquare);
        print(lambdaCircle);

        // We can also directly pass the behaviour to the method
        System.out.println("------------Passing behaviour as an argument------------");
        print(() -> System.out.println("Lambda -> Rectangle draw() method call"));
        print(() -> System.out.println("Lambda -> Square draw() method call"));
        print(() -> System.out.println("Lambda -> Circle draw() method call"));
    }

    private static void print(Shape shape){
        shape.draw();
    }
}
