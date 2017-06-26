package com.example.config;

import ch.qos.logback.classic.Level;
import io.github.avivcarmis.confeager.properties.ConfeagerPropertyBoolean;
import io.github.avivcarmis.confeager.properties.ConfeagerPropertyEnumCI;
import io.github.avivcarmis.confeager.properties.ConfeagerPropertyInteger;
import io.github.avivcarmis.confeager.properties.ConfeagerPropertyString;

/**
 * Created by Mamot on 6/25/2017.
 */
public class LocalConfig {

    // identity

    public final ConfeagerPropertyEnumCI<Environment> environment = new ConfeagerPropertyEnumCI<>(
            "environment", Environment.class, Environment.DEV);

    public final ConfeagerPropertyString machineId = new ConfeagerPropertyString("machineId", "local");

    // logs

    public final ConfeagerPropertyString loggingDir = new ConfeagerPropertyString("loggingDir", "");

    public final ConfeagerPropertyEnumCI<LoggingLevel> logLevel = new ConfeagerPropertyEnumCI<>(
            "logLevel", LoggingLevel.class, LoggingLevel.INFO);

    // server

    public final ConfeagerPropertyString host = new ConfeagerPropertyString("host", "0.0.0.0");

    public final ConfeagerPropertyInteger port = new ConfeagerPropertyInteger("port", 8080);

    public final ConfeagerPropertyBoolean enableSwagger = new ConfeagerPropertyBoolean(
            "enableSwagger", true);

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
