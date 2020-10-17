package xp.io.refactor;

public class Length {
  private final double value;
  private final String u;

  public Length(double val, String u) {
    this.value = val;
    this.u = u;
  }

  public Length as(String u) {
    Length len = this;
    if (this.u.equals("f") && u.equals("inch")) len = new Length(value * 12, u);
    if (this.u.equals("inch") && u.equals("f")) len = new Length(value / 12, u);

      if (this.u.equals("yard")) {
          if (u.equals("inch")) {
              len = new Length(value * 36, u);
          } else if (u.equals("f")){
              len = new Length(value * 3, u);
          }
      }
      if (u.equals("yard")) {
          if (this.u.equals("f")) {
              len = new Length(value / 3, u);
          } else if (this.u.equals("inch")) {
              len = new Length(value / 36, u);
          }
      }

    return len;
  }

  public double getVal() {
    return this.value;
  }

  public String getUnit() {
    return this.u;
  }
}
