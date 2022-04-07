package fr.usmb.m1isc.compilation.tp;

public class Not extends Node {
  public Not(Node e) {
    super("Not");
    left = e;
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.addCode("  NOT eax");
  }
}

