package fr.usmb.m1isc.compilation.tp;

import java.util.ArrayList;

class Prgm {
  public String code = "CODE SEGMENT\n";
  public ArrayList<String> data = new ArrayList<String>();

  public Prgm() { }

  public void addData(String d) {
    if( !data.contains(d) ) data.add(d);
  }
  public void addCode(String c) { code += c; }

  public String close() {
    String dataStr = "DATA SEGMENT\n";
    for(String s: data) {
      dataStr += s;
    }
    dataStr += "DATA ENDS";
    code += "CODE ENDS";
    return dataStr + "\n" + code;
  }

  public Prgm compile(Node tree) {
    if(tree == null) return this;
    tree.parse(this);
    compile(tree.left);
    compile(tree.right);
    return this;
  }
}
