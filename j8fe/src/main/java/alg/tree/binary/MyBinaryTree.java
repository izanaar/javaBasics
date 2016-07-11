package alg.tree.binary;

class MyBinaryTree {

    private Node root;

    public MyBinaryTree() {
    }

    MyBinaryTree(Node root) {
        this.root = root;
    }

    Node find(int key) {
        return findRec(root, key);
    }

    private Node findRec(Node cRoot, int key) {
        if (cRoot == null) {
            return null;
        } else {
            if (cRoot.key == key) {
                return cRoot;
            } else {
                if (cRoot.key > key) {
                    return findRec(cRoot.left, key);
                } else {
                    return findRec(cRoot.right, key);
                }
            }
        }
    }

    void insert(Node newNode) {
        if (root == null) {
            root = newNode;
            return;
        }
        insertRec(newNode, root);
    }

    private void insertRec(Node newNode, Node cRoot) {
        if (newNode.key < cRoot.key) {
            if (cRoot.left == null) {
                cRoot.left = newNode;
            } else {
                insertRec(newNode, cRoot.left);
            }
        } else {
            if (cRoot.right == null) {
                cRoot.right = newNode;
            } else {
                insertRec(newNode, cRoot.right);
            }
        }
    }

    Node delete(int key) {
        Node removableParent = getRemovableRoot(root, key);
        if (removableParent == null) {
            return null;
        }

        if (removableParent.key > key) {
            Node removable = removableParent.left;
            removableParent.left = removeChild(removable);
            return removable;
        } else {
            Node removable = removableParent.right;
            removableParent.right = removeChild(removable);
            return removable;
        }

    }

    private Node getRemovableRoot(Node cRoot, int key) {
        if (cRoot.key > key) {
            if (cRoot.left != null && cRoot.left.key == key) {
                return cRoot;
            } else {
                return cRoot.left == null ? null : getRemovableRoot(cRoot.left, key);
            }
        } else {
            if (cRoot.right != null && cRoot.right.key == key) {
                return cRoot;
            } else {
                return cRoot.right == null ? null : getRemovableRoot(cRoot.right, key);
            }
        }
    }

    private Node removeChild(Node removable) {
        Node smallestChild = getSmallestChild(removable);
        removable = smallestChild.equals(removable) ? null : smallestChild;
        return removable;
    }

    private Node getSmallestChild(Node cRoot) {
        return cRoot.left == null ? cRoot : getSmallestChild(cRoot.left);
    }

    public Node getRoot() {
        return root;
    }
}
