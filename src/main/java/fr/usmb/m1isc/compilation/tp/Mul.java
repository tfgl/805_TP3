package fr.usmb.m1isc.compilation.tp;

public class Mul extends Node {
  public Mul(Node a, Node b) {
    super("*");
    left = a;
    right = b;
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.compile(left)
        .addCode("  push eax")
        .compile(right)
        .addCode("  pop ebx")
        .addCode("  mul eax,ebx");
  }
}

