#!/bin/bash

# Set the CLASSPATH for ANTLR
export CLASSPATH=".:/usr/local/lib/antlr-4.13.2-complete.jar:$CLASSPATH"
echo "CLASSPATH set to: $CLASSPATH"

# Define aliases for ANTLR tools
alias antlr4='java -Xmx500M -cp "/usr/local/lib/antlr-4.13.2-complete.jar:$CLASSPATH" org.antlr.v4.Tool'
alias grun='java org.antlr.v4.gui.TestRig'
echo "Aliases for antlr4 and grun defined."

# Generate lexer and parser
echo "Generating lexer..."
antlr4 MapaTesoroLexer.g4

echo "Generating parser..."
antlr4 MapaTesoroParser.g4

# Compile all Java files
echo "Compiling Java files..."
javac *.java

# Confirm completion
echo "All steps completed successfully."
