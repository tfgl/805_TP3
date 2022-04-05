package fr.usmb.m1isc.compilation.tp;

public class Entier extends Node {
  public Entier(String id) {
    super(id);
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.addCode("  mov eax, "+symbol+"\n");
  }
}

