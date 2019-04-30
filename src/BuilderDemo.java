public class BuilderDemo {
    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();

        Director director = new Director(builder);
        director.construct();
    }
}
interface BuildProduct{
    void someMethod();
}
interface Builder{
    void buildPart();
}
class ConcreteBuilder implements Builder{
    private String buildResult = null;

    public String getBuildResult() {
        return buildResult;
    }

    @Override
    public void buildPart() {
        System.out.println("构建产品细节。。。");
    }
}

class Director{
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public void construct(){
        builder.buildPart();
    }
}
