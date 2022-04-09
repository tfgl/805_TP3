package fr.usmb.m1isc.compilation.tp;

public class Sub extends Node {
  public Sub(Node a, Node b) {
    super("-");
    left = a;
    right = b;
  }

  @Override
  public void parse(Prgm prgm) {  // |  eax  |  ebx  | stack  |   ZF   |   LF   |
                                  // +-------+-------+--------+--------+--------+
    prgm.compile(left)            // |   a   |   ?   | [ ][ ] |   ?    |   ?    |
        .addCode("  push eax")    // |   a   |   ?   | [a][ ] |   ?    |   ?    |
        .compile(right)           // |   b   |   ?   | [a][ ] |   ?    |   ?    |
        .addCode("  pop ebx")     // |   b   |   a   | [ ][ ] |   ?    |   ?    |
        .addCode("  sub ebx,eax") // |   b   |  a-b  | [ ][ ] | a-b==0 | a-b<0  | remove eax from ebx -> remove b from a
        .addCode("  mov eax,ebx") // |  a-b  |  a-b  | [ ][ ] |   ?    |   ?    | store the result in eax
        .addCode("  sub eax, 0"); // |  a-b  |  a-b  | [ ][ ] | a-b==0 | a-b<0  | just in case the flags have been change by the mov instruction (TODO: find the doc)
  }
}

