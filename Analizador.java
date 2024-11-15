import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*; 

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class Analizador {

    public static void main(String[] args) throws Exception {
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

        // Imprimimos el resultado en la terminal
        System.out.println(listener.getFormattedOutput());

        // Guardar el resultado en un archivo
        try (FileWriter fileWriter = new FileWriter("output.txt")) {
            fileWriter.write(listener.getFormattedOutput());
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }
}
