package alg.tree.drawers;

import alg.tree.binary.Node;
import alg.tree.rb.RBNode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RBTreeDrawerTest {

    private TreeDrawer drawer;

    @Before
    public void setUp() throws Exception {
        /*RBNode node1lvl3 = new RBNode(10, "level 3 1st", false);
        RBNode node2lvl3 = new RBNode(40, "level 3 2st", false);
        RBNode node3lvl3 = new RBNode(60, "level 3 3rd", true);
        RBNode node4lvl3 = new RBNode(90, "level 3 3rd", false, new RBNode(80, "level 4 7th", false), new RBNode(95, "level 4 8th", false));*/

         RBNode node1lvl3 = new RBNode(10, "level 3 1st", true, new RBNode(5, "level 4 1st", false), new RBNode(15, "level 4 2nd", true));
        RBNode node2lvl3 = new RBNode(40, "level 3 2st", false, new RBNode(35, "level 4 3rd", false), new RBNode(45, "level 4 4th", true));
        RBNode node3lvl3 = new RBNode(60, "level 3 3rd", false,new RBNode(55, "level 4 5th", false), new RBNode(70, "level 4 6th", true));
        RBNode node4lvl3 = new RBNode(90, "level 3 3rd", false,new RBNode(80, "level 4 7th", false), new RBNode(95, "level 4 8th", true));

        RBNode node1lvl2 = new RBNode(25, "level 2 1st", true, node1lvl3, node2lvl3);
        RBNode node2lvl2 = new RBNode(75, "level 2 2nd", false, node3lvl3, node4lvl3);

        RBNode root = new RBNode(50, "root", false, node1lvl2, node2lvl2);


        drawer = new RBTreeDrawer(root);
    }

    @Test
    public void drawTree() throws Exception {
        drawer.drawTree();
    }


}