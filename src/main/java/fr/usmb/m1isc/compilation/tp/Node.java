package fr.usmb.m1isc.compilation.tp;

public class Node {
  public String symbol = null;
  public Node left = null, right = null;

  public Node(String symbol) {
    this.symbol = symbol;
  }

  public boolean isLeaf() {
    return right == null && left == null;
  }

  public String toString() {
    String res = symbol;
    if(left != null)
      res += " " + left.toString();

    if(right != null)
      res += " " + right.toString();

    if( !isLeaf() ) res = "("+res+")";
    return res;
  }

  Node pushRight(Node n) {
    if(right != null) right.pushRight(n);
    else right = n;
    return this;
  }

  Node pushLeft(Node n) {
    if(left != null) left.pushLeft(n);
    else left = n;
    return this;
  }

  Node pushRight(String s) {
    if(right != null) right.pushRight(s);
    else right = new Node(s);
    return this;
  }

  Node pushLeft(String s) {
    if(left != null) left.pushLeft(s);
    else left = new Node(s);
    return this;
  }

  public void parse(Prgm prgm) {
    prgm.compile(left);
    prgm.compile(right);
  }
}
