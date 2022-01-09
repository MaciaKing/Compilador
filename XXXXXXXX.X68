	ORG    $600
f	DS.W 1
y	DS.W 1
p1	DS.W 1

	ORG    $1000

START:
	JMP E_MAIN
E_0:
	MOVE.W #x,f
	JMP hola
E_MAIN:
	MOVE.W #-1,y
	MOVE.W #3,p1
	JMP E_0
hola:
	END START
