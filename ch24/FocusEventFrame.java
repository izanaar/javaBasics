package ch24;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FocusEventFrame extends JFrame implements FocusListener {
    public FocusEventFrame() throws HeadlessException {
        CustomField field1 = new CustomField(5, "field 1"),
                field2 = new CustomField(5, "field 2");

        field1.addFocusListener(this);
        field2.addFocusListener(this);

        setSize(300, 200);
        add(field1); add(field2); add(new JButton("Test"));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    public void focusGained(FocusEvent e) {
        System.out.println(e.getSource() + " has gained focus. Temporary status: " + e.isTemporary() +". Opp comp: " + e.getOppositeComponent());
    }

    @Override
    public void focusLost(FocusEvent e) {
        System.out.println(e.getSource() + " has gained focus. Temporary status: " + e.isTemporary() +". Opp comp: " + e.getOppositeComponent());
    }

    public static void main(String[] args) {
        new FocusEventFrame();
    }
}

class CustomField extends JTextField{
    String name;

    public CustomField(int columns, String name) {
        super(columns);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}