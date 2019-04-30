public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("懒汉式：");
        SluggardSingleton sluggardSingleton = SluggardSingleton.getInstance();
        System.out.println("饿汉式");
        HungrySingleton hungrySingleton = HungrySingleton.getInstance();

        System.out.println("类级内部类方式");
        SingletonDemo singletonDemo = SingletonDemo.getInstance();
    }

    private static class SingletonHolder{
        private static SingletonDemo singletonDemo = new SingletonDemo();
    }

    public static SingletonDemo getInstance(){
        return SingletonHolder.singletonDemo;
    }


}
/**
 * 懒汉式
 */
class SluggardSingleton{
    private static SluggardSingleton sluggardSingleton = null ;

    /**
     * 私有化构造器，不能通过new创建
     */
    private SluggardSingleton() {
    }

    public static synchronized SluggardSingleton getInstance(){
        if(sluggardSingleton == null){
            sluggardSingleton = new SluggardSingleton();
        }
        return sluggardSingleton;
    }
}

/**
 * 饿汉式
 */

class HungrySingleton{
    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){}

    public static synchronized HungrySingleton getInstance(){
        return hungrySingleton;
    }
}