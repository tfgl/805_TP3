package fr.usmb.m1isc.compilation.tp;

public class If extends Node {
  private Node _condition;
  private Node _si;
  private Node _sinon;
  private static int occurence = 0;

  public If(Node condition, Node si, Node sinon) {
    super("IF");
    occurence++;
    _condition = condition;
    _si = new Node("THEN");
    _sinon = new Node("ELSE");

    pushLeft(_condition);
    pushRight(_si);
    _si.pushLeft(si);
    _si.pushRight(_sinon);
    _sinon.pushLeft(sinon);
  }

  @Override
  public void parse(Prgm prgm) {
    String label = "if_"+occurence;
    // CONDIDITION
    prgm.compile(left);
    prgm.addCode(" faux_cond_"+label+"\n"        +
                 "  mov eax, 1\n"                +
                 "  jmp sortie_cond_"+label+"\n" +
                 "faux_cond_"+label+":\n"        +
                 "  mov eax, 0\n"                +
                 "sortie_cond_"+label+":\n"      +
                  "  jz else_"+label+"\n");
    // THEN
    prgm.compile(right);
    // ELSE
    prgm.addCode("else_"+label+":\n");

  }
}

