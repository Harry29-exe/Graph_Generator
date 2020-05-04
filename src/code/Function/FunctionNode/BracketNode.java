package code.Function.FunctionNode;


import static code.Function.FunctionNode.NodeType.*;

public class BracketNode implements FunctionNode{
    int indexInFNList;
    NodeType nodeType;

    public BracketNode(NodeType bracketType,int indexInFNList) {
        this.indexInFNList = indexInFNList;
        if(bracketType != OPENING_BRACKET && bracketType != CLOSING_BRACKET) {
            throw new IllegalArgumentException();
        } else {
            nodeType = bracketType;
        }
    }

    @Override
    public int getIndexInFNList() {
        return indexInFNList;
    }

    @Override
    public NodeType getType() {
        return nodeType;
    }
}
