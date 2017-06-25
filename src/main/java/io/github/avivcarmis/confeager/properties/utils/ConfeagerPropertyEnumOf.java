package io.github.avivcarmis.confeager.properties.utils;

import io.github.avivcarmis.confeager.ConfeagerProperty;
import io.github.avivcarmis.confeager.properties.ConfeagerPropertyString;

/**
 * Created by Mamot on 6/25/2017.
 */
abstract public class ConfeagerPropertyEnumOf<T extends Enum<T>> extends ConfeagerProperty<T> {

    protected final Class<T> tClass;

    public ConfeagerPropertyEnumOf(String key, Class<T> tClass) {
        super(key);
        this.tClass = tClass;
    }

    public ConfeagerPropertyEnumOf(String key, Class<T> tClass, T defaultValue) {
        super(key, defaultValue);
        this.tClass = tClass;
    }

}
