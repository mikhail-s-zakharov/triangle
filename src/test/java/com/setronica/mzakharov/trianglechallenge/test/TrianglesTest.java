package com.setronica.mzakharov.trianglechallenge.test;

import com.setronica.mzakharov.trianglechallenge.ShapeDefinitionException;
import com.setronica.mzakharov.trianglechallenge.Triangle;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by mzakharov on 11.10.16.
 */
public class TrianglesTest {
    @Test
    public void sidesFormTriangle(){
        Triangle t = new Triangle(5.0d, 8.0d, 10.0d);
        Assert.assertEquals(true, t.canBeBuilt());
    }

    @Test
    public void sidesNotFormTriangle(){
        Triangle t = new Triangle(5.5d, 8.1d, 2.04d);
        Assert.assertEquals(false, t.canBeBuilt());
    }

    @Test
    public void formEquilateral(){
        Triangle t = new Triangle(5.0d, 5.0d, 5.0d);
        Assert.assertEquals(Triangle.KIND.EQUILATERAL, t.getTriangleKind());
    }

    @Test
    public void formIsosceles(){
        Triangle t = new Triangle(5.0d, 5.0d, 8.2d);
        Assert.assertEquals(Triangle.KIND.ISOSCELES, t.getTriangleKind());
    }

    @Test
    public void formScalene(){
        Triangle t = new Triangle(5.0d, 8.0d, 10.0d);
        Assert.assertEquals(Triangle.KIND.SCALENE, t.getTriangleKind());
    }

    @Test(expected = ShapeDefinitionException.class)
    public void throwExceptionDuringKindQuery(){
        Triangle t = new Triangle(5.5d, 8.1d, 2.04d);
        t.getTriangleKind();
    }

    @Test
    public void anglesSumm(){
        Triangle t = new Triangle(5.0d, 5.0d, 5.0d);
        Assert.assertEquals(Triangle.TRIANGLE_ANGLES_SUMM, t.getAlpha() + t.getBeta() + t.getGamma(), Triangle.EPSILON);
    }

    @Test
    public void sineTheoremComplies() {
        Triangle t = new Triangle(5.0d, 8.0d, 10.0d);
        double sinA = t.getA()/ Math.sin(Math.toRadians(t.getAlpha()));
        double sinB = t.getB()/ Math.sin(Math.toRadians(t.getBeta()));
        double sinC = t.getC()/ Math.sin(Math.toRadians(t.getGamma()));
        Assert.assertEquals(sinA, sinB, Triangle.EPSILON);
        Assert.assertEquals(sinC, sinB, Triangle.EPSILON);
        Assert.assertEquals(sinA, sinC, Triangle.EPSILON);
    }
}
