/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreakerbrba;

import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * @author Alberto
 */
public class Pelota extends Base {
    
    private double vX;
    private double vY;
    
    public Pelota (int posX, int posY, double velX, double velY) {
        super(posX, posY, getAnimacion());
        vX = velX;
        vY = velY;
    }
    
    /**
     * Checa si el objeto <code>Base</code> intersecta a otro
     * <code>Base</code>
     *
     * @return un valor boleano <code>true</code> si lo intersecta
     * <code>false</code> en caso contrario
     */
    public boolean intersects(Base obj, double velX, double velY) {
        setDoubleVx(velX);
        setDoubleVy(velY);
        return getPerimetro().intersects(obj.getPerimetro());
    }
    
    /**
     * Actualiza el parametro de velocidad en X
     */   
    public void setDoubleVx(double velX) {
        vX = velX;
    }
    
    /**
     * Actualiza el parametro de velocidad en Y
     */
    public void setDoubleVy(double velY) {
        vY = velY;
    }
    
    /**
     * Crea la animación de la pelota para el constructor
     * @return un objeto de tipo <code>Animacion</code>
     */ 
    private static Animacion getAnimacion() {
        Animacion anim = new Animacion();
        for (int i = 0; i <= 20; i++) {
            anim.sumaCuadro (Toolkit.getDefaultToolkit ().getImage (Pelota.class.getResource ("###############" + i + ".png")), 60);
        }
        return anim;
    }
}
