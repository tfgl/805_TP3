;; let a = 1; let b = 0; let c = ( a and (not b) ); output c.
;; (; (LET a 1) (; (LET b 0) (; (LET c (AND a (Not b))) (OUTPUT c))))
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
begin_while_1:
  mov eax, 0
  push eax
  mov eax, b
  pop ebx
  sub ebx,eax
  jl do_while_1
  jmp end_while_1
do_while_1:
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
  mov eax, a
  out eax
CODE ENDS

