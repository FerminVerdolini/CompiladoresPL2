import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;


public class AnalizadorListener extends MapaTesoroParserBaseListener {
    
    private StringBuilder formattedOutput = new StringBuilder();
    private boolean isFirstInstruction = true;
    
    @Override
    public void enterConfig_mapa(MapaTesoroParser.Config_mapaContext ctx) {
        formattedOutput.append("config_mapa:\n");
        formattedOutput.append("    titulo:\n");
        formattedOutput.append("        nombre_mapa: ").append(ctx.titulo().nombre_mapa().getText()).append("\n");
        if (ctx.tamaño() != null) {
            formattedOutput.append("    tamaño:\n");
            formattedOutput.append("        ancho: ").append(ctx.tamaño().ancho().NUMERO().getText()).append("\n");
            formattedOutput.append("        alto: ").append(ctx.tamaño().largo().NUMERO().getText()).append("\n");
        }
        isFirstInstruction = false;
    }

    @Override
    public void enterInstruccion(MapaTesoroParser.InstruccionContext ctx) {
        if (!isFirstInstruction) {
            formattedOutput.append("\n");
        }
        formattedOutput.append("instruccion\n");

        if (ctx.barco() != null) {
            formattedOutput.append("    barco\n");
            formattedOutput.append("        nombre_barco: ").append(ctx.barco().nombre_barco().getText()).append("\n");

            if (ctx.ubicacion() != null) {
                formattedOutput.append("    ubicacion:\n");
                formattedOutput.append("        pos_x: ").append(ctx.ubicacion().pos_x().NUMERO().getText()).append("\n");
                formattedOutput.append("        pos_y: ").append(ctx.ubicacion().pos_y().NUMERO().getText()).append("\n");
            }

            if (ctx.puntuacion() != null) {
                formattedOutput.append("    puntuacion: +").append(ctx.puntuacion().NUMERO().getText()).append("\n");
            }
        }

        if (ctx.mina() != null) {
            formattedOutput.append("    mina: Una mina\n");

            if (ctx.puntuacion() != null) {
                formattedOutput.append("    puntuacion: -").append(ctx.puntuacion().NUMERO().getText()).append("\n");
            }

            if (ctx.ubicacion() != null) {
                formattedOutput.append("    ubicacion:\n");
                formattedOutput.append("        pos_x: ").append(ctx.ubicacion().pos_x().NUMERO().getText()).append("\n");
                formattedOutput.append("        pos_y: ").append(ctx.ubicacion().pos_y().NUMERO().getText()).append("\n");
            }
        }

        isFirstInstruction = false;
    }

    public String getFormattedOutput() {
        return formattedOutput.toString();
    }
}
