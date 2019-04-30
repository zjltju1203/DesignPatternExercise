public class BridgeDemo {
    public static void main(String[] args) {
        Implementor implementor = new ConcreteImplementor();
        Abstraction abstraction = new RefinedAbstraction(implementor);
        abstraction.operation();
    }
}
interface Implementor{
    void operation();
}
abstract class Abstraction{
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public void operation(){
        implementor.operation();
    }
}
class RefinedAbstraction extends  Abstraction{
    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    public void operation() {
        super.operation();
        System.out.println("桥接完成，再做点事情");
    }
}
class ConcreteImplementor implements Implementor{
    @Override
    public void operation() {
        System.out.println("这是原始方法做的");
    }
}