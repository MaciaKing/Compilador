	ORG    $600
x	DS.W 1
s	DS.W 1
z	DS.W 1

	ORG    $1000

START:
E_MAIN:
	MOVE.W #2,s
	MOVE.W #2,z
	MOVE.W (s), D0
	MOVE.W (z), D1
	ADD.W D0, D1
	MOVE.W D1, x
	END START
