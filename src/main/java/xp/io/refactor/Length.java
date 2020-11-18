package xp.io.refactor;

public class Length {
    public static final Unit INCH = Unit.inch;
    public static final Unit FOOT = Unit.foot;
    public static final Unit YARD = Unit.yard;

    private final double value;
    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Unit unit) {
        return new Length(newValueIn(unit), unit);
    }

    private double newValueIn(Unit unit) {
        if (this.unit == FOOT && unit == INCH) {
            return value * 12;
        }
        if (this.unit == INCH && unit == FOOT) {
            return value / 12;
        }

        if (this.unit == YARD && unit == INCH) {
            return value * 36;
        }
        if (unit == YARD && this.unit == INCH) {
            return value / 36;
        }

        if (this.unit == YARD && unit == FOOT) {
            return value * 3;
        }
        if (unit == YARD && this.unit == FOOT) {
            return value / 3;
        }
        return value;
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return this.unit;
    }
}
