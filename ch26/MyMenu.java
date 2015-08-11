package ch26;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyMenu extends JFrame{
    JLabel command = new JLabel();

    public MyMenu() throws HeadlessException {
        ActionListener itemViewer = e-> command.setText(e.getActionCommand());

        MenuBar menuBar = new MenuBar();
        Menu main = new Menu("Main"), edit = new Menu("Edit"), var = new Menu("option: ",true);


        main.add(initItem(itemViewer,"New"));
        main.add(initItem(itemViewer,"Exit"));
        edit.add(initItem(itemViewer,"Select all"));
        edit.add(var);
        edit.add(initItem(e -> edit.remove(1),"Abort edit"));
        var.add(initItem(itemViewer,"Copy"));
        var.add(initItem(itemViewer,"Paste"));

        add(command);
        menuBar.add(main);
        menuBar.add(edit);

        setSize(400, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setMenuBar(menuBar);
    }

    private MenuItem initItem(ActionListener al, String command){
        MenuItem menuItem = new MenuItem(command);
        menuItem.addActionListener(al);
        return menuItem;
    }

    public static void main(String[] args) {
        new MyMenu();
    }
}
