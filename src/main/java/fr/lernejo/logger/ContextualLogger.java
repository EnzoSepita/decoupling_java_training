package fr.lernejo.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContextualLogger implements Logger {
    private final DateTimeFormatter time = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    private Logger logger2;
    private String name_class;
    public ContextualLogger(String name, Logger logger){
        this.logger2 = logger;
        this.name_class = name;
    }
    @Override
    public void log(String message) {
        logger2.log(LocalDateTime.now().format(time) + " " + name_class + " " + message);
    }


}
