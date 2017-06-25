package io.github.avivcarmis.confeager.properties;

import io.github.avivcarmis.confeager.properties.utils.ConfeagerValueMapper;
import io.github.avivcarmis.confeager.properties.utils.ConfeagerPropertyPrimitive;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerPropertyBoolean extends ConfeagerPropertyPrimitive<Boolean> {

    public ConfeagerPropertyBoolean(String key) {
        super(key, ConfeagerValueMapper.BOOLEAN_MAPPER);
    }

    public ConfeagerPropertyBoolean(String key, boolean defaultValue) {
        super(key, defaultValue, ConfeagerValueMapper.BOOLEAN_MAPPER);
    }
}
