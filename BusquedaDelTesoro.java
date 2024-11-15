import game.Mine;
import game.Player;
import game.Ship;
import game.TreasureMap;
import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*; 

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.invoke.SwitchPoint;
import java.net.http.WebSocket;
import javax.swing.text.Position;

public class BusquedaDelTesoro {
    
    // ANSI escape codes for colors
    public static final String RESET = "\033[0m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
    public static final String MAGENTA = "\033[35m";
    public static final String CYAN = "\033[36m";
    

    public static void main(String[] args) throws Exception{
             // Inicializar entrada
        String inputFile = null;
        if (args.length > 0)
            inputFile = args[0];

        // inicializamos los streams de datos
        InputStream is = System.in;
        if (inputFile != null) {
            try {
                is = new FileInputStream(inputFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Usamos CharStreams en lugar de ANTLRCharStream o ANTLRInputStream
        CharStream input = CharStreams.fromStream(is);

        // conectamos con el lexer
        MapaTesoroLexer lexer = new MapaTesoroLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // conectamos con el parser
        MapaTesoroParser parser = new MapaTesoroParser(tokens);

        // generamos el árbol a partir del axioma de la gramática
        ParseTree tree = parser.mapa();
        // Recorremos el arbol
        ParseTreeWalker walker = new ParseTreeWalker();
        AnalizadorListener listener = new AnalizadorListener();
        walker.walk(listener, tree);

        TreasureMap.createMap(listener.getWidth(), listener.getHeight());

        for (String name : listener.getShipsPoints().keySet()) {

            if (listener.getShipsPositions().containsKey(name)) {

                if(!TreasureMap.addShip(new Ship(name, listener.getShipsPositions().get(name), listener.getShipsPoints().get(name)))){
                    System.out.println(RED + "Error al añadir el barco " + name + RESET);
                }
            }
        }

        Mine.setPoints(listener.getMinePoints());
        
        for (Point position : listener.getMinePositions()) {
            
            if(!TreasureMap.addMine(new Mine(position))){
                System.out.println(RED + "Error al añadir La Mina" + RESET);
            }
            
        }
        
        Scanner scanner = new Scanner(System.in);
        System.out.println(GREEN +"Bienvenido al Juego: Busqueda del tesoro");
        System.out.println("Nombre del mapa: "+ listener.getNombreMapa() + " tamaño: "+ listener.getWidth() + " por "+ listener.getHeight()+ RESET+"\n\n");

        System.out.print("Por favor, ingresa su nombre: ");
        String name = scanner.nextLine(); // Leer la línea completa de texto

        Player player = new Player(name, listener.getShoots());

        // Display initial state
        System.out.println(BLUE + player + RESET);

        // Main game loop
        boolean playing = true;


        while (playing && player.hasShots()) {
            System.out.println(CYAN + "Enter your move (x y): " + RESET);
            Point shoot =  new Point(scanner.nextInt(), scanner.nextInt());

            player.shot(shoot);

            System.out.println(BLUE + player + RESET);
            
            if (!player.hasShots()) {
                System.out.println(RED + "No quedan disparos!" + RESET);
            } 

            if(TreasureMap.isEmpyOfObjects() ){
                playing = false;
                System.out.println(RED + "No quedan Tesoros en el mapa!" + RESET);
            }
        }


        // End game
        System.out.println(MAGENTA + "Game Over. Final score: " + player.getScore() + RESET);
        agregarPuntuacion(listener.getNombreMapa()+".txt", player.getName() + " puntuo : " + player.getScore());
        scanner.close();
    }

    public static void agregarPuntuacion(String nombreArchivo, String lineaNueva) {
        try (FileWriter escritor = new FileWriter(nombreArchivo, true)) {
            escritor.write(lineaNueva + System.lineSeparator());
        } catch (IOException e) {
        }
    }
}
