package fr.usmb.m1isc.compilation.tp;

public class Gt extends Node {
  public Gt(Node a, Node b) {
    super("<");
    left = a;
    right = b;
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.compile(left);
    prgm.addCode("  push eax\n");
    prgm.compile(right);
    prgm.addCode("  pop ebx\n"    +
                 "  sub eax,ebx\n");
    prgm.addCode("  jle"); //hack pas bo
  }
}

