package com.gzq.others;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JApplet;

import org.apache.tools.ant.taskdefs.Move;

public class NoBufferMovingCircle extends JApplet implements Runnable{
    
    Image screenImage = null;
    Thread thread;
    int x = 5;
    int move = 1;
    
    public void init() {
        screenImage = createImage(230, 160);
    }
    
    public void start() {
        if(thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        try {
            while(true) {
                x += move;
                if((x>105) || (x<5))
                    move *= -1;
                repaint();
                thread.sleep(10);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    public void drawCircle(Graphics gc) {
        Graphics2D g = (Graphics2D)gc;
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, 200, 100);
        g.setColor(Color.red);
        g.fillOval(x, 5, 90, 90);
    }
    
    public void pain(Graphics graphics) {
        graphics.setColor(Color.white);
        graphics.fillRect(0, 0, 200, 100);
        drawCircle(graphics);
    }

}
