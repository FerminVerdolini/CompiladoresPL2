parser grammar MapaTesoroParser;

options { tokenVocab=MapaTesoroLexer; }

// Regla principal para el mapa
mapa: config_mapa? (instruccion | comentario | SALTO)*;

config_mapa: titulo (DE_TAMAÑO tamaño)? SALTO;

titulo: COMILLAS nombre_mapa COMILLAS_CIERRE;
nombre_mapa: NOMBRE;
tamaño:  ancho POR largo;
ancho: NUMERO;
largo: NUMERO;

instruccion: (barco TE_DA? | mina TE_RESTA?) ( puntuacion PUNTOS | ESTA_ENTERRADO ubicacion) SALTO?;
barco: COMILLAS nombre_barco COMILLAS_CIERRE;
nombre_barco: NOMBRE;
mina: LA_MINA;

// Regla para puntuación
puntuacion: NUMERO;
// Regla para ubicación
ubicacion: pos_x COMA pos_y;
// Posiciones (coordenadas)
pos_x: NUMERO;
pos_y: NUMERO;

comentario: COMENTARIOABRIR (textos|SALTO)* COMENTARIOCERRAR
            | COMENTARIOLINEA textos* FINAL_COMENTARIO_UL;

textos: TEXTOCOMENTARIOML+ | TEXTOCOMENTARIOUL+;