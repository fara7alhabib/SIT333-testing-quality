package web.service;

public class MathQuestionService {

    public static double q1Addition(String number1, String number2) {
        if (number1 == null || number1.isEmpty() || number2 == null || number2.isEmpty()) {
            return 0;
        }
        return Double.valueOf(number1) + Double.valueOf(number2);
    }

    public static double q2Subtraction(String number1, String number2) {
        if (number1 == null || number1.isEmpty() || number2 == null || number2.isEmpty()) {
            return 0;
        }
        return Double.valueOf(number1) - Double.valueOf(number2);
    }

    public static double q3Multiplication(String number1, String number2) {
        if (number1 == null || number1.isEmpty() || number2 == null || number2.isEmpty()) {
            return 0;
        }
        return Double.valueOf(number1) * Double.valueOf(number2);
    }
}