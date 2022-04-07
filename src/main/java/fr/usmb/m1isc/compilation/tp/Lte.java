package fr.usmb.m1isc.compilation.tp;

public class Lte extends Sub {
  public Lte(Node a, Node b) {
    super(a, b);
    symbol = "<=";
  }

  @Override
  public void parse(Prgm prgm) {
    super.parse(prgm);
    prgm.jmp = "jle";
  }
}

