package io.github.avivcarmis.confeager;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Mamot on 6/25/2017.
 */
public interface ConfeagerFieldFilter {

    boolean test(Field field);

    ConfeagerFieldFilter NON_STATIC = field -> !Modifier.isStatic(field.getModifiers());

    ConfeagerFieldFilter ONLY_STATIC = field -> Modifier.isStatic(field.getModifiers());

}
