package fr.usmb.m1isc.compilation.tp;

public class Gt extends Node {
  public Gt(Node a, Node b) {
    // TODO
    super("<");
    left = a;
    right = b;
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.compile(left); // mov eax, 0
    prgm.addCode("  push eax\n");
    prgm.compile(right); // mov eax, b
    prgm.addCode("  pop ebx\n"    +
                 "  sub eax,ebx\n");
    /*
    prgm.addCode("  mov eax, 0\n" +
                 "  push eax\n"   +
                 "  mov eax, b\n" +
                 "  pop ebx\n"    +
                 "  sub eax,ebx\n");
    */
  }
}

