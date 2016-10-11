package com.setronica.mzakharov.trianglechallenge;

/**
 * Created by mzakharov on 11.10.16.
 * Represents computations with triangle shape
 */
public class Triangle extends Shape {
    /**
     * Summ of all angles, 180 degrees respectively
     */
    public static final double TRIANGLE_ANGLES_SUMM = 180.0d;
    /**
     * Computations delta within which results decided as equals (indistinctive)
     */
    public static final double EPSILON = 0.0000005;

    /*
    * Kind of triangle enumeration
    * */
    public enum KIND {
        EQUILATERAL,
        ISOSCELES,
        SCALENE
    }

    private double a;
    private double b;
    private double c;

    /**
     * Constructs new Triangle with defined side lengths. Constructed triangle stay immutable during usage.
     * @param a - side A length
     * @param b - side B length
     * @param c - side C length
     */
    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Check compliance to positive side lengths and to "triangle inequality"
     * @return true if triangle can be formed from defined side lengths
     */
    public boolean canBeBuilt() {
        return a > 0 && b > 0 && c > 0 && a + b > c && a + c > b && b + c > a;
    }

    /**
     *
     * @return @{@link KIND} member, relevant to
     */
    public KIND getTriangleKind(){
        checkCanBeBuilt();
        if (a == b && b == c) {
            return KIND.EQUILATERAL;
        }
        if (a == b || b == c || c == a){
            return KIND.ISOSCELES;
        }
        return KIND.SCALENE;
    }

    @Override
    public int getSidesCount() {
        return 3;
    }

    @Override
    public double getPerimeter() {
        checkCanBeBuilt();
        return a + b + c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getAlpha(){
        checkCanBeBuilt();
        return getOppositeAngleFor(a, b, c);
    }

    public double getBeta(){
        checkCanBeBuilt();
        return getOppositeAngleFor(b, a, c);
    }

    public double getGamma(){
        checkCanBeBuilt();
        return getOppositeAngleFor(c, b, a);
    }

    private void checkCanBeBuilt(){
        if (!canBeBuilt()){
            throw new ShapeDefinitionException("Triangle can't be formed out of such sides: " + a + ";" + b + ";" + c);
        }
    }

    private static double getOppositeAngleFor(double oppositeSide, double adjacentSideA, double adjacentSideB){
        /*
        *  according to cosine theorem, a^2 = b^2 + c^2 - 2bc * cos a
        *  cos a = (a^2 - b^2 - c^2) / 2bc
        *  angle deducted by arccosine
        * */
        double cosine = (Math.pow(oppositeSide, 2) - Math.pow(adjacentSideA, 2) - Math.pow(adjacentSideB, 2))/ (2 * adjacentSideA * adjacentSideB);
        double angle = Math.acos(cosine);
        double degrees = 180.0d - Math.toDegrees(angle);
        return degrees;
    }
}
