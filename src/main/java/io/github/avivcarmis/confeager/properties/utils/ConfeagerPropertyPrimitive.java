package io.github.avivcarmis.confeager.properties.utils;

import io.github.avivcarmis.confeager.ConfeagerProperty;
import io.github.avivcarmis.confeager.properties.ConfeagerPropertyString;

/**
 * Created by Mamot on 6/25/2017.
 */
abstract public class ConfeagerPropertyPrimitive<T> extends ConfeagerProperty<T> {

    private final ConfeagerValueMapper<T> mapper;

    public ConfeagerPropertyPrimitive(String key, ConfeagerValueMapper<T> mapper) {
        super(key);
        this.mapper = mapper;
    }

    public ConfeagerPropertyPrimitive(String key, T defaultValue, ConfeagerValueMapper<T> mapper) {
        super(key, defaultValue);
        this.mapper = mapper;
    }

    @Override
    protected T map(java.lang.String value) {
        return mapper.map(value);
    }

}
