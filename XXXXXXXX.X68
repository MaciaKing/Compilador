	ORG    $600
y	DS.W 1
x	DS.W 1
null	DS.W 1

	ORG    $1000

START:
E_MAIN:
	MOVE.W #0,x
	 ---------- 2,10,E_0
	MOVE.W #2, D0
	MOVE.W #10, D1
	CMP.W  D1, D0
	BGT E_0
	MOVE.W #0,t2
	JMP E_1
E_0:
	MOVE.W #-1,t2
E_1:
	 EQUAAAAAL 2,0,E_2
	MOVE.W (2), D0
	MOVE.W #0, D1
	CMP.W  D1, D0
	BGT E_2
	MOVE.W #10,y
E_2:
	END START
