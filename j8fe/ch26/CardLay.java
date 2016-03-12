package ch26;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CardLay extends JFrame{
    public CardLay(String title) throws HeadlessException {
        super(title);
        CardLayout crdLay = new CardLayout();
        JPanel crdPnl = new JPanel();
        crdPnl.setLayout(crdLay);

        setLayout(new FlowLayout());
        JButton winBtn = new JButton("Windows"), unixBtn = new JButton("Unix");

        winBtn.addActionListener(e -> crdLay.show(crdPnl, e.getActionCommand()));
        unixBtn.addActionListener(e -> crdLay.show(crdPnl, e.getActionCommand()));

        add(winBtn); add(unixBtn);

        crdPnl.add(initPnl(new JLabel("Windows 7"), new JLabel("Windows 8")), "Windows");
        crdPnl.add(initPnl(new JLabel("Mac OS"), new JLabel("Linux")), "Unix");
        add(crdPnl);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                crdLay.next(crdPnl);
            }
        });

        setSize(200, 200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel initPnl(Component ... components){
        JPanel panel = new JPanel();
        for(Component cmp : components)
            panel.add(cmp);
        return panel;
    }

    public static void main(String[] args) {
        new CardLay("Card layout demo");
    }
}
