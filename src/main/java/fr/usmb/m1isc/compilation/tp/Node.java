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
    return pushRight(new Node(s));
  }

  Node pushLeft(String s) {
    return pushLeft(new Node(s));
  }

  public void parse(Prgm prgm) {
    prgm.compile(left);
    prgm.compile(right);
  }
}

