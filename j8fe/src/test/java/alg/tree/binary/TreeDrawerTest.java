package alg.tree.binary;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TreeDrawerTest {

    private MyBinaryTree tree;
    private TreeDrawer drawer;

    @Before
    public void setUp() throws Exception {
        Node node1lvl3 = new Node(10, "level 3 1st", new Node(5, "level 4 1st"), new Node(15, "level 4 2nd"));
        Node node2lvl3 = new Node(40, "level 3 2st", new Node(35, "level 4 3rd"), new Node(45, "level 4 4th"));
        Node node3lvl3 = new Node(60, "level 3 3rd", new Node(55, "level 4 5th"), new Node(70, "level 4 6th"));
        Node node4lvl3 = new Node(90, "level 3 3rd", new Node(80, "level 4 7th"), new Node(95, "level 4 8th"));

        Node node1lvl2 = new Node(25, "level 2 1st", node1lvl3, node2lvl3);
        Node node2lvl2 = new Node(75, "level 2 2nd", node3lvl3, node4lvl3);

        Node root = new Node(50, "root", node1lvl2, node2lvl2);
       // Node root = new Node(50, "root", null, node2lvl2);


        tree = new MyBinaryTree(root);

        drawer = new TreeDrawer(tree);
    }

    @Test
    public void drawTree() throws Exception {
        drawer.drawTree();
    }

    @Test
    public void testArrayList() throws Exception {
        List<Integer> values = new ArrayList<>(3);
        assertEquals(0, values.size());
        values.add(null);
        values.add(null);
        values.add(5);
        assertEquals(3, values.size());
    }
}