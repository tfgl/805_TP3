package fr.usmb.m1isc.compilation.tp;


public class Input extends Node {
  public Input() {
    super("INPUT");
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.addCode("  in eax\n");
  }
}


