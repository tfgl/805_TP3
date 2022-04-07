DATA SEGMENT
  a DD
  b DD
  aux DD
DATA ENDS

CODE SEGMENT
  in eax
  mov a, eax
  in eax
  mov b, eax
  ;; WHILE
begin_while_1:
  mov eax, 0
  push eax
  mov eax, b
  pop ebx
  sub ebx,eax
  jl do_while_1
  jmp end_while_1
do_while_1:
  ;; DO
  mov eax, b
  push eax
  mov eax, a
  pop ebx
  mov ecx,eax
  div ecx,ebx
  mul ecx,ebx
  sub eax,ecx
  mov aux, eax
  mov eax, b
  mov a, eax
  mov eax, aux
  mov b, eax
  jmp begin_while_1
end_while_1:
  ;; DONE
  mov eax, a
  out eax
CODE ENDS
