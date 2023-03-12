package osgi.logger;

public class Logger {

    String moduleName;

    public Logger() {
        this.moduleName = "Module Logger";
    }

    public Logger(String moduleName) {
        this.moduleName = moduleName;
    }

    public void info(String message) {
        System.out.println("["+moduleName + "] - " + message);
    }

    public void error(String message) {
        System.err.println("["+moduleName + "] - " + message);
    }

    public void debug(String message) {
        System.out.println("["+moduleName + "] - " + message);
    }

    public void trace(String message) {
        System.out.println("["+moduleName + "] - " + message);
    }

    public void warn(String message) {
        System.out.println("["+moduleName + "] - " + message);
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getModuleName() {
        return moduleName;
    }
}
