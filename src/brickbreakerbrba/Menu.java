package brickbreakerbrba;


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
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
    
    

    private final URL playURL = this.getClass().getResource("images/uppoke2.gif");
    private final URL helpURL = this.getClass().getResource("images/uppoke2.gif");
    private final URL quitURL = this.getClass().getResource("images/uppoke2.gif");
    private final Image playImage = Toolkit.getDefaultToolkit().getImage(playURL);
    private final Image helpImage = Toolkit.getDefaultToolkit().getImage(helpURL);
    private final Image quitImage = Toolkit.getDefaultToolkit().getImage(quitURL);
    public Boton playButton = new Boton(3*Base.getW()/4, Base.getH()/4, playImage);
    public Boton helpButton = new Boton(3*Base.getW()/4, Base.getH()/2, helpImage);
    public Boton quitButton = new Boton(3*Base.getW()/4, 3*Base.getH()/4, quitImage);

    /**
     *
     * @param g
     */
    public void render(Graphics g) {
        /*Graphics2D g2d = (Graphics2D) g;
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
        g2d.draw (quitButton);*/
        
        g.drawImage(playButton.getImagenI(), playButton.getPosX(), playButton.getPosY(), null);
        g.drawImage(helpButton.getImagenI(), helpButton.getPosX(), helpButton.getPosY(), null);
        g.drawImage(quitButton.getImagenI(), quitButton.getPosX(), quitButton.getPosY(), null);
        

        
    }

    @Override
    public void mouseClicked (MouseEvent e) {
        if (playButton.contiene (e.getX(), e.getY())) {
            Juego.State = Juego.STATE.CHARSEL;
        } else if (helpButton.contiene(e.getX(), e.getY())) {
            Juego.State = Juego.STATE.HELP;
        } else if (quitButton.contiene(e.getX(), e.getY())) {
            Juego.jugando = false;
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
