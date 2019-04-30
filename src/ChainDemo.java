public class ChainDemo {
    public static void main(String[] args) {
        Handler  handler1 = new ConcreteHandler1();
        Handler  handler2 = new ConcreteHandler2();

        handler1.setSuccessor(handler2);
        handler1.handleRequest();
    }
}
abstract class Handler{
    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    abstract void handleRequest();
}

class ConcreteHandler1 extends Handler{
    @Override
    void handleRequest() {
        boolean condition = false;
        //满足条件，自己处理，否则向下传递
        if(condition){
            System.out.println("do ");
        }else{
            successor.handleRequest();
        }
    }
}
class ConcreteHandler2 extends Handler{
    @Override
    void handleRequest() {
        System.out.println("ConcreteHandler2 do it !");
    }
}