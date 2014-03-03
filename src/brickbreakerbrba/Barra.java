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
public class Barra extends Base {
    private boolean moveRight;
    private boolean moveLeft;
    
    /**
     * Metodo constructor de canasta
     * @param posX posicion en X inicial
     * @param posY posicion en Y inicial
     */
    public Barra(int posX, int posY) {
        super(posX, posY, getAnimacion());
        moveRight = false;
        moveLeft = false;
    }
    
    /**
     * Regresa la animacion de la barra
     * @return un objeto <code>Animacion</code>
     */
    private static Animacion getAnimacion() {
        Animacion anim = new Animacion();
        for (int i = 0; i <= 8; i++) {
            anim.sumaCuadro (Toolkit.getDefaultToolkit ().getImage (Barra.class.getResource ("Images/basket/net" + i + ".png")), 200);
        }
        return anim;
    }
    
    /**
     * Asigna a la variable <code>moveRight</code> el valor deseado.
     * @param b el valor a asignar.
     */
    public void setMoveRight(boolean b) {
        moveRight = b;
    }
    
    /**
     * Regresa el valor actual de <code>moveRight</code>
     * @return un <code>boolean</code>
     */
    public boolean getMoveRight() {
        return moveRight;
    }
    
    /**
     * Asigna a la variable <code>moveLeft</code> el valor deseado.
     * @param b el valor a asignar.
     */
    public void setMoveLeft(boolean b) {
        moveLeft = b;
    }
    
    /**
     * Regresa el valor actual de <code>moveLeft</code>
     * @return un <code>boolean</code>
     */
    public boolean getMoveLeft() {
        return moveLeft;
    }
    
    /**
     * Guarda las variables de <code>Barra</code> que se guardaran en un archivo
     * @return un objeto <code>String</code>
     */
    public String getData() {
        return String.valueOf(getPosX());
    }
    
    /**
     * Asigna las variables leidas del archivo
     * @param arr un arreglo de tipo <code>String</code>
     */
    public void assignData(String[] arr) {
        setPosX(Integer.parseInt(arr[13]));
    }
}
