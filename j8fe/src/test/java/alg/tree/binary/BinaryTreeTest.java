package alg.tree.binary;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    private Map<Integer, Node> nodeMap;
    private BinaryTree tree;

    @Before
    public void setUp() throws Exception {
        nodeMap = new HashMap<Integer, Node>(30);
        tree = new BinaryTree(new Node(27, "Root"));

        tree.insert(new Node(17, "One more"));
        tree.insert(new Node(30, "One more"));
        tree.insert(new Node(35, "One more"));
        tree.insert(new Node(32, "One more"));
        tree.insert(new Node(10, "One more"));
        tree.insert(new Node(25, "One more"));
        tree.insert(new Node(20, "One more"));
        tree.insert(new Node(20, "One more"));
        tree.insert(new Node(9, "One more"));
    }

    @Test
    public void general() throws Exception {
        System.out.println(tree.find(20) == null ? "Node with key 20 wasn't found in the tree." : "Node with key 20 was found in the tree.");
        System.out.println(tree.find(21) == null ? "Node with key 21 wasn't found in the tree." : "Node with key 21 was found in the tree.");

        Node node30 = tree.find(30);
        Node node32 = tree.find(32);

        assertNotEquals(node30.right, node32);

        assertEquals(tree.delete(35).key, 35);

        assertNull(tree.delete(26));

        assertEquals(node32, node30.right);
    }

    @Test
    public void testInsert() throws Exception {
        Node newNode = new Node(36, "New test node");

        tree.insert(newNode);
        assertEquals(tree.find(35).right, newNode);
    }
}