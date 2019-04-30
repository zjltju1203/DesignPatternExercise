import java.util.ArrayList;
import java.util.List;

public class ComponentDemo {
    public static void main(String[] args) {
        Component root = new Composite();

        Component component1 = new Composite();
        Component component2 = new Composite();

        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();
        Leaf leaf3 = new Leaf();

        component1.addChild(leaf1);
        component2.addChild(leaf2);

        root.addChild(component1);
        root.addChild(component2);
        root.addChild(leaf3);

        root.someoperation();

    }
}
abstract class Component{
    public abstract void someoperation();

    public void addChild(Component child){
            throw new UnsupportedOperationException("不支持的操作！");

    }

    public void removeChild(Component child){

            throw new UnsupportedOperationException("不支持的操作！");

    }

    public Component getChild(int index){
            throw new UnsupportedOperationException("不支持的操作！");


    }
}

class Composite extends Component{
    List<Component> componentList = new ArrayList<>();
    @Override
    public void someoperation() {
        for (Component component : componentList){
            component.someoperation();
        }
    }

    @Override
    public void addChild(Component child) {
        if(child != null){
            componentList.add(child);
        }
    }

    @Override
    public void removeChild(Component child) {
        if(child != null){
            componentList.remove(child);
        }
    }

    @Override
    public Component getChild(int index) {
        if(index < componentList.size()){
            return componentList.get(index);
        }
        return null;
    }
}
class Leaf extends Component{
    @Override
    public void someoperation() {
        System.out.println("Leaf do something");
    }
}
