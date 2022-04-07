package fr.usmb.m1isc.compilation.tp;

public class While extends Node {
  private static int occurence = 0;

  public While(Node condition, Node body) {
    super("WHILE");
    occurence++;
    this.left = condition;
    this.right = body;
  }

  @Override
  public void parse(Prgm prgm) {
    String label = "while_"+occurence;
    prgm.addCode("  ;; WHILE")
        .addCode("debut_"+label+":")
        // CONDITION
        .compile(left)
        .nextJmp("faux_cond_"+label)
        .addCode("  mov eax,1")
        .addCode("  jmp sortie_cond_"+label)
        .addCode("faux_cond_"+label+":")
        .addCode("  mov eax,0")
        .addCode("sortie_cond_"+label+":")
        .addCode("  jz sortie_"+label)
        // DO
        .addCode("  ;; DO")
        .compile(right)
        // GOTO CONDITION
        .addCode("  jmp debut_"+label)
        // DONE
        .addCode("sortie_"+label+":")
        .addCode("  ;; DONE");
  }
}

