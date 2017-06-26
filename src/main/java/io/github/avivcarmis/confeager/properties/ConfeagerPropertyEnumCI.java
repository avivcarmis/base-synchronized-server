package io.github.avivcarmis.confeager.properties;

import io.github.avivcarmis.confeager.properties.utils.ConfeagerPropertyEnumOf;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerPropertyEnumCI<T extends Enum<T>> extends ConfeagerPropertyEnumOf<T> {

    public ConfeagerPropertyEnumCI(String key, Class<T> tClass) {
        super(key, tClass);
    }

    public ConfeagerPropertyEnumCI(String key, Class<T> tClass, T defaultValue) {
        super(key, tClass, defaultValue);
    }

    @Override
    protected T map(String value) {
        for (T instance : tClass.getEnumConstants()) {
            if (instance.name().equalsIgnoreCase(value)) {
                return instance;
            }
        }
        throw new IllegalArgumentException("enum class " + tClass.getName() + " has no value " + value);
    }

}
