package io.github.avivcarmis.confeager.sources;

import io.github.avivcarmis.confeager.ConfeagerSource;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerSourceSystemProperties extends ConfeagerSource {

    public static final ConfeagerSource INSTANCE = new ConfeagerSourceSystemProperties();

    @Override
    public String getValueOrNull(String propertyName) {
        return System.getProperty(propertyName);
    }

}
