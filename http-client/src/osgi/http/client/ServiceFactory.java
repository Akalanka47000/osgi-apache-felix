package osgi.http.client;

import java.util.HashMap;

public class ServiceFactory {

    private static HashMap<String, Object> services = new HashMap<String, Object>();

    public static Object getService(String serviceName) {
        return services.get(serviceName);
    }

    public static Object setService(String serviceName, Object service) {
        return services.put(serviceName, service);
    }
}
