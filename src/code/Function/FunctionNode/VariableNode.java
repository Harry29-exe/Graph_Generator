package code.Function.FunctionNode;

import static code.Function.FunctionNode.NodeType.VARIABLE;

public class VariableNode implements ValueNode {
    String varName;
    int indexInVCList;
    int indexInFNList;

    public VariableNode(String varName, int indexInVCList, int indexInFNList) {
        this.varName = varName;
        this.indexInVCList = indexInVCList;
        this.indexInFNList = indexInFNList;
    }

    public String getVarName() {
        return varName;
    }

    @Override
    public NodeType getType() {
        return VARIABLE;
    }

    @Override
    public int getIndexInFNList() {
        return indexInFNList;
    }

    @Override
    public int getIndexInVCList() {
        return indexInVCList;
    }
}
