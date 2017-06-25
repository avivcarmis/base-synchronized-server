package io.github.avivcarmis.confeager;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Mamot on 6/25/2017.
 */
abstract public class ConfeagerSource {

    private static final String DEFAULT_ENVIRONMENT = "";

    private static final ConfeagerFieldFilter DEFAULT_FIELD_FILTER = ConfeagerFieldFilter.NON_STATIC;

    private final List<ConfeagerBinding> _confeagerBindings;

    public ConfeagerSource() {
        _confeagerBindings = new LinkedList<>();
    }

    public <T> T bind(Class<T> confeagerObjectClass, String environment, ConfeagerFieldFilter fieldFilter) {
        T t;
        try {
            t = confeagerObjectClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("could not instantiate confeager object class", e);
        }
        bind(t, environment, fieldFilter);
        return t;
    }

    public <T> T bind(Class<T> confeagerObjectClass, String environment) {
        return bind(confeagerObjectClass, environment, DEFAULT_FIELD_FILTER);
    }

    public <T> T bind(Class<T> confeagerObjectClass) {
        return bind(confeagerObjectClass, DEFAULT_ENVIRONMENT, DEFAULT_FIELD_FILTER);
    }

    public <T> T bind(Class<T> confeagerObjectClass, ConfeagerFieldFilter fieldFilter) {
        return bind(confeagerObjectClass, DEFAULT_ENVIRONMENT, fieldFilter);
    }

    public void bind(Object confeagerObject, String environment, ConfeagerFieldFilter fieldFilter) {
        ConfeagerBinding binding = new ConfeagerBinding(confeagerObject, fieldFilter, environment);
        _confeagerBindings.add(binding);
        populate(binding);
    }

    public void bind(Object confeagerObject, String environment) {
        bind(confeagerObject, environment, DEFAULT_FIELD_FILTER);
    }

    public void bind(Object confeagerObject, ConfeagerFieldFilter fieldFilter) {
        bind(confeagerObject, DEFAULT_ENVIRONMENT, fieldFilter);
    }

    public void bind(Object confeagerObject) {
        bind(confeagerObject, DEFAULT_ENVIRONMENT, DEFAULT_FIELD_FILTER);
    }

    protected void notifyUpdate() {
        for (ConfeagerBinding confeagerBinding : _confeagerBindings) {
            populate(confeagerBinding);
        }
    }

    private void populate(ConfeagerBinding binding) {
        List<String> missingProperties = new LinkedList<>();
        for (ConfeagerProperty property : binding._properties) {
            String propertyName = binding._prefix + property.getKey();
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
