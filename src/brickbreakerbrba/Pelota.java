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
    
    public Pelota (int posX, int posY) {
        super(posX, posY, getAnimacion());
    }
    
    private static Animacion getAnimacion() {
        Animacion anim = new Animacion();
        for (int i = 0; i <= 20; i++) {
            anim.sumaCuadro (Toolkit.getDefaultToolkit ().getImage (Pelota.class.getResource ("Images/ball/basketball" + i + ".png")), 60);
        }
        return anim;
    }
}
