package xp.io.refactor;

public class Length {
  private final double value;
  private final String unit;

  public Length(double val, String uinnt) {
    this.value = val;
    this.unit = uinnt;
  }

  public Length as(String u) {
    Length len = this;
    if (unit.equals("f") && u.equals("inch")) len = new Length(value * 12, u);
    if (unit.equals("inch") && u.equals("f")) len = new Length(value / 12, u);

      if (unit.equals("yard")) {
          if (u.equals("inch")) {
              len = new Length(value * 36, u);
          } else if (u.equals("f")){
              len = new Length(value * 3, u);
          }
      }
      if (u.equals("yard")) {
          if (unit.equals("f")) {
              len = new Length(value / 3, u);
          } else if (unit.equals("inch")) {
              len = new Length(value / 36, u);
          }
      }

    return len;
  }

  public double getVal() {
    return this.value;
  }

  public String getUinnt() {
    return this.unit;
  }
}
