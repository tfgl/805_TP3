package fr.usmb.m1isc.compilation.tp;

public class Ident extends Node {
  public Ident(String id) {
    super(id);
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.addCode("  mov eax, "+symbol);
  }
}

