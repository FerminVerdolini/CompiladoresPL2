import java.util.HashSet;
import java.util.ArrayList;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import game.Ship;
import java.awt.Point;
import java.util.HashMap;
import java.util.Set;

public class AnalizadorListener extends MapaTesoroParserBaseListener {

    private StringBuilder output = new StringBuilder(); // Para almacenar la salida formateada
    private int indentationLevel = 0; // Control de la tabulación
    private final String INDENT = "    "; // Espaciado base para cada nivel de indentación
    // "arador entre las reglas y los terminales

    private boolean isBarco = false; // True si estamos procesando un barco
    private boolean isMina = false;  // True si estamos procesando una mina

    private boolean isSimpleU = false;
    private boolean isSecondBound = false;

    private String currentShip; 
    private Integer currentX;
    private Integer firstComplexX;
    private Integer firstComplexY;

    private String nombreMapa;

    private int height = 10;
    private int width = 10;

    private int shoots = 5;
    
    private HashMap<String,Set<Point>> shipsPositions;// 
    private HashMap<String,Integer> shipsPoints ;//    
    private Integer minePoints;
    private Set<Point> minePositions;// 
    //private List<Ship> ships = new ArrayList<Ship>();
    
    public AnalizadorListener() {
        shipsPoints = new HashMap<>();
        shipsPositions = new HashMap<>();
        minePositions = new HashSet<>();
    }

    // Método para agregar texto con la tabulación actual
    private void appendWithIndentation(String text) {
        for (int i = 0; i < indentationLevel; i++) {
            output.append(INDENT);
        }
        output.append(text).append("\n");
    }
    
    @Override
    public void enterMapa(MapaTesoroParser.MapaContext ctx) {
        appendWithIndentation("MAPA");
        indentationLevel++;
    }
    
    @Override
    public void exitMapa(MapaTesoroParser.MapaContext ctx) {
        indentationLevel--;
    }
    
    @Override
    public void enterConfig_mapa(MapaTesoroParser.Config_mapaContext ctx) {
        appendWithIndentation("CONFIG_MAPA");
        indentationLevel++;
    }
    
    @Override
    public void exitConfig_mapa(MapaTesoroParser.Config_mapaContext ctx) {
        indentationLevel--;
    }

    @Override
    public void enterTitulo(MapaTesoroParser.TituloContext ctx) {
        appendWithIndentation("TITULO: " + ctx.getText());
        nombreMapa = ctx.nombre_mapa().getText();
    }
    
    @Override
    public void enterTamaño(MapaTesoroParser.TamañoContext ctx) {
        appendWithIndentation("TAMAÑO");
        indentationLevel++;
    }
    
    @Override
    public void exitTamaño(MapaTesoroParser.TamañoContext ctx) {
        indentationLevel--;
    }
    
    @Override
    public void enterAncho(MapaTesoroParser.AnchoContext ctx) {
        appendWithIndentation("ANCHO: " + ctx.getText());
        this.width = Integer.parseInt(ctx.getText());
    }
    
    @Override
    public void enterLargo(MapaTesoroParser.LargoContext ctx) {
        appendWithIndentation("LARGO: " + ctx.getText());
        this.height = Integer.parseInt(ctx.getText());
    }
    
    @Override
    public void enterTurnos(MapaTesoroParser.TurnosContext ctx) {
        appendWithIndentation("TURNOS: " + ctx.NUMERO().getText());
        this.shoots = Integer.parseInt(ctx.getText());
    }
    

    @Override
    public void enterInstruccion(MapaTesoroParser.InstruccionContext ctx) {
        appendWithIndentation("INSTRUCCION");
        indentationLevel++;
    }
    
    @Override
    public void exitInstruccion(MapaTesoroParser.InstruccionContext ctx) {
        indentationLevel--;
        isBarco = false;
        isMina = false;
        isSecondBound = false;
    }
    
