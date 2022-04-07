DATA SEGMENT
DATA ENDS

CODE SEGMENT
  ;; IF
if_1:
  mov eax, 0
  push eax
  mov eax, 4
  pop ebx
  sub ebx,eax
  jl then_if_1
  jmp else_if_1
then_if_1:
  ;; THEN
  mov eax, 1
  out eax
  ;; ELSE
else_if_1:
  mov eax, 0
  out eax
  ;; END
CODE ENDS
ODE ENDS
