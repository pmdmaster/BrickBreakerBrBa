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
 * @author AndresG
 */
public class Menu implements MouseListener {
    
    

    private final Boton PLAY;
    private final Boton HELP;
    private final Boton QUIT;
    private final Image BACKGROUND;
    
    /**
     * Metodo constructor
     * @param background imagen de fondo
     */
    public Menu(Image background) {
        this.BACKGROUND = background;
        PLAY = new Boton(2*Base.getW()/3, Base.getH()/5, "Images/Buttons/play.png");
        HELP = new Boton(2*Base.getW()/3, 2*Base.getH()/5, "Images/Buttons/help.png");
        QUIT = new Boton(2*Base.getW()/3, 3*Base.getH()/5, "Images/Buttons/quit.png");
    }
    /**
     * Dibuja la pantalla menu
     * @param g
     * @param juego
     */
    public void render(Graphics g, Juego juego) {
        
        g.drawImage(BACKGROUND, 0, 0, juego);
        g.drawImage(PLAY.getImagenI(), PLAY.getPosX(), PLAY.getPosY(), juego);
        g.drawImage(HELP.getImagenI(), HELP.getPosX(), HELP.getPosY(), juego);
        g.drawImage(QUIT.getImagenI(), QUIT.getPosX(), QUIT.getPosY(), juego);
        
    }

    /**
     * Revisa clicks en los botones
     * @param e 
     */
    @Override
    public void mouseClicked (MouseEvent e) {
        if(Juego.State == Juego.STATE.MENU) {
            if (PLAY.contiene (e.getX(), e.getY())) {
                Juego.State = Juego.STATE.CHARSEL;
            } else if (HELP.contiene(e.getX(), e.getY())) {
                Juego.State = Juego.STATE.HELP;
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
