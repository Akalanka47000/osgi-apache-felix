package osgi.intervalexecutor;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator
{
    public void start(BundleContext context)
    {
        Hashtable<String, String> props = new Hashtable<String, String>();
        context.registerService(
            IIntervalExecutor.class.getName(), new IntervalExecutor(), props);
		System.out.println("Interval Executor service registered and started successfully");	
    }

    public void stop(BundleContext context)
    {
    	System.out.println("Interval Executor service unregistered successfully");	
    }
}