package com.example;

import ch.qos.logback.classic.Level;
import io.github.avivcarmis.confeager.ConfeagerProperty;
import io.github.avivcarmis.confeager.properties.ConfeagerPropertyBoolean;
import io.github.avivcarmis.confeager.properties.ConfeagerPropertyCaseInsensitiveEnum;
import io.github.avivcarmis.confeager.properties.ConfeagerPropertyInteger;
import io.github.avivcarmis.confeager.properties.ConfeagerPropertyString;

/**
 * Created by Mamot on 6/25/2017.
 */
public class LocalConfig {

    public final ConfeagerPropertyString loggingDir = new ConfeagerPropertyString("loggingDir", "");

    public final ConfeagerPropertyCaseInsensitiveEnum<LoggingLevel> logLevel =
            new ConfeagerPropertyCaseInsensitiveEnum<>("logLevel", LoggingLevel.class, LoggingLevel.INFO);

    public final ConfeagerPropertyString host = new ConfeagerPropertyString("host", "0.0.0.0");

    public final ConfeagerPropertyInteger port = new ConfeagerPropertyInteger("port", 8080);

    public final ConfeagerPropertyBoolean enableSwagger = new ConfeagerPropertyBoolean("enableSwagger", true);

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

}
