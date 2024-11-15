import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

public class AnalizadorListener extends MapaTesoroParserBaseListener {

    private StringBuilder output = new StringBuilder(); // Para almacenar la salida formateada
    private int indentationLevel = 0; // Control de la tabulación
    private final String INDENT = "    "; // Espaciado base para cada nivel de indentación
    // "arador entre las reglas y los terminales

    private boolean isBarco = false; // True si estamos procesando un barco
    private boolean isMina = false;  // True si estamos procesando una mina

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
    }

    @Override
    public void enterLargo(MapaTesoroParser.LargoContext ctx) {
        appendWithIndentation("LARGO: " + ctx.getText());
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
    }

    @Override
    public void enterBarco(MapaTesoroParser.BarcoContext ctx) {
        appendWithIndentation("BARCO: " + ctx.getText());
        isBarco = true;
    }


    @Override
    public void enterPuntuacion(MapaTesoroParser.PuntuacionContext ctx) {
        String puntuacion = ctx.getText();

        if (isBarco) {
            appendWithIndentation(String.format("PUNTUACION: + %d puntos", Integer.parseInt(puntuacion))); // Si es un barco, puntuación positiva
        } else if (isMina) {
            appendWithIndentation(String.format("PUNTUACION: - %d puntos", Integer.parseInt(puntuacion))); // Si es un barco, puntuación positiva
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
    public void enterPos_x(MapaTesoroParser.Pos_xContext ctx) {
        appendWithIndentation("POS_X: " + ctx.getText());
    }

    @Override
    public void enterPos_y(MapaTesoroParser.Pos_yContext ctx) {
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
}

