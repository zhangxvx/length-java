package xp.io.refactor;

public class Length {
    private final double value;
    private final Unit unit;

    public Length(double value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public Length as(Unit target) {
        return new Length(newValueIn(target), target);
    }

    private double newValueIn(Unit target) {
        double targetValue = value;
        if (this.unit.equals(Unit.FOOT) && target.equals(Unit.INCH)) {
            targetValue = this.value * 12;
        }
        if (this.unit.equals(Unit.INCH) && target.equals(Unit.FOOT)) {
            targetValue = this.value / 12;
        }

        if (this.unit.equals(Unit.YARD) && target.equals(Unit.INCH)) {
            targetValue = this.value * 36;
        }
        if (this.unit.equals(Unit.INCH) && target.equals(Unit.YARD)) {
            targetValue = this.value / 36;
        }

        if (this.unit.equals(Unit.YARD) && target.equals(Unit.FOOT)) {
            targetValue = this.value * 3;
        }
        if (this.unit.equals(Unit.FOOT) && target.equals(Unit.YARD)) {
            targetValue = this.value / 3;
        }
        return targetValue;
    }

    public double getValue() {
        return this.value;
    }

    public Unit getUnit() {
        return this.unit;
    }
}
