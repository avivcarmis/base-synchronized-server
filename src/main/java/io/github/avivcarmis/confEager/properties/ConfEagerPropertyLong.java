package io.github.avivcarmis.confEager.properties;

import io.github.avivcarmis.confEager.ConfEager;
import io.github.avivcarmis.confEager.properties.utils.ConfEagerValueMapper;
import io.github.avivcarmis.confEager.properties.utils.ConfEagerPropertyPrimitive;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfEagerPropertyLong extends ConfEagerPropertyPrimitive<Long> {

    public ConfEagerPropertyLong(ConfEager.DefaultValue<Long> defaultValue, ConfEager.PropertyName propertyName) {
        super(defaultValue, propertyName, ConfEagerValueMapper.LONG_MAPPER);
    }

    public ConfEagerPropertyLong(ConfEager.PropertyName propertyName, ConfEager.DefaultValue<Long> defaultValue) {
        super(propertyName, defaultValue, ConfEagerValueMapper.LONG_MAPPER);
    }

    public ConfEagerPropertyLong(ConfEager.PropertyName propertyName) {
        super(propertyName, ConfEagerValueMapper.LONG_MAPPER);
    }

    public ConfEagerPropertyLong(ConfEager.DefaultValue<Long> defaultValue) {
        super(defaultValue, ConfEagerValueMapper.LONG_MAPPER);
    }

    public ConfEagerPropertyLong() {
        super(ConfEagerValueMapper.LONG_MAPPER);
    }

}
