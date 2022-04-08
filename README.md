# INFO805 TP2

# Avancement:
  - [x] exercice 1
  - [x] exercice 2

# TODO:
  - trouver la doc asm de la vm
  - implementer les noeuds restants:
    - EQU
    - AND
    - OR
    - NOT
  - faire le rendu

# Résultats:
## exercice 1:
### programe:
```
let prixHt = 200;
let prixTtc =  prixHt * 119 / 100 .
```

### arbre syntaxique:
```
(; (LET prixHt 200) (LET prixTtc (/ (* prixHt 119) 100)))
```

### assembleur:
```asm
DATA SEGMENT
  prixHt DD
  prixTtc DD
DATA ENDS

CODE SEGMENT
  mov eax, 200
  mov prixHt, eax
  mov eax, prixHt
  push eax
  mov eax, 119
  pop ebx
  mul eax,ebx
  push eax
  mov eax, 100
  pop ebx
  div ebx, eax
  mov eax, ebx
  mov prixTtc, eax
CODE ENDS
```

## exercice 2:
### programe:
```
let a = input;
let b = input;
while (0 < b)
do (let aux=(a mod b); let a=b; let b=aux );
output a
.
```

### arbre syntaxique:
```
(; (LET a INPUT) (; (LET b INPUT) (; (WHILE (< 0 b) (; (LET aux (% a b)) (; (LET a b) (LET b aux)))) (OUTPUT a))))
```

### assembleur:
```asm
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
```
