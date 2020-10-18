package xp.io.refactor;

public class Length {
    private final double value;
    private final String unit;

    public Length(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(String unit) {
        Length result = this;
        if (this.unit.equals("f") && unit.equals("inch")) {
            result = new Length(value * 12, unit);
        }
        if (this.unit.equals("inch") && unit.equals("f")) {
            result = new Length(value / 12, unit);
        }

        if (this.unit.equals("yard")) {
            if (unit.equals("inch")) {
                result = new Length(value * 36, unit);
            } else if (unit.equals("f")){
                result = new Length(value * 3, unit);
            }
        } else if (unit.equals("yard")) {
            if (this.unit.equals("f")) {
                result = new Length(value / 3, unit);
            } else if (this.unit.equals("inch")) {
                result = new Length(value / 36, unit);
            }
        }

        return result;
    }

    public double getValue() {
        return this.value;
    }

    public String getUnit() {
        return this.unit;
    }
}
