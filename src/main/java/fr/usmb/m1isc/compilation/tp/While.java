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
    prgm.addCode("debut_"+label+":\n");
    prgm.compile(left);
    prgm.addCode(" faux_cond_"+label+"\n"   + // hack pas bo
                 "  mov eax,1\n"            +
                 "  jmp sortie_cond_"+label+"\n" +
                 "faux_cond_"+label+":\n"        +
                 "  mov eax,0\n"            +
                 "sortie_cond_"+label+":\n"      +
                 "  jz sortie_"+label+"\n");
    prgm.compile(right);
    prgm.addCode("  jmp debut_"+label+"\n" +
                 "sortie_"+label+":\n");
  }
}

