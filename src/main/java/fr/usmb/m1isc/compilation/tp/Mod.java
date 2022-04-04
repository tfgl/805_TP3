package fr.usmb.m1isc.compilation.tp;

public class Mod extends Node {
  public Mod(Node a, Node b) {
    // TODO
    super("<");
    left = a;
    right = b;
  }

  @Override
  public void parse(Prgm prgm) {
    prgm.compile(right); // mov eax, b
    prgm.addCode("  push eax\n");
    prgm.compile(left); // mov eax, a
    prgm.addCode("  pop ebx\n"    +
                 "  mov ecx,eax\n" +
                 "  div ecx,ebx\n" +
                 "  mul ecx,ebx\n" +
                 "  sub eax,ecx\n" +
                 "  mov aux, eax\n");

    /*
      mov eax, b
      push eax
      mov eax, a
      pop ebx

      mov ecx,eax
      div ecx,ebx
      mul ecx,ebx
      sub eax,ecx
      mov aux, eax
    */
  }
}


