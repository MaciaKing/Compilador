	ORG    $600
true DC.B 'ERROR en la linea:2 La variable -m- no ha sido declarada previamente',0
SL	DS.W 1 *Variable auxiliar para los saltos de linea de la consola
	ORG    $1000

START:
	MOVEM.L D0-D1/A1,-(A7)
	MOVE.W (SL),D1
	MOVE.B #11,D0
	TRAP #15
	MOVE.W 16(A7),D1
	LEA true,A1
	MOVE.B #14,D0
	TRAP #15
	MOVEM.L (A7)+,D0-D1/A1
	END START
