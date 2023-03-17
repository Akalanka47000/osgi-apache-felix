package osgi.core;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.util.tracker.ServiceTracker;

import osgi.http.client.*;

public class Activator implements BundleActivator
{

    private BundleContext m_context = null;

    private ServiceTracker m_tracker = null;

    public void start(BundleContext context) throws InvalidSyntaxException
    {
        m_context = context;
        m_tracker = new ServiceTracker(
            m_context,
            m_context.createFilter(
                "(&(objectClass=" + HttpClient.class.getName() + "))"),
            null);
        m_tracker.open();
		try {
            System.out.println("Fetching data for todos.....");
            HttpClient client = (HttpClient) m_tracker.getService();
            HttpResponse res = client.get("https://jsonplaceholder.typicode.com/todos/1");
            System.out.println(res.getStatus());
            System.out.println(res.getData());
        } catch (Exception ex) { 
            System.out.println("Failed to fetch todos.");
        }
    }

    public void stop(BundleContext context)
    {
    	System.out.println("Core bundle unregistered successfully");	
    }
}