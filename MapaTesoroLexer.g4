lexer grammar MapaTesoroLexer;

// Tokens
COMILLAS: '"' -> pushMode(NOMBRES);                     // Detectar comillas
LA_MINA: 'Una mina';                // 'La mina' como palabra clave
PUNTOS: 'puntos';                  // La palabra 'puntos'
TE_DA: 'te da';                    // 'te da' como palabra clave
TE_RESTA: 'te resta';              // 'te resta' como palabra clave
ESTA_ENTERRADO: 'está '('enterrado'|'enterrada'); // 'está enterrado en' como palabra clave
EN: 'en';                         // 'en' como palabra clave
DESDE: 'desde';                   // 'desde' como palabra clave
HASTA: 'hasta';                   // 'hasta' como palabra clave
POR: 'por';                        // 'por' como palabra clave
Y: 'y';                           // 'y' como palabra clave
COMA: ',';                         // Coma para separar coordenadas
NUMERO: [0-9]+;                    // Cualquier número
SALTO: [\n\r];               // Fin de la asignación (salto de línea)
ESPACIO: [ \t\r]+ -> skip;         // Ignorar espacios y saltos de línea
DE_TAMAÑO: 'de tamaño';            // 'de tamaño' como palabra clave
CON: 'con';
TURNOS: 'turnos';

COMENTARIOABRIR: '/*' -> pushMode(COMENTARIO_MULTILINEA_MODE);
COMENTARIOLINEA: '//' -> pushMode(COMENTARIO_LINEA_MODE);
IDENTIFICADOR: [a-zA-Z]+;

mode COMENTARIO_MULTILINEA_MODE;
COMENTARIOCERRAR: '*/' -> popMode;
TEXTOCOMENTARIOML: .+?;

mode COMENTARIO_LINEA_MODE;
FINAL_COMENTARIO_UL: [\r\n] -> popMode;
TEXTOCOMENTARIOUL: .+?;

mode NOMBRES;
NOMBRE: ~["]+; // Esto captura cualquier cosa dentro de las comillas, excluyendo saltos de línea y comillas
COMILLAS_CIERRE : '"' -> popMode; // Salir del modo de nombre de barco