package io.github.avivcarmis.confEager.properties;

import io.github.avivcarmis.confEager.ConfEager;
import io.github.avivcarmis.confEager.properties.utils.ConfEagerValueMapper;
import io.github.avivcarmis.confEager.properties.utils.ConfEagerPropertyPrimitiveArray;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfEagerPropertyStringArray extends ConfEagerPropertyPrimitiveArray<String> {

    public ConfEagerPropertyStringArray(ConfEager.DefaultValue<String[]> defaultValue, ConfEager.PropertyName propertyName) {
        super(defaultValue, propertyName, ConfEagerValueMapper.STRING_MAPPER, String.class);
    }

    public ConfEagerPropertyStringArray(ConfEager.PropertyName propertyName, ConfEager.DefaultValue<String[]> defaultValue) {
        super(propertyName, defaultValue, ConfEagerValueMapper.STRING_MAPPER, String.class);
    }

    public ConfEagerPropertyStringArray(ConfEager.PropertyName propertyName) {
        super(propertyName, ConfEagerValueMapper.STRING_MAPPER, String.class);
    }

    public ConfEagerPropertyStringArray(ConfEager.DefaultValue<String[]> defaultValue) {
        super(defaultValue, ConfEagerValueMapper.STRING_MAPPER, String.class);
    }

    public ConfEagerPropertyStringArray() {
        super(ConfEagerValueMapper.STRING_MAPPER, String.class);
    }

}
