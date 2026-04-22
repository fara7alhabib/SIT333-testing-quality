package sit707_tasks;

import org.junit.Assert;
import org.junit.Test;

public class DateUtilTest {

    @Test
    public void testStudentIdentity() {
        String studentId = "223803449";
        System.out.println("Student ID test: " + studentId);
        Assert.assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Farah Alhabib";
        System.out.println("Student name test: " + studentName);
        Assert.assertNotNull("Student name is null", studentName);
    }

    @Test
    public void testMaxJanuary31ShouldIncrementToFebruary1() {
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment:  " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMinJanuary1ShouldIncrementToJanuary2() {
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment:  " + date);
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMinJanuary1ShouldDecrementToDecember31() {
        DateUtil date = new DateUtil(1, 1, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement:  " + date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testMaxFebruary29ShouldIncrementToMarch1() {
        DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment:  " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMinFebruary1ShouldDecrementToJanuary31() {
        DateUtil date = new DateUtil(1, 2, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement:  " + date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMaxApril30ShouldIncrementToMay1() {
        DateUtil date = new DateUtil(30, 4, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment:  " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMinJune1ShouldDecrementToMay31() {
        DateUtil date = new DateUtil(1, 6, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement:  " + date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMaxJune30ShouldIncrementToJuly1() {
        DateUtil date = new DateUtil(30, 6, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment:  " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMaxJanuary31ShouldDecrementToJanuary30() {
        DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement:  " + date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMaxSeptember30ShouldIncrementToOctober1() {
        DateUtil date = new DateUtil(30, 9, 2024);
        System.out.println("Before increment: " + date);
        date.increment();
        System.out.println("After increment:  " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(10, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMinSeptember1ShouldDecrementToAugust31() {
        DateUtil date = new DateUtil(1, 9, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement:  " + date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(8, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMinDecember1ShouldDecrementToNovember30() {
        DateUtil date = new DateUtil(1, 12, 2024);
        System.out.println("Before decrement: " + date);
        date.decrement();
        System.out.println("After decrement:  " + date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(11, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    // Equivalence class tests

    @Test
    public void testEquivalenceDayBetween1And28() {
        DateUtil date = new DateUtil(15, 5, 2024);
        System.out.println("D1 before increment: " + date);
        date.increment();
        System.out.println("D1 after increment:  " + date);
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testEquivalenceDay29InLeapYearFebruary() {
        DateUtil date = new DateUtil(29, 2, 2024);
        System.out.println("D2 before increment: " + date);
        date.increment();
        System.out.println("D2 after increment:  " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testEquivalenceDay30InThirtyDayMonth() {
        DateUtil date = new DateUtil(30, 4, 2024);
        System.out.println("D3 before increment: " + date);
        date.increment();
        System.out.println("D3 after increment:  " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testEquivalenceDay31InThirtyOneDayMonth() {
        DateUtil date = new DateUtil(31, 7, 2024);
        System.out.println("D4 before increment: " + date);
        date.increment();
        System.out.println("D4 after increment:  " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(8, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testEquivalenceFebruaryNonLeapYear() {
        DateUtil date = new DateUtil(28, 2, 2023);
        System.out.println("Non-leap year before increment: " + date);
        date.increment();
        System.out.println("Non-leap year after increment:  " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }

    @Test
    public void testEquivalenceFebruaryLeapYear() {
        DateUtil date = new DateUtil(28, 2, 2024);
        System.out.println("Leap year before increment: " + date);
        date.increment();
        System.out.println("Leap year after increment:  " + date);
        Assert.assertEquals(29, date.getDay());
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testEquivalenceThirtyDayMonth() {
        DateUtil date = new DateUtil(29, 6, 2024);
        System.out.println("30-day month before increment: " + date);
        date.increment();
        System.out.println("30-day month after increment:  " + date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testEquivalenceThirtyOneDayMonth() {
        DateUtil date = new DateUtil(30, 7, 2024);
        System.out.println("31-day month before increment: " + date);
        date.increment();
        System.out.println("31-day month after increment:  " + date);
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testEquivalenceEndOfYearChange() {
        DateUtil date = new DateUtil(31, 12, 2024);
        System.out.println("End of year before increment: " + date);
        date.increment();
        System.out.println("End of year after increment:  " + date);
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2025, date.getYear());
    }
}