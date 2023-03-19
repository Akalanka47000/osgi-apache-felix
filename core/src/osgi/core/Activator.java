package osgi.core;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;

import osgi.http.client.*;
import osgi.core.Core;

public class Activator implements BundleActivator
{

    @SuppressWarnings("unchecked")
	public void start(BundleContext context) throws InvalidSyntaxException
    {
        try {
            Core.run(context);
        } catch (Exception ex) { 
            System.out.println("Failed to fetch todos.");
        }
    }

    public void stop(BundleContext context)
    {
    	System.out.println("Core bundle unregistered successfully");	
    }
}