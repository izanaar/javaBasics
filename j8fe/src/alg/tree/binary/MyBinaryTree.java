package alg.tree.binary;

public class MyBinaryTree {

    private Node root;

    public MyBinaryTree() {
    }

    public MyBinaryTree(Node root) {
        this.root = root;
    }

    private Node find(int key) {
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

    private void insert(Node newNode) {
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

    private Node delete(int key) {
        Node removableParent = getRemovableRoot(root, key);
        if(removableParent == null){
            return null;
        }

        if(removableParent.key > key)
            return removeLeftChild(removableParent, removableParent.left);
        else
            return removeRightChild(removableParent, removableParent.right);

    }

    private Node getRemovableRoot(Node cRoot, int key) {
        if (cRoot.key > key) {
            if (cRoot.left.key == key) {
                return cRoot;
            } else {
                return getRemovableRoot(cRoot.left, key);
            }
        } else {
            if (cRoot.right.key == key) {
                return cRoot;
            } else {
                return getRemovableRoot(cRoot.right, key);
            }
        }
    }

    private Node removeLeftChild(Node removableParent, Node removable) {
        Node smallestChild = getSmallestChild(removable);
        removableParent.left = smallestChild.equals(removable) ? null : getSmallestChild(removable);
        return removable;
    }

    private Node removeRightChild(Node removableParent, Node removable) {
        Node smallestChild = getSmallestChild(removable);
        removableParent.right = smallestChild.equals(removable) ? null : getSmallestChild(removable);
        return removable;
    }

    private Node getSmallestChild(Node cRoot){
        return cRoot.left == null ? cRoot : getSmallestChild(cRoot.left);
    }

    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree(new Node(27, "Root"));
        tree.insert(new Node(17, "One more"));
        tree.insert(new Node(30, "One more"));
        tree.insert(new Node(35, "One more"));
        tree.insert(new Node(32, "One more"));
        tree.insert(new Node(10, "One more"));
        tree.insert(new Node(25, "One more"));
        tree.insert(new Node(20, "One more"));
        tree.insert(new Node(20, "One more"));
        tree.insert(new Node(9, "One more"));

        System.out.println(tree.find(20) == null ? "Node with key 20 wasn't found in the tree." : "Node with key 20 was found in the tree.");
        System.out.println(tree.find(21) == null ? "Node with key 21 wasn't found in the tree." : "Node with key 21 was found in the tree.");

        tree.delete(35);

        int k = 2;
    }

}
