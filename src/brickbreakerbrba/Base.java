package brickbreakerbrba;

import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Base {

    private int posX;    //posicion en x.       
    private int posY;	//posicion en y.
    private static int W;
    private static int H;
    private Animacion animacion;  //animacion del objeto

    /**
     * Metodo constructor usado para crear el objeto
     *
     * @param posX es la <code>posicion en x</code> del objeto.
     * @param posY es la <code>posicion en y</code> del objeto.
     * @param image es la <code>imagen</code> del objeto.
     */
    public Base(int posX, int posY, Animacion animacion) {
        this.posX = posX;
        this.posY = posY;
        this.animacion = animacion;
    }

    /**
     * Metodo modificador usado para cambiar la posicion en x del objeto
     *
     * @param posX es la <code>posicion en x</code> del objeto.
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * Metodo de acceso que regresa la posicion en x del objeto
     *
     * @return posX es la <code>posicion en x</code> del objeto.
     */
    public int getPosX() {
        return posX;
    }

    /**
     * Metodo modificador usado para cambiar la posicion en y del objeto
     *
     * @param posY es la <code>posicion en y</code> del objeto.
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * Metodo de acceso que regresa la posicion en y del objeto
     *
     * @return posY es la <code>posicion en y</code> del objeto.
     */
    public int getPosY() {
        return posY;
    }
    
    /**
     * Metodo modificador del atributo <code>animacion</code>
     * @param anim objeto de tipo <code>Animacion</code>
     */
    public void setAnimacion(Animacion anim) {
        animacion = anim;
    }

    /**
     * Metodo de acceso que regresa el icono del objeto
     *
     * @return icono es el <code>icono</code> del objeto.
     */
    public ImageIcon getImageIcon() {
        return animacion.getImagen();
    }

    /**
     * Metodo de acceso que regresa el ancho del icono
     *
     * @return un objeto de la clase <code>ImageIcon</code> que es el ancho del
     * icono.
     */
    public int getAncho() {
        return animacion.getImagen().getIconWidth();
    }

    /**
     * Metodo de acceso que regresa el alto del icono
     *
     * @return un objeto de la clase <code>ImageIcon</code> que es el alto del
     * icono.
     */
    public int getAlto() {
        return animacion.getImagen().getIconHeight();
    }

    /**
     * Metodo de acceso que regresa la imagen del icono
     *
     * @return un objeto de la clase <code>Image</code> que es la imagen del
     * icono.
     */
    public Image getImagenI() {
        return animacion.getImagen().getImage();
    }

    /**
     * Metodo de acceso que regresa un nuevo rectangulo
     *
     * @return un objeto de la clase <code>Rectangle</code> que es el perimetro
     * del rectangulo
     */
    public Rectangle getPerimetro() {
        return new Rectangle(getPosX(), getPosY(), getAncho(), getAlto());
    }

    /**
     * Checa si el objeto <code>Base</code> intersecta a otro
     * <code>Base</code>
     *
     * @return un valor boleano <code>true</code> si lo intersecta
     * <code>false</code> en caso contrario
     */
    public boolean intersecta(Base obj) {
        return getPerimetro().intersects(obj.getPerimetro());
    }

    /**
     * Checa si el objeto contiene al punto (x, y)
     * @param x coordenada X del punto
     * @param y coordenada Y del punto
     * @return <code>true</code> o <code>false</code>.
     */
    public boolean contiene(int x, int y) {
        return getPerimetro().contains(new Point(x, y));
    }

    /**
     * Actualiza la animacion
     * @param tiempo tiempo actual del JFrame
     */
    public void actualiza(long tiempo) {
        animacion.actualiza(tiempo);
    }
    
    /**
     * Permite a los objetos conocer el ancho del <code>JFrame</code>.
     * @param w ancho del <code>JFrame</code>.
     */
    public static void setW(int w) {
        W = w;
    }
    
    /**
     * Permite a los objetos conocer el ancho del <code>JFrame</code>.
     * @return el ancho del <code>JFrame</code>.
     */
    public static int getW() {
        return W;
    }
    
    /**
     * Permite a los objetos conocer el alto del <code>JFrame</code>.
     * @param h alto del <code>JFrame</code>.
     */
    public static void setH(int h) {
        H = h;
    }
    
    /**
     * Permite a los objetos conocer el alto del <code>JFrame</code>.
     * @return el alto del <code>JFrame</code>.
     */
    public static int getH() {
        return H;
    }
    
    public Rectangle getUp() {
        return new Rectangle(getPosX(), getPosY(), getAncho(), getAlto()/5);
    }
    public Rectangle getDown() {
        return new Rectangle(getPosX(), getPosY() + 4*getAlto()/5, getAncho(), getAlto()/5);
    }
    public Rectangle getLeft() {
        return new Rectangle(getPosX(), getPosY(), getAncho()/5, getAlto());
    }
    public Rectangle getRight() {
        return new Rectangle(getPosX() + 4*getAncho()/5, getPosY(), getAncho()/5, getAlto());
    }
    
    public boolean hitUp(Base otro) {
        return getUp().intersects(otro.getDown());
    }
    public boolean hitDown(Base otro) {
        return getDown().intersects(otro.getUp());
    }
    public boolean hitLeft(Base otro) {
        return getLeft().intersects(otro.getRight());
    }
    public boolean hitRight(Base otro) {
        return getRight().intersects(otro.getLeft());
    }
}
