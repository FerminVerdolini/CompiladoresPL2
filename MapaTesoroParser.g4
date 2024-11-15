parser grammar MapaTesoroParser;

options { tokenVocab=MapaTesoroLexer; }

// Regla principal para el mapa
mapa: config_mapa? (instruccion | comentario | SALTO)*;

config_mapa: titulo (DE_TAMAÑO tamaño)? (CON turnos TURNOS)? SALTO ;

titulo: COMILLAS nombre_mapa COMILLAS_CIERRE;
nombre_mapa: NOMBRE;
tamaño:  ancho POR largo;
ancho: NUMERO;
largo: NUMERO;

turnos: NUMERO;

instruccion: (barco TE_DA? | mina TE_RESTA?) (puntuacion PUNTOS)? Y? (ubicacion)? SALTO?;
barco: COMILLAS nombre_barco COMILLAS_CIERRE;
nombre_barco: NOMBRE;
mina: LA_MINA;

// Regla para puntuación
puntuacion: NUMERO;

// Reglas para ubicación
ubicacion: ESTA_ENTERRADO (ubicacion_simple | ubicacion_compuesta);

ubicacion_simple: (EN pos_x COMA pos_y);
ubicacion_compuesta: (DESDE pos_x COMA pos_y HASTA pos_x COMA pos_y);


// Posiciones (coordenadas)
pos_x: NUMERO;
pos_y: NUMERO;

comentario: COMENTARIOABRIR (textos|SALTO)* COMENTARIOCERRAR
            | COMENTARIOLINEA textos* FINAL_COMENTARIO_UL;

textos: TEXTOCOMENTARIOML+ | TEXTOCOMENTARIOUL+;