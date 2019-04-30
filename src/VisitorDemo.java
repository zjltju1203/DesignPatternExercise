import java.util.ArrayList;
import java.util.Collection;

public class VisitorDemo {
    public static void main(String[] args) {
        ObjectStructure objectStructure = new ObjectStructure();

        ConcreteElementA concreteElementA = new ConcreteElementA();
        ConcreteElementB concreteElementB = new ConcreteElementB();

        objectStructure.addElement(concreteElementA);
        objectStructure.addElement(concreteElementB);

        Visitor visitor = new ConcreteVisitorA();
        objectStructure.handleRequest(visitor);
    }
}
interface Visitor{
    void visitConcreteElemenA(ConcreteElementA concreteElementA);

    void visitConcreteElemenB(ConcreteElementB concreteElementB);
}

abstract class Element{
    abstract void accept(Visitor visitor);
}

class ConcreteElementA extends Element{
    @Override
    void accept(Visitor visitor) {
        visitor.visitConcreteElemenA(this);
    }

    public void opreation(){
        System.out.println("已有操作A");
    }
}

class ConcreteElementB extends Element{
    @Override
    void accept(Visitor visitor) {
        visitor.visitConcreteElemenB(this);
    }

    public void opreation(){
        System.out.println("已有操作B");
    }
}
class ConcreteVisitorA implements Visitor{
    @Override
    public void visitConcreteElemenA(ConcreteElementA concreteElementA) {
        System.out.println("A添加点东西");
        concreteElementA.opreation();
    }

    @Override
    public void visitConcreteElemenB(ConcreteElementB concreteElementB) {
        System.out.println("B添加点东西");
        concreteElementB.opreation();
    }
}

class ObjectStructure{
    private Collection<Element> collection = new ArrayList<Element>();

    public void handleRequest(Visitor visitor){
        for (Element element : collection){
            element.accept(visitor);
        }
    }

    public void addElement(Element e){
        collection.add(e);
    }
}
