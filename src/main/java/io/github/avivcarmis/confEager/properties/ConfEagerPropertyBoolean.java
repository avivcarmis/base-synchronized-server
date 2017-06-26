package io.github.avivcarmis.confEager.properties;

import io.github.avivcarmis.confEager.ConfEager;
import io.github.avivcarmis.confEager.properties.utils.ConfEagerPropertyPrimitive;
import io.github.avivcarmis.confEager.properties.utils.ConfEagerValueMapper;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfEagerPropertyBoolean extends ConfEagerPropertyPrimitive<Boolean> {

    public ConfEagerPropertyBoolean(ConfEager.DefaultValue<Boolean> defaultValue, ConfEager.PropertyName propertyName) {
        super(defaultValue, propertyName, ConfEagerValueMapper.BOOLEAN_MAPPER);
    }

    public ConfEagerPropertyBoolean(ConfEager.PropertyName propertyName, ConfEager.DefaultValue<Boolean> defaultValue) {
        super(propertyName, defaultValue, ConfEagerValueMapper.BOOLEAN_MAPPER);
    }

    public ConfEagerPropertyBoolean(ConfEager.PropertyName propertyName) {
        super(propertyName, ConfEagerValueMapper.BOOLEAN_MAPPER);
    }

    public ConfEagerPropertyBoolean(ConfEager.DefaultValue<Boolean> defaultValue) {
        super(defaultValue, ConfEagerValueMapper.BOOLEAN_MAPPER);
    }

    public ConfEagerPropertyBoolean() {
        super(ConfEagerValueMapper.BOOLEAN_MAPPER);
    }

}
