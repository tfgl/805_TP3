package fr.usmb.m1isc.compilation.tp;

public class Gte extends Node {
  public Gte(Node a, Node b) {
    super("<=");
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
    prgm.addCode("  jl"); //hack pas bo
  }
}

