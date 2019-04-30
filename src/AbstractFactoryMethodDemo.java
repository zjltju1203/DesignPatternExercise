public class AbstractFactoryMethodDemo {
    public static void main(String[] args) {
        AbstractFactoryMethod abstractFactoryMethod = new ConcreteFactoryMethodA1();
        ProductA productA = abstractFactoryMethod.createA();
        ProductB productB = abstractFactoryMethod.createB();
        productA.printAlog();
        productB.printBlog();

        abstractFactoryMethod = new ConcreteFactoryMethodB1();
        productA = abstractFactoryMethod.createA();
        productB = abstractFactoryMethod.createB();
        productA.printAlog();
        productB.printBlog();
    }
}

interface ProductA{
    void printAlog();
}
interface ProductB{
    void printBlog();
}

class ConcreteProductA1 implements ProductA{
    @Override
    public void printAlog() {
        System.out.println("A1");
    }
}
class ConcreteProductA2 implements ProductA{
    @Override
    public void printAlog() {
        System.out.println("A2");
    }
}
class ConcreteProductB1 implements ProductB{
    @Override
    public void printBlog() {
        System.out.println("B1");
    }
}
class ConcreteProductB2 implements ProductB{
    @Override
    public void printBlog() {
        System.out.println("B2");
    }
}

interface AbstractFactoryMethod{
    ProductA createA();
    ProductB createB();
}

class ConcreteFactoryMethodA1 implements AbstractFactoryMethod{
    @Override
    public ProductA createA() {
        return new ConcreteProductA1();
    }

    @Override
    public ProductB createB() {
        return new ConcreteProductB1();
    }
}

class ConcreteFactoryMethodB1 implements AbstractFactoryMethod{
    @Override
    public ProductA createA() {
        return new ConcreteProductA2();
    }

    @Override
    public ProductB createB() {
        return new ConcreteProductB2();
    }
}
