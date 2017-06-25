package io.github.avivcarmis.confeager.sources;

import io.github.avivcarmis.confeager.ConfeagerSource;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerSourceEnvironmentVariables extends ConfeagerSource {

    public static final ConfeagerSource INSTANCE = new ConfeagerSourceEnvironmentVariables();

    @Override
    public String getValueOrNull(String propertyName) {
        return System.getenv(propertyName);
    }

}
