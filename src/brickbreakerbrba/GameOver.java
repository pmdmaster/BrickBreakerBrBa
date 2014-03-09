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
public class GameOver implements MouseListener {
    
    private final Boton RETURN;
    private final Boton QUIT;
    private final Image BACKGROUND;
    
    /**
     * Metodo constructor
     * @param background imagen de fondo
     */
    public GameOver(Image background) {
        this.BACKGROUND = background;
        RETURN = new Boton(Base.getW()/5, Base.getH()/2, "Images/Buttons/return.png");
        QUIT = new Boton(4*Base.getW()/5, Base.getH()/2, "Images/Buttons/quit.png");
        RETURN.setPosX(RETURN.getPosX() - RETURN.getAncho()/2);
        RETURN.setPosY(RETURN.getPosY() - RETURN.getAlto()/2);
        QUIT.setPosX(QUIT.getPosX() - QUIT.getAncho()/2);
        QUIT.setPosY(QUIT.getPosY() - QUIT.getAlto()/2);
    }
    /**
     * Dibuja la pantalla menu
     * @param g
     * @param juego
     */
    public void render(Graphics g, Juego juego) {
        
        g.drawImage(BACKGROUND, 0, 0, juego);
        g.drawImage(RETURN.getImagenI(), RETURN.getPosX(), RETURN.getPosY(), juego);
        g.drawImage(QUIT.getImagenI(), QUIT.getPosX(), QUIT.getPosY(), juego);
        
    }

    /**
     * Revisa clicks en los botones
     * @param e 
     */
    @Override
    public void mouseClicked (MouseEvent e) {
        if(Juego.State == Juego.STATE.GAMEOVER) {
            if (RETURN.contiene (e.getX(), e.getY())) {
                Juego.State = Juego.STATE.MENU;
            } else if (QUIT.contiene(e.getX(), e.getY())) {
                Juego.jugando = false;
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
