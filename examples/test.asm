DATA SEGMENT
DATA ENDS

CODE SEGMENT
  ;; 5 < 0
  mov eax, 7  ;; eax:  5| ebx:  x| stack: [ ][ ][ ][ ][ ][ ]
  push eax    ;; eax:  5| ebx:  x| stack: [5][ ][ ][ ][ ][ ]

  mov eax, 6  ;; eax:  0| ebx:  x| stack: [5][ ][ ][ ][ ][ ]
  pop ebx     ;; eax:  0| ebx:  5| stack: [ ][ ][ ][ ][ ][ ]

  sub ebx,eax ;; eax: -5| ebx:  5| stack: [ ][ ][ ][ ][ ][ ]

  jle  vrai    ;; 
  jmp faux

faux:
  out eax
  mov eax, 0
  out eax
  jmp fin
vrai:
  out eax
  mov eax, 1
  out eax
fin:

CODE ENDS
