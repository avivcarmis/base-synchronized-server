package io.github.avivcarmis.confeager;

import io.github.avivcarmis.trafficante.core.BasicEndpoint;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.*;
import java.util.*;

class ConfeagerReflectionUtils {

    // Constants

    private static final Log LOG = LogFactory.getLog(BasicEndpoint.class);

    // Static

    static List<ConfeagerProperty> findProperties(Object confeagerObject, ConfeagerFieldFilter filter) {
        List<ConfeagerProperty> result = new LinkedList<>();
        Class<?> currentClass = confeagerObject.getClass();
        while (currentClass != null && !currentClass.equals(Object.class)) {
            Field[] currentClassFields = currentClass.getDeclaredFields();
            for (Field field : currentClassFields) {
                ConfeagerProperty property = validatePropertyField(filter, confeagerObject, field);
                if (property != null) {
                    result.add(property);
                }
            }
            currentClass = currentClass.getSuperclass();
        }
        return result;
    }

    private static ConfeagerProperty validatePropertyField(ConfeagerFieldFilter filter, Object object, Field field) {
        if (!filter.test(field) || !ConfeagerProperty.class.isAssignableFrom(field.getType())) {
            return null;
        }
        field.setAccessible(true);
        Object value;
        try {
            value = field.get(object);
        } catch (IllegalAccessException e) {
            LOG.error("could not access property " + field.getName() + " on confeager class " +
                    object.getClass().getSimpleName(), e);
            return null;
        }
        if (value == null) {
            LOG.error("property " + field.getName() + " on confeager class " + object.getClass().getSimpleName() +
                    " must not be null to be populated");
        }
        return (ConfeagerProperty) value;
    }

}