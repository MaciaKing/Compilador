	ORG    $600
t0	DS.W 1
t1	DS.W 1
t2	DS.W 1
t3	DS.W 1
SL	DS.W 1 *Variable auxiliar para los saltos de linea de la consola

	ORG    $1000

START:
	MOVE.W #0,SL
E_MAIN:
	MOVE.W #2, D0
	MOVE.W #10, D1
	CMP.W  D1, D0
	BGT E_0
	MOVE.W #0,t0
	JMP E_1
E_0:
	MOVE.W #-1,t0
E_1:
	 EQUAAAAAL---- t0 0,E_2
	--------------------------------------------------------------------2
	MOVE.W (0), D0
	MOVE.W #0, D1
	DIVU.W D0, D1
	MOVE.W D1, E_2
E_2:
	MOVE.W #2, D0
	MOVE.W #10, D1
	CMP.W  D1, D0
	BGT E_3
	MOVE.W #0,t1
	JMP E_4
E_3:
	MOVE.W #-1,t1
E_4:
	 EQUAAAAAL---- t1 0,E_5
	--------------------------------------------------------------------2
	MOVE.W (1), D0
	MOVE.W #0, D1
	DIVU.W D0, D1
	MOVE.W D1, E_5
E_5:
	MOVE.W #2, D0
	MOVE.W #10, D1
	CMP.W  D1, D0
	BGT E_6
	MOVE.W #0,t2
	JMP E_7
E_6:
	MOVE.W #-1,t2
E_7:
	 EQUAAAAAL---- t2 0,E_8
	--------------------------------------------------------------------2
	MOVE.W (2), D0
	MOVE.W #0, D1
	DIVU.W D0, D1
	MOVE.W D1, E_8
E_8:
	MOVE.W #2, D0
	MOVE.W #10, D1
	CMP.W  D1, D0
	BGT E_9
	MOVE.W #0,t3
	JMP E_10
E_9:
	MOVE.W #-1,t3
E_10:
	 EQUAAAAAL---- t3 0,E_11
	--------------------------------------------------------------------2
	MOVE.W (3), D0
	MOVE.W #0, D1
	DIVU.W D0, D1
	MOVE.W D1, E_11
E_11:
	JMP FIN
imprimeix
	MOVEM.L D0-D1,-(A7)
	MOVE.W (SL),D1
	MOVE.B #11,D0
	TRAP #15
	MOVE.W 12(A7),D1
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
