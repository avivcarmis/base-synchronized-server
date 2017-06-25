package io.github.avivcarmis.confeager.properties;

import io.github.avivcarmis.confeager.properties.utils.ConfeagerValueMapper;
import io.github.avivcarmis.confeager.properties.utils.ConfeagerPropertyPrimitiveArray;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerPropertyStringArray extends ConfeagerPropertyPrimitiveArray<String> {

    public ConfeagerPropertyStringArray(String key) {
        super(key, ConfeagerValueMapper.STRING_MAPPER, String.class);
    }

    public ConfeagerPropertyStringArray(String key, String[] defaultValue, Class<String> stringClass) {
        super(key, defaultValue, ConfeagerValueMapper.STRING_MAPPER, stringClass);
    }
}
