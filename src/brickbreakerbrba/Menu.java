package brickbreakerbrba;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AndresG
 */
public class Menu implements MouseListener{
    
    

    public Rectangle playButton = new Rectangle(Base.getW()/2 + 120, 150, 100, 50);
    public Rectangle helpButton = new Rectangle(Base.getW()/2 + 120, 250, 100, 50);
    public Rectangle quitButton = new Rectangle(Base.getW()/2 + 120, 350, 100, 50);

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
        g.drawString("Play", playButton.x + 19, playButton.y + 30);
        g2d.draw (playButton);
        g.drawString("Help", helpButton.x + 19, helpButton.y + 30);
        g2d.draw (helpButton);
        g.drawString("Quit", quitButton.x + 19, quitButton.y + 30);
        g2d.draw (quitButton);

        
    }

    @Override
    public void mouseClicked (MouseEvent e) {
        if(playButton.contains (e.getLocationOnScreen ())) {
            JFrameBrickBreakerBrBa.State = JFrameBrickBreakerBrBa.STATE.GAME;
        }
        
    }

    @Override
    public void mousePressed (MouseEvent e) {
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased (MouseEvent e) {
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered (MouseEvent e) {
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited (MouseEvent e) {
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
