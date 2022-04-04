package fr.usmb.m1isc.compilation.tp;

public class Neg extends Node {
  public Neg(Node n) {
    super("-");
    left = n;
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.compile(left);
    prgm.addCode("  push eax\n"+
                 "  mov eax, 0"+
                 "  pop ebx"+
                 "  sub eax, ebx\n");
  }
}


