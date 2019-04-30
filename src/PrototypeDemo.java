public class PrototypeDemo {
    public static void main(String[] args) {
        Prototype prototypeA = new PrototypeA();
        prototypeA.setName("tom");
        System.out.println(prototypeA.getName());

        Client client = new Client(prototypeA);
        client.someOperation();
    }
}

interface Prototype{
    String getName();
    void setName(String name);
    Prototype clone();
}

class PrototypeA implements Prototype{
    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Prototype clone() {
        Prototype prototypeA = new PrototypeA();
        return prototypeA;
    }
}

class PrototypeB implements Prototype{
    private String name ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Prototype clone() {
        Prototype prototypeB = new PrototypeA();
        return prototypeB;
    }
}
class Client{
    private Prototype prototype;

    public Client(Prototype prototype) {
        this.prototype = prototype;
    }

    public Prototype someOperation(){
        Prototype newPrototype = prototype.clone();
        newPrototype.setName("liom");
        System.out.println(newPrototype.getName());
        return newPrototype;
    }
}