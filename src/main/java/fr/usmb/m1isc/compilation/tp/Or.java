package fr.usmb.m1isc.compilation.tp;

public class Or extends Node {
  public Or(Node a, Node b) {
    super("OR");
    left = a;
    right = b;
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.compile(left)
        .addCode("  push eax")
        .compile(right)
        .addCode("  pop ebx")
        .addCode("  add eax, ebx")
        .addCode("  sub eax, 0")
        .jmp = "jg";
  }
}

// 0 0 -> 0
// 0 1 -> 1
// 1 0 -> 1
// 1 1 -> 2
