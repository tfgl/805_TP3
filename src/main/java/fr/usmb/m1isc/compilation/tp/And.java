package fr.usmb.m1isc.compilation.tp;

public class And extends Node {
  public And(Node a, Node b) {
    super("AND");
    left = a;
    right = b;
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.compile(left)
        .addCode("  push eax")
        .compile(right)
        .addCode("  pop ebx")
        .addCode("  mul eax, ebx")
        .addCode("  sub eax, 0")
        .jmp = "jg";
  }
}

// 0 0 -> 0
// 0 1 -> 0
// 1 0 -> 0
// 1 1 -> 1
