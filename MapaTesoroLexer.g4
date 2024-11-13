lexer grammar MapaTesoroLexer;

// Tokens
COMILLAS: '"' -> pushMode(NOMBRES);                     // Detectar comillas
LA_MINA: 'Una mina';                // 'La mina' como palabra clave
PUNTOS: 'puntos';                  // La palabra 'puntos'
TE_DA: 'te da';                    // 'te da' como palabra clave
TE_RESTA: 'te resta';              // 'te resta' como palabra clave
ESTA_ENTERRADO: 'está '('enterrado'|'enterrada') ' en'; // 'está enterrado en' como palabra clave
//ESTA_ENTERRADA: 'está enterrada en'; // 'está enterrado en' como palabra clave
COMA: ',';                         // Coma para separar coordenadas
NUMERO: [0-9]+;                    // Cualquier número
SALTO: [\n];               // Fin de la asignación (salto de línea)
ESPACIO: [ \t\r]+ -> skip;         // Ignorar espacios y saltos de línea
DE_TAMAÑO: 'de tamaño';            // 'de tamaño' como palabra clave

mode NOMBRES;
NOMBRE: ~["]+; // Esto captura cualquier cosa dentro de las comillas, excluyendo saltos de línea y comillas
COMILLAS_CIERRE : '"' -> popMode; // Salir del modo de nombre de barco