package alg.tree.binary;

public class Node {

    int key;
    private String value;

    Node left;
    Node right;

    public Node(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public Node(int key, String value, Node left, Node right) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return key == node.key;

    }

    @Override
    public int hashCode() {
        return key;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value='" + value + '\'' +
                ", key=" + key +
                '}';
    }
}
