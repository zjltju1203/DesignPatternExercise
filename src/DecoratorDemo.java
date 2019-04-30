public class DecoratorDemo {
}
abstract class ComponentDecorator{

    abstract void opreation();
}

class ConcreteComponentDecorator extends ComponentDecorator{
    @Override
    void opreation() {
        System.out.println(" do ConcreteComponentDecorator");
    }
}

abstract class Decorator extends ComponentDecorator{
    private ComponentDecorator component;

    public Decorator(ComponentDecorator component) {
        this.component = component;
    }

    @Override
    void opreation() {
        component.opreation();
    }
}

class ConcreteDecoratorA extends Decorator{
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ConcreteDecoratorA(ComponentDecorator component) {
        super(component);
    }

    @Override
    void opreation() {
        super.opreation();
    }
}

class ConcreteDecoratorB extends Decorator{

    public ConcreteDecoratorB(ComponentDecorator component) {
        super(component);
    }

    public void doSomething(){
        System.out.println("so something");
    }
    @Override
    void opreation() {
        super.opreation();
        doSomething();
    }
}
