public class IteratorDemo {
    public static void main(String[] args) {
        String[] strArr = {"张飞","关羽","姜维","赵云","马良"} ;
        ConcreteAggregate aggregate = new ConcreteAggregate(strArr);
        Iterator iterator = new ConcreteIterator(aggregate);

        iterator.first();
        while (!iterator.isDone()){
            System.out.println(iterator.currentItem());
            iterator.next();
        }
    }
}
interface Iterator{
    void first();

    void next();

    boolean isDone();

    Object currentItem();
}

class ConcreteIterator implements Iterator{
    private ConcreteAggregate concreteAggregate;

    private int index = -1;
    public ConcreteIterator(ConcreteAggregate concreteAggregate) {
        this.concreteAggregate = concreteAggregate;
    }

    @Override
    public void first() {
        index = 0;
    }

    @Override
    public void next() {
        if(index < concreteAggregate.size()){
            index++;
        }
    }

    @Override
    public boolean isDone() {
        if(index == concreteAggregate.size()){
            return true;
        }
        return false;
    }

    @Override
    public Object currentItem() {
        return concreteAggregate.getObj(index);
    }
}
abstract class Aggregate{
    abstract Iterator createIterator();
}

class ConcreteAggregate extends Aggregate{
    private String[] ss = null ;

    public ConcreteAggregate(String[] ss) {
        this.ss = ss;
    }

    @Override
    Iterator createIterator() {
        return null;
    }

    public Object getObj(int index){
        Object obj = null;
        if(index < ss.length){
            obj = ss[index];
        }
        return obj;
    }

    public int size(){
        int length = 0;
        if(ss!=null){
            length = ss.length;
        }
        return length;
    }
}