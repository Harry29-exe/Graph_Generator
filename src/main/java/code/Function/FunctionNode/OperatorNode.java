package code.Function.FunctionNode;


import static code.Function.FunctionNode.NodeType.OPERATOR;

public class OperatorNode implements FunctionNode{
    char operatorType;
    int indexInFNList;

    public OperatorNode(char operatorType, int indexInFNList) {
        this.operatorType = operatorType;
        this.indexInFNList = indexInFNList;
    }

    public char getOperatorType() {
        return operatorType;
    }

    @Override
    public NodeType getType() {
        return OPERATOR;
    }

    @Override
    public int getIndexInFNList() {
        return indexInFNList;
    }

    @Override
    public String toString() {
        return operatorType + "";
    }


}
