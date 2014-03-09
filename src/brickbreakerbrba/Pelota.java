/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreakerbrba;

import java.awt.Toolkit;

/**
 *
 * @author Alberto
 */
public class Pelota extends Base {
    
    private double ang;
    private double vel;
    
    public Pelota () {
        super(0, 0, getAnimacion());
    }
    
    public void setAng (double ang) {
        this.ang = ang;
    }
    
    public double getAng () {
        return ang;
    }
    
    /**
     * Inicia el movimiento de <code>Pelota<code>.
     * @param v velocidad inicial
     */
    public void lanzar(double v) {
        //ang = Math.random()*(Math.PI/2) + Math.PI/4;
        ang = Math.PI/3;
        vel = v;
    }
    
    /**
     * Crea la animación de la pelota para el constructor
     * @return un objeto de tipo <code>Animacion</code>
     */ 
    private static Animacion getAnimacion() {
        Animacion anim = new Animacion();
        for(int i = 1; i <= 3; i++) {
             anim.sumaCuadro (Toolkit.getDefaultToolkit ().getImage (Pelota.class.getResource ("Images/pill" + i+ ".png")), 60);
        }
        return anim;
    }
    
    public String getData() {
        String salida = "";
        //salida = String.valueOf(getPosX())+","+String.valueOf(getPosY())+","+ String.valueOf(vX) + ",";
        //salida += String.valueOf (vY);
        return salida;
        
    }
    public void assingData(String[] arr) {
        
        /*setPosX(Integer.parseInt(arr[3]));
        setPosY(Integer.parseInt(arr[4]));
        vX = Integer.parseInt(arr[5]);
        vY = Integer.parseInt(arr[6]);*/

    }
    /**
     * La pelota se mueve de acuerdo al tiempo, velocidad en X y Y, y gravedad.
     */
    public void avanza() {
        setDoublePosX(getPosX() + vel*Math.cos(ang));
        setDoublePosY(getPosY() - vel*Math.sin(ang));
    }
    
    /**
     * Checa si la pelota colisiona con otro objeto, y cambia su direccion
     * @param otro objeto de tipo <code>Base</code>
     * @return <code>boolean</code>
     */
    public boolean colisiona(Base otro) {
        if (hitUp(otro) || hitDown(otro)) {
            ang = 2*Math.PI - ang;
            return true;
        } else if (hitLeft(otro) || hitRight(otro)) {
            if (ang < Math.PI) {
                ang = Math.PI - ang;
            } else {
                ang = 3*Math.PI - ang;
            }
            return true;
        }
        return false;
    }
}
