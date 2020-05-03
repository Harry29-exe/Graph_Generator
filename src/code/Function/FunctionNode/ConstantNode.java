package code.Function.FunctionNode;

import static code.Function.FunctionNode.NodeType.CONST;

public class ConstantNode implements FunctionNode {
    int indexInVCList;

    public ConstantNode(int constIndex) {
        this.indexInVCList = indexInVCList;
    }

    public int getConstIndex() {
        return indexInVCList;
    }

    @Override
    public NodeType getType() {
        return CONST;
    }
}
