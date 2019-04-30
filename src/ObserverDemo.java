
import java.util.ArrayList;
import java.util.List;

public class ObserverDemo {
    public static void main(String[] args) {
        ConcreateObserver concreateObserver = new ConcreateObserver();
        concreateObserver.setObserverState("202");
        System.out.println(concreateObserver.getObserverState());

        ConcreateSubject subjectA = new ConcreateSubject();
        subjectA.attach(concreateObserver);
        subjectA.setSubjectState("404");
        System.out.println(concreateObserver.getObserverState());

        subjectA.detach(concreateObserver);
        subjectA.setSubjectState("500");
        System.out.println(concreateObserver.getObserverState());
    }
}
interface Observer{
    void update(SubjectA subject);
}
class SubjectA{
    private List<Observer> observerList = new ArrayList<Observer>();

    //注册
    public void attach(Observer observer){
        observerList.add(observer);
    }

    //注销
    public void detach(Observer observer){
        observerList.remove(observer);
    }

    public void notifyObservers(){
        for(Observer observer : observerList){
            observer.update(this);
        }
    }
}

class ConcreateSubject extends SubjectA{
    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;

        this.notifyObservers();
    }
}

class ConcreateObserver implements Observer{
    private String ObserverState;
    @Override
    public void update(SubjectA subject) {
        ObserverState = ((ConcreateSubject)subject).getSubjectState();
    }

    public String getObserverState() {
        return ObserverState;
    }

    public void setObserverState(String observerState) {
        ObserverState = observerState;
    }
}