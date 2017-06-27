package com.example.config;

import ch.qos.logback.classic.Level;
import io.github.avivcarmis.confEager.ConfEager;
import io.github.avivcarmis.confEager.properties.ConfEagerPropertyBoolean;
import io.github.avivcarmis.confEager.properties.ConfEagerPropertyEnum;
import io.github.avivcarmis.confEager.properties.ConfEagerPropertyInteger;
import io.github.avivcarmis.confEager.properties.ConfEagerPropertyString;

/**
 * Created by Mamot on 6/25/2017.
 */
public class LocalConfig extends ConfEager {

    // identity

    public final ConfEagerPropertyEnum<Environment> environment = new ConfEagerPropertyEnum<>(Environment.class, false, defaultValue(Environment.DEV));

    public final ConfEagerPropertyString machineId = new ConfEagerPropertyString(defaultValue("local"));

    // logs

    public final ConfEagerPropertyString loggingDir = new ConfEagerPropertyString(defaultValue(""));

    public final ConfEagerPropertyEnum<LoggingLevel> logLevel = new ConfEagerPropertyEnum<>(LoggingLevel.class, false, defaultValue(LoggingLevel.INFO));

    // server

    public final ConfEagerPropertyString host = new ConfEagerPropertyString(defaultValue("0.0.0.0"));

    public final ConfEagerPropertyInteger port = new ConfEagerPropertyInteger(defaultValue(8080));

    public final ConfEagerPropertyBoolean enableSwagger = new ConfEagerPropertyBoolean(defaultValue(true));

    // enums

    public enum LoggingLevel {

        OFF(Level.OFF),
        ERROR(Level.ERROR),
        WARN(Level.WARN),
        INFO(Level.INFO),
        DEBUG(Level.DEBUG),
        TRACE(Level.TRACE),
        ALL(Level.ALL);

        public final Level level;

        LoggingLevel(Level level) {
            this.level = level;
        }

    }

    public enum Environment {
        DEV, STAGING, PRODUCTION
    }

}
