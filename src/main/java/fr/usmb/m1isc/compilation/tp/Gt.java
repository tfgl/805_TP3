package fr.usmb.m1isc.compilation.tp;

public class Gt extends Node {
  public Gt() {
    super("<");
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.addCode("  mov eax, 0\n" +
                 "  push eax\n"   +
                 "  mov eax, b\n" +
                 "  pop ebx\n"    +
                 "  sub eax,ebx\n");
  }
}

