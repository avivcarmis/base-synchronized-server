package io.github.avivcarmis.confEager.properties;

import io.github.avivcarmis.confEager.ConfEager;
import io.github.avivcarmis.confEager.properties.utils.ConfEagerValueMapper;
import io.github.avivcarmis.confEager.properties.utils.ConfEagerPropertyPrimitiveArray;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfEagerPropertyIntegerArray extends ConfEagerPropertyPrimitiveArray<Integer> {

    public ConfEagerPropertyIntegerArray(ConfEager.DefaultValue<Integer[]> defaultValue, ConfEager.PropertyName propertyName) {
        super(defaultValue, propertyName, ConfEagerValueMapper.INTEGER_MAPPER, Integer.class);
    }

    public ConfEagerPropertyIntegerArray(ConfEager.PropertyName propertyName, ConfEager.DefaultValue<Integer[]> defaultValue) {
        super(propertyName, defaultValue, ConfEagerValueMapper.INTEGER_MAPPER, Integer.class);
    }

    public ConfEagerPropertyIntegerArray(ConfEager.PropertyName propertyName) {
        super(propertyName, ConfEagerValueMapper.INTEGER_MAPPER, Integer.class);
    }

    public ConfEagerPropertyIntegerArray(ConfEager.DefaultValue<Integer[]> defaultValue) {
        super(defaultValue, ConfEagerValueMapper.INTEGER_MAPPER, Integer.class);
    }

    public ConfEagerPropertyIntegerArray() {
        super(ConfEagerValueMapper.INTEGER_MAPPER, Integer.class);
    }

}