    @Override
    public void enterBarco(MapaTesoroParser.BarcoContext ctx) {
        appendWithIndentation("BARCO: " + ctx.nombre_barco().getText());
        currentShip = ctx.getText();
        if(!shipsPositions.keySet().contains(currentShip)){
            shipsPositions.put(currentShip, new HashSet<Point>());
        }
    
        if(!shipsPoints.keySet().contains(currentShip)){
            shipsPoints.put(currentShip, 0);
        }
        isBarco = true;
    }
    
    
    @Override
    public void enterPuntuacion(MapaTesoroParser.PuntuacionContext ctx) {
        String puntuacion = ctx.getText();
        
        if (isBarco) {
            appendWithIndentation(String.format("PUNTUACION: + %d puntos", Integer.parseInt(puntuacion))); // Si es un barco, puntuación positiva
            shipsPoints.put(currentShip,Integer.parseInt(puntuacion));
        } else if (isMina) {
            appendWithIndentation(String.format("PUNTUACION: - %d puntos", Integer.parseInt(puntuacion))); // Si es un barco, puntuación positiva
            minePoints = Integer.parseInt(puntuacion);
        } else {
            appendWithIndentation(String.format("PUNTUACION: %d puntos", Integer.parseInt(puntuacion))); // Si es un barco, puntuación positiva
        }
    }
    
    @Override
    public void enterUbicacion(MapaTesoroParser.UbicacionContext ctx) {
        appendWithIndentation("UBICACION");
        indentationLevel++;
    }
    
    @Override
    public void exitUbicacion(MapaTesoroParser.UbicacionContext ctx) {
        indentationLevel--;
    }

    
    @Override
    public void enterUbicacion_simple(MapaTesoroParser.Ubicacion_simpleContext ctx) {
        isSimpleU = true;
    }

    @Override
    public void exitUbicacion_simple(MapaTesoroParser.Ubicacion_simpleContext ctx) {
        isSimpleU = false;
    }


    @Override
    public void enterPos_x(MapaTesoroParser.Pos_xContext ctx) {
        if(isSimpleU){
            currentX =  Integer.parseInt(ctx.getText());
        }else{
            if (isSecondBound) {
                currentX = Integer.parseInt(ctx.getText());
            }else{
                firstComplexX = Integer.parseInt(ctx.getText());
            }
        }
        appendWithIndentation("POS_X: " + ctx.getText());
    }
    
    @Override
    public void enterPos_y(MapaTesoroParser.Pos_yContext ctx) {
        int currentY = Integer.parseInt(ctx.getText());
        if(isBarco){
            Set<Point> pointsSet = shipsPositions.get(currentShip);
            if(isSimpleU){
                pointsSet.add(new Point(currentX,currentY));
            }else{
                if (isSecondBound) {   
                    int initx = Math.min(firstComplexX, currentX);
                    int endx = Math.max(firstComplexX, currentX); 
                    int inity = Math.min(firstComplexY, currentY);
                    int endy = Math.max(firstComplexY, currentY); 
                    for (int i = initx; i <= endx; i++) {
                        for (int j = inity; j <= endy; j++) {
                            pointsSet.add(new Point(i,j));
                        }
                    }
                }else{
                    firstComplexY = currentY;
                    isSecondBound = true;
                }
            }
        }else{
            minePositions.add(new Point(currentX,currentY));
        }
        appendWithIndentation("POS_Y: " + ctx.getText());
    }
    
    @Override
    public void enterMina(MapaTesoroParser.MinaContext ctx) {
        appendWithIndentation("MINA: " + ctx.getText());
        isMina = true;
    }
    
    // Método para obtener la salida formateada
    public String getFormattedOutput() {
        return output.toString();
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public HashMap<String, Integer> getShipsPoints() {
        return shipsPoints;
    }
    
    public HashMap<String, Set<Point>> getShipsPositions() {
        return shipsPositions;
    }
    
    public Integer getMinePoints() {
        return minePoints;
    }
    
    public Set<Point> getMinePositions() {
        return minePositions;
    }

    public String getNombreMapa() {
        return nombreMapa;
    }

    public int getShoots() {
        return shoots;
    }

}

