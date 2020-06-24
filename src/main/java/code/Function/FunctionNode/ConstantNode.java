package code.Function.FunctionNode;

import static code.Function.FunctionNode.NodeType.CONST;

public class ConstantNode implements ValueNode {
    int indexInVCList;
    int indexInFNList;



    public ConstantNode(int indexInVCList, int indexInFNList) {
        this.indexInVCList = indexInVCList;
        this.indexInFNList = indexInFNList;
    }

    @Override
    public NodeType getType() {
        return CONST;
    }

    @Override
    public int getIndexInFNList() {
        return indexInFNList;
    }

    @Override
    public int getIndexInVCList() {
        return indexInVCList;
    }

    @Override
    public String toString() {
        return indexInVCList + "";
    }
}
