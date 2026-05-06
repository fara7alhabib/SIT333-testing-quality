package web.service;

import org.junit.Assert;
import org.junit.Test;

public class TestMathQuestionService {

    @Test
    public void testQ1AdditionCorrect() {
        Assert.assertEquals(8.0, MathQuestionService.q1Addition("5", "3"), 0.001);
    }

    @Test
    public void testQ1AdditionEmptyInput() {
        Assert.assertEquals(0.0, MathQuestionService.q1Addition("", ""), 0.001);
    }

    @Test
    public void testQ2SubtractionCorrect() {
        Assert.assertEquals(2.0, MathQuestionService.q2Subtraction("5", "3"), 0.001);
    }

    @Test
    public void testQ2SubtractionEmptyInput() {
        Assert.assertEquals(0.0, MathQuestionService.q2Subtraction("", ""), 0.001);
    }

    @Test
    public void testQ3MultiplicationCorrect() {
        Assert.assertEquals(15.0, MathQuestionService.q3Multiplication("5", "3"), 0.001);
    }
}