package code.Function.FunctionNode;


import static code.Function.FunctionNode.NodeType.OPERATOR;

public class OperatorNode implements FunctionNode{
    char operatorType;

    public OperatorNode(char operatorType) {
        this.operatorType = operatorType;
    }

    public char getOperatorType() {
        return operatorType;
    }

    @Override
    public NodeType getType() {
        return OPERATOR;
    }



}
