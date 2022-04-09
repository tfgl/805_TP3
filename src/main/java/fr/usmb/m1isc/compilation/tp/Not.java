package fr.usmb.m1isc.compilation.tp;

public class Not extends Node {
  private static int occurence = 0;
  public Not(Node e) {
    super("Not");
    occurence++;
    left = e;
  }

  @Override
  public void parse(Prgm prgm) {
    String label= "Not_"+occurence;

    prgm.compile(left);
    if( prgm.jmp == null ) {
      prgm.addCode("  sub eax, 0")
          .jmp = "jg";
    }
    prgm.nextJmp(label+"_z")
        .addCode("  mov eax, 1")
        .addCode("  jmp "+label+"_end")
        .addCode(label+"_z:")
        .addCode("  mov eax, 0")
        .addCode(label+"_end:")
        .addCode("  sub eax, 0")
        .jmp = "jg";
  }
}

// 1 -> 0
// 0 -> 1
