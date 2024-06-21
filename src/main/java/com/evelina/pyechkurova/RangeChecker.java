package com.evelina.pyechkurova;

import java.lang.reflect.Field;

public class RangeChecker {
    public static boolean checkMinMaxValue(Cat obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();
        boolean isValid = true;
        for (Field field : objClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(Range.class)) {
                field.setAccessible(true);
                int value = (int) field.get(obj);
                if (value >= field.getAnnotation(Range.class).min() && value <= field.getAnnotation(Range.class).max()) {
                    System.out.println("+ The field " + field.getName() + " is in range!");
                }
                else {
                    System.out.println("- The field " + field.getName() + " is in not range!");
                    isValid = false;
                }
            }
        }
        if (isValid) {
            System.out.println("| All values are in range!");
        }
        return isValid;
    }
}
