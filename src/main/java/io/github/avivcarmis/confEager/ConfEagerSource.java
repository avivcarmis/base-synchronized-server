package io.github.avivcarmis.confEager;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mamot on 6/25/2017.
 */
abstract public class ConfEagerSource {

    private static final String DEFAULT_ENVIRONMENT = "";

    private static final ConfEagerFieldFilter DEFAULT_FIELD_FILTER = ConfEagerFieldFilter.NON_STATIC;

    private final List<ConfEagerBinding> _confEagerBindings;

    public ConfEagerSource() {
        _confEagerBindings = new LinkedList<>();
    }

    public <T extends ConfEager> T bind(Class<T> confEagerObjectClass, String environment, ConfEagerFieldFilter fieldFilter) {
        T t;
        try {
            t = confEagerObjectClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("could not instantiate confEager object class", e);
        }
        bind(t, environment, fieldFilter);
        return t;
    }

    public <T extends ConfEager> T bind(Class<T> confEagerObjectClass, String environment) {
        return bind(confEagerObjectClass, environment, DEFAULT_FIELD_FILTER);
    }

    public <T extends ConfEager> T bind(Class<T> confEagerObjectClass) {
        return bind(confEagerObjectClass, DEFAULT_ENVIRONMENT, DEFAULT_FIELD_FILTER);
    }

    public <T extends ConfEager> T bind(Class<T> confEagerObjectClass, ConfEagerFieldFilter fieldFilter) {
        return bind(confEagerObjectClass, DEFAULT_ENVIRONMENT, fieldFilter);
    }

    public void bind(ConfEager confEagerObjectClass, String environment, ConfEagerFieldFilter fieldFilter) {
        ConfEagerBinding binding = new ConfEagerBinding(confEagerObjectClass, fieldFilter, environment);
        _confEagerBindings.add(binding);
        populate(binding);
    }

    public void bind(ConfEager confEagerObject, String environment) {
        bind(confEagerObject, environment, DEFAULT_FIELD_FILTER);
    }

    public void bind(ConfEager confEagerObject, ConfEagerFieldFilter fieldFilter) {
        bind(confEagerObject, DEFAULT_ENVIRONMENT, fieldFilter);
    }

    public void bind(ConfEager confEagerObject) {
        bind(confEagerObject, DEFAULT_ENVIRONMENT, DEFAULT_FIELD_FILTER);
    }

    protected void notifyUpdate() {
        for (ConfEagerBinding confEagerBinding : _confEagerBindings) {
            populate(confEagerBinding);
        }
    }

    private void populate(ConfEagerBinding binding) {
        List<String> missingProperties = new LinkedList<>();
        for (ConfEagerProperty property : binding._properties) {
            String propertyName = binding._prefix + property.getPropertyName();
            String value = getValueOrNull(propertyName);
            if (value == null) {
                if (property.isRequired()) {
                    missingProperties.add("`" + propertyName + "`");
                }
            }
            else {
                property.update(value);
            }
        }
        if (missingProperties.size() > 0) {
            throw new RuntimeException("the following required config properties are missing from " +
                    getClass().getSimpleName() + ": " + String.join(", ", missingProperties));
        }
    }

    abstract public String getValueOrNull(String propertyName);

}
