package code.Function.FunctionNode;

import static code.Function.FunctionNode.NodeType.CONST;

public class ConstNode implements FunctionNode {
    int indexInVCList;

    public ConstNode(int constIndex) {
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
