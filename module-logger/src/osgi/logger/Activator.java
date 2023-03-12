package osgi.logger;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator
{
    public void start(BundleContext context)
    {
        Hashtable<String, String> props = new Hashtable<String, String>();
        context.registerService(
            Logger.class.getName(), new Logger(), props);
		System.out.println("Logger service registered and started successfully");	
    }

    public void stop(BundleContext context)
    {
    	System.out.println("Logger service unregistered successfully");	
    }
}