DATA SEGMENT
DATA ENDS

CODE SEGMENT
  ;; IF
if_1:
  mov eax, 0
  push eax
  mov eax, 1
  pop ebx
  add eax, ebx
  jg then_if_1
  jmp else_if_1
then_if_1:
  ;; THEN
  mov eax, 1
  out eax
  jmp end_if_1
  ;; ELSE
else_if_1:
  mov eax, 0
  out eax
  end_if_1:
  ;; END
CODE ENDS
