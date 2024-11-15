import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*; 

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

public class AnalizadorMiniB {
    public static void main(String[] args) throws Exception {
        // Validar que se proporcione un archivo de entrada
        if (args.length == 0) {
            System.err.println("Por favor, proporciona el nombre del archivo de entrada.");
            return;
        }

        String inputFile = args[0]; // Archivo de entrada

        // Extraer el nombre base del archivo (sin directorio ni extensión)
        String baseName = inputFile.substring(inputFile.lastIndexOf('\\') + 1, inputFile.lastIndexOf('.'));
        String outputFile = baseName + ".txt"; // Agregar extensión .txt al nombre base

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
        MiniBLexer lexer = new MiniBLexer(input);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // conectamos con el parser
        MiniBParser parser = new MiniBParser(tokens);

        // generamos el árbol a partir del axioma de la gramática
        ParseTree tree = parser.programa();

        // Recorremos el arbol
        ParseTreeWalker walker = new ParseTreeWalker();
        MiniBListener listener = new MiniBListener();
        walker.walk(listener, tree);

        // Imprimimos el resultado en la terminal
        // Obtener la salida formateada
        String output = listener.getFormattedOutput();
        System.out.println(output);

        // Escribir la salida al archivo con extensión .txt
        try (FileWriter fileWriter = new FileWriter("OutputASTtxt\\"+outputFile)) {
            fileWriter.write(output);
            System.out.println("Árbol sintáctico guardado en: " + "OutputASTtxt\\"+outputFile);
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo de salida: " + e.getMessage());
        }
    }
}
