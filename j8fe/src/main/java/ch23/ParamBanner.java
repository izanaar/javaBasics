package ch23;

import java.applet.Applet;
import java.awt.*;
/*
    <applet code = "ParamBanner" width = 300, height = 50>
    <param name = message value = "Java makes the web move">
    </applet>
*/

public class ParamBanner extends Applet{
    Thread thread;
    volatile boolean stopFlag;
    String text;

    @Override
    public void init() {
        if ((text = getParameter("message")) == null)
            text = " Uber super cool banner";
        thread = new Thread(() ->{
            while (true) {
                if (stopFlag)
                    return;
                char c = text.charAt(0);
                text = text.substring(1);
                text += c;
                repaint();
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        setBackground(Color.BLACK);
        setForeground(Color.white);
        stopFlag = false;
    }

    @Override
    public void start() {
        thread.start();
    }

    @Override
    public void stop() {
        stopFlag = true;
    }

    @Override
    public void destroy() {
        stop();
        text = null;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread = null;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(this.getForeground());
        g.drawString(text,50,30);
    }
}
