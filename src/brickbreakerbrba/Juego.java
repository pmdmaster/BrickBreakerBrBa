package brickbreakerbrba;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class Juego extends JFrame implements Runnable, KeyListener, MouseListener {

    private static final long serialVersionUID = 1L;
    private static final String nombreArchivo = "score.txt";
    private String[] arr;    //Arreglo del archivo divido.
    private Pelota pelota;
    private Barra barra;
    private Vector<Ladrillo> ladrillos;
    private boolean pausa;
    private boolean sound;
    private int vidas;
    private int score;
    private int niveles;
    private int nivel;
    private int contador;
    private final int TCONTADOR = 500;
    private Image dbImage;
    private Image menuBG;
    private Image helpBG;
    private Image charSelBG;
    private Image[] levelBG;
    private Image gameOverBG;
    private Image pause;
    private Boton[] cont;
    private Graphics dbg;
    private SoundClip bang;
    private SoundClip shoot;
    private Menu menu;
    private CharSel charSel;
    private GameOver gameOver;
    private Help help;
    
    public static enum STATE {
        MENU,
        HELP,
        CHARSEL,
        GAME,
        GAMEOVER
    };
    public static STATE State;
    public static int jugador = -1;
    public static long tiempo;
    public static boolean jugando;
    public static boolean startGame;

    //Variables de control de tiempo de la animacion
    private long tiempoActual;

    /**
     * Método constructor de la clase <code>JFrameExamen</code>.
     */
    public Juego() {
        setTitle("Breaking Bad");
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        start();
    }

    /**
     * Metodo <I>init</I> sobrescrito de la clase <code>Applet</code>.<P>
     * En este metodo se inizializan las variables o se crean los objetos a
     * usarse en el <code>Applet</code> y se definen funcionalidades.
     */
    public void init() {
        addKeyListener(this);
        addMouseListener(this);
        Base.setW(getWidth());
        Base.setH(getHeight());
        pelota = new Pelota(getWidth() / 2, getHeight() - 50, 0, 0);
        ladrillos = new Vector();
        niveles = 3;

        menuBG = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/background/background.jpg"));
        helpBG = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/background/instrucciones.jpg"));
        charSelBG = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/background/background.jpg"));
        gameOverBG = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/background/gameover2.jpg"));
        for (int i = 0; i < niveles; i++) {
            levelBG[i] = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/background/background.jpg"));
        }
        cont = new Boton[3];
        for (int i = 0; i < 3; i++) {
            cont[i] = new Boton(0, 0, "Images/background/background.jpg");
            cont[i].setPosX(getWidth()/2 - cont[i].getAncho()/2);
            cont[i].setPosY(getHeight()/2 - cont[i].getAlto()/2);
        }

        State = STATE.MENU;
        menu = new Menu(menuBG);
        charSel = new CharSel(charSelBG);
        help = new Help(helpBG);
        gameOver = new GameOver(gameOverBG);
        
        pause = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("Images/pause.png"));

        pausa = false;
        sound = true;
        vidas = 3;
        score = 0;

        jugando = true;
        startGame = false;

        //Pinta el fondo del Applet de color blanco
        setBackground(Color.white);
        shoot = new SoundClip("Sounds/failS.wav");
        bang = new SoundClip("Sounds/hoopS.wav");

    }

    /**
     * Metodo <I>start</I> sobrescrito de la clase <code>Applet</code>.<P>
     * En este metodo se crea e inicializa el hilo para la animacion este metodo
     * es llamado despues del init o cuando el usuario visita otra pagina y
     * luego regresa a la pagina en donde esta este <code>Applet</code>
     *
     */
    public void start() {

        //Crea el thread
        Thread th = new Thread(this);
        //Inicializa el thread
        th.start();
    }

    /**
     * Metodo <I>run</I> sobrescrito de la clase <code>Thread</code>.<P>
     * En este metodo se ejecuta el hilo, es un ciclo indefinido donde se
     * incrementa la posicion en x o y dependiendo de la direccion, finalmente
     * se repinta el <code>Applet</code> y luego manda a dormir el hilo.
     *
     */
    public void run() {
        //Guarda el tiempo actual del sistema
        tiempoActual = System.currentTimeMillis();
        //Ciclo principal del Applet. Actualiza y despliega en pantalla la 
        //animacion hasta que el Applet sea cerrado
        while (true) {
            if (!jugando) {
                setVisible(false);
                disable();
            }
            if (State == STATE.GAME) {
                if (!pausa) {
                    //Actualiza la animacion
                    actualiza();
                    checaColision();
                }
            }
            //Manda a llamar al metodo paint() para mostrar en pantalla la animación
            repaint();
            //Hace una pausa de 20 milisegundos
            try {
                Thread.sleep(20);
            } catch (InterruptedException ex) {
                System.out.println("Error en " + ex.toString());
            }
        }

    }

    /**
     * Metodo que lee a informacion de un archivo y lo agrega a un vector.
     *
     * @throws IOException
     */
    public void leeArchivo() throws IOException {
        BufferedReader fileIn;
        try {
            fileIn = new BufferedReader(new FileReader(nombreArchivo));
        } catch (FileNotFoundException e) {
            File puntos = new File(nombreArchivo);
            PrintWriter fileOut = new PrintWriter(puntos);
            fileOut.println("5,0,0,0,0,0,0,0,0,0");
            fileOut.close();
            fileIn = new BufferedReader(new FileReader(nombreArchivo));
        }
        String dato = fileIn.readLine();

        arr = dato.split(",");
        pausa = Boolean.parseBoolean(arr[0]);
        vidas = Integer.parseInt(arr[1]);
        score = Integer.parseInt(arr[2]);

        pelota.assingData(arr);

        sound = Boolean.parseBoolean(arr[7]);
        fileIn.close();

    }

    /**
     * Metodo que agrega la informacion del vector al archivo.
     *
     * @throws IOException
     */
    public void grabaArchivo() throws IOException {
        //guarda cuando no se encuentra en instrucciones
        try {
            PrintWriter fileOut = new PrintWriter(new FileWriter(nombreArchivo));

            fileOut.println(String.valueOf(pausa) + "," + String.valueOf(vidas) + "," + String.valueOf(score) + "," + pelota.getData() + "," + String.valueOf(sound));
            fileOut.close();
        } catch (FileNotFoundException e) {

        }
    }

    /**
     * El método actualiza() actualiza la animación
     */
    public void actualiza() {
        //Determina el tiempo que ha transcurrido desde que el Applet inicio su ejecución
        long tiempoTranscurrido = System.currentTimeMillis() - tiempoActual;

        //Guarda el tiempo actual
        tiempoActual += tiempoTranscurrido;

        
        if (barra.getMoveLeft()) {
            barra.setPosX(barra.getPosX() - 4);
        }
        if (barra.getMoveRight()) {
            barra.setPosX(barra.getPosX() + 4);
        }

        if (startGame) {
            
            contador = 2 - (int)(System.currentTimeMillis() - tiempo) / TCONTADOR;
            if (contador < 0) {
                startGame = false;
                pelota.lanzar();
            } else {
                pelota.setPosX(barra.getPosX() + barra.getAncho()/2 - pelota.getAncho()/2);
                pelota.setPosY(barra.getPosY() - pelota.getAlto());
            }
            
        } else {
            pelota.avanza();
        }

        //Actualiza la animación en base al tiempo transcurrido
        barra.actualiza(tiempoTranscurrido);
        pelota.actualiza(tiempoTranscurrido);
    }

    /**
     * Metodo usado para checar las colisiones de los personajes con las orillas
     * del <code>Applet</code> y entre si.
     */
    public void checaColision() {
        if (State == STATE.GAME) {
            // Colision de barra con JFrame
            if (barra.getPosX() < 0) {
                barra.setPosX(0);
            }
            if (barra.getPosX() + barra.getAncho() > getWidth()) {
                barra.setPosX(getWidth() - barra.getAncho());
            }
            
            // Colision de pelota con JFrame
            if ((pelota.getPosX() < 0) || (pelota.getPosX() + pelota.getAncho() > getWidth())) {
                pelota.setVx(-pelota.getVx());
            }
            if (pelota.getPosY() > getHeight() + 10) {
                if (sound) {
                    shoot.play();
                }
                startGame = true;
                tiempo = System.currentTimeMillis();
                vidas--;
                if (vidas == 0) {
                    State = STATE.GAMEOVER;
                }
            }
            
            // Colision de pelota con barra
            if (pelota.colisiona(barra)) {

                if (sound) {
                    bang.play();
                }
            }
            
            // Colision de pelota con ladrillos
            for (Ladrillo ladrillo : ladrillos) {

                if(pelota.colisiona(ladrillo)) {
                    ladrillo.hit();
                }
            }
        }
    }

    /**
     * Metodo <I>update</I> sobrescrito de la clase <code>Applet</code>,
     * heredado de la clase Container.<P>
     * En este metodo lo que hace es actualizar el contenedor
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint(Graphics g) {
        // Inicializan el DoubleBuffer
        if (dbImage == null) {
            dbImage = createImage(this.getSize().width, this.getSize().height);
            dbg = dbImage.getGraphics();
        }

        // Actualiza la imagen de fondo.
        dbg.setColor(getBackground());
        dbg.fillRect(0, 0, this.getSize().width, this.getSize().height);

        // Actualiza el Foreground.
        dbg.setColor(getForeground());
        paint1(dbg);

        // Dibuja la imagen actualizada
        g.drawImage(dbImage, 0, 0, this);
    }

    /**
     * Metodo <I>paint</I> sobrescrito de la clase <code>Applet</code>, heredado
     * de la clase Container.<P>
     * En este metodo se dibuja la imagen con la posicion actualizada, ademas
     * que cuando la imagen es cargada te despliega una advertencia.
     *
     * @param g es el <code>objeto grafico</code> usado para dibujar.
     */
    public void paint1(Graphics g) {
        if (State == STATE.GAME) {
            //g.setColor(Color.RED);
            //g.fillRect(0, 0, getWidth(), getHeight());
            // Muestra en pantalla el cuadro actual de la animación
            g.drawImage(levelBG[nivel], 0, 0, this);    // Imagen de background

            if (pelota != null && pelota.getImagenI() != null) {
                g.drawImage(pelota.getImagenI(), pelota.getPosX(), pelota.getPosY(), this);
            }

            if (barra != null && barra.getImagenI() != null) {
                g.drawImage(barra.getImagenI(), barra.getPosX(), barra.getPosY(), this);
            }

            for (Ladrillo ladrillo : ladrillos) {
                g.drawImage(ladrillo.getImagenI(), ladrillo.getPosX(), ladrillo.getPosY(), this);
            }
            
            g.setFont(new Font("default", Font.BOLD, 16));
            if (pausa) { // mensaje de pausa
                g.setColor(Color.white);
                g.drawImage(pause, barra.getPosX() - 10, barra.getPosY() - 37, this);
            }

            g.setColor(Color.green);
            g.drawString("Score: " + score, 20, 55);

            g.setColor(Color.red);
            g.drawString("Vidas: " + vidas, 20, 105);
            
            if (contador >= 0) {
                g.drawImage(cont[contador].getImagenI(), cont[contador].getPosX(), cont[contador].getPosY(), this);
            }
            
        } else if (State == STATE.MENU) {
            menu.render(g, this);
        } else if (State == STATE.HELP) {
            help.render(g, this);
        } else if (State == STATE.CHARSEL) {
            charSel.render(g, this);
        } else if (State == STATE.GAMEOVER) {
            gameOver.render(g, this);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    /**
     * Define el sentido del movimiento de <code>barra</code>
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (State == STATE.GAME) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                barra.setMoveLeft(true);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                barra.setMoveRight(true);
            } else if (e.getKeyCode() == KeyEvent.VK_P) {
                pausa = !pausa;
            } else if (e.getKeyCode() == KeyEvent.VK_C) {

                try {
                    leeArchivo();
                } catch (IOException ex) {
                    Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getKeyCode() == KeyEvent.VK_S) {
                sound = !sound;
            }
        }
    }

    /**
     * Define el sentido del movimiento de <code>barra</code>
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (State == STATE.GAME) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                barra.setMoveLeft(false);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                barra.setMoveRight(false);
            } else if (e.getKeyCode() == KeyEvent.VK_G) {
                //if (!instrucciones) {
                    try {
                        grabaArchivo();
                    } catch (IOException ex) {
                        Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
                    }
                //}

            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
