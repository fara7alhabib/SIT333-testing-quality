package sit707_week6;

import org.junit.Assert;
import org.junit.Test;

public class GradeCalculatorTest {

    // Boundary test (B)
    @Test
    public void testBoundaryPass() {
        GradeCalculator g = new GradeCalculator();
        Assert.assertEquals("Pass", g.getGrade(50));
    }

    // Normal test
    @Test
    public void testNormalFail() {
        GradeCalculator g = new GradeCalculator();
        Assert.assertEquals("Fail", g.getGrade(30));
    }

    // Invalid test (I)
    @Test
    public void testInvalidLow() {
        GradeCalculator g = new GradeCalculator();
        Assert.assertEquals("Invalid", g.getGrade(-5));
    }

    // Invalid test (high)
    @Test
    public void testInvalidHigh() {
        GradeCalculator g = new GradeCalculator();
        Assert.assertEquals("Invalid", g.getGrade(120));
    }
}