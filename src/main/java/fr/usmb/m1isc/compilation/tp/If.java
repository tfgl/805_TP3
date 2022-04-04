package fr.usmb.m1isc.compilation.tp;

public class If extends Node {
  private Node _condition;
  private Node _si;
  private Node _sinon;

  public If(Node condition, Node si, Node sinon) {
    super("IF");
    _condition = condition;
    _si = new Node("THEN");
    _si.left = si;
    _sinon = new Node("ELSE");
    _sinon.left = sinon;
    _si.right = _sinon;

    pushLeft(_condition);
    pushRight(_si);
  }

  @Override
  public void parse(Prgm prgm) {
  }
}
