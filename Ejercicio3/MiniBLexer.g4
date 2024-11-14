lexer grammar MiniBLexer;

// Palabras clave (insensibles a mayúsculas y minúsculas)
FOR:      [fF] [oO] [rR];
TO:       [tT] [oO];
NEXT:     [nN] [eE] [xX] [tT];
IF:       [iI] [fF];
THEN:     [tT] [hH] [eE] [nN];
ELSE:     [eE] [lL] [sS] [eE];
WHILE:    [wW] [hH] [iI] [lL] [eE];
DO:       [dD] [oO];
END:      [eE] [nN] [dD];
PRINT:    [pP] [rR] [iI] [nN] [tT];
INPUT:    [iI] [nN] [pP] [uU] [tT];
LET:      [lL] [eE] [tT];
MOD:      [mM] [oO] [dD];
CONTINUE: [cC] [oO] [nN] [tT] [iI] [nN] [uU] [eE];
EXIT:     [eE] [xX] [iI] [tT];
REPEAT:   [rR] [eE] [pP] [eE] [aA] [tT];
UNTIL:    [uU] [nN] [tT] [iI] [lL];

// Funciones
VAL:   [vV] [aA] [lL];
LEN:   [lL] [eE] [nN];
ISNAN: [iI] [sS] [nN] [aA] [nN];

// Operadores y símbolos
EQUAL: '=';
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
LT: '<';
LTE: '<=';
GT: '>';
GTE: '>=';
EQ: '==';
NEQ: '!=';
LPAREN: '(';
RPAREN: ')';
COMMA: ',';
QUOTE: '"';
AND: [Aa] [Nn] [Dd];
OR: [Oo] [Rr];
NOT: [Nn] [Oo] [Tt];

// Identificadores y literales
IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_]*; // Identificadores
NUMBER: [0-9]+;                    // Números enteros
STRING: '"' .*? '"';                // Cadenas

// Ignorar espacios y saltos de línea
WS: [ \t\r\n]+ -> skip;             

// Ignorar comentarios estilo REM
COMMENT: 'REM' ~[\r\n]* -> skip;    

