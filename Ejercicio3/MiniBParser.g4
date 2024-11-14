parser grammar MiniBParser;

options { tokenVocab=MiniBLexer; }

// Regla principal del programa
programa: statement+;

// Declaraciones posibles en MiniB
statement: forStatement
         | ifStatement
         | whileStatement
         | printStatement
         | inputStatement
         | letStatement
         | repeatStatement
         ;

// Bucle FOR
forStatement: FOR IDENTIFIER EQUAL expression TO expression bloqueControl NEXT;

// Declaración condicional IF-ELSE
ifStatement: IF condition THEN bloqueControl (ELSE bloqueControl)? END;

// Bucle WHILE
whileStatement: WHILE condition bloqueControl END;

// Declaración de impresión
printStatement: PRINT expression (PLUS expression)*;

// Declaración de entrada de usuario
inputStatement: INPUT STRING IDENTIFIER;

// Declaración LET (asignación de variable)
letStatement: (LET)? IDENTIFIER EQUAL expression;

// Declaración REPEAT-UNTIL
repeatStatement: REPEAT statement+ UNTIL condition;

// Operadores Lógicos
logicalOp: AND | OR | NOT;

// Bloque de código reutilizable (para funciones y estructuras de control)
bloqueControl: (statement+ | CONTINUE | EXIT);

// Expresiones y condiciones
condition: expression ((LT | LTE | GT | GTE | EQ | NEQ) expression)? (logicalOp condition)?;
expression: term ((PLUS | MINUS) term)*;
term: factor ((MULT | DIV | MOD) factor)*;
factor: NUMBER 
      | IDENTIFIER 
      | LPAREN expression RPAREN 
      | STRING
      | VAL LPAREN expression RPAREN
      | LEN LPAREN expression RPAREN
      | ISNAN LPAREN expression RPAREN;
