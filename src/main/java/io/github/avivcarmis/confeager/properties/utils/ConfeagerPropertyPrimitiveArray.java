package io.github.avivcarmis.confeager.properties.utils;

import io.github.avivcarmis.confeager.ConfeagerProperty;
import io.github.avivcarmis.confeager.properties.ConfeagerPropertyString;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mamot on 6/25/2017.
 */
abstract public class ConfeagerPropertyPrimitiveArray<T> extends ConfeagerProperty<T[]> {

    private final ConfeagerValueMapper<T> mapper;

    private final Class<T> tClass;

    public ConfeagerPropertyPrimitiveArray(String key, ConfeagerValueMapper<T> mapper, Class<T> tClass) {
        super(key);
        this.mapper = mapper;
        this.tClass = tClass;
    }

    public ConfeagerPropertyPrimitiveArray(String key, T[] defaultValue, ConfeagerValueMapper<T> mapper, Class<T> tClass) {
        super(key, defaultValue);
        this.mapper = mapper;
        this.tClass = tClass;
    }

    @Override
    protected T[] map(java.lang.String value) {
        List<T> list = new LinkedList<>();
        for (java.lang.String s : value.split(",")) {
            java.lang.String trimmed = s.trim();
            if (trimmed.isEmpty()) {
                continue;
            }
            list.add(mapper.map(trimmed));
        }
        @SuppressWarnings("unchecked") T[] array = (T[]) Array.newInstance(tClass, list.size());
        list.toArray(array);
        return array;
    }

}
