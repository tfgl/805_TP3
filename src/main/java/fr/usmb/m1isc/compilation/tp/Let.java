package fr.usmb.m1isc.compilation.tp;

public class Let extends Node {
  public Let(String symbol, Node value) {
    super("LET");
    pushLeft(symbol);
    pushRight(value);
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.addData("  "+left.symbol + " DD\n");
    prgm.compile(right);
    prgm.addCode("  mov "+left.symbol+", eax\n");
  }
}

