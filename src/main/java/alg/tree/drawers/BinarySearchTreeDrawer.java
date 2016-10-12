package alg.tree.drawers;

import alg.tree.binary.Node;

public class BinarySearchTreeDrawer extends TreeDrawer {
    public BinarySearchTreeDrawer(Node node) {
        super(node);
    }

    @Override
    void printSpaces(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print("--");
        }
    }

    @Override
    void printValue(Node node) {
        int value = node.getKey();
        System.out.print(value < 10 ? "0" + value : value);
    }
}
