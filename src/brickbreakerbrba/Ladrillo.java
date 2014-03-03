/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package brickbreakerbrba;

/**
 *
 * @author AndresG
 */
public class Ladrillo extends Base {

    private int nivel;
    
    public Ladrillo (int posX, int posY, int niv, Animacion animacion) {
        super (posX, posY, animacion);
        nivel = niv;
    }
    
    public void explota() {
        
    }
    

    
}
