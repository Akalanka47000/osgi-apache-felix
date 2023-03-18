package osgi.commands;

import java.io.Serializable;

import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import osgi.command.ICommand;
import osgi.http.client.HttpClient;
import osgi.http.client.HttpResponse;

public class CatFactFetch implements ICommand, Serializable {

	@Override
	public void execute(BundleContext context) {
		System.out.println("execute");
		
		BundleContext m_context = null;
	    ServiceTracker<?, ?> m_tracker = null;
	    		
			try {
				m_context = context;
				m_tracker = new ServiceTracker<HttpClient, HttpClient>(
						m_context,
						m_context.createFilter(
								"(&(objectClass=" + HttpClient.class.getName() + "))"),
						null);
				m_tracker.open();
				
	            System.out.println("Fetching data for todos.....");
	            HttpClient client = (HttpClient) m_tracker.getService();
	            HttpResponse res = client.get("https://catfact.ninja/fact");
	            System.out.println(res.getStatus());
	            System.out.println(res.getData());
			} catch (Exception e) {
				System.out.println("ERROR");
			}
	}

	@Override
	public void onInitiation() {
		System.out.println("initiate");
	}

	@Override
	public void onSuccess() {
		System.out.println("success");
	}

	@Override
	public void onError(Exception e) {
		System.out.println("ERROR");
	}

}
