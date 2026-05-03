package sit707_week6;

public class GradeCalculator {

    public String getGrade(int mark) {

        // fix invalid values
        if (mark < 0 || mark > 100) {
            return "Invalid";
        }

        if (mark >= 50) {
            return "Pass";
        } else {
            return "Fail";
        }
    }
}