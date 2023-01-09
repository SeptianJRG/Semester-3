ORG	000H

	MOV	A,#10000000B
NEXT:
	MOV	P2,A
	CALL	DELAY
	RR	A
	JMP	NEXT

;==============================
; DELAY 0.1S
;==============================
DELAY:
	MOV	R6,#250
DL1:
	MOV	R7,#249
	DJNZ	R7,$
	DJNZ	R6,DL1
	RET

	END