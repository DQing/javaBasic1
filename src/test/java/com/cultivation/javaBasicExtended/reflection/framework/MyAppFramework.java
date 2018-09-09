package com.cultivation.javaBasicExtended.reflection.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

@SuppressWarnings("WeakerAccess")
public class MyAppFramework {
    HashMap<String, Class> provide = new HashMap<>();

    public void registerController(Class controllerClazz) throws IllegalAccessException, InstantiationException {
        // TODO: Please implement the method
        // <--start
        if (controllerClazz == null) {
            throw new IllegalAccessException();
        }
        if (provide.containsKey(controllerClazz.getName())) {
            throw new IllegalArgumentException();
        }
        String name = controllerClazz.getName();
        provide.put(name, controllerClazz);
        // --end-->
    }

    public Response getResponse(String requestController, String requestMethod) throws IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        // TODO: Please implement the method
        // <--start
        if (requestController == null || requestMethod == null) {
            throw new IllegalArgumentException();
        }
        if (!provide.containsKey(requestController)) {
            return new Response(404);
        }
        Class aClass = provide.get(requestController);
        Method invokeMethod = Arrays.stream(aClass.getMethods())
                .filter(method -> method.getName().equals(requestMethod))
                .findFirst().orElse(null);
        Method privateMethod = Arrays.stream(aClass.getDeclaredMethods())
                .filter(method -> method.getName().equals(requestMethod) && !Modifier.isPublic(method.getModifiers()))
                .findFirst().orElse(null);
        if (privateMethod != null) {
            return new Response(403);
        }
        if (invokeMethod == null) {
            return new Response(404);
        }
        try {
            int parameterCount = invokeMethod.getParameterCount();
            if (parameterCount > 0) {
                return new Response(503);
            }
            Object invoke = invokeMethod.invoke(aClass.newInstance());
            if (invoke == null) {
                return new Response(503);
            }
            return (Response) invoke;
        } catch (InvocationTargetException e) {
            return new Response(500);
        }
        // --end-->
    }

    // TODO: You can add additional methods here if you want
    // <--start
    // --end-->
}