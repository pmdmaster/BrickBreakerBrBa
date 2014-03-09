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
    
    public Ladrillo (int posX, int posY, int niv, int it) {
        super (posX, posY, getAnim(niv));
        nivel = niv;
        visible = true;
        item = it;
    }
    
    /**
     * Disminuye la vida de un ladrillo de acuerdo a su nivel
     * Si la vida es menor a uno regresa verdadero para ser destruido
     * @return Si el nivel es mayor o igual a 1
     */
    public boolean disminuir() {
        nivel--;
        if (nivel >= 1) {
            setAnimacion(getAnim(nivel));
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Cambia el parametro de visibilidad a falso
     * @return el valor que tenía de cadaa item
     */
    public int desaparece() {
        visible = false;
        return item;
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
    
    
    private static Animacion getAnim(int i) {
        return anims[i-1];
    }

    
}
