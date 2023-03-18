package osgi.http.client;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTracker;

import osgi.jsonparser.*;

public class Activator implements BundleActivator
{

    private BundleContext m_context = null;
    private ServiceTracker<Object, Object> m_tracker = null;
    
    ServiceRegistration<?> registration;

    public void start(BundleContext context) throws InvalidSyntaxException
    {
        m_context = context;
        m_tracker = new ServiceTracker<Object, Object>(m_context, m_context.createFilter("(&(objectClass=" + JSONParser.class.getName() + "))"), null);
        m_tracker.open();

        ServiceMap.setService("json-parser", (JSONParser) m_tracker.getService());

        Hashtable<String, String> props = new Hashtable<String, String>();
        registration = context.registerService(
            HttpClient.class.getName(), new HttpClientImpl(), props);
		System.out.println("Http client service registered and started successfully");	
    }

    public void stop(BundleContext context)
    {
    	registration.unregister();
    	System.out.println("Http client service unregistered successfully");	
    }
}