package fr.usmb.m1isc.compilation.tp;

public class Div extends Node {
  public Div(Node a, Node b) {
    super("/");
    left = a;
    right = b;
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.compile(left);
    prgm.addCode("  push eax\n");
    prgm.compile(right);
    prgm.addCode("  pop ebx\n"     +
                 "  div ebx, eax\n" +
                 "  mov eax, ebx\n");
  }
}

