DATA SEGMENT
DATA ENDS

CODE SEGMENT
  ;; IF
if_1:
  mov eax, 5
  push eax
  mov eax, 0
  pop ebx
  sub eax,ebx
  jle faux_cond_if_1
  mov eax, 1
  jmp sortie_cond_if_1
faux_cond_if_1:
  mov eax, 0
sortie_cond_if_1:
  jz else_if_1
  ;; THEN
  mov eax, 0
  out eax
  mov eax, 5
  out eax
  ;; ELSE
else_if_1:
  mov eax, 5
  out eax
  ;; END
CODE ENDS
