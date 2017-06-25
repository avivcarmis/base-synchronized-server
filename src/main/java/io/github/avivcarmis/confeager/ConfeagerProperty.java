package io.github.avivcarmis.confeager;

import io.github.avivcarmis.confeager.properties.ConfeagerPropertyString;

/**
 * Created by avivc on 1/22/2017.
 */
abstract public class ConfeagerProperty<T> {

    private final String _key;

    private final boolean _required;

    private boolean _populated;

    private T _value;

    public ConfeagerProperty(String key) {
        _key = key;
        _required = true;
        _populated = false;
        _value = null;
    }

    public ConfeagerProperty(String key, T defaultValue) {
        _key = key;
        _required = false;
        _populated = true;
        _value = defaultValue;
    }

    public T get() {
        if (!_populated) {
            throw new RuntimeException("confeager property not populated before read");
        }
        return _value;
    }

    void update(java.lang.String value) {
        this._value = map(value);
        _populated = true;
    }

    String getKey() {
        return _key;
    }

    boolean isRequired() {
        return _required;
    }

    abstract protected T map(java.lang.String value);

}
