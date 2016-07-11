package alg.tree.drawers;

import alg.tree.binary.Node;
import alg.tree.rb.RBNode;
import alg.tree.rb.RBTree;

import java.util.StringJoiner;

public class RBTreeDrawer extends TreeDrawer{

    public RBTreeDrawer(RBNode root) {
        super(root);
    }

    @Override
    void printSpaces(int amount) {
        System.out.print("---");
    }

    @Override
    void printValue(Node node) {
        RBNode rbNode = (RBNode) node;
        String keyStr = node.getKey() < 10 ? "0" + String.valueOf(node.getKey()) : String.valueOf(node.getKey());
        keyStr = rbNode.isRed() ? "R" + keyStr : "B" + keyStr;
        System.out.print(keyStr);
    }

}
