import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;


public class MiniBListener extends MiniBParserBaseListener {

    private StringBuilder output = new StringBuilder();
    private int indentationLevel = 0; // Control de la tabulación
    private final String INDENT = "    "; // Espaciado base para cada nivel

    // Método para agregar texto con la tabulación actual
    private void appendWithIndentation(String text) {
        for (int i = 0; i < indentationLevel; i++) {
            output.append(INDENT);
        }
        output.append(text).append("\n");
    }

    @Override
    public void enterPrograma(MiniBParser.ProgramaContext ctx) {
        appendWithIndentation("PROGRAMA");
        indentationLevel++;
    }

    @Override
    public void exitPrograma(MiniBParser.ProgramaContext ctx) {
        indentationLevel--;
    }

    @Override
    public void enterStatement(MiniBParser.StatementContext ctx) {
        appendWithIndentation("STATEMENT");
        indentationLevel++;
    }

    @Override
    public void exitStatement(MiniBParser.StatementContext ctx) {
        indentationLevel--;
    }

    @Override
    public void enterForStatement(MiniBParser.ForStatementContext ctx) {
        appendWithIndentation("FOR_STATEMENT");
        indentationLevel++;
    }

    @Override
    public void exitForStatement(MiniBParser.ForStatementContext ctx) {
        indentationLevel--;
    }

    @Override
    public void enterIfStatement(MiniBParser.IfStatementContext ctx) {
        appendWithIndentation("IF_STATEMENT");
        indentationLevel++;
    }

    @Override
    public void exitIfStatement(MiniBParser.IfStatementContext ctx) {
        indentationLevel--;
    }

    @Override
    public void enterPrintStatement(MiniBParser.PrintStatementContext ctx) {
        appendWithIndentation("PRINT_STATEMENT");
        indentationLevel++;
    }

    @Override
    public void exitPrintStatement(MiniBParser.PrintStatementContext ctx) {
        indentationLevel--;
    }

    @Override
    public void enterBloqueControl(MiniBParser.BloqueControlContext ctx) {
        appendWithIndentation("BLOQUE_CONTROL");
        indentationLevel++;
    }

    @Override
    public void exitBloqueControl(MiniBParser.BloqueControlContext ctx) {
        indentationLevel--;
    }

    @Override
    public void enterCondition(MiniBParser.ConditionContext ctx) {
        appendWithIndentation("CONDITION");
        indentationLevel++;
    }

    @Override
    public void exitCondition(MiniBParser.ConditionContext ctx) {
        indentationLevel--;
    }

    @Override
    public void enterExpression(MiniBParser.ExpressionContext ctx) {
        appendWithIndentation("EXPRESSION");
        indentationLevel++;
    }

    @Override
    public void exitExpression(MiniBParser.ExpressionContext ctx) {
        indentationLevel--;
    }

    @Override
    public void enterFactor(MiniBParser.FactorContext ctx) {
        appendWithIndentation("FACTOR");
        indentationLevel++;
    }

    @Override
    public void exitFactor(MiniBParser.FactorContext ctx) {
        indentationLevel--;
    }

    @Override
    public void enterInputStatement(MiniBParser.InputStatementContext ctx) {
        appendWithIndentation("INPUT_STATEMENT");
        indentationLevel++;
    }

    @Override
    public void exitInputStatement(MiniBParser.InputStatementContext ctx) {
        indentationLevel--;
    }

    @Override
    public void enterLetStatement(MiniBParser.LetStatementContext ctx) {
        appendWithIndentation("LET_STATEMENT");
        indentationLevel++;
    }

    @Override
    public void exitLetStatement(MiniBParser.LetStatementContext ctx) {
        indentationLevel--;
    }

    // Imprime únicamente los terminales que no se imprimieron en nodos específicos
    @Override
    public void visitTerminal(TerminalNode node) {
        // Si el terminal pertenece directamente al árbol y no está ya anidado, lo imprimimos
        if (indentationLevel > 0) {
            appendWithIndentation(node.getText());
        }
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        // Si hay un error, lo imprimimos
        appendWithIndentation("ERROR: " + node.getText());
    }

    // Método para obtener la salida formateada
    public String getFormattedOutput() {
        return output.toString();
    }
}
