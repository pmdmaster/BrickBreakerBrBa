package brickbreakerbrba;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AndresG
 */
public class Menu {
    
    

    public Rectangle playButton = new Rectangle(Base.getW()/2 + 120, 150, 100, 50);
    public Rectangle helpButton = new Rectangle(Base.getW()/2 + 120, 250, 100, 50);
    public Rectangle quitButton = new Rectangle(Base.getW()/2 + 120, 350, 100, 50);
    
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Font font0 = new Font("arial", Font.BOLD, 50);
        g.setFont (font0);
        g.setColor(Color.white);
        g.drawString("BREAKING BAD", Base.getW() /2, 100);
        
        g2d.draw (playButton);
        g2d.draw (helpButton);
        g2d.draw (quitButton);

        
    }
}
