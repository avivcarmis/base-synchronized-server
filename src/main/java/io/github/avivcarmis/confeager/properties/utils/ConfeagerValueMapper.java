package io.github.avivcarmis.confeager.properties.utils;

/**
 * Created by Mamot on 6/25/2017.
 */
public interface ConfeagerValueMapper<OUTPUT> {

    OUTPUT map(String input);

    ConfeagerValueMapper<String> STRING_MAPPER = input -> input;

    ConfeagerValueMapper<Boolean> BOOLEAN_MAPPER = input -> {
        if (input.trim().equals("true")) {
            return true;
        }
        if (input.trim().equals("false")) {
            return false;
        }
        throw new IllegalArgumentException("boolean cannot be parsed from: " + input);
    };

    ConfeagerValueMapper<Integer> INTEGER_MAPPER = Integer::valueOf;

    ConfeagerValueMapper<Long> LONG_MAPPER = Long::valueOf;

    ConfeagerValueMapper<Float> FLOAT_MAPPER = Float::valueOf;

    ConfeagerValueMapper<Double> DOUBLE_MAPPER = Double::valueOf;

}
