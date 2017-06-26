package io.github.avivcarmis.confEager.sources;

import io.github.avivcarmis.confEager.ConfEagerSource;

import java.util.List;

/**
 * Created by Mamot on 6/25/2017.
 */
public class ConfEagerSourceCombinator extends ConfEagerSource {

    private final List<ConfEagerSource> _sources;

    public ConfEagerSourceCombinator(List<ConfEagerSource> sources) {
        _sources = sources;
    }

    @Override
    public String getValueOrNull(String propertyName) {
        for (ConfEagerSource source : _sources) {
            String value = source.getValueOrNull(propertyName);
            if (value != null) {
                return value;
            }
        }
        return null;
    }

}
