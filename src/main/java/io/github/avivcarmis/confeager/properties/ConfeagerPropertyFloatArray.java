package io.github.avivcarmis.confeager.properties;

import io.github.avivcarmis.confeager.properties.utils.ConfeagerValueMapper;
import io.github.avivcarmis.confeager.properties.utils.ConfeagerPropertyPrimitiveArray;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerPropertyFloatArray extends ConfeagerPropertyPrimitiveArray<Float> {

    public ConfeagerPropertyFloatArray(String key) {
        super(key, ConfeagerValueMapper.FLOAT_MAPPER, Float.class);
    }

    public ConfeagerPropertyFloatArray(String key, Float[] defaultValue, Class<Float> floatClass) {
        super(key, defaultValue, ConfeagerValueMapper.FLOAT_MAPPER, floatClass);
    }
}
