import java.util.HashMap;
import java.util.Map;

public class FlyweightDemo {
    public static void main(String[] args) {
        FlyweightFactory flyweightFactory = new FlyweightFactory();
        Flyweight flyweight = flyweightFactory.getFlyweight("404");
        flyweight.opreation("Error");

        flyweight = new UnsharedConcreteFlyweight();
        flyweight.opreation("500");
    }
}
interface Flyweight{
    void opreation(String outState);
}
class ConcreteFlyweight implements Flyweight{
    private String innerState;

    public ConcreteFlyweight(String innerState) {
        this.innerState = innerState;
    }

    @Override
    public void opreation(String outState) {
        System.out.println("do someting:"+innerState+", "+outState);
    }
}
class UnsharedConcreteFlyweight implements Flyweight{
    private String ownState;

    @Override
    public void opreation(String outState) {
        System.out.println("do something:"+outState);
    }
}

class FlyweightFactory{
    Map<String,Flyweight> flyweightMap = new HashMap<String,Flyweight> ();

    public Flyweight getFlyweight(String key){
        Flyweight f = flyweightMap.get(key);

        if(f == null ){
            f = new ConcreteFlyweight(key);
            flyweightMap.put(key,f);
        }
        return f;
    }
}