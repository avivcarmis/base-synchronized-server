package io.github.avivcarmis.confeager.properties;

import io.github.avivcarmis.confeager.properties.utils.ConfeagerValueMapper;
import io.github.avivcarmis.confeager.properties.utils.ConfeagerPropertyPrimitiveArray;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerPropertyLongArray extends ConfeagerPropertyPrimitiveArray<Long> {

    public ConfeagerPropertyLongArray(String key) {
        super(key, ConfeagerValueMapper.LONG_MAPPER, Long.class);
    }

    public ConfeagerPropertyLongArray(String key, Long[] defaultValue, Class<Long> longClass) {
        super(key, defaultValue, ConfeagerValueMapper.LONG_MAPPER, longClass);
    }
}
