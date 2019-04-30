public class InterpreterDemo {
    public static void main(String[] args) {

    }
}
class ContextInterpret{

}
abstract class AbstractExcepression{
    abstract void interpret(ContextInterpret contextInterpret);

}

class TerminalExpression extends AbstractExcepression{
    @Override
    void interpret(ContextInterpret contextInterpret) {
        System.out.println("TerminalExpression");
    }
}

class NonterminalExpression extends AbstractExcepression{
    @Override
    void interpret(ContextInterpret contextInterpret) {
        System.out.println("NonterminalExpression");
    }
}
