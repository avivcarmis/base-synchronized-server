package io.github.avivcarmis.confEager.properties;

import io.github.avivcarmis.confEager.ConfEager;
import io.github.avivcarmis.confEager.properties.utils.ConfEagerValueMapper;
import io.github.avivcarmis.confEager.properties.utils.ConfEagerPropertyPrimitiveArray;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfEagerPropertyLongArray extends ConfEagerPropertyPrimitiveArray<Long> {

    public ConfEagerPropertyLongArray(ConfEager.DefaultValue<Long[]> defaultValue, ConfEager.PropertyName propertyName) {
        super(defaultValue, propertyName, ConfEagerValueMapper.LONG_MAPPER, Long.class);
    }

    public ConfEagerPropertyLongArray(ConfEager.PropertyName propertyName, ConfEager.DefaultValue<Long[]> defaultValue) {
        super(propertyName, defaultValue, ConfEagerValueMapper.LONG_MAPPER, Long.class);
    }

    public ConfEagerPropertyLongArray(ConfEager.PropertyName propertyName) {
        super(propertyName, ConfEagerValueMapper.LONG_MAPPER, Long.class);
    }

    public ConfEagerPropertyLongArray(ConfEager.DefaultValue<Long[]> defaultValue) {
        super(defaultValue, ConfEagerValueMapper.LONG_MAPPER, Long.class);
    }

    public ConfEagerPropertyLongArray() {
        super(ConfEagerValueMapper.LONG_MAPPER, Long.class);
    }

}
