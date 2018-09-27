package com.cultivation.javaBasicExtended.myUnitTestFramework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

class UnitTestRunner {
    UnitTestRunningResult run(Class<?> unitTestClass) {
        // <--start
        Method[] declaredMethods = unitTestClass.getDeclaredMethods();
        ArrayList<TestResultItem> itemMethodResult = new ArrayList<>();
        Arrays.stream(declaredMethods)
                .filter(method -> method.getAnnotation(MyTest.class) != null)
                .filter(method -> Modifier.isPublic(method.getModifiers()))
                .forEach(filterMethod -> getItemResultArray(unitTestClass, itemMethodResult, filterMethod));
        return new UnitTestRunningResult(itemMethodResult);
        // --end-->
    }

    private void getItemResultArray(Class<?> unitTestClass, ArrayList<TestResultItem> itemMethodResult, Method filterMethod) {
        try {
            filterMethod.invoke(unitTestClass.newInstance());
        } catch (MyUnitTestAssertException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
            String message = e.getCause() == null ? "no cause" : e.getCause().getMessage();
            itemMethodResult.add(new TestResultItem(false, unitTestClass.getName(), filterMethod.getName(), message));
            return;
        }
        itemMethodResult.add(new TestResultItem(true, unitTestClass.getName(), filterMethod.getName()));
    }
}
