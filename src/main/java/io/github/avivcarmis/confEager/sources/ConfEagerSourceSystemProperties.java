package io.github.avivcarmis.confEager.sources;

import io.github.avivcarmis.confEager.ConfEagerSource;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfEagerSourceSystemProperties extends ConfEagerSource {

    public static final ConfEagerSource INSTANCE = new ConfEagerSourceSystemProperties();

    @Override
    public String getValueOrNull(String propertyName) {
        return System.getProperty(propertyName);
    }

}
