package io.github.avivcarmis.confEager;

/**
 * Created by Mamot on 6/26/2017.
 */
abstract public class ConfEager {

    protected static <T> DefaultValue<T> defaultValue(T value) {
        return new DefaultValue<>(value);
    }

    protected static PropertyName propertyName(String name) {
        return new PropertyName(name);
    }

    public static class DefaultValue<T> {

        private final T _value;

        private DefaultValue(T value) {
            _value = value;
        }

        T getValue() {
            return _value;
        }

    }

    public static class PropertyName {

        private final String _name;

        private PropertyName(String name) {
            _name = name;
        }

        String getName() {
            return _name;
        }

    }

}
