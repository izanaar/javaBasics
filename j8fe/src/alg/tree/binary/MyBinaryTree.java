package alg.tree.binary;

public class MyBinaryTree {

    private Node root;

    public MyBinaryTree() {
    }

    public MyBinaryTree(Node root) {
        this.root = root;
    }

    private Node find(int key){
        return findRec(root, key);
    }

    private Node findRec(Node cRoot, int key){
        if(cRoot == null){
            return null;
        }else {
            if(cRoot.key == key){
                return cRoot;
            }else {
                if(cRoot.key > key){
                    return findRec(cRoot.left, key);
                }else {
                    return findRec(cRoot.right, key);
                }
            }
        }
    }

    private void insert(Node newNode){
        if(root == null){
            root = newNode;
            return;
        }
        insertRec(newNode, root);
    }

    private void insertRec(Node newNode, Node cRoot){
        if(newNode.key < cRoot.key){
            if(cRoot.left == null){
                cRoot.left = newNode;
            }else {
                insertRec(newNode, cRoot.left);
            }
        }else {
            if(cRoot.right == null){
                cRoot.right= newNode;
            }else {
                insertRec(newNode, cRoot.right);
            }
        }
    }

    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree(new Node(27, "Root"));
        tree.insert(new Node(17, "One more"));
        tree.insert(new Node(30, "One more"));
        tree.insert(new Node(35, "One more"));
        tree.insert(new Node(10, "One more"));
        tree.insert(new Node(25, "One more"));
        tree.insert(new Node(20, "One more"));
        tree.insert(new Node(28, "One more"));

        System.out.println(tree.find(20) == null ? "Node with key 20 wasn't found in the tree." : "Node with key 20 was found in the tree.");
        System.out.println(tree.find(21) == null ? "Node with key 21 wasn't found in the tree." : "Node with key 21 was found in the tree.");

        int k = 2;
    }

}
