package io.github.avivcarmis.confEager;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Created by Mamot on 6/25/2017.
 */
public interface ConfEagerFieldFilter {

    boolean test(Field field);

    ConfEagerFieldFilter NON_STATIC = field -> !Modifier.isStatic(field.getModifiers());

    ConfEagerFieldFilter ONLY_STATIC = field -> Modifier.isStatic(field.getModifiers());

}
