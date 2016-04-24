package ch27;

import javax.swing.*;
import java.awt.*;

class ImgPnl extends JPanel {
    Image i;

    public ImgPnl(Image i) {
        this.i = i;
        Dimension d = new Dimension(i.getWidth(null),i.getHeight(null));
        setMinimumSize(d);
        setPreferredSize(d);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(i,0,0,this);
    }

    public void setI(Image i) {
        this.i = i;
        repaint();
    }
}
