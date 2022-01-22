	ORG    $600
x	DS.L 1
y	DS.L 1
t0	DS.L 1
SL	DS.W 1 *Variable auxiliar para los saltos de linea de la consola

	ORG    $1000

START:
	MOVE.W #0,SL
E_MAIN:
	MOVE.L #2,x
	MOVE.L #11,y
E_0:
	 ;IFGT y,10,E_1
	MOVE.L (y),D0
	MOVE.L #10,D1
	CMP.L  D1, D0
	BGT E_1
	MOVE.L #0,t0
	JMP E_2
E_1:
	MOVE.L #-1,t0
E_2:
	 ;EQUAAAAAL----TEMPORAL t0, 0,E_3
	MOVE.L (t0), D0
	MOVE.L #0, D1
	CMP.L  D0,D1
	BEQ E_3
	MOVE.L (x),D0
	MOVE.L #10,D1
	SUB.L D1, D0
	MOVE.L D0, x
	MOVE.L (y),D0
	MOVE.L #1,D1
	SUB.L D1, D0
	MOVE.L D0, y
	JMP E_0
E_3:
	MOVE.L (x),-(A7)
	JSR imprimeix
	MOVE.L (A7)+,(x)
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
