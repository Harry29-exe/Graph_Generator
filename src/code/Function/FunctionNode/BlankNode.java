package code.Function.FunctionNode;

import static code.Function.FunctionNode.NodeType.BLANK;

public class BlankNode implements FunctionNode {
    int indexInFNList;

    public BlankNode(int indexInFNList) {
        this.indexInFNList = indexInFNList;
    }

    @Override
    public NodeType getType() {
        return BLANK;
    }

    @Override
    public int getIndexInFNList() {
        return indexInFNList;
    }
}
