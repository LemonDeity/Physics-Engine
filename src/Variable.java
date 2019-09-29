public class Variable {
    private String variable;
    private Equation eq;
    public Variable(String var){
        variable = var;
        eq = new Equation("");
    }

    public Variable(String var, String equ){
        variable = var;
        eq = new Equation(equ);
    }

    public String getVariable() {
        return variable;
    }

    public Equation getEquation(){
        return eq;
    }

    public String varStringEQ(){
        return eq.toString();
    }
}
