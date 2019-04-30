public class SimpleFactoryDemo {
    static class Client{
    public static void main(String[] args) {
        SimpleFactory factory = new SimpleFactory();
        GoodApi goodApi = factory.createGood(1);
        goodApi.operation();
    }
    }
}
interface GoodApi{
    void operation();
}

class GoodA implements  GoodApi{
    @Override
    public void operation() {
        System.out.println("GoodA");
    }
}

class GoodB implements  GoodApi{
    @Override
    public void operation() {
        System.out.println("GoodB");
    }
}

class SimpleFactory{
    public GoodApi createGood(int type){
        GoodApi goodApi = null;
        if(type==0){
            goodApi = new GoodA();
        }else if(type ==1 ){
            goodApi = new GoodB();
        }
        return goodApi;
    }
}
