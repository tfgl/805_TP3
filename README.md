# INFO805 TP3/4

# Utilisation
compiler: `$ make build`

executer: `$ make run`

ecrire un programme, copier le resultat dans un fichier (ex: tmp.asm)

executer le code assembleur: `java -jar vm-0.9.jar tmp.asm`

# Avancement:
  - [x] exercice 1
  - [x] exercice 2

# Fonctionnalités:
  toutes les fonctionnalités demandées ont été implementées
  - [x] variables boolean (false: 0, true: 1)
  - [x] expression logiques:
    - [x] AND
    - [x] NOT
    - [x] OR
    - [x] <
    - [x] <=
    - [x] ==
    - [x] >=
    - [x] >
  - [x] expression arithmetiques:
    - [x] ADD
    - [x] MUL
    - [x] DIV
    - [x] SUB
    - [x] MOD
    - [x] NEG
  - [x] INPUT / OUTPUT
  - [x] LET
  - [x] WHILE ... DO ...
  - [x] IF ... THEN ... ELSE ...

# Compte Rendu:
  Le but de ce programme est de générer du code assembleur à partir d'un programme écris dans un sous-ensemble du langage λ-ada.
  Pour y parvenir, nous utilisons jflex comme lexer, et cup comme parser pour générer un arbre syntaxique.

  L'arbre syntaxique est implementé par la classe Node. Plusieurs sous classes en herites pour representer des morceaux de code (ex: class Sequence, If, Sub, Add etc)
  Cette classe n'est jamais instancié directement, comme elle ne represente aucune instruction du langage λ-ada.
  Chaque classe fille de Node implemente une methode `public void parse(Prgm prgm)` qui génère le code assembleur correspondant.

  Le parametre prgm represente le programme, cette classe contient essentiellement deux attributs, code et data, qui represente respectivement les segments code et data.
  Cette classe contient également une methode `Prgm compile(Node tree)` qui ne appel la methode parse de tree, puis retourne l'objet appelant.
  Elle contient également un attributs jmp et une methode `Prgm nextJmp(String lbl)` qui permet de gerer plus simplement les sauts conditionels.

  Apres avoir parser un code en λ-ada, le programme va parcourir l'arbre syntaxique généré. l'arbre est principalement binaire comme la classe Node possede deux successeurs.
  La classe est la seule exception, comme une instruction if est toujours suivit des mot clef then et else, elle possede 3 attributs (une condion, un bloc en cas de success, et un en cas d'echec)
  
  Les valeurs booleans True et False peuvent etre affectées à des variables et traitées par des operations logiques. Elles sont traduites en assembleur par 1 et 0.


# Résultats:
## exercice 1:
### programme:
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
### programme:
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
  mov eax,ebx
  sub eax, 0
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

## guess the number

### programme
```
let target = input;
let guess = input;
let try = 1;

while ( not ( target = guess ) )
do ( let try = try + 1; let guess = input );

output try.
```

### arbre syntaxique
```
(; (LET target INPUT) (; (LET guess INPUT) (; (LET try 0) (; (WHILE (Not (= target guess)) (; (LET try (+ try 1)) (LET guess INPUT))) (OUTPUT try)))))
```
### assembleur

```asm
DATA SEGMENT
  target DD
  guess DD
  try DD
DATA ENDS

CODE SEGMENT
  in eax
  mov target, eax
  in eax
  mov guess, eax
  mov eax, 1
  mov try, eax
begin_while_1:
  mov eax, target
  push eax
  mov eax, guess
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
  jg do_while_1
  jmp end_while_1
do_while_1:
  mov eax, try
  push eax
  mov eax, 1
  pop ebx
  add eax,ebx
  mov try, eax
  in eax
  mov guess, eax
  jmp begin_while_1
end_while_1:
  mov eax, try
  out eax
CODE ENDS
```

## test du if

### programme
```
if ( 1 and (not ( 1 = 0) )) then (output 1) else (output 0).
```

### arbre syntaxique
```
(IF (AND 1 (Not (= 1 0))) (OUTPUT 1) (OUTPUT 0))
```

### assembleur
```asm
DATA SEGMENT
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
```
