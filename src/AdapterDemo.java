public class AdapterDemo {
    static class Client{
        public static void main(String[] args) {
            Adaptee adaptee = new Adaptee();

            Adapter adapter = new Adapter(adaptee);
            adapter.request();
        }
    }
}

interface Target{
    void request();
}

class Adaptee{
    public void existingRequest(){
        System.out.println("已有接口");
    }
}

class Adapter implements Target{
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        System.out.println("适配现有接口");
        adaptee.existingRequest();
    }
}
