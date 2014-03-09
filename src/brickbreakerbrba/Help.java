package brickbreakerbrba;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alberto
 */
public class Help implements MouseListener {
    
    private Boton returnButton;
    private final Image BACKGROUND;
    
    /**
     * Metodo constructor
     * @param background imagen de fondo
     */
    public Help(Image background) {
        this.BACKGROUND = background;
        returnButton = new Boton(0, 0, "Images/Buttons/return.jpg");
    }
    
    /**
     * Dibuja la pantalla de ayuda
     * @param g
     */
    public void render(Graphics g) {
        
        g.drawImage(BACKGROUND, 0, 0, null);
        g.drawImage(returnButton.getImagenI(), returnButton.getPosX(), returnButton.getPosY(), null);
        
    }

    /**
     * Revisa clicks en los botones
     * @param e 
     */
    @Override
    public void mouseClicked (MouseEvent e) {
        if (Juego.State == Juego.STATE.HELP) {
            if (returnButton.contiene (e.getX(), e.getY())) {
                Juego.State = Juego.STATE.MENU;
            }
        }
    }

    @Override
    public void mousePressed (MouseEvent e) {}

    @Override
    public void mouseReleased (MouseEvent e) {}

    @Override
    public void mouseEntered (MouseEvent e) {}

    @Override
    public void mouseExited (MouseEvent e) {}
}
