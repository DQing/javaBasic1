package com.cultivation.javaBasicExtended.myUnitTestFramework;

import com.cultivation.javaBasicExtended.myUnitTestFramework.exampleTests.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnitTestRunnerTest {
    private UnitTestRunningResult runTest(Class<?> unitTestClass) {
        UnitTestRunner runner = new UnitTestRunner();
        return runner.run(unitTestClass);
    }

    @Test
    void should_run_success_unit_test() {
        UnitTestRunningResult result = runTest(WithOneTestMethod.class);
        assertTrue(result.isSuccess());
        assertNull(result.getReason());
    }

    @Test
    void should_run_unit_test_and_get_details() {
        UnitTestRunningResult result = runTest(WithOneTestMethod.class);

        List<TestResultItem> details = result.getDetails();

        assertEquals(1, details.size());
        TestResultItem detailsItem = details.get(0);

        assertTrue(detailsItem.isSuccess());
        assertEquals(WithOneTestMethod.class.getName(), detailsItem.getTestClass());
        assertEquals("should_success", detailsItem.getTestMethod());
    }

    @Test
    void should_run_unit_test_and_get_error() {
        UnitTestRunningResult result = runTest(WithOneFailureTestMethod.class);

        assertFalse(result.isSuccess());
        System.out.println("result===" + result.getReason());
        assertEquals("Please see details", result.getReason());
    }

    @Test
    void should_run_unit_test_and_get_error_details() {
        UnitTestRunningResult result = runTest(WithOneFailureTestMethod.class);

        List<TestResultItem> details = result.getDetails();

        assertEquals(1, details.size());
        TestResultItem detail = details.get(0);

        assertFalse(detail.isSuccess());
        assertEquals(WithOneFailureTestMethod.class.getName(), detail.getTestClass());
        assertEquals("Hello does not equal with World.", detail.getReason());
    }

    @Test
    void should_success_if_no_test_is_found() {
        UnitTestRunningResult result = runTest(WithoutTestMethod.class);
        assertTrue(result.isSuccess());
        assertNull(result.getReason());
        assertEquals(0, result.getDetails().size());
    }

    @Test
    void should_report_all_failed_methods() {
        UnitTestRunningResult result = runTest(WithMultipleFailures.class);

        assertFalse(result.isSuccess());
        assertEquals("Please see details", result.getReason());

        List<TestResultItem> details = result.getDetails();
        assertEquals(2, details.size());
        assertFailure(details, "should_fail_first", "Hello does not equal with World.");
        assertFailure(details, "should_fail_second", "I am the king of the world");
    }

    private void assertFailure(List<TestResultItem> details, String methodName, String expectedReason) {
        TestResultItem firstResult = details.stream().filter(d -> d.getTestMethod().equals(methodName))
                .findFirst().orElse(null);
        assertNotNull(firstResult);
        assertFalse(firstResult.isSuccess());
        assertEquals(expectedReason, firstResult.getReason());
    }

    @Test
    void should_return_false() {
        UnitTestRunningResult result = runTest(WithOneNoAnnotaTestMethod.class);
        assertEquals(0, result.getDetails().size());
    }

}
