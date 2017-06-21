import ch.qos.logback.core.*
import ch.qos.logback.core.rolling.*
import ch.qos.logback.classic.encoder.PatternLayoutEncoder

//def logDir
//def logLevel
//def onlySTDOut
logDir = "C:\\Users\\Mamot\\Desktop\\1"
logLevel = INFO
onlySTDOut = false
//try {
//    logDir = MachineConfig.LOG_DIR.get()
//    logLevel = MachineConfig.LOG_LEVEL.get()
//    allowGreyLog = MachineConfig.ENV.get() == MachineConfig.Environment.PRODUCTION
//    onlySTDOut = logDir == null || logDir.isEmpty()
//} catch (ignored) {
//    logDir = "C:\\Users\\Mamot\\Desktop\\1"
//    logLevel = LogLevel.INFO
//    onlySTDOut = true
//    allowGreyLog = false
//}

if (!onlySTDOut) {
    def archiveBase = "${logDir}/archive"
    appender("FLOW_LOG_FILE", RollingFileAppender) {
        file = "${logDir}/flow.log"
        rollingPolicy(TimeBasedRollingPolicy) {
            fileNamePattern = "${archiveBase}/%d{yyyy-MM-dd}-flow.log"
            maxHistory = 5
        }
        encoder(PatternLayoutEncoder) {
            pattern = "[%level] - %date{yyyy-MM-dd HH:mm:ss} - %logger{0} - %thread - %X %n%message%n%xException"
        }
    }
    appender("ERROR_LOG_FILE", RollingFileAppender) {
        file = "${logDir}/error.log"
        rollingPolicy(TimeBasedRollingPolicy) {
            fileNamePattern = "${archiveBase}/%d{yyyy-MM-dd}-error.log"
            maxHistory = 5
        }
        encoder(PatternLayoutEncoder) {
            pattern = "[%level] - %date{yyyy-MM-dd HH:mm:ss} - %logger{0} - %thread - %X %n%message%n%xException"
        }
    }
    appender("SYSTEM_LOG_FILE", RollingFileAppender) {
        file = "${logDir}/system.log"
        rollingPolicy(TimeBasedRollingPolicy) {
            fileNamePattern = "${archiveBase}/%d{yyyy-MM-dd}-system.log"
            maxHistory = 2
        }
        encoder(PatternLayoutEncoder) {
            pattern = "[%level] - %date{yyyy-MM-dd HH:mm:ss} - %logger - %message%n%xException{5}"
        }
    }
    appender("LIBS_LOG_FILE", RollingFileAppender) {
        file = "${logDir}/libs.log"
        rollingPolicy(TimeBasedRollingPolicy) {
            fileNamePattern = "${archiveBase}/%d{yyyy-MM-dd}-libs.log"
            maxHistory = 2
        }
        encoder(PatternLayoutEncoder) {
            pattern = "[%level] - %date{yyyy-MM-dd HH:mm:ss} - %logger{0} - %thread - %X %n%message%n%xException"
        }
    }
}

appender("STDOUT", ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        pattern = "[%level] - %date{yyyy-MM-dd HH:mm:ss} - %logger - %X - %message%n%xException{5}"
    }
}

def declareLogger(String loggerName, List<String> appenderNames) {
    if (onlySTDOut) {
        appenderNames = ["STDOUT"]
    }
    else {
        appenderNames.add("STDOUT")
    }
    logger(loggerName, logLevel, appenderNames, false)
}

// internal logs
declareLogger("FLOW_LOGGER", ["FLOW_LOG_FILE"])
declareLogger("ERROR_LOGGER", ["ERROR_LOG_FILE"])
declareLogger("SYSTEM_LOGGER", ["SYSTEM_LOG_FILE"])
declareLogger("LIBS_LOGGER", ["LIBS_LOG_FILE"])

// external logs
declareLogger("io.github.avivcarmis.trafficante.core.BasicEndpoint", ["FLOW_LOG_FILE"])
declareLogger("io.github.avivcarmis.trafficante", ["LIBS_LOG_FILE"])
declareLogger("org.springframework", ["LIBS_LOG_FILE", "SYSTEM_LOG_FILE"])
declareLogger("ch.qos.logback", ["LIBS_LOG_FILE", "SYSTEM_LOG_FILE"])
declareLogger("com.codahale.metrics", ["LIBS_LOG_FILE"])

root(WARN, ["STDOUT"])