package fr.usmb.m1isc.compilation.tp;

public class Mod extends Node {
  public Mod(Node a, Node b) {
    super("%");
    left = a;
    right = b;
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.compile(right);
    prgm.addCode("  push eax\n");
    prgm.compile(left);
    prgm.addCode("  pop ebx\n"    +
                 "  mov ecx,eax\n" +
                 "  div ecx,ebx\n" +
                 "  mul ecx,ebx\n" +
                 "  sub eax,ecx\n");
  }
}

