lexer grammar MapaTesoroLexer;

// Tokens
COMILLAS: '"' -> pushMode(NOMBRE_BARCO);                     // Detectar comillas
PUNTOS: 'puntos';                  // La palabra 'puntos'
TE_DA: 'te da';                    // 'te da' como palabra clave
ESTA_ENTERRADO: 'está enterrado en'; // 'está enterrado en' como palabra clave
COMA: ',';                         // Coma para separar coordenadas
NUMERO: [0-9]+;                    // Cualquier número
FIN_ASIGNACION: [\n];               // Fin de la asignación (salto de línea)
ESPACIO: [ \t\r]+ -> skip;         // Ignorar espacios y saltos de línea

mode NOMBRE_BARCO;
NOMBRE: ~["]+; // Esto captura cualquier cosa dentro de las comillas, excluyendo saltos de línea y comillas
COMILLAS_CIERRE : '"' -> popMode; // Salir del modo de nombre de barco