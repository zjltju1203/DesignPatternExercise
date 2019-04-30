public class FactoryMethodDemo {
    public static void main(String[] args) {
        Creater creater = new ConcreteCreaterA();
        Product productA = creater.factoryMethod();
        productA.printLog();

        creater = new ConcreteCreaterB();
        Product productB = creater.factoryMethod();
        productB.printLog();
    }
}
interface Product{
    void printLog();
}

class ConcreteProductA implements  Product{
    @Override
    public void printLog() {
        System.out.println("ConcreteProductA");
    }
}

class ConcreteProductB implements  Product{
    @Override
    public void printLog() {
        System.out.println("ConcreteProductB");
    }
}

abstract class Creater{
    protected abstract Product factoryMethod();

    public void someOpreations(){}
}

class ConcreteCreaterA extends Creater{
    @Override
    protected Product factoryMethod() {
        return new ConcreteProductA();
    }
}

class ConcreteCreaterB extends Creater{
    @Override
    protected Product factoryMethod() {
        return new ConcreteProductB();
    }
}
