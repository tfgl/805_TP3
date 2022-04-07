package fr.usmb.m1isc.compilation.tp;

public class Gt extends Sub {
  public Gt(Node a, Node b) {
    super(a, b);
    symbol = ">";
  }

  @Override
  public void parse(Prgm prgm) {
    super.parse(prgm);
    prgm.jmp = "jg";
  }
}

