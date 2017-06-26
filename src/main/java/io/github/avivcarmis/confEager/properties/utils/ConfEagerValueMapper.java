package io.github.avivcarmis.confEager.properties.utils;

/**
 * Created by Mamot on 6/25/2017.
 */
public interface ConfEagerValueMapper<OUTPUT> {

    OUTPUT map(String input);

    ConfEagerValueMapper<String> STRING_MAPPER = input -> input;

    ConfEagerValueMapper<Boolean> BOOLEAN_MAPPER = input -> {
        if (input.trim().equals("true")) {
            return true;
        }
        if (input.trim().equals("false")) {
            return false;
        }
        throw new IllegalArgumentException("boolean cannot be parsed from: " + input);
    };

    ConfEagerValueMapper<Integer> INTEGER_MAPPER = Integer::valueOf;

    ConfEagerValueMapper<Long> LONG_MAPPER = Long::valueOf;

    ConfEagerValueMapper<Float> FLOAT_MAPPER = Float::valueOf;

    ConfEagerValueMapper<Double> DOUBLE_MAPPER = Double::valueOf;

}
