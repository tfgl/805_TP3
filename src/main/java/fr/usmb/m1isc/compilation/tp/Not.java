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
    prgm.compile(left)
        .addCode("  jz z_"+label)
        .addCode("  mov eax, 0")
        .addCode("  jmp end_"+label)
        .addCode("z_"+label+":")
        .addCode("  mov eax, 1")
        .addCode("end_"+label+":")
        .jmp = "jg";
  }
}

// 1 -> 0
// 0 -> 1
