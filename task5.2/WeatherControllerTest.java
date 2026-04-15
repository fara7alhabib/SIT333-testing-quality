package sit707_week5;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class WeatherControllerTest {

    private static WeatherController wController;
    private static double[] temperatures;
    private static double minTemperature;
    private static double maxTemperature;
    private static double avgTemperature;
    private static int totalHours;

    @BeforeClass
    public static void setUp() {
        // Arrange
        wController = WeatherController.getInstance();
        totalHours = wController.getTotalHours();

        temperatures = new double[totalHours];
        minTemperature = Double.MAX_VALUE;
        maxTemperature = -Double.MAX_VALUE;
        double sum = 0;

        for (int i = 0; i < totalHours; i++) {
            temperatures[i] = wController.getTemperatureForHour(i + 1);

            if (temperatures[i] < minTemperature) {
                minTemperature = temperatures[i];
            }

            if (temperatures[i] > maxTemperature) {
                maxTemperature = temperatures[i];
            }

            sum += temperatures[i];
        }

        avgTemperature = sum / totalHours;
    }

    @AfterClass
    public static void tearDown() {
        // After
        wController.close();
    }

    @Test
    public void testStudentIdentity() {
        // Arrange
        String studentId = "223803449";

        // Assert
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        // Arrange
        String studentName = "Farah Mansour M Alhabib";

        // Assert
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testTemperatureMin() {
        // Act
        double cachedMin = wController.getTemperatureMinFromCache();

        // Assert
        Assert.assertEquals(minTemperature, cachedMin, 0.001);
    }

    @Test
    public void testTemperatureMax() {
        // Act
        double cachedMax = wController.getTemperatureMaxFromCache();

        // Assert
        Assert.assertEquals(maxTemperature, cachedMax, 0.001);
    }

    @Test
    public void testTemperatureAverage() {
        // Act
        double cachedAverage = wController.getTemperatureAverageFromCache();

        // Assert
        Assert.assertEquals(avgTemperature, cachedAverage, 0.001);
    }

    /*
    @Test
    public void testTemperaturePersist() {
        // Not required for this task
    }
    */
}
