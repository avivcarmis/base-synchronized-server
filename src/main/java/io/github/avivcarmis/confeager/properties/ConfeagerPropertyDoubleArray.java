package io.github.avivcarmis.confeager.properties;

import io.github.avivcarmis.confeager.properties.utils.ConfeagerValueMapper;
import io.github.avivcarmis.confeager.properties.utils.ConfeagerPropertyPrimitiveArray;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerPropertyDoubleArray extends ConfeagerPropertyPrimitiveArray<Double> {

    public ConfeagerPropertyDoubleArray(String key) {
        super(key, ConfeagerValueMapper.DOUBLE_MAPPER, Double.class);
    }

    public ConfeagerPropertyDoubleArray(String key, Double[] defaultValue, Class<Double> doubleClass) {
        super(key, defaultValue, ConfeagerValueMapper.DOUBLE_MAPPER, doubleClass);
    }
}
