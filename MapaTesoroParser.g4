parser grammar MapaTesoroParser;

options { tokenVocab=MapaTesoroLexer; }

// Regla principal para el mapa
mapa: (primer_linea)? instruccion+;

primer_linea: titulo (DE_TAMAÑO tamaño)? SALTO;

titulo: COMILLAS nombre_mapa COMILLAS_CIERRE;

tamaño:  ancho COMA largo;

ancho: NUMERO;
largo: NUMERO;

// Instrucción que puede ser un barco con puntuación o ubicación
instruccion: (barco TE_DA? | mina TE_RESTA?) ( puntuacion PUNTOS | ESTA_ENTERRADO ubicacion) SALTO;

// Regla para el nombre del barco entre comillas
barco: COMILLAS nombre_barco COMILLAS_CIERRE;

mina: LA_MINA;

// Regla para puntuación
puntuacion: NUMERO;

// Regla para ubicación
ubicacion: pos_x COMA pos_y;

nombre_barco: NOMBRE;
nombre_mapa: NOMBRE;


// Posiciones (coordenadas)
pos_x: NUMERO;
pos_y: NUMERO;