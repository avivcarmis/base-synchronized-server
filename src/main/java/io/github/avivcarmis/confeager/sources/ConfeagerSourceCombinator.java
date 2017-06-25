package io.github.avivcarmis.confeager.sources;

import io.github.avivcarmis.confeager.ConfeagerSource;

import java.util.List;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfeagerSourceCombinator extends ConfeagerSource {

    private final List<ConfeagerSource> _sources;

    public ConfeagerSourceCombinator(List<ConfeagerSource> sources) {
        _sources = sources;
    }

    @Override
    public String getValueOrNull(String propertyName) {
        for (ConfeagerSource source : _sources) {
            String value = source.getValueOrNull(propertyName);
            if (value != null) {
                return value;
            }
        }
        return null;
    }

}
