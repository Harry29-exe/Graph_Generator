package code.Function;

@Deprecated
public class Node {

    private int index;
    private String type;
    private int priority;

    public Node(int index, String type, int priority) {
        this.index = index;
        this.type = type;
        this.priority = priority;
    }

    public int getIndex() {
        return index;
    }

    public String getType() {
        return type;
    }

    public int getPriority() {
        return priority;
    }
}
