package fr.usmb.m1isc.compilation.tp;

public class Neg extends Node {
  public Neg(Node n) {
    super("-");
    left = n;
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.compile(left);
    prgm.addCode("  mul eax, -1\n");
  }
}

