public class TemplateDemo {
    public static void main(String[] args) {
        AbstractClass concreteClass = new ConcreteClass();
        concreteClass.doOperation1();
        concreteClass.doOperation2();
    }
}

abstract class AbstractClass{
   abstract void doOperation1();

   abstract void doOperation2();
}

class ConcreteClass extends AbstractClass{
    @Override
    void doOperation1() {
        System.out.println("doOperation1");
    }

    @Override
    void doOperation2() {
        System.out.println("doOperation2");
    }
}