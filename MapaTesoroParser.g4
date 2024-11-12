parser grammar MapaTesoroParser;

options { tokenVocab=MapaTesoroLexer; }

// Regla principal para el mapa
mapa: barco+;

barco: nombre (puntuacion | ubicacion);

// Regla para frases de puntuación
nombre: BARCO;

// Regla para frases de puntuación
puntuacion: TE_DA NUMERO PUNTOS;

// Regla para frases de ubicación
ubicacion: ESTA_ENTERRADO NUMERO COMA NUMERO;
