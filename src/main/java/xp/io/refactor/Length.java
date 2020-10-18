package xp.io.refactor;

public class Length {
    private final double val;
    private final String uinnt;

    public Length(double val, String uinnt) {
        this.val = val;
        this.uinnt = uinnt;
    }

    public Length as(String u) {
        Length len = this;
        if (this.uinnt.equals("f") && u.equals("inch")) {
            len = new Length(val * 12, u);
        }
        if (this.uinnt.equals("inch") && u.equals("f")) {
            len = new Length(val / 12, u);
        }

        if (this.uinnt.equals("yard")) {
            if (u.equals("inch")) {
                len = new Length(val * 36, u);
            } else if (u.equals("f")){
                len = new Length(val * 3, u);
            }
        } else if (u.equals("yard")) {
            if (this.uinnt.equals("f")) {
                len = new Length(val / 3, u);
            } else if (this.uinnt.equals("inch")) {
                len = new Length(val / 36, u);
            }
        }

        return len;
    }

    public double getVal() {
        return this.val;
    }

    public String getUnit() {
        return this.uinnt;
    }
}
