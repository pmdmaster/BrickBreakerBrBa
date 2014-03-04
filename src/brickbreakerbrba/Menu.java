package brickbreakerbrba;


import java.awt.Dimension;
import java.awt.Graphics;
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
    int val;

    public Rectangle playButton = new Rectangle(Base.getW()/2 + 120, 150, 100, 50);
    public Rectangle helpButton = new Rectangle(Base.getW()/2 + 120, 150, 100, 50);
    public Rectangle quitButton = new Rectangle(Base.getW()/2 + 120, 150, 100, 50);
    
    public void render(Graphics g) {
        
    }
}
