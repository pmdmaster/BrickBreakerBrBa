/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreakerbrba;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author AndresG
 */
public class seleccionUsuario implements KeyListener {
    public Rectangle selectButton = new Rectangle(Base.getW()/2 + 120, 150, 100, 50);
    private int posX;
    private int posY;
    private int height;
    private int width;

    /**
     *
     * @param g
     */
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Font font0 = new Font("arial", Font.BOLD, 50);
        g.setFont (font0);
        g.setColor(Color.white);
        g.drawString("BREAKING BAD", Base.getW() /2, 100);
        Font font1 = new Font("arial", Font.BOLD, 30);
        g.setFont (font1);
        g2d.draw (selectButton);
        posX = 0;
        posY = 0;
        height = Base.getH ()/2;
        width = Base.getW ()/2;

        
    }

    @Override
    public void keyTyped (KeyEvent e) {
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed (KeyEvent e) {
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased (KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            posX = (posX - width)%Base.getW();
            if(posX<0) posX = width*3;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            posY = (posY - height)%Base.getH();
            if(posX<0) posX = height*2;
            
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            posX = (posX + width)%Base.getW();

        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            posY = (posY + height)%Base.getH();
        }
    }
    
    
}
