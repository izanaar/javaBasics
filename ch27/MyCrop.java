package ch27;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

public class MyCrop extends JFrame {

    Image source;
    Image[] cropped;
    ImgPnl panel;

    int subImgs;
    int ch, cw, sh, sw;

    public MyCrop(Image source, int subImgs) throws HeadlessException {
        super("Random crop");
        this.source = source;
        this.subImgs = subImgs;

        sh = source.getHeight(null);
        sw = source.getWidth(null);

        ch = sh/subImgs;
        cw = sw/subImgs;

        panel = new ImgPnl(source);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    crop();
                    paintCropped(panel.getGraphics());
                    return;
                }else {
                    paintSource(panel.getGraphics());
                    return;
                }
            }
        });

        add(panel);
        setSize(panel.getPreferredSize().width,panel.getPreferredSize().height+28);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    private void crop(){
        if(cropped == null) {
            cropped = new Image[subImgs * subImgs];
            int counter = 0;

            for (int w = 0; w < sw - 1; w += cw)
                for (int h = 0; h < sh - 1; h += ch) {
                    CropImageFilter f = new CropImageFilter(w, h, cw, ch);
                    FilteredImageSource is = new FilteredImageSource(source.getSource(), f);
                    cropped[counter] = createImage(is);
                    counter++;
                }
        }

        Random rand = new Random(new Date().getTime());

        int i1 = rand.nextInt((subImgs*subImgs - 1) + 1) + 0, i2 = rand.nextInt((subImgs*subImgs - 1) + 1) + 0;

        Image img1 = cropped[i1];
        cropped[i1] = cropped[i2];
        cropped[i2] = img1;
    }

    private void paintCropped(Graphics g){
        int counter = 0;
        for(int w = 0; w < sw-1; w+= cw)
            for(int h = 0; h < sh-1; h+= ch)
            {
                g.drawImage(cropped[counter],w,h,null);
                counter++;
            }
    }

    private void paintSource(Graphics g){
        cropped = null;
        g.drawImage(source,0,0,null);
    }

    public static void main(String[] args) {
        try {
            new MyCrop(ImageIO.read(new File("/home/traum/Pictures/MVLd1AtIIBM.jpg")),2);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
