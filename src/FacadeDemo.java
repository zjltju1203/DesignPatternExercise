public class FacadeDemo {
    static class Client{
        public static void main(String[] args) {
            Facade.opreation();
        }
    }
}

interface ModelA{
    void add();
}

interface ModelB{
    void delete();
}

interface ModelC{
    void update();
}

class ModelAImpl implements ModelA{
    @Override
    public void add() {
        System.out.println("modelA add()");
    }
}

class ModelBImpl implements ModelB{
    @Override
    public void delete() {
        System.out.println("modelA delete()");
    }
}

class ModelCImpl implements ModelC{
    @Override
    public void update() {
        System.out.println("modelC update()");
    }
}

class Facade{
    public static void opreation(){
        ModelA modelA = new ModelAImpl();
        modelA.add();

        ModelB modelB = new ModelBImpl();
        modelB.delete();

        ModelC modelC = new ModelCImpl();
        modelC.update();
    }
}
