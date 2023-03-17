package osgi.jsonparser;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator
{
	ServiceRegistration<?> registration;
	
    public void start(BundleContext context)
    {
        Hashtable<String, String> props = new Hashtable<String, String>();
        context.registerService(
            JSONParser.class.getName(), new JSONParserImpl(), props);
		System.out.println("JSON parser service registered and started successfully");	
    }

    public void stop(BundleContext context)
    {
    	registration.unregister();
    	System.out.println("JSON parser service unregistered successfully");	
    }
}