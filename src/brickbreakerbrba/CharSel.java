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
    
    /**
     * Metodo constructor
     * @param background imagen de fondo
     */
    public CharSel(Image background) {
        this.BACKGROUND = background;
        PLAY = new Boton(Base.getW()/4, 6*Base.getH()/7, "Images/Buttons/play.png");
        RETURN = new Boton(3*Base.getW()/4, 6*Base.getH()/7, "Images/Buttons/return.png");
        SELECTION = new Boton(0, 0, "Images/Faces/rect.png");
        PERSONAJES = new Boton[4];
        for (int i = 1; i <= 4; i++) {
            PERSONAJES[i-1] = new Boton(i*Base.getW()/5, 2*Base.getH()/5, "Images/Faces/choice" + i + ".jpg");
            PERSONAJES[i-1].setPosX(PERSONAJES[i-1].getPosX() - PERSONAJES[i-1].getAncho()/2);
            PERSONAJES[i-1].setPosY(PERSONAJES[i-1].getPosY() - PERSONAJES[i-1].getAlto()/2);
        }
    }
    
    /**
     * Dibuja la pantalla de seleccion de personajes
     * @param g
     * @param juego
     */
    public void render(Graphics g, Juego juego) {
        
        g.drawImage(BACKGROUND, 0, 0, juego);
        g.drawImage(PLAY.getImagenI(), PLAY.getPosX(), PLAY.getPosY(), juego);
        g.drawImage(RETURN.getImagenI(), RETURN.getPosX(), RETURN.getPosY(), juego);
        for (int i = 0; i < 4; i++) {
            g.drawImage(PERSONAJES[i].getImagenI(), PERSONAJES[i].getPosX(), PERSONAJES[i].getPosY(), juego);
        }
        if (Juego.jugador != -1) {
            g.drawImage(SELECTION.getImagenI(), SELECTION.getPosX(), SELECTION.getPosY(), juego);
        }
        
    }

    /**
     * Revisa clicks en los botones
     * @param e 
     */
    @Override
    public void mouseClicked (MouseEvent e) {
        if (Juego.State == Juego.STATE.CHARSEL) {
            
            if (PLAY.contiene(e.getX(), e.getY())) {
                if (Juego.jugador != -1) {
                    Juego.changeToGame = true;
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
