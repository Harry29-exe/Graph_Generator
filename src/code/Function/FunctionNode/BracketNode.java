package code.Function.FunctionNode;


import static code.Function.FunctionNode.NodeType.BRACKET;

public class BracketNode implements FunctionNode{

    @Override
    public NodeType getType() {
        return BRACKET;
    }
}
