	ORG    $600
x	DS.W 1
y	DS.W 1
z	DS.W 1
t0	DS.W 1

	ORG    $1000

START:
E_MAIN:
	MOVE.W #2, D0
	MOVE.W #10, D1
	CMP.W  D1, D0
	BGT E_0
	MOVE.W #0,t3
	JMP E_1
E_0:
	MOVE.W #-1,t3
E_1:
	 EQUAAAAAL t0,x,E_2
	--------------------------------------------------------------------2
	MOVE.W (3), D0
	MOVE.W #0, D1
	DIVU.W D0, D1
	MOVE.W D1, E_2
E_2:
	END START
