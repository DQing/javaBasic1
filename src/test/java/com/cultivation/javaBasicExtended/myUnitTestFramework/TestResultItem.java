package com.cultivation.javaBasicExtended.myUnitTestFramework;

class TestResultItem {
    private final boolean success;
    private final String testClass;
    private final String testMethod;
    private String reason;

    TestResultItem(boolean success, String testClass, String testMethod, String reason) {
        if (testClass == null || testMethod == null) {
            throw new IllegalArgumentException("Test class and test method must be provided.");
        }

        this.reason = reason;
        this.success = success;
        this.testClass = testClass;
        this.testMethod = testMethod;
    }

    TestResultItem(boolean success, String testClass, String testMethod) {
        if (testClass == null || testMethod == null) {
            throw new IllegalArgumentException("Test class and test method must be provided.");
        }
        this.success = success;
        this.testClass = testClass;
        this.testMethod = testMethod;
    }

    boolean isSuccess() {
        return success;
    }

    String getTestClass() {
        return testClass;
    }

    String getTestMethod() {
        return testMethod;
    }

    String getReason() {
        return reason;
    }
}
