package io.github.avivcarmis.confEager.properties;

import io.github.avivcarmis.confEager.ConfEager;
import io.github.avivcarmis.confEager.ConfEagerProperty;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfEagerPropertyEnum<T extends Enum<T>> extends ConfEagerProperty<T> {

    private final Class<T> _tClass;

    private final boolean _caseSensitive;

    public ConfEagerPropertyEnum(Class<T> tClass, boolean caseSensitive, ConfEager.DefaultValue<T> defaultValue, ConfEager.PropertyName propertyName) {
        super(defaultValue, propertyName);
        _tClass = tClass;
        _caseSensitive = caseSensitive;
    }

    public ConfEagerPropertyEnum(Class<T> tClass, boolean caseSensitive, ConfEager.PropertyName propertyName, ConfEager.DefaultValue<T> defaultValue) {
        super(propertyName, defaultValue);
        _tClass = tClass;
        _caseSensitive = caseSensitive;
    }

    public ConfEagerPropertyEnum(Class<T> tClass, boolean caseSensitive, ConfEager.PropertyName propertyName) {
        super(propertyName);
        _tClass = tClass;
        _caseSensitive = caseSensitive;
    }

    public ConfEagerPropertyEnum(Class<T> tClass, boolean caseSensitive, ConfEager.DefaultValue<T> defaultValue) {
        super(defaultValue);
        _tClass = tClass;
        _caseSensitive = caseSensitive;
    }

    public ConfEagerPropertyEnum(Class<T> tClass, boolean caseSensitive) {
        _tClass = tClass;
        _caseSensitive = caseSensitive;
    }

    @Override
    protected T map(String value) {
        if (_caseSensitive) {
            return Enum.valueOf(_tClass, value);
        }
        for (T instance : _tClass.getEnumConstants()) {
            if (instance.name().equalsIgnoreCase(value)) {
                return instance;
            }
        }
        throw new IllegalArgumentException("enum class " + _tClass.getName() + " has no value " + value);
    }

}
