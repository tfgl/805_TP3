package fr.usmb.m1isc.compilation.tp;

public class Output extends Node {
  public Output(Node n) {
    super("OUTPUT");
    left = n;
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.compile(left)
        .addCode("  out eax");
  }
}

