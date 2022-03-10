package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name){
        Logger temp = new ConsoleLogger();

        return temp;
    }

}
