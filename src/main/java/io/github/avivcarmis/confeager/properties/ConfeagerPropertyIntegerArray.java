package io.github.avivcarmis.confeager.properties;

import io.github.avivcarmis.confeager.properties.utils.ConfeagerValueMapper;
import io.github.avivcarmis.confeager.properties.utils.ConfeagerPropertyPrimitiveArray;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerPropertyIntegerArray extends ConfeagerPropertyPrimitiveArray<Integer> {

    public ConfeagerPropertyIntegerArray(String key) {
        super(key, ConfeagerValueMapper.INTEGER_MAPPER, Integer.class);
    }

    public ConfeagerPropertyIntegerArray(String key, Integer[] defaultValue, Class<Integer> integerClass) {
        super(key, defaultValue, ConfeagerValueMapper.INTEGER_MAPPER, integerClass);
    }
}
