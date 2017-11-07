package ru.toywar.homework;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

/**
 * Created by romek on 07.11.2017.
 */

public class FieldsExclude implements ExclusionStrategy {

    private final Class<?> aClass;

    public FieldsExclude(Class<?> aClass) {
        this.aClass = aClass;
    }

    @Override
    public boolean shouldSkipField(FieldAttributes f) {
        return f.getAnnotation(Exclusion.class) != null;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
        return (clazz == aClass);
    }
}
