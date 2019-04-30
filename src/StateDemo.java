public class StateDemo {
    public static void main(String[] args) {
        State state = new ConcreteStateA();
        ContextState contextState = new ContextState();
        contextState.setState(state);
        contextState.process();
    }
}

interface State{
    public void handle(String param);
}

class ConcreteStateA implements State{
    @Override
    public void handle(String param) {
        System.out.println("A do something:"+param);
    }
}
class ConcreteStateB implements State{
    @Override
    public void handle(String param) {
        System.out.println("A do something:"+param);
    }
}
class ContextState{
    int i=10;
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void process(){

        while (i>0){
            if(i<=5){
                setState(new ConcreteStateB());
            }
            state.handle(i+"");
            i--;
        }

    }
}