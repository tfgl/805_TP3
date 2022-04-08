package fr.usmb.m1isc.compilation.tp;

public class If extends Node {
  private Node _condition;
  private static int occurence = 0;

  public If(Node condition, Node si, Node sinon) {
    super("IF");
    occurence++;
    _condition = condition;
    left = si;
    right = sinon;
  }

  @Override
  public void parse(Prgm prgm) {
    String label = "if_"+occurence;
    prgm.addCode(label+":");
    // CONDIDITION
    prgm.compile(_condition)
        .nextJmp("then_"+label)
        .addCode("  jmp else_"+label)
        .addCode("then_"+label+":")
    // THEN
        .compile(left)
        .addCode("  jmp end_"+label)
    // ELSE
        .addCode("else_"+label+":")
        .compile(right)
        .addCode("  end_"+label+":");
  }

  @Override
  public String toString() {
    String res = symbol;

    res += " " + _condition.toString();
    res += " " + left.toString();
    res += " " + right.toString();

    return "("+res+")";
  }
}

