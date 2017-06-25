package io.github.avivcarmis.confeager.properties;

import io.github.avivcarmis.confeager.properties.utils.ConfeagerValueMapper;
import io.github.avivcarmis.confeager.properties.utils.ConfeagerPropertyPrimitive;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerPropertyLong extends ConfeagerPropertyPrimitive<Long> {

    public ConfeagerPropertyLong(String key) {
        super(key, ConfeagerValueMapper.LONG_MAPPER);
    }

    public ConfeagerPropertyLong(String key, long defaultValue) {
        super(key, defaultValue, ConfeagerValueMapper.LONG_MAPPER);
    }
}
