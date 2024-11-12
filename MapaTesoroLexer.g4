lexer grammar MapaTesoroLexer;

// Tokens
BARCO: '"' ~["]+ '"';           // Cadenas entre comillas, para nombres de barcos
PUNTOS: 'puntos';
TE_DA: 'te da';
ESTA_ENTERRADO: 'está enterrado en';
COMA: ',';                      // Coma para separar coordenadas
NUMERO: [0-9]+;                 // Cualquier número entero
ESPACIO: [ \t\r\n]+ -> skip;    // Ignorar espacios y saltos de línea
