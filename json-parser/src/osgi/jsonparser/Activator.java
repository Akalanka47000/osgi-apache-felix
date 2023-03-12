package osgi.jsonparser;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator
{
    public void start(BundleContext context)
    {
        Hashtable<String, String> props = new Hashtable<String, String>();
        context.registerService(
            JSONParser.class.getName(), new JSONParser(), props);
		System.out.println("JSON parser service registered and started successfully");	
    }

    public void stop(BundleContext context)
    {
    	System.out.println("JSON parser service unregistered successfully");	
    }
}