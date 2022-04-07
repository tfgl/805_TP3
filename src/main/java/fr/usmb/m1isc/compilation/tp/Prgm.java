package fr.usmb.m1isc.compilation.tp;

import java.util.ArrayList;

class Prgm {
  public String code = "CODE SEGMENT\n";
  public ArrayList<String> data = new ArrayList<String>();
  public String jmp;

  public Prgm() { }

  public Prgm addData(String d) {
    if( !data.contains(d) ) data.add(d);
    return this;
  }
  public Prgm addCode(String c) { code += c + "\n"; return this; }
  public Prgm nextJmp(String lbl) { addCode("  "+jmp+" "+lbl); return this; }

  public String close() {
    String dataStr = "DATA SEGMENT\n";

    for(String s: data)
      dataStr += s + "\n";

    dataStr += "DATA ENDS\n\n";
    code += "CODE ENDS";
    return dataStr + code;
  }

  public Prgm compile(Node tree) {
    if(tree != null)
      tree.parse(this);
    return this;
  }
}
