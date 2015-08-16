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
    coord last;

    Random rnd;

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
                    repaintCropped(panel.getGraphics());
                    return;
                }else {
                    paintSource(panel.getGraphics());
                    return;
                }
            }
        });

        add(panel);
        new Thread(this::crop).start();
        setSize(panel.getPreferredSize().width, panel.getPreferredSize().height + 28);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void crop(){
        cropped = new Image[subImgs * subImgs];
        int counter = 0;
        for (int h = 0; h < sh; h += ch)
            for (int w = 0; w < sw; w += cw) {
                CropImageFilter f = new CropImageFilter(w, h, cw, ch);
                FilteredImageSource is = new FilteredImageSource(source.getSource(), f);
                cropped[counter] = createImage(is);
                counter++;
            }
        rnd = new Random(new Date().getTime());
        last = new coord();
    }

    private void repaintCropped(Graphics g){
        int c1 = rnd.nextInt(subImgs*subImgs-1), c2;

        do{
            c2 = rnd.nextInt(subImgs*subImgs-1);
        }while (c2 == c1);

        switchCropImgs(c1,c2);

        last.w1 = c1%subImgs;
        last.h1 = c1/subImgs;

        g.drawImage(cropped[c1],last.w1*cw,last.h1*ch,null);

        last.w2 = c2%subImgs;
        last.h2 = c2/subImgs;

        g.drawImage(cropped[c2],last.w2*cw,last.h2*ch,null);
    }

    private void switchCropImgs(int i1, int i2){
        Image buffer = cropped[i1], img2 = cropped[i2];
        cropped[i1] = cropped[i2];
        cropped[i2] = buffer;
    }

    private void paintSource(Graphics g){
        g.drawImage(source,0,0,null);
        crop();
    }

    class coord{
        public int w1,w2,h1,h2;
    }

    public static void main(String[] args) {
        try {
            new MyCrop(ImageIO.read(new File("/home/traum/Pictures/MVLd1AtIIBM.jpg")),8);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
