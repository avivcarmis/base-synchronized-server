package io.github.avivcarmis.confeager.properties;

import io.github.avivcarmis.confeager.properties.utils.ConfeagerValueMapper;
import io.github.avivcarmis.confeager.properties.utils.ConfeagerPropertyPrimitive;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerPropertyString extends ConfeagerPropertyPrimitive<String> {

    public ConfeagerPropertyString(String key) {
        super(key, ConfeagerValueMapper.STRING_MAPPER);
    }

    public ConfeagerPropertyString(String key, java.lang.String defaultValue) {
        super(key, defaultValue, ConfeagerValueMapper.STRING_MAPPER);
    }

}
