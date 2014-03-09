/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreakerbrba;

import java.awt.Toolkit;

/**
 *
 * @author AndresG
 */
public class Ladrillo extends Base {

    private int nivel;
    private boolean visible;
    private int item;
    private static Animacion[] anims = crearAnimacionLadrillo();
    
    /**
     * Método constructor de <code>Ladrillo</code>
     * @param posX coordenada X
     * @param posY coordenada Y
     * @param niv tipo de objeto
     * @param it tipo de power-up
     */
    public Ladrillo (int posX, int posY, int niv, int it) {
        super (posX, posY, anims[niv-1]);
        nivel = niv;
        visible = true;
        item = it;
    }
    
    /**
     * Se llama cuando la pelota golpea al ladrillo
     * @return el tipo de <code>Item</code> que contiene.
     */
    public int hit() {
        nivel--;
        if (nivel == 0) {
            visible = false;
            return item;
        } else {
            setAnimacion(anims[nivel-1]);
        }
        return -1;
    }
    
    
    /**
     * Crea la animación del ladrillo para el constructor
     * @return un objeto de tipo <code>Animacion</code>
     */
    private static Animacion[] crearAnimacionLadrillo() {
        int tipos = 3;
        Animacion[] anims = new Animacion[tipos];
        for (Animacion anim : anims) {
            for (int i = 0; i <= 20; i++) {
                anim.sumaCuadro (Toolkit.getDefaultToolkit ().getImage (Pelota.class.getResource ("##################" + i + ".png")), 60);
            }
        }
        return anims;
    }
    
    /**
     * Metodo que regresa el valor de <code>visible</code>
     * @return <code>boolean</code>
     */
    public boolean getVisible() {
        return visible;
    }
    
}
