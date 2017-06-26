package io.github.avivcarmis.confEager.properties;

import io.github.avivcarmis.confEager.ConfEager;
import io.github.avivcarmis.confEager.properties.utils.ConfEagerValueMapper;
import io.github.avivcarmis.confEager.properties.utils.ConfEagerPropertyPrimitiveArray;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfEagerPropertyFloatArray extends ConfEagerPropertyPrimitiveArray<Float> {

    public ConfEagerPropertyFloatArray(ConfEager.DefaultValue<Float[]> defaultValue, ConfEager.PropertyName propertyName) {
        super(defaultValue, propertyName, ConfEagerValueMapper.FLOAT_MAPPER, Float.class);
    }

    public ConfEagerPropertyFloatArray(ConfEager.PropertyName propertyName, ConfEager.DefaultValue<Float[]> defaultValue) {
        super(propertyName, defaultValue, ConfEagerValueMapper.FLOAT_MAPPER, Float.class);
    }

    public ConfEagerPropertyFloatArray(ConfEager.PropertyName propertyName) {
        super(propertyName, ConfEagerValueMapper.FLOAT_MAPPER, Float.class);
    }

    public ConfEagerPropertyFloatArray(ConfEager.DefaultValue<Float[]> defaultValue) {
        super(defaultValue, ConfEagerValueMapper.FLOAT_MAPPER, Float.class);
    }

    public ConfEagerPropertyFloatArray() {
        super(ConfEagerValueMapper.FLOAT_MAPPER, Float.class);
    }

}
