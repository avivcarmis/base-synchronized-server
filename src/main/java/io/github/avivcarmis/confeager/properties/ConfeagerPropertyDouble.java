package io.github.avivcarmis.confeager.properties;

import io.github.avivcarmis.confeager.properties.utils.ConfeagerValueMapper;
import io.github.avivcarmis.confeager.properties.utils.ConfeagerPropertyPrimitive;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerPropertyDouble extends ConfeagerPropertyPrimitive<Double> {

    public ConfeagerPropertyDouble(String key) {
        super(key, ConfeagerValueMapper.DOUBLE_MAPPER);
    }

    public ConfeagerPropertyDouble(String key, double defaultValue) {
        super(key, defaultValue, ConfeagerValueMapper.DOUBLE_MAPPER);
    }
}
