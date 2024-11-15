LET x = 0
LET limit = 10

WHILE x < limit AND x MOD 2 == 0
    PRINT "x es par y menor que el límite"
    LET x = x + 2
END

PRINT "Fin del bucle"
