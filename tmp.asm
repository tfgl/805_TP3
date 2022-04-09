DATA SEGMENT
  target DD
  guess DD
  try DD
DATA ENDS

CODE SEGMENT
if_1:
  mov eax, 1
  push eax
  mov eax, 1
  push eax
  mov eax, 0
  pop ebx
  sub ebx,eax
  mov eax,ebx
  sub eax, 0
  jz Not_1_z
  mov eax, 1
  jmp Not_1_end
Not_1_z:
  mov eax, 0
Not_1_end:
  sub eax, 0
  pop ebx
  mul eax, ebx
  sub eax, 0
  jg then_if_1
  jmp else_if_1
then_if_1:
  mov eax, 1
  out eax
  jmp end_if_1
else_if_1:
  mov eax, 0
  out eax
end_if_1:
CODE ENDS
