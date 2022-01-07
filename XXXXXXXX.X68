	ORG    $600
y	DS.W 1
x	DS.W 1
t0	DS.W 1
t1	DS.W 1
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
	MOVE.W #null,2
	JMP E_1
E_0:
	MOVE.W #null,2
E_1:
	MOVE.W #10,y
E_2:
	 ---------- 2,10,E_3
	MOVE.W #2, D0
	MOVE.W #10, D1
	CMP.W  D1, D0
	BGT E_3
	MOVE.W #null,3
	JMP E_4
E_3:
	MOVE.W #null,3
E_4:
	MOVE.W #10,y
E_5:
	 ---------- 2,10,E_6
	MOVE.W #2, D0
	MOVE.W #10, D1
	CMP.W  D1, D0
	BGT E_6
	MOVE.W #null,4
	JMP E_7
E_6:
	MOVE.W #null,4
E_7:
	MOVE.W #10,y
E_8:
	END START
