package io.github.avivcarmis.confeager.properties;

import io.github.avivcarmis.confeager.properties.utils.ConfeagerPropertyEnumOf;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerPropertyCaseSensitiveEnum<T extends Enum<T>> extends ConfeagerPropertyEnumOf<T> {

    public ConfeagerPropertyCaseSensitiveEnum(String key, Class<T> tClass) {
        super(key, tClass);
    }

    public ConfeagerPropertyCaseSensitiveEnum(String key, Class<T> tClass, T defaultValue) {
        super(key, tClass, defaultValue);
    }

    @Override
    protected T map(String value) {
        return Enum.valueOf(tClass, value);
    }

}
