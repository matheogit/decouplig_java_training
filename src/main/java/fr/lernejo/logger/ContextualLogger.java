package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger{
    Logger delegateLogger;
    String callerClass;

    public ContextualLogger(String class_name, Logger logger) {
        this.callerClass = class_name;
        this.delegateLogger = logger;
    }

    public void log(String message) {
        delegateLogger.log(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")) + " " + callerClass + " " + message);
    }
}
