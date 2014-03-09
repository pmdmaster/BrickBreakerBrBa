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
public class CharSel implements MouseListener {
    private final Boton PLAY;
    private final Boton RETURN;
    private final Boton SELECTION;
    private final Boton[] PERSONAJES;
    private final Image BACKGROUND;
    
    public CharSel(Image background) {
        this.BACKGROUND = background;
        PLAY = new Boton(0, 0, "Images/Buttons/play.jpg");
        RETURN = new Boton(0, 0, "Images/Buttons/return.jpg");
        SELECTION = new Boton(0, 0, "");
        PERSONAJES = new Boton[4];
        for (int i = 0; i < 4; i++) {
            PERSONAJES[i] = new Boton(0, 0, "");
        }
    }
    /**
     *
     * @param g
     */
    public void render(Graphics g) {
        
        g.drawImage(BACKGROUND, 0, 0, null);
        g.drawImage(PLAY.getImagenI(), PLAY.getPosX(), PLAY.getPosY(), null);
        g.drawImage(RETURN.getImagenI(), RETURN.getPosX(), RETURN.getPosY(), null);
        for (int i = 0; i < 4; i++) {
            g.drawImage(PERSONAJES[i].getImagenI(), PERSONAJES[i].getPosX(), PERSONAJES[i].getPosY(), null);
        }
        if (Juego.jugador != -1) {
            g.drawImage(SELECTION.getImagenI(), SELECTION.getPosX(), SELECTION.getPosY(), null);
        }
        
    }

    @Override
    public void mouseClicked (MouseEvent e) {
        if (Juego.State == Juego.STATE.CHARSEL) {
            
            if (PLAY.contiene(e.getX(), e.getY())) {
                if (Juego.jugador != -1) {
                    Juego.State = Juego.STATE.GAME;
                }
            } else if (RETURN.contiene (e.getX(), e.getY())) {
                Juego.State = Juego.STATE.MENU;
            } else {
                for (int i = 0; i < 4; i++) {
                    if (PERSONAJES[i].contiene(e.getX(), e.getY())) {
                        Juego.jugador = i;
                        SELECTION.setPosX(PERSONAJES[i].getPosX());
                        SELECTION.setPosY(PERSONAJES[i].getPosY());
                    }
                }
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
