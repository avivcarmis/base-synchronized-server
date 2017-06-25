package io.github.avivcarmis.confeager;

import java.util.List;

/**
 * Created by Mamot on 6/25/2017.
 */
class ConfeagerBinding {

    final String _prefix;

    final List<ConfeagerProperty> _properties;

    ConfeagerBinding(Object confeagerObject, ConfeagerFieldFilter fieldFilter, String prefix) {
        _prefix = prefix;
        _properties = ConfeagerReflectionUtils.findProperties(confeagerObject, fieldFilter);
    }

}
