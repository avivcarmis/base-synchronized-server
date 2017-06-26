package io.github.avivcarmis.confEager.properties.utils;

import io.github.avivcarmis.confEager.ConfEager;
import io.github.avivcarmis.confEager.ConfEagerProperty;

/**
 * Created by Mamot on 6/25/2017.
 */
abstract public class ConfEagerPropertyPrimitive<T> extends ConfEagerProperty<T> {

    private final ConfEagerValueMapper<T> _mapper;

    public ConfEagerPropertyPrimitive(ConfEager.DefaultValue<T> defaultValue, ConfEager.PropertyName propertyName, ConfEagerValueMapper<T> mapper) {
        super(defaultValue, propertyName);
        _mapper = mapper;
    }

    public ConfEagerPropertyPrimitive(ConfEager.PropertyName propertyName, ConfEager.DefaultValue<T> defaultValue, ConfEagerValueMapper<T> mapper) {
        super(propertyName, defaultValue);
        _mapper = mapper;
    }

    public ConfEagerPropertyPrimitive(ConfEager.PropertyName propertyName, ConfEagerValueMapper<T> mapper) {
        super(propertyName);
        _mapper = mapper;
    }

    public ConfEagerPropertyPrimitive(ConfEager.DefaultValue<T> defaultValue, ConfEagerValueMapper<T> mapper) {
        super(defaultValue);
        _mapper = mapper;
    }

    public ConfEagerPropertyPrimitive(ConfEagerValueMapper<T> mapper) {
        _mapper = mapper;
    }

    @Override
    protected T map(java.lang.String value) {
        return _mapper.map(value);
    }

}
