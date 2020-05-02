package code.Function.FunctionNode;

import static code.Function.FunctionNode.NodeType.VARIABLE;

public class VariableNode implements FunctionNode{
    String varName;
    int indexInVCList;

    public VariableNode(String varName, int indexInVCList) {
        this.varName = varName;
        this.indexInVCList = indexInVCList;
    }

    public String getVarName() {
        return varName;
    }

    public int getIndexInVCList() {
        return indexInVCList;
    }

    @Override
    public NodeType getType() {
        return VARIABLE;
    }
}
