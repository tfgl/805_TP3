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
    prgm.addCode("begin_"+label+":")
        // CONDITION
        .compile(left)
        .nextJmp("do_"+label)
        .addCode("  jmp end_"+label)
        .addCode("do_"+label+":")
        // DO
        .compile(right)
        // GOTO CONDITION
        .addCode("  jmp begin_"+label)
        // DONE
        .addCode("end_"+label+":");
  }
}

