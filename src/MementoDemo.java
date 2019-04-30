public class MementoDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        originator.setState("404");
        Memento memento = originator.createMemento();

        Caretaker caretaker = new Caretaker();
        caretaker.saveMemento(memento);

        System.out.println(originator.getState());


        originator.setState("500");
        System.out.println(originator.getState());

        Memento memento1 = caretaker.retriveMemento();
        originator.setMemento(memento1);
        System.out.println(originator.getState());
    }
}

interface Memento{

}
class Originator{
    private String state = "";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setMemento(Memento memento){
       MementoImpl memento1 = (MementoImpl) memento;
       this.state = memento1.getState();
   }

   public Memento createMemento(){
       return new MementoImpl(state);
   }

    private static class MementoImpl implements Memento{
        private String state = "";

        public MementoImpl() {

        }
        public MementoImpl(String state) {
            this.state = state;
        }

        public String getState() {
            return state;
        }
    }

}

class Caretaker{
    private Memento memento = null;

    public void saveMemento(Memento memento) {
        this.memento = memento;
    }

    public Memento retriveMemento(){
        return this.memento;
    }

}