public class CommandDemo {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreateCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.runCommand();
    }
}
interface Command{
    void execute();
}
class Receiver{
    public void action(){
        System.out.println("do something...");
    }
}
class ConcreateCommand implements Command{
    //命令自身状态
    private String state;

    private Receiver receiver;

    public ConcreateCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
class Invoker{
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void runCommand(){
        command.execute();
    }
}