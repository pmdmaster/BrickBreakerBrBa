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
    
    private int vX;
    private int vY;
    private int initX;
    private int initY;
    private boolean mov;
    
    public Pelota (int posX, int posY, int velX, int velY) {
        super(posX, posY, getAnimacion());
        vX = velX;
        initX = posX;
        vY = initY = velY;
        initY = posY;
    }
    
    /**
     * Checa si el objeto <code>Base</code> intersecta a otro
     * <code>Base</code>
     *
     * @return un valor boleano <code>true</code> si lo intersecta
     * <code>false</code> en caso contrario
     */
    public boolean intersects(Base obj) {
        return getPerimetro().intersects(obj.getPerimetro());
    }
    
    /**
     * Establece el valor de vx
     * @param v un <code>double</code>
     */
    public void setVx(int v) {
        vX = v;
    }
    
    /**
     * Establece el valor de vy
     * @param v un <code>double</code>
     */
    public void setVy(int v) {
        vY = v;
    }
    
    /**
     * Establece el valor de vx
     * @param v un <code>double</code>
     */
    public int getVx() {
        return vX;
    }
    
    /**
     * Establece el valor de vy
     * @return 
     */
    public int getVy() {
        return vY;
    }
    
    /**
     * Indica si la pelota está en movimiento o no
     * @param m valor que tomará <code>mov</code>
     */
    public void setMov(boolean m) {
        mov = m;
    }
    
    /**
     * Regresa si <code>Pelota</code> esta en movimiento o no
     * @return true o false
     */
    public boolean getMov() {
        return mov;
    }
    /**
     * Inicia el movimiento de <code>Pelota<code>.
     */
    public void lanzar() {
        mov = true;
        vX = (int) (Math.random ()*10-5);
        vY = (int) -(Math.random ()*4+1);

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
    
    public String getData() {
        String salida = String.valueOf(getPosX())+","+String.valueOf(getPosY())+","+ String.valueOf(vX) + ",";
        salida += String.valueOf (vY);
        return salida;
        
    }
    public void assingData(String[] arr) {
        
        setPosX(Integer.parseInt(arr[3]));
        setPosY(Integer.parseInt(arr[4]));
        vX = Integer.parseInt(arr[5]);
        vY = Integer.parseInt(arr[6]);

    }
    /**
     * La pelota se mueve de acuerdo al tiempo, velocidad en X y Y, y gravedad.
     */
    public void avanza() {
        if (mov) {
            setPosX(getPosX() + vX);
            setPosY(getPosY() + vY);
        }
    }
    /**
     * <code>Pelota</code> reaparece en su posicion original.
     */
    public void reaparecer() {
        setPosX(initX);
        setPosY(initY);
        mov = false;
    }
}
