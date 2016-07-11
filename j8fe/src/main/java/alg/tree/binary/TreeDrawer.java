package alg.tree.binary;

import java.util.*;

class TreeDrawer {

    private int depth;
    private int width;
    private MyBinaryTree tree;
    private Map<Integer, List<Integer>> values;

    TreeDrawer(MyBinaryTree tree) {
        this.tree = tree;
        depth = 0;
        width = 0;
        values = new HashMap<>();
    }

    void drawTree() {
        defineDepth(tree.getRoot(), 1);
        defineValues();
        values.keySet().forEach(this::showRow);
    }

    private void defineDepth(Node root, int level) {
        if (root != null) {
            depth = level;
            defineDepth(root.left, level + 1);
            defineDepth(root.right, level + 1);
        }
    }

    private void defineValues() {
        initValuesMap();
        fillValues(tree.getRoot(), 1);
    }

    private void printSpaces(int amount) {
        for (int i = 0; i < amount; i++) {
            System.out.print("--");
        }
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

        List<Integer> currValues = values.get(i);
        if (node == null) {
            fillEmptyChildren(i);
        } else {
            currValues.add(node.key);
            fillValues(node.left, i + 1);
            fillValues(node.right, i + 1);
        }


    }

    private void fillEmptyChildren(int level) {
        if (level > depth) {
            return;
        } else {
            List<Integer> currLvlVals = values.get(level);
            if (depth != level) {
                fillEmptyChildren(level + 1);
                fillEmptyChildren(level + 1);
            }
            currLvlVals.add(null);
        }
    }

    private void showRow(int level) {
        List<Integer> currVals = values.get(level);
        int shift = defineShift(level);
        printSpaces(defineFirstShift(level));
        for (int i = 0; i < currVals.size(); i++) {
            Integer currValue = currVals.get(i);

            if(currValue != null){
                System.out.print(currValue < 10 ? "0" + currValue : String.valueOf(currValue));
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

}
