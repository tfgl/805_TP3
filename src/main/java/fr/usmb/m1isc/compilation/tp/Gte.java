package fr.usmb.m1isc.compilation.tp;

public class Gte extends Node {
  public Gte(Node a, Node b) {
    super("<=");
    left = a;
    right = b;
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.compile(left)
        .addCode("  push eax")
        .compile(right)
        .addCode("  pop ebx")
        .addCode("  sub eax,ebx")
        .jmp = "jl";
  }
}

