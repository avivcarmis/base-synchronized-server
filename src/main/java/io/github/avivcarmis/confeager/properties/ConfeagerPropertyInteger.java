package io.github.avivcarmis.confeager.properties;

import io.github.avivcarmis.confeager.properties.utils.ConfeagerValueMapper;
import io.github.avivcarmis.confeager.properties.utils.ConfeagerPropertyPrimitive;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerPropertyInteger extends ConfeagerPropertyPrimitive<Integer> {

    public ConfeagerPropertyInteger(String key) {
        super(key, ConfeagerValueMapper.INTEGER_MAPPER);
    }

    public ConfeagerPropertyInteger(String key, int defaultValue) {
        super(key, defaultValue, ConfeagerValueMapper.INTEGER_MAPPER);
    }
}
