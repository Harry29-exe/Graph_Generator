package code.Function;

import java.util.LinkedList;

@Deprecated
public class FunctionNodeList {
    LinkedList<Node> nodeList;

    public FunctionNodeList() {
        nodeList = new LinkedList<>();
    }
    public void addNode(Node node) {
        if(nodeList.getFirst() == null || node.getPriority() > nodeList.getFirst().getPriority()) {
            nodeList.addFirst(node);
        } if( node.getPriority() < nodeList.getLast().getPriority()) {
            nodeList.addLast(node);
        } else {
            int i = 0;
            while(node.getPriority() < nodeList.get(i).getPriority()) {
                i++;
            }
            nodeList.add(i, node);
        }
    }
}
