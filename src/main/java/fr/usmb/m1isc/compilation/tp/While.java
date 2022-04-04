package fr.usmb.m1isc.compilation.tp;

public class While extends Node {
  private static int occurence = 0;
  private Node condition;
  private Node body;

  public While(Node condition, Node body) {
    super("WHILE");
    occurence++;
    this.left = condition;
    this.right = body;
    this.condition = this.left;
    this.body = this.right;
  }

  @Override
  public void parse(Prgm prgm) {
    String label = "while_"+occurence;
    prgm.addCode("debut_"+label+":");
    prgm.compile(condition);
    prgm.addCode("  jle faux_"+label+"\n"   +
                 "  mov eax,1\n"            +
                 "  jmp sortie_"+label+"\n" +
                 "faux_"+label+":\n"        +
                 "  mov eax,0\n"            +
                 "sortie_"+label+":\n"      +
                 "jz sortie_"+label+"\n");
    prgm.compile(body);
  }
}

