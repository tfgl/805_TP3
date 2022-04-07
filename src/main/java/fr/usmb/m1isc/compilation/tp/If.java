package fr.usmb.m1isc.compilation.tp;

public class If extends Node {
  private Node _condition;
  private Node _then;
  private Node _else;
  private static int occurence = 0;

  public If(Node condition, Node si, Node sinon) {
    super("IF");
    occurence++;
    _condition = condition;
    _then = new Node("THEN");
    _else = new Node("ELSE");

    pushLeft(_condition);
    pushRight(_then);
    _then.pushLeft(si);
    _then.pushRight(_else);
    _else.pushLeft(sinon);
  }

  @Override
  public void parse(Prgm prgm) {
    String label = "if_"+occurence;
    prgm.addCode("  ;; IF")
        .addCode(label+":");
    // CONDIDITION
    prgm.compile(_condition)
        .nextJmp("faux_cond_"+label)
        .addCode("  mov eax, 1")
        .addCode("  jmp sortie_cond_"+label)
        .addCode("faux_cond_"+label+":")
        .addCode("  mov eax, 0")
        .addCode("sortie_cond_"+label+":")
        .addCode("  jz else_"+label);
    // THEN
    prgm.addCode("  ;; THEN")
        .compile(_then);
    // ELSE
    prgm.addCode("  ;; ELSE")
        .addCode("else_"+label+":")
        .compile(_else)
        .addCode("  ;; END");
  }
}

