package io.github.avivcarmis.confeager.properties;

import io.github.avivcarmis.confeager.properties.utils.ConfeagerValueMapper;
import io.github.avivcarmis.confeager.properties.utils.ConfeagerPropertyPrimitive;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerPropertyFloat extends ConfeagerPropertyPrimitive<Float> {

    public ConfeagerPropertyFloat(String key) {
        super(key, ConfeagerValueMapper.FLOAT_MAPPER);
    }

    public ConfeagerPropertyFloat(String key, float defaultValue) {
        super(key, defaultValue, ConfeagerValueMapper.FLOAT_MAPPER);
    }
}
