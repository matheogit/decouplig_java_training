package fr.lernejo.logger;

public class CompositeLogger implements Logger{
    Logger logger_1;
    Logger logger_2;

    public CompositeLogger(Logger logger_1, Logger logger_2) {
        this.logger_1 = logger_1;
        this.logger_2 = logger_2;
    }

    public void log(String message) {
        this.logger_1.log(message);
        this.logger_2.log(message);
    }
}
