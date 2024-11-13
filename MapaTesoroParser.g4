parser grammar MapaTesoroParser;

options { tokenVocab=MapaTesoroLexer; }

// Regla principal para el mapa
mapa: instruccion+;

// Instrucción que puede ser un barco con puntuación o ubicación
instruccion: barco ((TE_DA puntuacion PUNTOS) | (ESTA_ENTERRADO ubicacion)) FIN_ASIGNACION;

// Regla para el nombre del barco entre comillas
barco: COMILLAS nombre_barco COMILLAS_CIERRE; 
// Regla para puntuación
puntuacion: NUMERO;

// Regla para ubicación
ubicacion:  pos_x COMA pos_y;

nombre_barco: NOMBRE;

// Posiciones (coordenadas)
pos_x: NUMERO;
pos_y: NUMERO;