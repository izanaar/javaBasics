package ch27;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

public class ImgView extends JFrame{
    Image img;

    public ImgView() throws HeadlessException, IOException {
        Image img = ImageIO.read(new File("/home/traum/14.jpg"));


        ImgPnl ip = new ImgPnl(img);
        ip.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        add(ip);
        setSize(img.getWidth(this), img.getHeight(this));
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }





    public static void main(String[] args) {
        try {
            new ImgView();
        } catch (MalformedURLException e) {
            System.out.println(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


