package osgi.http.client;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceEvent;

import osgi.http.client.core.*;
import osgi.http.client.services.*;

public class Activator implements BundleActivator
{
    public void start(BundleContext context)
    {
        Hashtable<String, String> props = new Hashtable<String, String>();
        context.registerService(
            HttpClient.class.getName(), new HttpClientImpl(), props);
		System.out.println("Http client service registered and started successfully");	
    }

    public void stop(BundleContext context)
    {
        // NOTE: The service is automatically unregistered.
    }
}