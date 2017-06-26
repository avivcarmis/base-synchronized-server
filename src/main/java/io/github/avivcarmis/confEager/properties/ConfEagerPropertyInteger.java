package io.github.avivcarmis.confEager.properties;

import io.github.avivcarmis.confEager.ConfEager;
import io.github.avivcarmis.confEager.properties.utils.ConfEagerValueMapper;
import io.github.avivcarmis.confEager.properties.utils.ConfEagerPropertyPrimitive;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfEagerPropertyInteger extends ConfEagerPropertyPrimitive<Integer> {

    public ConfEagerPropertyInteger(ConfEager.DefaultValue<Integer> defaultValue, ConfEager.PropertyName propertyName) {
        super(defaultValue, propertyName, ConfEagerValueMapper.INTEGER_MAPPER);
    }

    public ConfEagerPropertyInteger(ConfEager.PropertyName propertyName, ConfEager.DefaultValue<Integer> defaultValue) {
        super(propertyName, defaultValue, ConfEagerValueMapper.INTEGER_MAPPER);
    }

    public ConfEagerPropertyInteger(ConfEager.PropertyName propertyName) {
        super(propertyName, ConfEagerValueMapper.INTEGER_MAPPER);
    }

    public ConfEagerPropertyInteger(ConfEager.DefaultValue<Integer> defaultValue) {
        super(defaultValue, ConfEagerValueMapper.INTEGER_MAPPER);
    }

    public ConfEagerPropertyInteger() {
        super(ConfEagerValueMapper.INTEGER_MAPPER);
    }

}
