package io.github.avivcarmis.confEager;

import io.github.avivcarmis.trafficante.core.BasicEndpoint;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.*;
import java.util.*;

class ConfEagerReflectionUtils {

    // Constants

    private static final Log LOG = LogFactory.getLog(BasicEndpoint.class);

    // Static

    static List<ConfEagerProperty> findProperties(ConfEager confEagerObject, ConfEagerFieldFilter filter) {
        List<ConfEagerProperty> result = new LinkedList<>();
        Class<?> currentClass = confEagerObject.getClass();
        while (currentClass != null && !currentClass.equals(Object.class)) {
            Field[] currentClassFields = currentClass.getDeclaredFields();
            for (Field field : currentClassFields) {
                ConfEagerProperty property = validatePropertyField(filter, confEagerObject, field);
                if (property != null) {
                    result.add(property);
                }
            }
            currentClass = currentClass.getSuperclass();
        }
        return result;
    }

    private static ConfEagerProperty validatePropertyField(ConfEagerFieldFilter filter, ConfEager object, Field field) {
        if (!filter.test(field) || !ConfEagerProperty.class.isAssignableFrom(field.getType())) {
            return null;
        }
        field.setAccessible(true);
        Object value;
        try {
            value = field.get(object);
        } catch (IllegalAccessException e) {
            LOG.error("could not access property " + field.getName() + " on confEager class " +
                    object.getClass().getSimpleName(), e);
            return null;
        }
        if (value == null) {
            LOG.error("property " + field.getName() + " on confEager class " + object.getClass().getSimpleName() +
                    " must not be null to be populated");
            return null;
        }
        ConfEagerProperty result = (ConfEagerProperty) value;
        result.setFieldName(field.getName());
        return result;
    }

}