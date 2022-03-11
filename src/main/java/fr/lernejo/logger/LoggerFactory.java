package fr.lernejo.logger;

public class LoggerFactory {

    public static Logger getLogger(String name){

        Logger temp = new ContextualLogger(name, new FilteredLogger(new ConsoleLogger(), message->message.contains("Simulation")));

        return temp;
    }

}
