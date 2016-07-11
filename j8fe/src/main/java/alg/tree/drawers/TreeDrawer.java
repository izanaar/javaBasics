package alg.tree.drawers;

import alg.tree.binary.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class TreeDrawer {

    private int depth;
    private Node root;
    private Map<Integer, List<Node>> values;

    public TreeDrawer(Node root) {
        this.root = root;
        values = new HashMap<>();
    }

    public void drawTree() {
        defineDepth(root, 1);
        defineValues();
        values.keySet().forEach(this::showRow);
    }

    private void defineDepth(Node node, int level) {
        if (node != null) {
            depth = level;
            defineDepth(node.getLeft(), level + 1);
            defineDepth(node.getRight(), level + 1);
        }
    }

    private void defineValues() {
        initValuesMap();
        fillValues(root, 1);
    }

    private int defineFirstShift(int level) {
        return (int) (Math.pow(2.0, depth - level) - 1);
    }

    private int defineShift(int level) {
        return (int) (Math.pow(2.0, (depth + 1) - level) - 1);
    }

    private void initValuesMap() {
        for (int i = 1; i <= depth; i++) {
            values.put(i, new ArrayList<>(getNodesAmountAtThisDepth(i)));
        }
    }

    private int getNodesAmountAtThisDepth(int depth) {
        return (int) (Math.pow(2.0, depth) - Math.pow(2.0, depth - 1));
    }

    private void fillValues(Node node, int i) {
        if (i > depth) {
            return;
        }

        List<Node> currValues = values.get(i);
        if (node == null) {
            fillEmptyChildren(i);
        } else {
            currValues.add(node);
            fillValues(node.getLeft(), i + 1);
            fillValues(node.getRight(), i + 1);
        }


    }

    private void fillEmptyChildren(int level) {
        if (level >= depth) {
            List<Node> currLvlVals = values.get(level);
            if (depth != level) {
                fillEmptyChildren(level + 1);
                fillEmptyChildren(level + 1);
            }
            currLvlVals.add(null);
        }
    }

    private void showRow(int level) {
        List<Node> currVals = values.get(level);
        int shift = defineShift(level);
        printSpaces(defineFirstShift(level));
        for (int i = 0; i < currVals.size(); i++) {
            Node currValue = currVals.get(i);

            if(currValue != null){
                printValue(currValue);
            }else {
                printSpaces(1);
            }

            if((i + 1) == currVals.size()){
                printSpaces(defineFirstShift(level));
            }else {
                printSpaces(shift);
            }
        }
        System.out.println();
    }

    abstract void printSpaces(int amount);

    abstract void printValue(Node node);
}
