import javax.print.attribute.standard.Media;

public class MediatorDemo {
    public static void main(String[] args) {
        Mediator mediator = new ConcreteMediator();
        ColleagueA colleague = new ColleagueA(mediator);
        colleague.someOperation();
        ColleagueB colleagueB = new ColleagueB(mediator);
        colleagueB.someOperation();
    }
}
interface Mediator{
    void changed(Colleague colleague);
}
abstract class Colleague{

    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return mediator;
    }
}

class ColleagueA extends Colleague{
    public ColleagueA(Mediator mediator) {
        super(mediator);
    }

    public void someOperation(){
        getMediator().changed(this);

    }
}

class ColleagueB extends Colleague{
    public ColleagueB(Mediator mediator) {
        super(mediator);
    }

    public void someOperation(){
        getMediator().changed(this);

    }
}

class ConcreteMediator implements Mediator{
    @Override
    public void changed(Colleague colleague) {
        if(colleague instanceof ColleagueA){
            System.out.println("完成与A的交互操作");
        }else if (colleague instanceof  ColleagueB){
            System.out.println("完成与B的交互操作");
        }
    }
}
