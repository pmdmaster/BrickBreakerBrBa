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
    
    

    private Boton playButton;
    private Boton helpButton;
    private Boton quitButton;
    private final Image BACKGROUND;
    
    /**
     * Metodo constructor
     * @param background imagen de fondo
     */
    public Menu(Image background) {
        this.BACKGROUND = background;
        playButton = new Boton(3*Base.getW()/4, Base.getH()/4, "Images/Buttons/play.jpg");
        helpButton = new Boton(3*Base.getW()/4, Base.getH()/2, "Images/Buttons/help.jpg");
        quitButton = new Boton(3*Base.getW()/4, 3*Base.getH()/4, "Images/Buttons/quit.jpg");
    }
    /**
     * Dibuja la pantalla menu
     * @param g
     * @param juego
     */
    public void render(Graphics g, Juego juego) {
        
        g.drawImage(BACKGROUND, 0, 0, juego);
        g.drawImage(playButton.getImagenI(), playButton.getPosX(), playButton.getPosY(), juego);
        g.drawImage(helpButton.getImagenI(), helpButton.getPosX(), helpButton.getPosY(), juego);
        g.drawImage(quitButton.getImagenI(), quitButton.getPosX(), quitButton.getPosY(), juego);
        
    }

    /**
     * Revisa clicks en los botones
     * @param e 
     */
    @Override
    public void mouseClicked (MouseEvent e) {
        if(Juego.State == Juego.STATE.MENU) {
            if (playButton.contiene (e.getX(), e.getY())) {
                Juego.State = Juego.STATE.CHARSEL;
            } else if (helpButton.contiene(e.getX(), e.getY())) {
                Juego.State = Juego.STATE.HELP;
            } else if (quitButton.contiene(e.getX(), e.getY())) {
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
