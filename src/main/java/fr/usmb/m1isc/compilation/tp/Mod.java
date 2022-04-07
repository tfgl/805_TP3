package fr.usmb.m1isc.compilation.tp;

public class Mod extends Node {
  public Mod(Node a, Node b) {
    super("%");
    left = a;
    right = b;
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.compile(right)
        .addCode("  push eax")
        .compile(left)
        .addCode("  pop ebx")
        .addCode("  mov ecx,eax")
        .addCode("  div ecx,ebx")
        .addCode("  mul ecx,ebx")
        .addCode("  sub eax,ecx");
  }
}

