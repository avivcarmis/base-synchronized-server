package io.github.avivcarmis.confEager.properties.utils;

import io.github.avivcarmis.confEager.ConfEager;
import io.github.avivcarmis.confEager.ConfEagerProperty;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mamot on 6/25/2017.
 */
abstract public class ConfEagerPropertyPrimitiveArray<T> extends ConfEagerProperty<T[]> {

    private final ConfEagerValueMapper<T> _mapper;

    private final Class<T> _tClass;

    public ConfEagerPropertyPrimitiveArray(ConfEager.DefaultValue<T[]> defaultValue, ConfEager.PropertyName propertyName, ConfEagerValueMapper<T> mapper, Class<T> tClass) {
        super(defaultValue, propertyName);
        _mapper = mapper;
        _tClass = tClass;
    }

    public ConfEagerPropertyPrimitiveArray(ConfEager.PropertyName propertyName, ConfEager.DefaultValue<T[]> defaultValue, ConfEagerValueMapper<T> mapper, Class<T> tClass) {
        super(propertyName, defaultValue);
        _mapper = mapper;
        _tClass = tClass;
    }

    public ConfEagerPropertyPrimitiveArray(ConfEager.PropertyName propertyName, ConfEagerValueMapper<T> mapper, Class<T> tClass) {
        super(propertyName);
        _mapper = mapper;
        _tClass = tClass;
    }

    public ConfEagerPropertyPrimitiveArray(ConfEager.DefaultValue<T[]> defaultValue, ConfEagerValueMapper<T> mapper, Class<T> tClass) {
        super(defaultValue);
        _mapper = mapper;
        _tClass = tClass;
    }

    public ConfEagerPropertyPrimitiveArray(ConfEagerValueMapper<T> mapper, Class<T> tClass) {
        _mapper = mapper;
        _tClass = tClass;
    }

    @Override
    protected T[] map(java.lang.String value) {
        List<T> list = new LinkedList<>();
        for (java.lang.String s : value.split(",")) {
            java.lang.String trimmed = s.trim();
            if (trimmed.isEmpty()) {
                continue;
            }
            list.add(_mapper.map(trimmed));
        }
        @SuppressWarnings("unchecked") T[] array = (T[]) Array.newInstance(_tClass, list.size());
        list.toArray(array);
        return array;
    }

}
