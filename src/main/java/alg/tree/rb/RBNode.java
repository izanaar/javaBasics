package alg.tree.rb;

import alg.tree.binary.Node;

public class RBNode extends Node {

    private boolean isRed;

    public RBNode(int key, String value, boolean isRed) {
        this(key, value, isRed, null, null);
    }

    public RBNode(int key, String value, boolean isRed, RBNode left, RBNode right) {
        super(key, value, left, right);
        this.isRed = isRed;
    }

    public boolean isRed() {
        return isRed;
    }

    @Override
    public RBNode getLeft(){
        return (RBNode) super.getLeft();
    }

    @Override
    public RBNode getRight() {
        return (RBNode) super.getRight();
    }
}
