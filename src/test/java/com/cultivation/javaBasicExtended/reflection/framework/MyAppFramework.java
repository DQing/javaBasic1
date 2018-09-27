package com.cultivation.javaBasicExtended.reflection.framework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;

@SuppressWarnings("WeakerAccess")
public class MyAppFramework {
    HashMap<String, Class> provide = new HashMap<>();

    public void registerController(Class controllerClazz) {
        if (controllerClazz == null) {
            throw new IllegalArgumentException();
        }
        if (provide.containsKey(controllerClazz.getName())) {
            throw new IllegalArgumentException();
        }
        String name = controllerClazz.getName();
        provide.put(name, controllerClazz);
    }

    public Response getResponse(String requestController, String requestMethod) throws IllegalAccessException, InstantiationException {
        if (requestController == null || requestMethod == null) {
            throw new IllegalArgumentException();
        }
        if (!provide.containsKey(requestController)) {
            return new Response(404);
        }
        Class aClass = provide.get(requestController);
        Method invokeMethod = Arrays.stream(aClass.getDeclaredMethods())
                .filter(method -> method.getName().equals(requestMethod))
                .findFirst().orElse(null);
        if (invokeMethod == null) {
            return new Response(404);
        }
        if (!Modifier.isPublic(invokeMethod.getModifiers())) {
            return new Response(403);
        }
        return getServiceErrorResponse(aClass, invokeMethod);
    }

    private Response getServiceErrorResponse(Class aClass, Method invokeMethod) throws IllegalAccessException, InstantiationException {
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
    }
}