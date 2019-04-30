public class ProxyDemo {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);
        proxy.request();
    }
}

interface Subject{
    void request();
}
class RealSubject implements Subject{
    @Override
    public void request() {
        System.out.println("realSubject");
    }
}
class Proxy implements Subject{
    private RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {

        System.out.println("开始请求前做一些校验操作。。。");

        System.out.println("校验完成！");
        realSubject.request();

        System.out.println("请求结束做一些处理事宜。。。");
        System.out.println("处理完成");
    }
}