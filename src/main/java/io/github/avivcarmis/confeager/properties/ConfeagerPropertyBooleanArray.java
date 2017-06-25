package io.github.avivcarmis.confeager.properties;

import io.github.avivcarmis.confeager.properties.utils.ConfeagerValueMapper;
import io.github.avivcarmis.confeager.properties.utils.ConfeagerPropertyPrimitiveArray;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerPropertyBooleanArray extends ConfeagerPropertyPrimitiveArray<Boolean> {

    public ConfeagerPropertyBooleanArray(String key) {
        super(key, ConfeagerValueMapper.BOOLEAN_MAPPER, Boolean.class);
    }

    public ConfeagerPropertyBooleanArray(String key, Boolean[] defaultValue, Class<Boolean> booleanClass) {
        super(key, defaultValue, ConfeagerValueMapper.BOOLEAN_MAPPER, booleanClass);
    }
}
