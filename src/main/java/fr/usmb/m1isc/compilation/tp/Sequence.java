package fr.usmb.m1isc.compilation.tp;

public class Sequence extends Node {
  public Sequence(Node l, Node r) {
    super(";");
    left = l;
    right = r;
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.compile(left);
    prgm.compile(right);
  }
}

