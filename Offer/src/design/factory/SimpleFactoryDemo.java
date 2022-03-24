package design.factory;

public class SimpleFactoryDemo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape s1 = factory.produce("circle");
        System.out.println(s1.getRange());
        Shape s2 = factory.produce("rectangle");
        System.out.println(s2.getRange());
    }
}

interface Shape{
    double getRange();
}

class Circle implements Shape {

    @Override
    public double getRange() {
        return 0;
    }
}

class Rectangle implements Shape {

    @Override
    public double getRange() {
        return 2;
    }
}

class ShapeFactory{
    public Shape produce(String type){
        if(type.equals("circle")){
            return  new Circle();
        }else if (type.equals("rectangle")){
            return new Rectangle();
        }
        return null;
    }
}