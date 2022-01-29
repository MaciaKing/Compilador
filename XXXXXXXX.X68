	ORG    $600
y	DS.L 1
x	DS.L 1
z	DS.L 1
m	DS.L 1
t0	DS.L 1
t1	DS.L 1
t2	DS.L 1
SL	DS.W 1 *Variable auxiliar para los saltos de linea de la consola

	ORG    $1000

START:
	MOVE.W #0,SL
E_MAIN:
	MOVE.L #0,y
	MOVE.L #-1,x
	MOVE.L #-1,z
	MOVE.L #-1,m
	MOVE.L #-1,t0
	;anddddddddddddddd
	MOVE.L #-1, D0
	MOVE.L (t0), D1
	AND.L D0,D1
	MOVE.L D1,t1
	;anddddddddddddddd
	MOVE.L #-1, D0
	MOVE.L (t1), D1
	AND.L D0,D1
	MOVE.L D1,t2
	 ;EQUAAAAAL----TEMPORAL t2, 0,E_2
	MOVE.L (t2), D0
	MOVE.L #0, D1
	CMP.L  D0,D1
	BEQ E_2
	MOVE.L #10,y
E_2:
	MOVE.L (y),-(A7)
	JSR imprimeix
	MOVE.L (A7)+,(y)
	ADD.L #1,SL
	JMP FIN
imprimeix
	MOVEM.L D0-D1,-(A7)
	MOVE.L (SL),D1
	MOVE.B #11,D0
	TRAP #15
	MOVE.L 12(A7),D1
	MOVE.B #3,D0
	TRAP #15
	MOVEM.L (A7)+,D0-D1
	RTS
imprimeixBooleano
	MOVEM.L D0-D1/A1,-(A7)
	MOVE.W (SL),D1
	MOVE.B #11,D0
	TRAP #15
	MOVE.W 16(A7),D1
	TST.W D1
	BEQ fals
	LEA true,A1
	JMP finb
fals
	LEA false,A1
finb
	MOVE.B #14,D0
	TRAP #15
	MOVEM.L (A7)+,D0-D1/A1
	RTS
true DC.B 'cert',0
false DC.B 'fals',0
	DS.W 0
escriure
	MOVEM.L D0-D1/A1,-(A7)
	MOVE.W (SL),D1
	MOVE.B #11,D0
	TRAP #15
	LEA write,A1
	MOVE.B #14,D0
	TRAP #15
	MOVE.W  #(13)<<8,D1
	OR.W (SL),D1
	MOVE.B #11,D0
	TRAP #15
	MOVE.B #4,D0
	TRAP #15
	MOVE.W D1,D2
	MOVEM.L (A7)+,D0-D1/A1
	RTS
write DC.B 'escriu aqui: ',0
	DS.W 0
FIN
	END START
