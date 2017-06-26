package io.github.avivcarmis.confEager;

import java.util.List;

/**
 * Created by Mamot on 6/25/2017.
 */
class ConfEagerBinding {

    final String _prefix;

    final List<ConfEagerProperty> _properties;

    ConfEagerBinding(ConfEager confEagerObject, ConfEagerFieldFilter fieldFilter, String prefix) {
        _prefix = prefix;
        _properties = ConfEagerReflectionUtils.findProperties(confEagerObject, fieldFilter);
    }

}
