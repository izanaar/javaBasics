package alg.tree.drawers;

import alg.tree.binary.MyBinaryTree;

public class BinarySearchTreeDrawer extends TreeDrawer {
    public BinarySearchTreeDrawer(MyBinaryTree tree) {
        super(tree);
    }

    @Override
    void printSpaces(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print("--");
        }
    }

    @Override
    void printValue(int value) {
        System.out.print(value < 10 ? "0" + value : value);
    }

}
