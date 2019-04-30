public class StrategyDemo {
    public static void main(String[] args) {
        Strategy strategy = new ConcreteStrategyA();
        Context context = new Context(strategy);
        context.contextInterface();
    }
}
interface Strategy{
    void algorithmInterface();
}

class ConcreteStrategyA implements Strategy{
    @Override
    public void algorithmInterface() {
        System.out.println("algorithm1");
    }
}

class ConcreteStrategyB implements Strategy{
    @Override
    public void algorithmInterface() {
        System.out.println("algorithm2");
    }
}

class ConcreteStrategyC implements Strategy{
    @Override
    public void algorithmInterface() {
        System.out.println("algorithm3");
    }
}
class Context{
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void contextInterface(){
        strategy.algorithmInterface();
    }
}